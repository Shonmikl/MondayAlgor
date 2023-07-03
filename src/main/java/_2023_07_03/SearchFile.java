package _2023_07_03;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {
    public static void main(String[] args) {
        List<File> fileList = new ArrayList<>();
        search(new File("E:\\"), fileList);
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void search(File rootFile, List<File> fileList) {
        if(rootFile.isDirectory()) {
            System.out.println("searching...... " + rootFile.getAbsolutePath());
            File[] directoryFiles = rootFile.listFiles();
            if(directoryFiles != null) {
                for (File file : directoryFiles) {
                    if(file.isDirectory()) {
                        search(file, fileList);
                    } else {
                        if(file.getName().toLowerCase().endsWith(".pdf")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }
}