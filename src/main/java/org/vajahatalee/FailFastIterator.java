package org.vajahatalee;

import java.util.HashMap;
import java.util.Map;

public class FailFastIterator {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");

        for(String key : map.keySet()){
            System.out.println(map.get(key));
            map.put("key3","value3");//this is throwing java.util.ConcurrentModificationException due to fail-fast
        }
    }

}
