package af.cmr.indyli.akdemia.ws.config;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@OpenAPIDefinition(info = @Info(title = "akdemia", version = "1.0", description = "akdemia", contact = @Contact(name = "akdemia")), security = {@SecurityRequirement(name = "bearerToken")})
@Import(AkdemiaBusinessGp4eConfig.class)
@ComponentScan(basePackages = {"af.cmr.indyli.akdemia.ws.*"})
public class AkdemiaWsGp4eConfig {

}