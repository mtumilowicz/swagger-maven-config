# swagger
The main goal of this project is to test basic features of Swagger.

# preface
Swagger is an open source software framework that helps developers design, build, document, and consume RESTful Web services.

# technologies used

* processing annotations
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

* user friendly interface to display documentation & provide ecosystem for consuming RESTful Web services.
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>

# configuration
* add class annotations:
	@Configuration
	@EnableSwagger2

* configuration API:
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				... cofigs builder
				
* swagger ui will be available at: root/swagger-ui.html#
	in this project root = localhost:8080
		
# details
	* Docket
	    @Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.host(host()) // define hosts where swagger will be added
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(metaData());
		}
		
		private String host() {
		// supported hosts in spring application properties
			host = InetAddress.getLocalHost().getHostName();
		}

	* meta data
		private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Swagger")
                .description("\"Testing Swagger\"")
                .version("0.0.1-SNAPSHOT")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Michal Tumilowicz", 
                        "https://www.linkedin.com/in/mtumilowicz/", 
                        "michal.tumilowicz01@gmail.com"))
                .build();
		}
		// photo
	
	* documenting controller
		@Api(value="hello", description="Saying hello to everybody.")
		// photo
	
	* documenting operation
		@ApiOperation(value = "Greeting message.")
		// photo
		
	* documenting property
		@ApiModelProperty(notes = "Name that will be greeted", required = true)
		// photo
