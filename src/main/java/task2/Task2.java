package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Locale;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Написати метод, який на вхід приймає список рядків-текстів, в яких можуть бути хеш-теги
 * (слова, що починаються на знак "#"). Як результат, метод повинен повертати top-5 найчастіше
 * згаданих хеш-тегів із зазначенням кількості згадки кожного з них. Декілька однакових хеш-тегів в
 * одному рядку повинні вважатися однією згадкою. Написати unit-тести для цього методу.
 */
public class Task2 {
    /**
     * 1)#a#b - it will be one hashtag - #a
     * 2)#a and #A are equals hashtag (Hashtags are not case sensitive)
     * 3)#abc?cc a hashtag of this will be @abc
     */
    public Map<String, Integer> topFive(List<String> texts) {

        if (texts == null) throw new NullPointerException("there is must be list of Strings");
        else if (texts.isEmpty()) return new HashMap<>();

        Map<String, Integer> mapOfTags = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\A|\\s)#\\w+");
        for (String text : texts) {
            Set<String> stringSet = new HashSet<>();
            int startIndex = 0;
            Matcher matcher = pattern.matcher(text);
            while (matcher.find(startIndex)) {
                stringSet.add(matcher.group().replace(" ", "").toLowerCase(Locale.ROOT));
                startIndex = matcher.end();
            }
            for (String tag : stringSet) {
                if (!mapOfTags.containsKey(tag)) {
                    mapOfTags.put(tag, 1);
                } else {
                    int value = mapOfTags.get(tag);
                    mapOfTags.put(tag, ++value);
                }
            }
        }

        return mapOfTags.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
