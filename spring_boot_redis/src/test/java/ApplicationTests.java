import com.lyndon.util.Application;
import com.lyndon.util.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyndon on 2018/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Resource
    private RedisService redisService;

    private static List<Object> list = null;

    static {
        list = new ArrayList<>();
        list.add("22");
        list.add("33");
    }

    @Test
    public void setReidsList() {
        redisService.setList(list,list);
    }


    @Test
    public void getReidsList() {
        List re = redisService.getAllListByKey(list);
        System.out.print(re.size());
    }

    @Test
    public void delReidsList() {
        boolean re = redisService.delKey(list);
        System.out.print(re);
    }



}
