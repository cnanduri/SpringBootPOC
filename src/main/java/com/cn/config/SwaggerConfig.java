package com.cn.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.vo.ApiError;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String API_ERROR = "ApiError";
	private static final String VOID = "Void";
	@Autowired
	private TypeResolver resolver;

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("User Management API")
				.description("API to perform CRUD operations on User").build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(headerParameters())
				.globalResponseMessage(RequestMethod.GET, responseMessages())
				.globalResponseMessage(RequestMethod.PUT, responseMessages())
				.globalResponseMessage(RequestMethod.POST, responseMessages())
				.useDefaultResponseMessages(false).apiInfo(apiInfo())
				.additionalModels(resolver.resolve(ApiError.class)).select()
				.apis(Predicates.not(RequestHandlerSelectors
						.basePackage("org.springframework.boot")))
				.build();
	}

	private List<ResponseMessage> responseMessages() {
		List<ResponseMessage> responseMessages = new ArrayList<>();

		ResponseMessage badRequestRespMsg = new ResponseMessageBuilder()
				.code(HttpStatus.BAD_REQUEST.value())
				.message(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.responseModel(new ModelRef(API_ERROR)).build();

		responseMessages.add(badRequestRespMsg);

		ResponseMessage unauthorizedRespMsg = new ResponseMessageBuilder()
				.code(HttpStatus.BAD_REQUEST.value())
				.message(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.responseModel(new ModelRef(API_ERROR)).build();

		responseMessages.add(unauthorizedRespMsg);

		ResponseMessage forbiddenRespMsg = new ResponseMessageBuilder()
				.code(HttpStatus.BAD_REQUEST.value())
				.message(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.responseModel(new ModelRef(VOID)).build();

		responseMessages.add(forbiddenRespMsg);

		ResponseMessage notFoundRespMsg = new ResponseMessageBuilder()
				.code(HttpStatus.BAD_REQUEST.value())
				.message(HttpStatus.BAD_REQUEST.getReasonPhrase())
				.responseModel(new ModelRef(API_ERROR)).build();

		responseMessages.add(notFoundRespMsg);

		ResponseMessage unsupportedMediaTypeRespMsg = new ResponseMessageBuilder()
				.code(HttpStatus.SERVICE_UNAVAILABLE.value())
				.message(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase())
				.responseModel(new ModelRef(VOID)).build();

		responseMessages.add(unsupportedMediaTypeRespMsg);

		ResponseMessage internalServerErrorRespMsg = new ResponseMessageBuilder()
				.code(HttpStatus.SERVICE_UNAVAILABLE.value())
				.message(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase())
				.responseModel(new ModelRef(API_ERROR)).build();

		responseMessages.add(internalServerErrorRespMsg);

		ResponseMessage serviceUnavailableRespMsg = new ResponseMessageBuilder()
				.code(HttpStatus.SERVICE_UNAVAILABLE.value())
				.message(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase())
				.responseModel(new ModelRef(VOID)).build();

		responseMessages.add(serviceUnavailableRespMsg);

		return responseMessages;
	}

	private List<Parameter> headerParameters() {
		List<Parameter> headerParameters = new ArrayList<>();

		Parameter contentTypeParam = getParameter("Content-Type",
				"MIME Type of the request", "string", "header", true);
		headerParameters.add(contentTypeParam);
		
		Parameter txnIdParam = getParameter("transactionId", "Transaction Id",
				"string", "header", true);
		headerParameters.add(txnIdParam);

		return headerParameters;
	}

	private Parameter getParameter(String name, String description,
			String modelRefType, String parameterType, boolean required) {
		Parameter param = new ParameterBuilder().name(name)
				.description(description).modelRef(new ModelRef(modelRefType))
				.parameterType(parameterType).required(required).build();

		return param;
	}

}
