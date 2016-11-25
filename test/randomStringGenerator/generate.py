import os
import sys
import random

f1 = open(str(sys.argv[1]), 'w')
number_of_strings = int(str(sys.argv[2]))
length_of_string = int(str(sys.argv[3]))
alphabet = str(sys.argv[4])

line = ""
if alphabet == "DNA":
    nucleotides = ['A', 'C', 'G', 'T']
    line = "DNA\n"
    
elif alphabet  == "PROTEIN":
    line = "PROTEIN\n"
    nucleotides = ['A', 'R', 'N', 'D', 'C', 'E', 'Q', 'G',
                   'H', 'I', 'L', 'K', 'M', 'F', 'P', 'S',
                   'T', 'W', 'Y', 'V']

f1.write(line)

for x in range(1, number_of_strings):
    line = ""
    for y in range(1, length_of_string):
        random_no = random.randint(0, len(nucleotides) - 1)
        line += nucleotides[random_no]
    line += "\n"
    f1.write(line)

f1.close()
    
