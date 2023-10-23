/*
 * Matheus Rodrigues da Silva Espalaor
 * Use of the Sedgewick Package: https://lift.cs.princeton.edu/java/linux/
 */

public class Main
{

    public static void main(String[] args)
    {
        int tam = StdIn.readInt();
        int[] array = new int[tam];
        for(int i = 0; i < tam; i++)
        {
            array[i] = StdIn.readInt();
        }

        int soma = StdIn.readInt();
        int inicio = 0, fim = 0, j = 0, sumArray = 0;
        boolean encontrado = false;
        for(int i = 0; i < tam && !encontrado; i++)
        {   
            j = i + 1;
            //StdOut.println("primeiro elemento " + array[i]);
            inicio = i + 1;
            sumArray += array[i];
            while(j < tam)
            {  
                //StdOut.println("valores " + array[j]);
                if(sumArray + array[j] <= soma)
                {
                    sumArray += array[j];
                    fim = j + 1;
                }
                j++;
            }
            
            if(sumArray == soma){
                StdOut.println(inicio + " " + fim);
                encontrado = true;
            }
            sumArray = 0;
        }
    }
}

//Source: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&sortBy=submissions