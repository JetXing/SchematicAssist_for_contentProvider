package com.example;

import java.util.List;
import java.util.Map;

/**
 * Created by xingguangyao on 14/11/24.
 */
public class ColumnBuild {

    public static final String INTEGER = "INTEGER";

    public static final String TEXT = "TEXT";

    public static final String BLOB = "BLOB";

    public static final String REAL = "REAL";

    public static final String PUBLIC = "public";

    public static final String CLASS = "class";

    public static final String INTERFACE = "interface";

    public static final String START = "{";

    public static final String END = "}";

    public static final String EXTENDS = "extends";

    public static final String IMPLEMENTS = "implements";

    public static final String NEWLINE = "\r\n";

    public static final String QUOTING = "\"";

    public static final String SEMICOLON = ";";

    public static final String TEMP = " ";

    public static String TYPE = "@DataType(%s)%sString ";

    /**
     * 指定数据类型
     */
    public String dataType;

    private String getStart(String interfaceName, String parentName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PUBLIC).append(TEMP).append(INTERFACE).append(TEMP)
                .append(interfaceName).append(TEMP).append(EXTENDS).append(TEMP).append(parentName)
                .append(TEMP).append(START).append(NEWLINE).append(NEWLINE);
        return stringBuilder.toString();
    }

    /**
     * 生成一段String代码
     * @param strings
     * @return
     */
    public String getString(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(dataType).append(string.toUpperCase())
                    .append(" = ").append(QUOTING).append(string)
                    .append(QUOTING).append(SEMICOLON).append(NEWLINE)
                    .append(NEWLINE);
        }

        return stringBuilder.toString();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = String.format(TYPE, dataType, NEWLINE);
    }

    public ColumnBuild() {
    }

    /**
     * 根据map生成指定的类，但是不是按照指定的顺序生成，因为map是无序的
     * @param interfaceName 类名或接口名
     * @param parentName
     * @param map
     * @return
     */
    public String getInterface(String interfaceName, String parentName,Map<String, String> map){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getStart(interfaceName, parentName));

        for (Map.Entry<String, String> entry : map.entrySet()){
            if (entry.getKey().contains(BLOB)){
                setDataType(BLOB);
            } else if(entry.getKey().contains(TEXT)){
                setDataType(TEXT);
            } else if (entry.getKey().contains(INTEGER)){
                setDataType(INTEGER);
            } else if (entry.getKey().contains(REAL)){
                setDataType(REAL);
            }
            stringBuilder.append(getString(entry.getValue()));
        }

          return stringBuilder.append(END).toString();

    }

    /**
     * 根据list生成指定的类，按照顺序生成
     * @param interfaceName
     * @param parentName
     * @param mLists
     * @return
     */
    public String getInterface(String interfaceName, String parentName, List<BaseList> mLists){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getStart(interfaceName, parentName));
        for (BaseList mBaseList : mLists){
            setDataType(mBaseList.getType());
            for (String string : mBaseList.getmList()){
                stringBuilder.append(getString(string));
            }
        }

        return stringBuilder.append(END).toString();
    }
}
