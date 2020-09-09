package com.techproed;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotations {
    //On a JUnit project we can use @Test annotation to run a test
    //create a void method and name:test1
    //By default JUnit runs the test in alphetical order
    //it doesn't run from top to bottom
    @Test  // @Test annotation helps us create test cases.We can run test cases without main method.
    public void test1(){
        System.out.println("Printing Test 1");
    }

    //I want to run test2 method before any other method


    @Before
    @Test
    public void test2(){
        System.out.println("Printing Test 2");
    }
    @Ignore
    @Test
    public void test3(){
        System.out.println("Printing Test 3");
    }




}
