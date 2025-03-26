package fifthproject;

import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in );
        System.out.print("Введите количество абитуриентов: ");
        int n;
        if (in.hasNextInt()) {
            n = in.nextInt();
        } else {
            System.out.print("Введены некорректные данные!");
            return;
        }
        System.out.print("Введите количество экзаменов: ");
        int exams;
        if (in.hasNextInt()) {
            exams = in.nextInt();
        } else {
            System.out.print("Введены некорректные данные!");
            return;
        }
        Abiturient [] array = new Abiturient[n];
        for (int i=0; i<n; i++) {
            System.out.print("Введите имя абитуриента номер " + (i+1) + ": ");
            array[i] = new Abiturient(in.next(), exams);
        }
        System.out.print("Введите отметки: ");
        System.out.println();
        int mark;
        for (int i=0; i< n; i++) {
            System.out.print("Введите отметки абитуриента номер " + (i+1) + ": ");
            for(int j = 0; j < exams; j++) {
            	array[i].AddGrade(in.nextInt());
            }
        }
        quickSort(array, 0, array.length - 1);
        System.out.print("Введите число мест: ");
        int places;
        if (in.hasNextInt()) {
            places = in.nextInt();
        } else {
            System.out.print("Введены некорректные данные!");
            return;
        }
        if(n <= places) {
        	System.out.print("Все поступили!");
        }
        else {
        	System.out.print("Список поступивших:");
        	System.out.println();
        	for(int i = n - 1; i > (n-places-1); i--) {
            	System.out.println(array[i].GetName());
            }
        }
    }
    public static void quickSort(Abiturient[] arr, int low, int high) {
	       if (low < high) {
	           int pi = partition(arr, low, high);

	           quickSort(arr, low, pi - 1);
	           quickSort(arr, pi + 1, high);
	       }
	   }

	private static int partition(Abiturient[] arr, int low, int high) {
	       // Выбор среднего элемента в качестве опорного
	       int middle = low + (high - low) / 2;
	       Abiturient pivot = arr[middle];

	       // Обмен опорного элемента с последним, чтобы использовать существующую логику
	       Abiturient temp = arr[middle];
	       arr[middle] = arr[high];
	       arr[high] = temp;

	       int i = (low - 1);
	       for (int j = low; j < high; j++) {
	           if (arr[j].GetAverage() < pivot.GetAverage()) {
	               i++;

	               temp = arr[i];
	               arr[i] = arr[j];
	               arr[j] = temp;
	           }
	       }

	       temp = arr[i + 1];
	       arr[i + 1] = arr[high];
	       arr[high] = temp;

	       return i + 1;
	   }
}
