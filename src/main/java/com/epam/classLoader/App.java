package com.epam.classLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App
{
    public static void main( String[] args ) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        MySingleton mySingleton = MySingleton.takeObject("Who are you?");
        MySingleton myLinkToFirstSingleton = MySingleton.takeObject("I don't exist");
        System.out.println(mySingleton == myLinkToFirstSingleton);

        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.loadClass("D:\\EpamLab\\ClassLoaderTask\\target\\classes\\com\\epam\\classLoader\\MySingleton.class");
        Method newSingleton = clazz.getMethod("takeObject", String.class);
        Object myReallySecondSingleton = newSingleton.invoke(null, "I'm you");
        System.out.println(mySingleton == myReallySecondSingleton);
        System.out.println(mySingleton.getMessage());
        Method getMessage = clazz.getMethod("getMessage", null);
        System.out.println(getMessage.invoke(myReallySecondSingleton, null));
    }
}


//com.epam.classLoader.MySingleton