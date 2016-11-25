import os
import sys
import random

f1 = open(str(sys.argv[1]), 'w')
number_of_strings = int(str(sys.argv[2]))
length_of_string = int(str(sys.argv[3]))

nucleotides = ['A', 'C', 'G', 'T']

for x in range(1, number_of_strings):
    line = ""
    for y in range(1, length_of_string):
        random_no = random.randint(0, 3)
        line += nucleotides[random_no]
    line += "\n"
    f1.write(line)

f1.close()
    
