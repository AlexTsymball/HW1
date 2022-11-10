package task1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Зробити метод, який приймає на вхід масив цілих чисел, і повертає тільки ті з них, які позитивні (>=0),
 * відсортувавши їх за спаданням. Зробити unit-тести для цього методу.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, -5, 11, 54, -6, -334, 234, 0};
        Task1 task1 = new Task1();
        int[] arrResult = task1.arrMoreThanZeroReverseOrder(arr);
        System.out.println(Arrays.toString(arrResult));
    }

    public int[] arrMoreThanZeroReverseOrder(int[] arrayOfInt) {

        if(arrayOfInt == null) throw new NullPointerException("there is must be array");
        else if (arrayOfInt.length == 0) return new int[]{};

        return Arrays.stream(arrayOfInt)
                .filter(x -> x >= 0)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

    }
}
