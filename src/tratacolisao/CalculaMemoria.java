package tratacolisao;

import java.util.ArrayList;
import java.util.List;


public class CalculaMemoria
{
    private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes)
    {
        return bytes / MEGABYTE;
    }

     public static void main(String[] args)
     {
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
    }
}
