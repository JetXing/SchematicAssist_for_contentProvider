package com.example.model;

import com.example.base.BaseList;

import java.util.List;
import java.util.Map;

/**
 * Created by xingguangyao on 14/11/24.
 */
public class ModelDataBuild {

    public static final String INTEGER = "long";

    public static final String TEXT = "String";

    public static final String BLOB = "boolean";

    public static final String PUBLIC = "public";

    public static final String CLASS = "class";

    public static final String START = "{";

    public static final String END = "}";

    public static final String NEWLINE = "\r\n";

    public static final String QUOTING = "\"";

    public static final String SEMICOLON = ";";

    public static final String TEMP = " ";

    public static String TYPE = "@SerializedName(\"%s\")%spublic %s ";

    public static final String SPLIT = "_";

    /**
     * 指定数据类型
     */
    public String dataType;

    private String getStart(String className) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PUBLIC).append(TEMP).append(CLASS).append(TEMP)
                .append(className).append(TEMP).append(START).append(NEWLINE).append(NEWLINE);
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
            stringBuilder.append(String.format(TYPE, string, NEWLINE, dataType)).append(getVariateName(string))
                    .append(SEMICOLON).append(NEWLINE).append(NEWLINE);
        }

        return stringBuilder.toString();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;

    }

    public String getVariateName(String variateName){
        StringBuffer mStringBuffer = getStringBuffer();
        String[] strings = variateName.split(SPLIT);
        int size = strings.length;
        for (int i = 0; i < size ; i++){
            if (i == 0){
                mStringBuffer.append(strings[i]);
            } else {
                strings[i] = strings[i].replace(strings[i].substring(0, 1), strings[i].substring(0,1).toUpperCase());
                mStringBuffer.append(strings[i]);

            }
        }

        return mStringBuffer.toString();
    }

    public StringBuffer getStringBuffer(){
        return new StringBuffer();
    }

    public ModelDataBuild() {
    }

    /**
     * 根据map生成指定的类，但是不是按照指定的顺序生成，因为map是无序的
     * @param className
     * @param map
     * @return
     */
    public String getInterface(String className, Map<String, String> map){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getStart(className));

        for (Map.Entry<String, String> entry : map.entrySet()){
            if (entry.getKey().contains(BLOB)){
                setDataType(BLOB);
            } else if(entry.getKey().contains(TEXT)){
                setDataType(TEXT);
            } else if (entry.getKey().contains(INTEGER)){
                setDataType(INTEGER);
            }
            stringBuilder.append(getString(entry.getValue()));
        }

          return stringBuilder.append(END).toString();

    }

    /**
     * 根据list生成指定的类，按照顺序生成
     * @param name
     * @param mLists
     * @return
     */
    public String getInterface(String name, List<BaseList> mLists){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getStart(name));
        for (BaseList mBaseList : mLists){
            setDataType(mBaseList.getType());
            for (String string : mBaseList.getmList()){
                stringBuilder.append(getString(string));
            }
        }

        return stringBuilder.append(END).toString();
    }
}
