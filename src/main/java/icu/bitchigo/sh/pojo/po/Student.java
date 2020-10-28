package icu.bitchigo.sh.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@ApiModel(value = "学生",description = "学生信息")
@AllArgsConstructor
@NoArgsConstructor
@TableName("student")
public class Student implements Serializable {
    @ApiModelProperty(value = "主键")
    @TableId(type = IdType.AUTO,value = "id")
    private int id;

    @ApiModelProperty(value = "学生名")
    private String name;

    @ApiModelProperty(value = "性别")
    private int sex;

    @ApiModelProperty(value = "专业id")
    private int majorId;

    @ApiModelProperty(value = "班级id")
    private int classId;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "学院id")
    private int instituteId;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "学号")
    private String number;
}
