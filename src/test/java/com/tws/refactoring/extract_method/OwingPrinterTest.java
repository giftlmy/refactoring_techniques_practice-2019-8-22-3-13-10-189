package com.tws.refactoring.extract_method;

import com.tws.refactoring.extract_variable.BannerRender;
import com.tws.refactoring.extract_variable.PriceCalculator;
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
    @Test
    public void shold_return_Banner_if_given_not_ie() {
        //given
        BannerRender bannerRender = new BannerRender();

        //when
        String s = bannerRender.renderBanner("MAC", "chrome");
        //then
       assertEquals("banner",s);
        
    }
    @Test
    public void shold_return_IEonMa_if_given_mac_ie() {
        //given
        BannerRender bannerRender = new BannerRender();

        //when
        String s = bannerRender.renderBanner("MAC", "IE");
        //then
        assertEquals("IE on Mac?",s);

    }
    @Test
    public void shold_return_correct_if_given_than_500() {
        //given
        PriceCalculator priceCalculator = new PriceCalculator();
        //when
        double price = priceCalculator.getPrice(600, 10);
        //then
        assertEquals(6050,price,0);

    }
    @Test
    public void shold_return_correct_if_given_less_500() {
        //given
        PriceCalculator priceCalculator = new PriceCalculator();
        //when
        double price = priceCalculator.getPrice(400, 10);
        //then
        assertEquals(4100,price,0);

    }
}