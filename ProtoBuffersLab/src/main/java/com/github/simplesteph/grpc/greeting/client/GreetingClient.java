package com.github.simplesteph.grpc.greeting.client;

import com.proto.dummy.DummyServicedGrpc;
import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello I'm a gRPC client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() // DON'T USE IN PRODUCTION
                .build();
        System.out.println("Creating Stub");

        //DummyServicedGrpc.DummyServicedBlockingStub syncClient = DummyServicedGrpc.newBlockingStub(channel);
        //DummyServicedGrpc.DummyServicedFutureStub asyncClient = DummyServicedGrpc.newFutureStub(channel);


        // created a greet service client (blocking - synchrous
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);

        // created a protocol buffer greeting message
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Eric")
                .setLastName("Appier")
                .build();
        //do the same for GreetRequest
        GreetRequest request = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

        //call the RPC and get back a GreetResponse (protocol buffers)
        GreetResponse response = greetClient.greet(request);

        System.out.println(response.getResult());



        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
