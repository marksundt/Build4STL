package demo.Controller;
import demo.services.cardService;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
public class UserController {

    @RequestMapping("/user/donate")
    public ResponseEntity<String> getResource() {
       cardService cardService = new cardService();
        String result = cardService.chargeCard("4111111111111111", "0919", "2.00");
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
