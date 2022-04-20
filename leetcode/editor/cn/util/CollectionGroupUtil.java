package leetcode.editor.cn.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionGroupUtil {
    public static <T> List<List<T>> groupListByQuantity(List<T> list, int quantity) {
        List<List<T>> result = new ArrayList<>();
        if (list == null || list.size() == 0) {
            result.add(list);
            return result;
        }

        if (quantity <= 0) {
            new IllegalArgumentException("Wrong quantity.");
        }

        int count = 0;
        while (count < list.size()) {
            result.add(list.subList(count, (count + quantity) > list.size() ? list.size() : count + quantity));
            count += quantity;
        }

        return result;
    }
}
