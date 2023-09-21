package com.truong.grpc.client.test;

import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import test.proto.MyServiceGrpc;
import test.proto.MyServiceGrpc.MyServiceBlockingStub;
import test.proto.Test.MyRequest;
import test.proto.Test.MyResponse;

@Service
public class MyClient {
	
	@GrpcClient("MyService") // "myService" là tên của bean gRPC client
	private MyServiceGrpc.MyServiceBlockingStub myServiceBlockingStub;
	
	public MyResponse findOne(int a, int b) {
		
		MyRequest request = MyRequest.newBuilder().setA(a).setB(b).build();
		
		return myServiceBlockingStub.findOne(request);
	}
	
}
