package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {

//        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {

        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
        //given
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order(3));
        orders.add(new Order(4));
        OwingPrinter owingPrinter = new OwingPrinter();
        //when
        owingPrinter.printOwing("name",orders);

    }
}