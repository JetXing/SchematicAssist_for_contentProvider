package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingguangyao on 14/11/25.
 */
public class BaseList {

    private String type;

    private List<String> mList = new ArrayList<String>();

    public BaseList(String type){
        this.type = type;
    }

    public List<String> setList(String... strings){
        for (String string : strings){
            mList.add(string);
        }
        return mList;
    }

    public void clearList(){
        this.mList.clear();
    }

    public List<String> getmList() {
        return mList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
