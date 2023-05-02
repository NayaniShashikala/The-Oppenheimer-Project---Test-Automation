package org.ui.oppenheimerqaassignment.util;

import java.io.File;

public class Helper {

    public static String getFileAbsolutePathFromTestResources(String fileName) {
        return new File("src/test/resources/testData/" + fileName).getAbsolutePath();
    }
}

//C:\Users\NAYANI\Documents\GitHub\oppenheimer-project-test-automation\src\test\resources\testData\working-class-hero-list.csv