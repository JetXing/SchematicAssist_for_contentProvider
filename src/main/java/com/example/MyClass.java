package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyClass {

    public static void main(String[] args){

        UserBuild mUserBuild = new UserBuild();

        Map<String, String> map = new RepetitionHashMap();

        map.put(UserBuild.BLOB, "fork");
        map.put(UserBuild.BLOB, "hasDownloads");
        map.put(UserBuild.TEXT, "pushedAt");
        map.put(UserBuild.TEXT, "updatedAt");
        map.put(UserBuild.INTEGER, "size");
        map.put(UserBuild.INTEGER, "watchers");
        System.out.println(mUserBuild.getInterface("RepositoryColumn", "BaseColumn", map));
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


        List<BaseList> mLists = new ArrayList<BaseList>();
        BaseList mBaseList = new BaseList(UserBuild.BLOB);
        mBaseList.setList("fork", "hasDownloads");
        mLists.add(mBaseList);

        BaseList mBaseList1 = new BaseList(UserBuild.BLOB);
        mBaseList1.setType(UserBuild.TEXT);
        mBaseList1.setList("createdAt", "updatedAt");
        mLists.add(mBaseList1);
        System.out.println(mUserBuild.getInterface("RepositoryColumn", "BaseColumn", mLists));

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





}
