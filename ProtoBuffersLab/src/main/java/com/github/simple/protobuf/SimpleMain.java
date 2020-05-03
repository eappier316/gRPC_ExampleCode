package com.github.simple.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleMain {

    public static void main(String[] args) {

        System.out.println("Hellow World!");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        // simple fields
        builder.setId(42)
                .setIsSimple(true)
                .setName("Test Name");

        //repeated fields
        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3);

        System.out.println(builder.toString());

        SimpleMessage message = builder.build();

        message.getId();
        message.getName();

        //write protocol buffers binary to a file
        try {
            FileOutputStream outputStream = new FileOutputStream( "simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // send as byte array
        //byte[] bytes = message.toByteArray();

        FileInputStream input = null;
        try {
            System.out.println("Reading from file....");
            input = new FileInputStream( "simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(input);
            System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
