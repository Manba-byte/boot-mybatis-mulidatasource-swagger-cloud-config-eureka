项目架构springboot + springcloud + mybatis
1.通过eureka提供注册中心
2.通过spring cloud config读取git仓库配置文件
3.annotaion-multiDatasource通过获取config读取下来的配置文件信息,配置多数据源结合swagger实现
单表的crud操作，以及使用pagehelper实现物理分页

记录踩坑：
	在springboot2.0以上版本,在进行eureka服务注册时,依赖的包为
	 <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>