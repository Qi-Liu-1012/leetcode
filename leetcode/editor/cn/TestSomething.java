package leetcode.editor.cn;

import leetcode.editor.cn.util.CollectionGroupUtil;
import leetcode.editor.cn.util.MonitorInfo;
import leetcode.editor.cn.util.MonitorUtils;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.*;

public class TestSomething {
    public static void main(String[] args) {
        TestSomething something = new TestSomething();

        List<String> list = something.splitStringToList("123456789,74867891212,3249879823", ",", String.class);
        System.out.println(list.toString());
    }

    public void test1() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 999999; i++) {
            String str = "My Heart Will Go On!";
            Pattern p = Pattern.compile("Will");
            Matcher m = p.matcher(str);
            if (i != 0) {
                continue;
            }
            if (m.find()) {
                System.out.println("方法1： 包含这个字符串！");
            } else {
                System.out.println("方法1： 不包含这个字符串！");
            }
        }
        System.out.println("方法耗时:" + (System.currentTimeMillis() - startTime));

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++) {
            String str = "My Heart Will Go On!";
            String findStr = "Will";
            if (i != 0) {
                continue;
            }
            if (str.contains(findStr)) {
                System.out.println("方法2： 包含这个字符串！");
            } else {
                System.out.println("方法2： 不包含这个字符串！");
            }
        }
        System.out.println("方法耗时:" + (System.currentTimeMillis() - startTime2));
    }

    public void test2() {
        Long big = 6499265870410754L;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 2000; i++) {
            s.append(++big).append(",");
        }
        s = new StringBuilder(s.substring(0, s.length() - 1));
        System.out.println(s);
    }

    public void test3() {
        String str = "123,1234,4466";
        System.out.println(str.contains("1"));

        String[] listArr = str.split(",");
        HashSet<String> set = new HashSet<>(Arrays.asList(listArr));
        System.out.println(set.contains("1"));
    }

    public void test4() {
        List<String> allList = new ArrayList<String>();
        for (int i = 1; i <= 504; i++) {
            allList.add(i + "");
        }

        List<List<String>> groupList = CollectionGroupUtil.groupListByQuantity(allList, 50);
        int i = 0;
        List<String> list = null;
        for (int c = 0; c < groupList.size(); c++) {
            list = groupList.get(c);

            System.out.println("第" + (c + 1) + "组： ");
            System.out.println(list.toString());
            System.out.println();
        }
    }

    public void test5() {
        List<String> allList = new ArrayList<String>();
        for (int i = 1; i <= 45; i++) {
            allList.add(i + "");
        }

        List<List<String>> groupList = CollectionGroupUtil.groupListByQuantity(allList, 50);
        int i = 0;
        List<String> list = null;
        for (int c = 0; c < groupList.size(); c++) {
            list = groupList.get(c);

            System.out.println("第" + (c + 1) + "组： ");
            for (String temp : list) {
                System.out.print(temp + ", ");
            }
            System.out.println();
        }
    }

    public void test6() {
        List<String> allList = new ArrayList<String>();
        for (int i = 1; i <= 1; i++) {
            allList.add(i + "");
        }

        List<List<String>> groupList = CollectionGroupUtil.groupListByQuantity(allList, 50);
        int i = 0;
        List<String> list = null;
        for (int c = 0; c < groupList.size(); c++) {
            list = groupList.get(c);

            System.out.println("第" + (c + 1) + "组： ");
            for (String temp : list) {
                System.out.print(temp + ", ");
            }
            System.out.println();
        }
    }

    public void test7() {
        String java = "1111{\"AppKey\":\"111\",\"Sign\":null,\"TimeStamp\":\"1639382106576\",\"Method\":\"mq.send.batchmessage\",\"Context\":\"{\\\"Messages\\\":[{\\\"Id\\\":0,\\\"TopicName\\\":\\\"beefun.record.stock\\\",\\\"Content\\\":\\\"{\\\\\\\"isSyncSku\\\\\\\":true,\\\\\\\"messageType\\\\\\\":0,\\\\\\\"profileId\\\\\\\":123456,\\\\\\\"skuIds\\\\\\\":[],\\\\\\\"skuId\\\\\\\":0,\\\\\\\"ptypeId\\\\\\\":null,\\\\\\\"sourceName\\\\\\\":null,\\\\\\\"storeId\\\\\\\":0,\\\\\\\"qty\\\\\\\":0}\\\"}]}\",\"RequestId\":null}1111";
        String c = "1111{\"AppKey\":\"111\",\"Sign\":null,\"TimeStamp\":\"1639382106576\",\"Method\":\"mq.send.batchmessage\",\"Context\":\"{\\\"Messages\\\":[{\\\"Id\\\":0,\\\"TopicName\\\":\\\"beefun.record.stock\\\",\\\"Content\\\":\\\"{\\\\\\\"isSyncSku\\\\\\\":true,\\\\\\\"messageType\\\\\\\":0,\\\\\\\"profileId\\\\\\\":123456,\\\\\\\"skuIds\\\\\\\":[],\\\\\\\"skuId\\\\\\\":0,\\\\\\\"ptypeId\\\\\\\":null,\\\\\\\"sourceName\\\\\\\":null,\\\\\\\"storeId\\\\\\\":0,\\\\\\\"qty\\\\\\\":0}\\\"}]}\",\"RequestId\":null}1111";
        System.out.println(java.equals(c));
    }

    public void test8() {
        List<Object> objects = Arrays.asList(null);
        System.out.println(objects.toString());
    }

    public void test9(Map<String, List<String>> map) {
        List<String> a = map.get("a");
//		changeList = changeList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getSourceId() + ";" + o.getSourceType()))), ArrayList::new));
        List<String> newA = a.stream().filter(s -> s.equals("0")).collect(Collectors.toList());
        map.put("a", newA);
        System.out.println(map);
    }

    public void test10(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int t = 0; t < n; t++) {
            list.add(t);
        }

        int size = list.size();
        int batchCount = 200;
        int limit = size % batchCount == 0 ? size / batchCount : (size / batchCount + 1);

        int fromIndex, toIndex;
        for (int i = 0; i < limit; i++) {
            fromIndex = i * batchCount;
            toIndex = Math.min(size, fromIndex + batchCount);
            System.out.println("第" + (i + 1) + "次分批：" + list.subList(fromIndex, toIndex));
        }
    }

    public void test11() {
        MonitorInfo monitorInfo = null;
        try {
            monitorInfo = MonitorUtils.getMonitorInfoBean();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("JVM可使用内存=" + monitorInfo.getTotalMemory() +
                "MB");
        System.out.println("JVM剩余内存=" + monitorInfo.getFreeMemory() + "MB");
        System.out.println("JVM最大可使用内存=" + monitorInfo.getMaxMemory() +
                "MB");

        System.out.println("操作系统=" + monitorInfo.getOsName());
        System.out.println("核心数=" + monitorInfo.getProcessors());
        System.out.println("总的物理内存=" + monitorInfo.getTotalMemorySize() + "GB");
        System.out.println("剩余的物理内存=" + monitorInfo.getFreeMemorySize() + "GB");
        System.out
                .println("已使用的物理内存=" + monitorInfo.getUsedMemorySize() + "GB");
    }

    public <T> List<T> splitStringToList(String str, String splitStr, Class<T> tClass) {
        List<T> result = new ArrayList<>();
        try {
            String[] arr = str.split(splitStr);
            for (int i = 0; i < arr.length; i++){
                T n;
                if (BigInteger.class.equals(tClass)) {
                    n = (T) new BigInteger(arr[i]);
                } else if (Integer.class.equals(tClass)) {
                    n = (T) new Integer(arr[i]);
                } else if (String.class.equals(tClass)) {
                    n = (T) arr[i];
                } else {
                    throw new RuntimeException("无法转为当前类型：" + tClass.getSimpleName());
                }
                result.add(n);
            }

            return result;
        }catch (Exception e){
            throw new RuntimeException("字符串拆分到列表异常：" + e.getMessage(), e);
        }
    }
}
