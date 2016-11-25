import os
import sys
import random

f1 = open(str(sys.argv[1]), 'w')
n = int(str(sys.argv[2]))
l = int(str(sys.argv[3]))

nucleotides = ['A', 'C', 'G', 'T']

for x in range(1, n):
    line = ""
    for y in range(1, l):
        randomNo = random.randint(0, 3)
        line += nucleotides[randomNo]
    line += "\n"
    f1.write(line)

f1.close()
    
