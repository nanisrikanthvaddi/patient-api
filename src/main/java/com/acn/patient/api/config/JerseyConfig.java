package com.acn.patient.api.config;

import com.acn.patient.api.controller.PatientController;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import static com.acn.patient.api.config.SwaggerConfig.initSwagger;


import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        register(PatientController.class);

        register(JacksonJaxbJsonProvider.class);
        initSwagger(
                "API Health - Open API Scheme", "Health Services",
                "API Health Support Team",
                "Company Licence - http://www.accenture.com/licenses.html",
                "https://www.accenture.com/terms-and-conditions",
                "Health API",
                "api",
                "https://api-intrant.com.sg",
                this);

    }

}
