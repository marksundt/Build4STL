package demo.Controller;


import demo.services.cardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    @RequestMapping("/user/signup")
    public ResponseEntity<String> signUpUser() {

       String result = "test";
        return new ResponseEntity<String>(result, HttpStatus.OK);

    }
    @RequestMapping("/user/donate")
    public ResponseEntity<String> donate() {

        cardService cardService = new cardService();

        String result = cardService.chargeCard("4111111111111111" , "0919","2.00");
        return new ResponseEntity<String>(result, HttpStatus.OK);

    }
}
