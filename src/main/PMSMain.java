package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import algorithms.PMS1;
import exceptions.InvalidInputException;
import utils.PMSHelper;

public class PMSMain {

    public static void main(String[] args)
        throws InvalidInputException, IOException
    {
        if(null == args || args.length < 4)
        {
            throw new InvalidInputException(
                "Input file names, output file names, motif length and " +
                "maxHammingDistance should be provided as parameters"
            );
        }
        else
        {
            String inputFiles = args[0];
            String outPutFiles = args[1];
            int motifLength = Integer.parseInt(args[2]);
            int maxHammingDistance = Integer.parseInt(args[3]);
            
            if(maxHammingDistance > motifLength)
            {
                throw new InvalidInputException(
                    "maxHammingDistance cannot be greater than motif length"
                );
            }
            
            if(inputFiles.split(",").length != outPutFiles.split(",").length)
            {
                throw new InvalidInputException(
                    "No of input files should be equal to no of output files"
                );
            }
            
            String[] inputFilesArray = inputFiles.split(",");
            String[] outputFilesArray = outPutFiles.split(",");
            
            for(int i = 0; i < inputFilesArray.length; i++)
            {
                ArrayList<String> inputStrings =
                    PMSHelper.readInputStrings(inputFilesArray[i]);
                
                Long startTime = System.currentTimeMillis();
                
                PMS1 pms1 =
                    new PMS1(inputStrings, motifLength, maxHammingDistance);
                
                HashSet<String> outPutMotifs = pms1.process();
                
                Long endTime   = System.currentTimeMillis();
                Long totalTime = endTime - startTime;
                
                System.out.println("Total processing time taken for file " + (i + 1) +
                                   " : " + totalTime + "ms");
                
                PMSHelper.writeOutputMotifs(outPutMotifs, outputFilesArray[i]);
            }
        }
    }

}
