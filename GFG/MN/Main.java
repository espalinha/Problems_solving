/*
 * Matheus Rodrigues da Silva Espalaor
 * Use package from Sedgewick: https://lift.cs.princeton.edu/java/linux/
 * Source: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
 */

/*
 * Ideia:
 *       Uso do algoritmo de ordenamento MergeSort para poder colocar os elementos em ordem. Para assim, no final só precisarmos trabalhar com um O(n), em que n é o tamanho da lista. *isso desconsiderando o O() do MergeSort*
 * 
 * A entrada é feita pelo terminal linux --> java-introcs Main < data.txt
 */

public class Main
{
    public static int AchaDivInteira(int valor, int numero)
    {
        return (valor - (valor % numero))/numero;
    }
    public static void MergeSort(int[] array)
    {
        if (array.length > 1)
        {
            int imed = AchaDivInteira(array.length, 2), indice = 0;
            int[] Left = new int[imed];
            int[] Right = new int[array.length - imed];

            while(indice < array.length)
            {
                for(int i = 0; i < imed; i++)
                {
                    Left[i] = array[indice];
                    indice++;
                }
                for(int i = 0; i < array.length - imed; i++)
                {
                    Right[i] = array[indice];
                    indice++;
                }
            }

            MergeSort(Left);
            MergeSort(Right);

            int i = 0, j = 0, k = 0;
            while(i < Left.length && j < Right.length)
            {
                if(Left[i] > Right[j])
                {
                    array[k] = Right[j];
                    j++;
                } else
                {
                    array[k] = Left[i];
                    i++;
                }
                k++;
            }

            while(i < Left.length)
            {
                array[k] = Left[i];
                i++;
                k++;
            }

            while(j < Right.length)
            {
                array[k] = Right[j];
                j++;
                k++;
            }
        }
    }
    
    public static void Print(int[] array)
    {
        StdOut.print("[");
        for(int i = 0; i < array.length; i++)
        {
            StdOut.print(array[i] + " ");
        }
        StdOut.println("]");
    }
    public static void main(String[] args)
    {
        int[] lista = new int[999];
        for(int i = 0; i < 999; i++)
        {
            lista[i] = StdIn.readInt();
        }


        //int[] lista = {6, 7, 1, 2, 5, 8, 3, 9};
        //int tam = lista.length + 1; //Vai receber o tamanho de uma array, e vamos ter que encontrar o que ta faltando, no nosso caso é 4
        Print(lista);
        MergeSort(lista);
        Print(lista);
        boolean teste = false;
        int i = 0;
        while(i + 1< lista.length && !teste)
        {
            if(lista[i]  + 1 != lista[i + 1])
            {
                StdOut.println(lista[i] + 1);
                teste = true;
            }
            i++;
        }
        if(!teste)
        {
            StdOut.println(lista.length + 1);
        }
    }
}