package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import exceptions.InvalidInputException;

public class PMSHelper
{
	public static int getHammingDistance(String sequence1, String sequence2)
	{	
		char[] s1 = sequence1.toCharArray();
	    char[] s2 = sequence2.toCharArray();

	    int shorter = Math.min(s1.length, s2.length);
	    int longest = Math.max(s1.length, s2.length);

	    int result = 0;
	    
	    for(int i = 0; i < shorter; i++)
	    {
	        if (s1[i] != s2[i])
        	{
	        	result++;
        	}
	    }
	    result += longest - shorter;

	    return result;
	}
	
	public static ArrayList<String> getLmers(String inputString,
                                             int motifLength)
        throws InvalidInputException
	{
		if(null == inputString || inputString.isEmpty())
		{
			throw new InvalidInputException("inputString is null/empty");
		}
		
		ArrayList<String> lmers = new ArrayList<String>();
		
		int n = inputString.length();
		
		for(int i = 0; i < n - motifLength + 1; i++)
		{
			lmers.add(inputString.substring(i, i + motifLength));
		}
		
		return lmers;
	}
	
	public static ArrayList<String> readInputStrings(String filePath)
	    throws IOException
	{
	    ArrayList<String> inputStrings = new ArrayList<String>();
        
	    String line = null;
	    FileReader fileReader = null;
	    BufferedReader bufferedReader = null;
	    
        try
        {   
            fileReader = new FileReader(filePath);

            bufferedReader = new BufferedReader(fileReader);

            while(null != (line = bufferedReader.readLine()))
            {
                inputStrings.add(line);
            }
            
            return inputStrings;
        }
        finally
        {
            if(null != bufferedReader)
            {
                bufferedReader.close();
            }
            
            if(null != fileReader)
            {
                fileReader.close();
            }
        }
	}
	
	public static void writeOutputMotifs(HashSet<String> outPutMotifs,
	                                     String outputFilePath)
	    throws IOException
	{
	    FileWriter fileWriter = null;
	    BufferedWriter bufferedWriter = null;
	    
	    try
	    {
            fileWriter = new FileWriter(outputFilePath);
            bufferedWriter = new BufferedWriter(fileWriter);
            
            for(String motif : outPutMotifs)
            {
                bufferedWriter.write(motif);
                bufferedWriter.newLine();
            }
        }
	    finally
	    {
	        if(null != bufferedWriter)
	        {
	            bufferedWriter.close();
	        }
	        if(null != fileWriter)
	        {
	            fileWriter.close();
	        }
	    }
	}
	
	public static HashMap<Character, List<Character>> getDNAChoiceMap()
	{
	    HashMap<Character, List<Character>> dnaMap =
	        new HashMap<Character, List<Character>>();
	    
	    dnaMap.put('A', new ArrayList<Character>(Arrays.asList('C', 'G', 'T')));
	    dnaMap.put('C', new ArrayList<Character>(Arrays.asList('A', 'G', 'T')));
	    dnaMap.put('G', new ArrayList<Character>(Arrays.asList('A', 'C', 'T')));
	    dnaMap.put('T', new ArrayList<Character>(Arrays.asList('A', 'C', 'G')));
	    
	    return dnaMap;
	}
	
}
