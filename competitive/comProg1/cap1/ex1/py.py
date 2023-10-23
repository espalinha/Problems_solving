import random

MAXIMO = 2**16 - 1

def main():
    for i in range(10000):
        print(random.randint(0, MAXIMO))

main()

