package com.epam.classLoader;

public class MySingleton {
    private String message;
    private static MySingleton forSingleton;

    private MySingleton(String message) {
        this.message = message;
        forSingleton = this;
    }

    public static MySingleton takeObject(String message){
        if (forSingleton != null){
            return forSingleton;
        }
        forSingleton = new MySingleton(message);
        return forSingleton;
    }

    public String getMessage() {
        return message;
    }
}
