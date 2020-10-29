package icu.bitchigo.sh.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher")
@ApiModel(value = "老师类")
public class Teacher {
    @TableId(type = IdType.AUTO,value = "id")
    @ApiModelProperty(value = "主键")
    private int id;
    @ApiModelProperty(value = "老师名字")
    private String name;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "账号")
    private String number;

}
