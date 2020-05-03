package com.github.simplesteph.blog.client;

import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BlogClient {
    public static void main(String[] args) {
        System.out.println("Hello I'm a gRPC client");

        BlogClient main = new BlogClient();
        main.run();
    }

    private void run() {

    }
}
