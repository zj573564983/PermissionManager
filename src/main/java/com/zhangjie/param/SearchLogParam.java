package com.zhangjie.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @author zhangjie
 * @date 2019/4/18 15:35
 */
@Getter
@Setter
@ToString
public class SearchLogParam {

    private Integer type; // LogType

    private String beforeSeg;

    private String afterSeg;

    private String operator;

    private String fromTime;//yyyy-MM-dd HH:mm:ss

    private String toTime;
}
