package com.midashnt.taekwondo.util;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MidasHnTSystemUtil {

    public static String getResourceFile(String filePath) {
        try {
            ClassPathResource resourceFile = new ClassPathResource(filePath);
            return new String(FileCopyUtils.copyToByteArray(resourceFile.getInputStream()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getBean(Class<?> classType) {
        ApplicationContext applicationContext = ApplicationContextProvider.getContext();
        return applicationContext.getBean(classType);
    }

}