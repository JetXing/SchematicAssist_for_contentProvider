package com.example;

import java.util.HashMap;

/**
 * Created by xingguangyao on 14/11/25.
 */
public class RepetitionHashMap extends HashMap<String, String> {

    public static int keyTemp = 0;

    @Override
    public String put(String key, String value) {
        if (containsKey(key)){
            key = new StringBuffer().append(key).append(keyTemp).toString();
            keyTemp ++;
        }

        return super.put(key, value);
    }
}
