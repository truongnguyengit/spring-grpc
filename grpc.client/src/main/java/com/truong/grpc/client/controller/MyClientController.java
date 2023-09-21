package com.truong.grpc.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.truong.grpc.client.test.MyClient;

import test.proto.Test.MyResponse;

@RestController()
@RequestMapping("api/client")
public class MyClientController {
	
	@Autowired
	MyClient client;
	
	@GetMapping("")
	public ResponseEntity<BaseResponse<Object>> findOne(
			@RequestParam(name = "a", defaultValue = "1") int a,
			@RequestParam(name = "b", defaultValue = "1") int b) {
		
		BaseResponse<Object> response = new BaseResponse<>();
		
		MyResponse p = client.findOne(a, b);
		
		response.setData(p.getData());
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
