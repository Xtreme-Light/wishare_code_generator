package com.light.generate.ro;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
* <p>
* 
* </p>
*
* @author wishare
* @since 2022-04-02
*/
@Data
@Accessors(chain = true)
@ApiModel(value = "user请求对象", description = "")
public class UserRO {
  @ApiModelProperty("主键ID")
  private Long id;
  @ApiModelProperty("姓名")
  private String name;
  @ApiModelProperty("年龄")
  private Integer age;
  @ApiModelProperty("邮箱")
  private String email;

}
