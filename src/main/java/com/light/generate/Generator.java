package com.light.generate;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Generator {

  public static void main(String[] args) {
    FastAutoGenerator.create(
            "jdbc:mysql://127.0.0.1:3306/demo_ds_0?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8",
            "root", "123456")
        .globalConfig(builder -> {
          builder.author("wishare") // 设置作者
              .enableSwagger() // 开启 swagger 模式
              .dateType(DateType.TIME_PACK)
//              .fileOverride() // 覆盖已生成文件
              .outputDir("D:\\IdeaProjects\\wishare_code_generator\\src\\main\\java"); // 指定输出目录
        })
        .packageConfig(builder -> {
          builder.parent("com.light.generate")
//              .moduleName("sys")
//              .moduleName(null)
              .entity("entity")
              .service("service")
              .serviceImpl("service.impl")
              .mapper("mapper")
              .xml("mapper.xml")
              .controller("controller")
              //其他
              .other("")
              .pathInfo(Collections.singletonMap(OutputFile.xml,
                  "D:\\IdeaProjects\\wishare_code_generator\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
        })
        .templateConfig(template -> {
          template.entity("/templates/entity.java")
              .service("/templates/service.java")
              .serviceImpl("/templates/serviceImpl.java")
              .mapper("/templates/mapper.java")
              .xml("/templates/mapper.xml")
              .controller("/templates/controller.java");
        })
        .injectionConfig(builder -> {
          final Map<String, Object> customMap = new HashMap<>(4);
          //数据库对象后缀
          customMap.put("DOSuffix", "DO");
          //数据传输对象后缀
          customMap.put("DTOSuffix", "DTO");
          // 视图VO后缀
          customMap.put("VOSuffix", "VO");
          // 业务请求对象后缀
          customMap.put("ROSuffix", "RO");
          final Properties properties = new Properties();
          properties.setProperty("suffix", "DTO.java");
          properties.setProperty("packageName", "dto");
          customMap.put("dto", properties);
          final Map<String, String> customFile = new HashMap<>();
          customFile.put("dto", "/templates/dto.java.ftl");
          final Properties properties1 = new Properties();
          properties1.setProperty("suffix", "VO.java");
          properties1.setProperty("packageName", "vo");
          customMap.put("vo", properties1);
          customFile.put("vo", "/templates/vo.java.ftl");
          final Properties properties2 = new Properties();
          properties2.setProperty("suffix", "RO.java");
          properties2.setProperty("packageName", "ro");
          customMap.put("ro", properties2);
          customFile.put("ro", "/templates/requestParameter.java.ftl");
          builder.beforeOutputFile((tableInfo, objectMap) -> {
                System.out.println(
                    "tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
              })
              .customMap(customMap)
              .customFile(customFile)
          ;
        })
        .strategyConfig(builder -> {
          builder.enableCapitalMode()
              .enableCapitalMode()
              .enableSkipView()
              .disableSqlFilter()
//              .likeTable(new LikeTable("USER"))
              .addInclude("user")
//              .addTablePrefix("t_", "c_")
//              .addFieldSuffix("_flag")
              .mapperBuilder()
              .superClass(BaseMapper.class)
              .enableMapperAnnotation()
              .enableBaseResultMap()
              .enableBaseColumnList()
//              .cache(MyMapperCache.class)
              .formatMapperFileName("%sMapper")
              .formatXmlFileName("%sMapper")
              .entityBuilder()
//              .superClass(BaseEntity.class)
              .disableSerialVersionUID()
              .enableChainModel()
              .enableLombok()
//              开启生成字段常量
              .enableColumnConstant()
//              开启 Boolean 类型字段移除 is 前缀
//              .enableRemoveIsPrefix()
              .enableTableFieldAnnotation()
              .enableActiveRecord()
//              .versionColumnName("version")
//              .versionPropertyName("version")
//              .logicDeleteColumnName("deleted")
//              .logicDeletePropertyName("deleteFlag")
              .naming(NamingStrategy.no_change)
              .columnNaming(NamingStrategy.no_change)
//              .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
//              .addIgnoreColumns("age")
              .addTableFills(new Column("create_time", FieldFill.INSERT))
              .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
              .idType(IdType.AUTO)
              .formatFileName("%sDO")
              .controllerBuilder()
//              .superClass(BaseController.class)
              .enableHyphenStyle()
              .enableRestStyle()
              .formatFileName("%sController")
              .serviceBuilder()
//              .superServiceClass(BaseService.class)
//              .superServiceImplClass(BaseServiceImpl.class)
              .formatServiceFileName("%sService")
              .formatServiceImplFileName("%sServiceImp")

          ;
        })
        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板

        .execute();
  }
}
