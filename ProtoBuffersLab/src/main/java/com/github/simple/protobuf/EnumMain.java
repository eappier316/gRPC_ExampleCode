package com.github.simple.protobuf;

import example.enumeration.EnumExamples;
import example.enumeration.EnumExamples.EnumMessage;

public class EnumMain {

    public static void main(String[] args) {
        System.out.println("Example for Enums....");

        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(345)
                .setDayOfTheWeek(EnumExamples.DayOfTheWeek.FRIDAY);

        EnumMessage message = builder.build();

        System.out.println(message);
    }
}
