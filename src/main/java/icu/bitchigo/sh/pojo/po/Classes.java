package icu.bitchigo.sh.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("classes")
@AllArgsConstructor
@Data
@NoArgsConstructor
@ApiModel(value = "班级",discriminator = "班级信息")
public class Classes implements Serializable {

    @ApiModelProperty(value = "主键")
    private int id;
    @ApiModelProperty(value = "班级名称")
    private String name;
    @ApiModelProperty(value = "专业id")
    private int majorId;
}
