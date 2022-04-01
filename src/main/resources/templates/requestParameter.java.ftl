package ${package.Parent}.${ro.packageName};



<#if swagger>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
import lombok.Data;
  <#if chainModel>
import lombok.experimental.Accessors;
  </#if>
</#if>
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
* <p>
* ${table.comment!}
* </p>
*
* @author ${author}
* @since ${date}
*/
<#if entityLombokModel>
@Data
    <#if chainModel>
@Accessors(chain = true)
    </#if>
</#if>
<#if swagger>
@ApiModel(value = "${table.name}请求对象", description = "${table.comment!}")
</#if>
public class ${table.name?cap_first}${ROSuffix} {
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
  <#if field.comment!?length gt 0>
  <#if swagger>
  @ApiModelProperty("${field.comment}")
  <#else>
  /**
  * ${field.comment}
  */
  </#if>
  </#if>
  <#if field.propertyType == 'LocalDateTime'>
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  <#elseif field.propertyType == 'LocalDate'>
  @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  <#elseif field.propertyType == 'LocalTime'>
  @JsonFormat(pattern = "HH:mm:ss",timezone = "GMT+8")
  @DateTimeFormat(pattern = "HH:mm:ss")
  <#else>
  </#if>
  private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->

}
