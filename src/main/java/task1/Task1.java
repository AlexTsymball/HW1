package task1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Зробити метод, який приймає на вхід масив цілих чисел, і повертає тільки ті з них, які позитивні (>=0),
 * відсортувавши їх за спаданням. Зробити unit-тести для цього методу.
 */
public class Task1 {

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
