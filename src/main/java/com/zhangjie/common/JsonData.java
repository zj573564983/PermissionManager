package com.zhangjie.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/***
 * @author zhangjie
 * @date 2019/4/10 19:25
 */
@Getter
@Setter
public class JsonData {

    private boolean ret;

    private String msg;

    private Object data;

    public JsonData(boolean ret){
        this.ret=ret;
    }

    public static JsonData success(Object object,String msg){
        JsonData jsonData=new JsonData(true);
        jsonData.data=object;
        jsonData.msg=msg;
        return jsonData;
    }

    public static JsonData success(Object object){
        JsonData jsonData=new JsonData(true);
        jsonData.data=object;
        return jsonData;
    }

    public static JsonData fail(String msg){
        JsonData jsonData=new JsonData(false);
        jsonData.msg=msg;
        return jsonData;
    }

    public static JsonData success(){
        return new JsonData(true);
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result=new HashMap<>();
        result.put("ret",ret);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }
}
