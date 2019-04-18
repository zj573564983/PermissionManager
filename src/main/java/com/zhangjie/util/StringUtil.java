package com.zhangjie.util;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

/***
 * @author zhangjie
 * @date 2019/4/18 13:10
 */
public class StringUtil {
    public static List<Integer> splitToListInt(String str) {
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        return strList.stream().map(strItem -> Integer.parseInt(strItem)).collect(Collectors.toList());
    }
}
