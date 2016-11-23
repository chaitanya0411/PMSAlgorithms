package algorithms;

import java.util.ArrayList;
import java.util.HashSet;

import exceptions.InvalidInputException;
import utils.PMSHelper;

public class PMS1 extends PMS
{

    public PMS1(ArrayList<String> inputStrings, int motifLength,
                int maxHammingDistance)
    {
        super(inputStrings, motifLength, maxHammingDistance);
    }
    
    public HashSet<String> process()
            throws InvalidInputException
    {
        HashSet<String> outPutMotifs = new HashSet<String>();
        
        int i = 0;
        for(String inputString : inputStrings)
        {
            ArrayList<String> lmers =
                PMSHelper.getLmers(inputString, motifLength);
            ArrayList<String> neighbors = new ArrayList<String>();
            addNeighbors(lmers, neighbors);
            neighbors = radixSort(neighbors);
            
            HashSet<String> nonDuplicateNeighbors = removeDuplicates(neighbors);
            
            if(i == 0)
            {
                outPutMotifs.addAll(nonDuplicateNeighbors);
            }
            else
            {
                outPutMotifs = intersectNeighborhood(outPutMotifs,
                                                     nonDuplicateNeighbors);
            }
            i++;
        }
        return outPutMotifs;
    }
        

}
