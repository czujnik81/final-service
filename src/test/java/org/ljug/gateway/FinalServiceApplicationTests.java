package org.ljug.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"ZIPKIN_URL = localhost:9411"})
public class FinalServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
