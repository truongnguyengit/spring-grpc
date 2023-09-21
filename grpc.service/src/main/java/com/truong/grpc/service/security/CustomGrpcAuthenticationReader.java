package com.truong.grpc.service.security;

import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import io.grpc.Metadata;
import io.grpc.ServerCall;

public class CustomGrpcAuthenticationReader implements GrpcAuthenticationReader {

    private final UserDetailsService userDetailsService;

    public CustomGrpcAuthenticationReader(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

	@Override
	public Authentication readAuthentication(ServerCall<?, ?> call, Metadata headers) throws AuthenticationException {
		 // Đọc thông tin xác thực từ tiêu đề gRPC (ví dụ: mã thông tin xác thực)
        String token = headers.get(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER));

        // Sử dụng UserDetailsService để tìm UserDetails dựa trên mã thông tin xác thực (ví dụ: mã thông tin xác thực là tên người dùng)
        UserDetails userDetails = userDetailsService.loadUserByUsername(token);

        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Tạo một đối tượng Authentication dựa trên UserDetails và trả về
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}


}
