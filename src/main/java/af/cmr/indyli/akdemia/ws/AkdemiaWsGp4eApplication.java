package af.cmr.indyli.akdemia.ws;

import af.cmr.indyli.akdemia.ws.config.AkdemiaWsGp4eConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AkdemiaWsGp4eConfig.class)
public class AkdemiaWsGp4eApplication {

    public static void main(String[] args) {
        SpringApplication.run(AkdemiaWsGp4eApplication.class, args);
    }

}
