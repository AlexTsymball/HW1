package task3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реалізувати метод, який сортує геометричні 3d фігури за об'ємом.
 * Метод приймає параметром колекцію довільних геометричних фігур (куб, кулю, циліндр). Написати unit-тести для методу.
 */
public class Task3 {

    public  List<Shape> sortShape(List<Shape> shapeList) {
        if(shapeList == null) throw new NullPointerException("there is must be list of shapes");
        else if(shapeList.isEmpty()) return Collections.emptyList();

        return shapeList.stream()
                .sorted(Comparator.comparing(Shape::getVolume))
                .collect(Collectors.toList());
    }
}
