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
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("select")
@ApiModel("学生选课类")
public class Select implements Serializable {
    @ApiModelProperty(value = "主键")
    @TableId(type = IdType.AUTO,value = "id")
    private int id;

    @ApiModelProperty(value = "学生id")
    private int StudentId;

    @ApiModelProperty(value = "方向id")
    private int DirectionId;

    @ApiModelProperty(value = "最后更新时间")
    private Timestamp lastTime;

}
