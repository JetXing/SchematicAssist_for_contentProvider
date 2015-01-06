package com.example.base;

import com.example.column.ColumnUtils;
import com.example.model.ModelDataUtils;

/**
 * Created by xingguangyao on 14/11/30.
 */
public class UtilsFactory extends Factory {

    /**
     * 根据条件返回指定的类
     * @param flag
     * @return
     */
    @Override
    protected BaseUtils createUtils(boolean flag) {

        if (flag)
            return new ColumnUtils();
        return new ModelDataUtils();
    }
}
