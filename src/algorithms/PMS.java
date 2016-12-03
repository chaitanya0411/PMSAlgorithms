package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import enums.AlphabetType;
import utils.Constants;
import utils.PMSHelper;

public class PMS
{
    protected ArrayList<String> inputStrings;
    protected int motifLength;
    protected int maxHammingDistance;
    protected HashMap<Character, List<Character>> choiceMap;
    
	protected PMS(ArrayList<String> inputStrings, int motifLength,
	              int maxHammingDistance,
	              AlphabetType alphabetType)
	{
	    this.inputStrings = inputStrings;
	    this.motifLength = motifLength;
	    this.maxHammingDistance = maxHammingDistance;
	    
	    if(alphabetType == AlphabetType.DNA)
	    {
	        this.choiceMap = PMSHelper.getDNAChoiceMap();
	    }
	    else if(alphabetType == AlphabetType.PROTEIN)
            {
                this.choiceMap = PMSHelper.getProteinChoiceMap();
            }
	}
	
	protected HashSet<String> intersectNeighborhood(HashSet<String> set1,
	                                                HashSet<String> set2)
	{
	    Iterator<String> iterator = set1.iterator();
	    
	    while(iterator.hasNext())
	    {
	        if(!set2.contains(iterator.next()))
	        {
	            iterator.remove();
	        }
	    }
	    return set1;
	}
	
	protected ArrayList<String> radixSort(ArrayList<String> lmers)
	{
	    int n = lmers.get(0).length();
	    
	    ArrayList<String> sortedList = lmers;
	    
	    for(int i = n - 1; i >= 0; i--)
	    {
	        sortedList = countingSort(sortedList, i);
	    }
	    
	    return sortedList;
	}

	protected ArrayList<String> countingSort(ArrayList<String> lmers,
                                             int index)
	{
	    int[] count = new int[26];
	    
	    for(String lmer : lmers)
	    {
	        count[lmer.charAt(index) - 'A']++;
	    }
	        
	    for(int i = 1; i < 26; i++)
	    {
	        count[i] += count[i - 1];
	    }
	        
	    String[] sortedArray = new String[lmers.size()];
	    
	    for(int i = lmers.size() - 1; i >= 0; i--)
	    {
	        String lmer = lmers.get(i);
	        sortedArray[count[lmer.charAt(index) - 'A'] - 1] = lmer;
	        count[lmer.charAt(index) - 'A']--;
	    }
	    
	    return new ArrayList<String>(Arrays.asList(sortedArray));
	}

	protected HashSet<String> removeDuplicates(ArrayList<String> lmers)
	{
	    if(null != lmers && lmers.size() > 0)
	    {
	        Iterator<String> iterator = lmers.iterator();
	        String prev = iterator.next();
	        
	        while (iterator.hasNext())
	        {
	            String str = iterator.next();
	            
	            if(str.equals(prev))
	            {
	                iterator.remove();
	            }
	            else
	            {
	                prev = str;
	            }
	        }
	    }
	    HashSet<String> set = new HashSet<String>();
	    set.addAll(lmers);
	    return set;
	}
	
	protected void addNeighbors(ArrayList<String> lmers,
	                            ArrayList<String> neighbors)
	{
	    for(String lmer : lmers)
	    {
	        permute(lmer, maxHammingDistance, neighbors, 0, -1);
	    }
	}
	
	protected void permute(String actual, int d,
	                       ArrayList<String> neighbors, int index, int k)
	{
	    if(index > d)
	    {
	        return;
	    }
	    else
	    {
	        neighbors.add(actual);
	        
	        for(int i = k + 1; i < actual.length(); i++)
	        {
	            List<Character> choiceList =
	                choiceMap.get(actual.charAt(i)); 
	            
	            for(int j = 0; j < choiceList.size(); j++)
	            {
	                String modifiedString =
                        actual.substring(0, i) + choiceList.get(j) +
                        actual.substring(i + 1);
	                 
	                permute(modifiedString, d, neighbors, index + 1, i);
	            }
	        }
	    }
	}
	
}
