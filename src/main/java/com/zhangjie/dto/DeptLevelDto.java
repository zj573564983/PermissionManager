package com.zhangjie.dto;

import com.google.common.collect.Lists;
import com.zhangjie.model.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/***
 * @author zhangjie
 * @date 2019/4/11 9:50
 */
@Getter
@Setter
@ToString
public class DeptLevelDto extends SysDept {
    private List<DeptLevelDto> deptList = Lists.newArrayList();

    public static DeptLevelDto adapt(SysDept dept) {
        DeptLevelDto dto = new DeptLevelDto();
        BeanUtils.copyProperties(dept, dto);
        return dto;
    }
}
