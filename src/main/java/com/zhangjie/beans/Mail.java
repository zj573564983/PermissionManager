package com.zhangjie.beans;

import lombok.*;

import java.util.Set;

/***
 * @author zhangjie
 * @date 2019/4/17 9:25
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    private String subject;

    private String message;

    private Set<String> receivers;
}
