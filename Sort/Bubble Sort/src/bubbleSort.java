import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bubbleSort {
   public static void main(String[] args) throws Exception {

		for(int trial = 1; trial <= 3; trial++){
			int[] array = readData();

			long timeStart = System.nanoTime();

			//sort.bubbleSort();
			sort.selectionSort(array);
			//sort.insertionSort(array);
			//sort.quickSort();
			//Arrays.sort(array);

			long timeEnd = System.nanoTime();
        	long runTime = timeEnd - timeStart;

        	long hours = runTime / 3600000000000L;
        	long minutes = (runTime % 3600000000000L) / 60000000000L;
        	long seconds = (runTime % 60000000000L) / 1000000000L;
        	long milliseconds = (runTime % 1000000000L) / 1000000L;
        	long nanoseconds = runTime % 1000000L;

        	String formattedRuntime = String.format("%02d:%02d:%02d:%03d:%03d", hours, minutes, seconds, milliseconds, nanoseconds);
			System.out.println("Trial " + trial + ": " + formattedRuntime);
		}

   }

   public static int[] readData(){
		String file = "dataset.txt";
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line);
                numbers.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] dataset = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            dataset[i] = numbers.get(i);
        }

		return dataset;
	}

   	class sort {
		static void bubbleSort(){
			int[] array = readData();
			int size = array.length;

			for (int i = 0; i < size - 1; i++){

				for (int j = 0; j < size - i - 1; j++){

					if (array[j] > array[j + 1]) {
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
					}
				}
			}
		}

		static void selectionSort(int[] array){
			array = readData();
			int size = array.length;

			for (int step = 0; step < size - 1; step++) {
      			int min_idx = step;

      		for (int i = step + 1; i < size; i++) {
        		if (array[i] < array[min_idx]) {
          		min_idx = i;
        		}
      		}
      		int temp = array[step];
      		array[step] = array[min_idx];
      		array[min_idx] = temp;
    		}
		}

		static void insertionSort(int[] array){
			array = readData();
			int size = array.length;

			for (int step = 1; step < size; step++) {
      			int key = array[step];
      			int j = step - 1;

      			while (j >= 0 && key < array[j]) {
        			array[j + 1] = array[j];
        			--j;
      			}
				
      		array[j + 1] = key;
    		}
    	}

		// static void quickSort(){
		// 	int[] array = readData();
		// 	int size = array.length;
		// }
	}
}
