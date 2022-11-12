package Java;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadSector {
    public static void main(String[] args) throws IOException {
        File diskRoot = new File ("\\\\.\\PhysicalDrive0");
        RandomAccessFile diskAccess = new RandomAccessFile (diskRoot, "r");
        byte[] content = new byte[1024];
        diskAccess.readFully (content);
        for (int i = 0; i < content.length; i++) {
            System.out.print((char)content[i]+" ");
        }
    }
}