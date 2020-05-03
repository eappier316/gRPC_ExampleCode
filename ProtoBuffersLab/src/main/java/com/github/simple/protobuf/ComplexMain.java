package com.github.simple.protobuf;

import example.complex.Complex;
import example.complex.Complex.DummyMessage;
import example.complex.Complex.ComplexMessage;

import java.util.Arrays;

public class ComplexMain {

    public static void main(String[] args) {
        System.out.println("Complex Example");

        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");
        DummyMessage twoDummy = newDummyMessage(56, "two dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(oneDummy);
        builder.addMultipleDummy(newDummyMessage(66, "second"));
        builder.addMultipleDummy(newDummyMessage(67, "third"));
        builder.addMultipleDummy(newDummyMessage(68, "fourth"));

        builder.addAllMultipleDummy(Arrays.asList(
                newDummyMessage(69, "fifth"),
                newDummyMessage(70, "sixth")
        ));

        ComplexMessage message = builder.build();

        System.out.println(message.toString());

        message.getMultipleDummyList();
    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder dummyBuilder = DummyMessage.newBuilder();

        DummyMessage message = dummyBuilder.setName(name)
                .setId(id)
                .build();

        return message;
    }
}
