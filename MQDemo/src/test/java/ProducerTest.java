import com.anhua.RabbitmqProducerApplication;
import com.anhua.dao.User;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@SpringBootTest(classes = RabbitmqProducerApplication.class)
public class ProducerTest {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void simpleProduct() throws UnsupportedEncodingException {
        for (int num = 0; num < 20; num++) {
            User user=new User(num+"",num+"");
            Gson gson = new Gson();
            String jsonString = gson.toJson(user);
            rabbitTemplate.convertAndSend("simpleQueue", user.toString().getBytes("UTF-8") );
            rabbitTemplate.convertAndSend("simpleQueue2", user.toString() );
//            rabbitTemplate.convertAndSend("simpleQueue3","杨安华" );
//            User myObject = gson.fromJson(jsonString, User.class);
//            System.out.println(myObject.toString());
//            rabbitTemplate.convertAndSend("simpleQueue", user);
//            rabbitTemplate.convertAndSend("simpleQueue", "简单模式ba"+num);

        }
    }
}
