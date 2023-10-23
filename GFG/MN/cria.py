import random

def main():
    lista = [i for i in range(1000)]
    random.shuffle(lista)
    for i in lista:
        print(i)
main()