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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("专业")
@TableName("major")
public class Major implements Serializable {

    @ApiModelProperty(value = "主键")
    @TableId(type = IdType.AUTO,value = "id")
    private int id;

    @ApiModelProperty(value = "专业名称")
    private String name;

    @ApiModelProperty(value = "学院id")
    private int instituteId;

}
