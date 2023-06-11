import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bubbleSort {
   public static void main(String[] args) throws Exception {

		for(int trial = 1; trial <= 20; trial++){
			long timeStart = System.nanoTime();

			sort.bubbleSort();

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

        // Convert the list to an array
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

		// loop to access each array element

		for (int i = 0; i < size - 1; i++){

		// loop to compare array elements
			for (int j = 0; j < size - i - 1; j++)

				// compare two adjacent elements
				if (array[j] > array[j + 1]) {

				// swapping occurs if elements
				// are not in the intended order
				int temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
		}
	}
}