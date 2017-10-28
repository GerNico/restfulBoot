//package testL9.controllers;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import testL9.model.Post;
//import testL9.model.Tag;
//import testL9.services.PostService;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@WebAppConfiguration
//public class PostControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private Post post1 = new Post(1, "Spring", "3 Steps",
//            Arrays.asList(new Tag(1, "boot"),
//                    new Tag(2, "mvc"),
//                    new Tag(3, "security")));
//    private Post post2 = new Post(2, "Java Core", "2 Steps",
//            Arrays.asList(new Tag(4, "basic core"),
//                    new Tag(5, "advanced topics")));
//    private List<Post> posts = Arrays.asList(post1, post2);
//
//    private String post1Json = "{\"id\": 1," +
//            "  \"title\": \"Spring\"," +
//            "  \"content\": \"3 Steps\"," +
//            "  \"tags\": [" +
//            "    {" +
//            "      \"id\": 1," +
//            "      \"content\": \"boot\"" +
//            "    }," +
//            "    {" +
//            "      \"id\": 2," +
//            "      \"content\": \"mvc\"" +
//            "    }," +
//            "    {" +
//            "      \"id\": 3," +
//            "      \"content\": \"security\"" +
//            "    }" +
//            "  ]" +
//            "}";
//    private String post2Json = "{\"id\": 2," +
//            "  \"title\": \"Java Core\"," +
//            "  \"content\": \"2 Steps\"," +
//            "  \"tags\": [" +
//            "    {" +
//            "      \"id\": 4," +
//            "      \"content\": \"basic core\"" +
//            "    }," +
//            "    {" +
//            "      \"id\": 5," +
//            "      \"content\": \"advanced topics\"" +
//            "    }" +
//            "  ]" +
//            "}";
//    String expected = "[" + post1Json + "," + post2Json + "]";
//
//    @Before
//    public void setup() {
//        this.mockMvc = standaloneSetup(new PostController()).build();
//    }
//
//    @Test
//    public void testSayHelloWorld() throws Exception {
//this.mockMvc.perform(get("localhost:8080/posts"))
//        .andExpect(result -> re)
//
//    }
//}
