package com.epam.classLoader;

import java.io.*;

public class MyClassLoader extends ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(!name.equals("D:\\EpamLab\\ClassLoaderTask\\target\\classes\\com\\epam\\classLoader\\MySingleton.class")){
            return super.findSystemClass(name);
        }

        File fileName = new File(name);
        Class<?> clazz = null;
        try(BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream(fileName))) {
            byte[] bytes = new byte[(int) fileName.length()];
            bufferedReader.read(bytes);
            clazz = defineClass("com.epam.classLoader.MySingleton", bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(clazz == null){
            throw new ClassNotFoundException();
        }
        return clazz;
    }
}
