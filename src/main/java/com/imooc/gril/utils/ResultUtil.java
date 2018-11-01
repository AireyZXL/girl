package com.imooc.gril.utils;

import com.imooc.gril.domain.Result;

/**
 * TODO
 *
 * @author zxlei1
 * @date 2018/10/31 21:58
 */
public class ResultUtil {

    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result succcess() {
        return success(null);
    }

    public static Result error(Object obj) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("失败");
        result.setData(obj);
        return result;


    }
}
