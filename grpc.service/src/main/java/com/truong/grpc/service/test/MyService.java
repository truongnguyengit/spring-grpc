package com.truong.grpc.service.test;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import test.proto.MyServiceGrpc.MyServiceImplBase;
import test.proto.Test.MyRequest;
import test.proto.Test.MyResponse;


@GrpcService
public class MyService extends MyServiceImplBase {

	@Override
    public void findOne(MyRequest request, StreamObserver<MyResponse> responseObserver) {
		 
		
		MyResponse response = MyResponse.newBuilder()
                .setData(request.getA() + request.getB())
                .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
