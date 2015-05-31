package demo.Controller;
import dao.DaoStuff;
import demo.domain.Card;
import demo.domain.RedeemRequest;
import demo.domain.RedemptionCode;
import demo.services.cardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.domain.User;
import twilioService.thankYou;

@RestController
public class UserController {

    @RequestMapping("/user/donate")
    public ResponseEntity<String> donate(@RequestBody Card card) {
        cardService cardService = new cardService();
        String result = cardService.chargeCard(card.getCard(), "0919", card.getAmount());


            DaoStuff dao = new DaoStuff();

        return new ResponseEntity(result, HttpStatus.OK);

    }

    @RequestMapping("/user/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
      DaoStuff dao = new DaoStuff();
        String url = "\"https://api.orchestrate.io/v0/users/";
        url= url + user.getName();
        dao.createUser(url,user.getName(), user.getPhone(),user.getEmail());
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @RequestMapping("/user/createCard")
    public ResponseEntity<String> createCard() {
        cardService cardService = new cardService();
        String result = cardService.newCardToken("4111111111111111", "0919", "200", "VISA", "123 ave", "63105", "test");

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping("/user/redeemCode")
    public ResponseEntity<String> redeemCode (@RequestBody RedeemRequest req)  throws Exception{
        DaoStuff dao = new DaoStuff();

        RedemptionCode code = dao.redeemCode();
        thankYou  thankYou = new thankYou();

        String sid =
        String authToken=
        thankYou.thankYou(sid, authToken, code.getPhone(),code.getName(), req.getName(), "http://feed/stl/login");
        thankYou.redeemCode(sid, authToken, req.getName(), req.getPhone(), code.getCode());
        return new ResponseEntity(code, HttpStatus.OK);
    }

}
