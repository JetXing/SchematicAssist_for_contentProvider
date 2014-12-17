package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xingguangyao on 14/11/26.
 * 生成数据库中的column
 */
public class ColumnUtils implements BaseUtils{


    private String getColumnUseMap(ColumnBuild mColumnBuild){

        Map<String, String> map = new RepetitionHashMap();

        map.put(mColumnBuild.TEXT, "id");
        map.put(mColumnBuild.INTEGER, "number");
        map.put(mColumnBuild.TEXT, "name");
        map.put(mColumnBuild.TEXT, "avatar_url");
        return mColumnBuild.getInterface("OrgsColumn", "BaseColumn", map);
        /* result
        public interface RepositoryColumn extends BaseColumn {
            @DataType(INTEGER)
            String SIZE = "size";

            @DataType(BLOB)
            String FORK = "fork";

            @DataType(BLOB)
            String HASDOWNLOADS = "hasDownloads";

            @DataType(TEXT)
            String PUSHEDAT = "pushedAt";

            @DataType(INTEGER)
            String WATCHERS = "watchers";

            @DataType(TEXT)
            String UPDATEDAT = "updatedAt";

        }*/


        
    }

    /**
     * 主要更改类
     * @return
     */
    private String getColumnUseList(){
        ColumnBuild mColumnBuild = new ColumnBuild();
        List<BaseList> mLists = new ArrayList<BaseList>();
        BaseList mBaseList = new BaseList(ColumnBuild.INTEGER);
        mBaseList.setList("number");
        mLists.add(mBaseList);

//        BaseList mBaseList1 = new BaseList("Owner");
//        mBaseList1.setList("owner");
//        mLists.add(mBaseList1);

        BaseList mBaseList2 = new BaseList(ColumnBuild.TEXT);
        mBaseList2.setList("id", "subject", "head_ref", "base_ref", "head_commit", "base_commit", "state", "created_at", "updated_at");
        mLists.add(mBaseList2);

//        BaseList mBaseList4 = new BaseList(ColumnBuild.TEXT);
//        mBaseList4.setList( "default_branch");
//        mLists.add(mBaseList4);
//
//        BaseList mBaseList5 = new BaseList(ColumnBuild.INTEGER);
//        mBaseList5.setList( "forks_count", "watchers_count");
//        mLists.add(mBaseList5);
        return mColumnBuild.getInterface("PullColumn", "BaseColumn", mLists);
        /* result
        public interface RepositoryColumn extends BaseColumn {
            @DataType(BLOB)
            String FORK = "fork";

            @DataType(BLOB)
            String HASDOWNLOADS = "hasDownloads";

            @DataType(TEXT)
            String CREATEDAT = "createdAt";

            @DataType(TEXT)
            String UPDATEDAT = "updatedAt";

        }*/
    }

    @Override
    public String getClassData() {
        return getColumnUseList();
    }
}
