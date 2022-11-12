package Java;

import java.io.File;
import java.io.IOException;

public class Question3 {
    public static void main(String[] args) throws IOException {
        KLASOR_DETAY("C:\\Users\\pc\\Desktop\\test");

    }
    public static void KLASOR_DETAY(String path) throws IOException {
        int numberOfFolders = 0 ;
        int numberOfFiles = 0 ;
        long sizeOfFiles = 0 ;
        File f = new File(path);
        if (f.list() == null){
            System.out.println(" The folder is empty ");
            return;
        }
        for (int i = 0; i < f.list().length; i++) {
            File f2 = new File(f.getPath() + "\\" + f.list()[i]);
            if (f2.isDirectory()){
                numberOfFolders++;
            }else {
                numberOfFiles++;
                sizeOfFiles += f2.length();
            }
        }
        System.out.println("The number of files is " + numberOfFiles);
        System.out.println("The number of folders is : " + numberOfFolders);
        System.out.println("The size of files : " + getFileSize(sizeOfFiles));
    }
    // path the file
    public static String  getFileSize(long bytes_of_sizes) {

            long bytes = bytes_of_sizes;
            long kilobytes = (bytes / 1024);
            long megabytes = (kilobytes / 1024);
            long gigabytes = (megabytes / 1024);
            long terabytes = (gigabytes / 1024);


            if (bytes > 1024){
                if (kilobytes > 1024){
                    if (megabytes > 1024){
                        if (gigabytes > 1024){
                            return String.format("%,d terabytes", terabytes);
                        }
                        else
                            return String.format("%,d gigabytes", gigabytes);
                    }
                    else
                        return String.format("%,d megabytes", megabytes);
                }
                else
                    return String.format("%,d kilobytes", kilobytes);
            }
            else
                return String.format("%,d bytes", bytes);
    }

}

