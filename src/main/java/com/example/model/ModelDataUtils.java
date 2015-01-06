package com.example.model;

import com.example.base.BaseList;
import com.example.base.BaseUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingguangyao on 14/11/26.
 * 生成json解析的标准类
 */
public class ModelDataUtils implements BaseUtils {

    /**
     * 主要更改类
     * @return
     */
    private String getModelData(){

        ModelDataBuild modelDataBuild = new ModelDataBuild();

        List<BaseList> mLists = new ArrayList<BaseList>();
        BaseList mBaseList = new BaseList(ModelDataBuild.INTEGER);
        mBaseList.setList("number");
        mLists.add(mBaseList);
//
        BaseList mBaseList1 = new BaseList("User");
        mBaseList1.setList("creator");
        mLists.add(mBaseList1);

        BaseList mBaseList2 = new BaseList(ModelDataBuild.TEXT);
        mBaseList2.setList("id", "subject", "head_ref", "base_ref", "head_commit", "base_commit", "state", "created_at", "updated_at");
        mLists.add(mBaseList2);
//
//        BaseList mBaseList3 = new BaseList(ModelDataBuild.BLOB);
//        mBaseList3.setList( "private", "fork");
//        mLists.add(mBaseList3);
//
//        BaseList mBaseList4 = new BaseList(ModelDataBuild.TEXT);
//        mBaseList4.setList( "default_branch");
//        mLists.add(mBaseList4);
//
//        BaseList mBaseList5 = new BaseList(ModelDataBuild.INTEGER);
//        mBaseList5.setList( "forks_count", "watchers_count");
//        mLists.add(mBaseList5);


        return modelDataBuild.getInterface("Project", mLists);
    }

    @Override
    public String getClassData() {
        return getModelData();
    }
}
