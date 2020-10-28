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
@TableName("institute")
@ApiModel(value = "学院",description = "学院信息")
public class Institute implements Serializable {
    @ApiModelProperty(value = "主键")
    @TableId(type = IdType.AUTO,value = "id")
    private int id;

    @ApiModelProperty(value = "学院名称")
    private String name;

}
