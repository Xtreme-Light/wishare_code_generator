package com.light.generate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wishare
 * @since 2022-04-02
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Accessors(chain = true)
@TableName("user")
@ApiModel(value = "user表对象", description = "")
public class UserDO extends Model<UserDO> {

    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String AGE = "age";

    public static final String EMAIL = "email";

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
