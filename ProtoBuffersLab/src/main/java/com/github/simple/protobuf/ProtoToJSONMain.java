package com.github.simple.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

public class ProtoToJSONMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        // simple fields
        builder.setId(42)
                .setIsSimple(true)
                .setName("Test Name");

        //repeated fields
        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3);

        String jsonString = JsonFormat.printer()
                .omittingInsignificantWhitespace()
                .includingDefaultValueFields()
                .print(builder);
        System.out.println(jsonString);

        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);

        System.out.println(builder2);
    }
}
