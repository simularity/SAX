# Python
import numpy as np
from scipy import stats as sp

import sys

def lookupEquiprobableRegions(word_length):
    """Look up equiprobable regions from a normal distribution"""
    regions = np.arange(0, word_length, 1) / word_length
    return sp.norm.ppf(regions)

def printCuts(cuts):
    actual = cuts[1:-1]
    #print("{ ", end='')
    display = False
    last = - actual[0]
    for cut in actual:
        if display:
            print(",", end='')
        else:
            display = True
        print(cut, end='')

    if display:
        print(", ", end='')
    else:
        display = True
    print(last, end='')

    #print("}")
    

alphabet_size = int(sys.argv[1])

printCuts(lookupEquiprobableRegions(alphabet_size))
