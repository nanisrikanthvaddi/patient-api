package com.acn.patient.api.config;

 import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.AcceptHeaderApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;

public class SwaggerConfig {
    public SwaggerConfig() {
    }

    public static void initSwagger(String title, String description, String contact, String license, String termsOfServiceUrl, String xCategory, String path, String host, ResourceConfig applicationConfig) {
        initSwagger(title, description, contact, license, termsOfServiceUrl, xCategory, host, applicationConfig, path);
    }

    public static void initSwagger(String title, String description, String contact, String license, String termsOfServiceUrl, String xCategory, String host, ResourceConfig applicationConfig, String path) {
        initSwaggerBeanConfig(title, description, contact, license, termsOfServiceUrl, xCategory, host, applicationConfig, path);
         applicationConfig.register(AcceptHeaderApiListingResource.class);
        applicationConfig.register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
    }

    private static void initSwaggerBeanConfig(String title, String description, String contact, String license, String termsOfServiceUrl, String xCategory, String host, ResourceConfig applicationConfig, String path) {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle(title);
        beanConfig.setDescription(description);
        beanConfig.setTermsOfServiceUrl(termsOfServiceUrl);
        beanConfig.setContact(contact);
        beanConfig.setLicense(license);
        beanConfig.setSchemes(new String[]{"http", "https"});
        beanConfig.setHost(host);
        beanConfig.setBasePath(path);
        String packages = "com.acn.patient.api.config";
        beanConfig.setResourcePackage(packages);
        beanConfig.setConfigId(path);
        beanConfig.setScan(true);
    }
}

