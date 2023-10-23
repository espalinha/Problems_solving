#include <stdio.h>

#define MAX_LEN 10000
#define SIZEOF(arr) sizeof(arr)/sizeof(arr[0])

// C program for Merge Sort
// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
void merge(long arr[], size_t l, size_t m, size_t r)
{
	size_t i, j, k;
	size_t n1 = m - l + 1;
	size_t n2 = r - m;

	// Create temp arrays
	int L[n1], R[n2];

	// Copy data to temp arrays L[] and R[]
	for (i = 0; i < n1; i++)
		L[i] = arr[l + i];
	for (j = 0; j < n2; j++)
		R[j] = arr[m + 1 + j];

	// Merge the temp arrays back into arr[l..r
	i = 0;
	j = 0;
	k = l;
	while (i < n1 && j < n2) {
		if (L[i] <= R[j]) {
			arr[k] = L[i];
			i++;
		}
		else {
			arr[k] = R[j];
			j++;
		}
		k++;
	}

	// Copy the remaining elements of L[],
	// if there are any
	while (i < n1) {
		arr[k] = L[i];
		i++;
		k++;
	}

	// Copy the remaining elements of R[],
	// if there are any
	while (j < n2) {
		arr[k] = R[j];
		j++;
		k++;
	}
}

// l is for left index and r is right index of the
// sub-array of arr to be sorted
void mergeSort(long arr[], size_t  l, size_t r)
{
	if (l < r) {
		size_t m = l + (r - l) / 2;

		// Sort first and second halves
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);

		merge(arr, l, m, r);
	}
}

void AchaDuplicado(long array[]){
	size_t tamanho = SIZEOF(array);
	for(size_t i = 0; i + 1< tamanho; i++){
		if(array[i] == array[i + 1]){
			printf("Temos um par com o número %lu", array[i]);
		}
		else {
			printf("não temos\n");
		}
	}
} 

int main(){
	long array[MAX_LEN];
	long numero;
	long* pont = array;
	for(size_t i = 0; i < MAX_LEN; i++){
		scanf("%lu", &numero);
		*pont = numero;
		pont++;
	}
	
	size_t len = SIZEOF(array);

	mergeSort(array, 0, len - 1); 
	
	AchaDuplicado(array);

	return 0;
}
