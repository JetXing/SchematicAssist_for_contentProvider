package com.example.column;


import com.example.base.BaseList;
import com.example.base.BaseUtils;
import com.example.base.RepetitionHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xingguangyao on 14/11/26.
 * 生成数据库中的column
 */
public class ColumnUtils implements BaseUtils {


    private String getColumnUseMap(ColumnBuild mColumnBuild) {

        Map<String, String> map = new RepetitionHashMap();

        map.put(mColumnBuild.TEXT, "id");
        map.put(mColumnBuild.INTEGER, "number");
        map.put(mColumnBuild.TEXT, "name");
        map.put(mColumnBuild.TEXT, "avatar_url");
        return mColumnBuild.getInterface("OrgsColumn", "BaseColumn", map);


    }

    /**
     * 主要更改类
     *
     * @return
     */
    private String getColumnUseList() {
        ColumnBuild mColumnBuild = new ColumnBuild();
        List<BaseList> mLists = new ArrayList<BaseList>();
        BaseList mBaseList = new BaseList(ColumnBuild.INTEGER);
        mBaseList.setList("number");
        mLists.add(mBaseList);


        BaseList mBaseList2 = new BaseList(ColumnBuild.TEXT);
        mBaseList2.setList("id", "subject", "head_ref", "base_ref", "head_commit", "base_commit", "state", "created_at", "updated_at");
        mLists.add(mBaseList2);

        return mColumnBuild.getInterface("PullColumn", "BaseColumn", mLists);
    }

    @Override
    public String getClassData() {
        return getColumnUseList();
    }
}
