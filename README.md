Sequence motifs are short, recurring patterns in DNA that are presumed to have a biological function. Often they indicate sequence-specific binding sites for proteins such as nucleases and transcription factors (TF). Others are involved in important processes at the RNA level, including ribosome binding, mRNA processing (splicing, editing, polyadenylation) and transcription termination.

PMS is planted motif search which is the process of finding motifs in a set of input strings.

The search problem may be summarized as follows:
Input are n strings (s1, s2, … , sn) of length m each from an alphabet Σ and two integers l and d. Find all strings x such that |x| = l and every input string contains at least one variant of x at a Hamming distance of at most d. Each such x is referred to as an (l, d) motif.
For example, if the input strings are GCGCGAT, CACGTGA, and CGGTGCC; l = 3 and d = 1, then GGT is a motif of interest. Note that the first input string has GAT as a substring, the second input string has CGT as a substring, and the third input string has GGT as a substring. GAT is a variant of GGT that is within a Hamming distance of 1 from GGT, etc. Call the variants of a motif that occur in the input strings as instances of the motif. For example, GAT is an instance of the motif GGT that occurs in the first input string.

How to use ?

Eclipse Arguments :
Argument 1 : comma separated input files names having the input strings
Argument 2 : comma separated output files to generate the motifs. There is 1:1 correlation between input and output files i.e 1st input files putput will be generated in the 1st output file.
Argument 3 : motif length(l)
Argument 4 : hamming distance(d)

Sample arguments : input1,input2 output1,output2 9 2


.
