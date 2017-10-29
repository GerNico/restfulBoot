package testL9.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import testL9.model.Post;
import testL9.model.Tag;
import testL9.services.PostService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService service;

    private Post post1 = new Post(1, "Spring", "3 Steps",
            Arrays.asList(new Tag(1, "boot"),
                    new Tag(2, "mvc"),
                    new Tag(3, "security")));
    private Post post2 = new Post(2, "Java Core", "2 Steps",
            Arrays.asList(new Tag(4, "basic core"),
                    new Tag(5, "advanced topics")));
    private List<Post> posts = Arrays.asList(post1, post2);

    private String post1Json = "{\"id\": 1," +
            "  \"title\": \"Spring\"," +
            "  \"content\": \"3 Steps\"," +
            "  \"tags\": [" +
            "    {" +
            "      \"id\": 1," +
            "      \"content\": \"boot\"" +
            "    }," +
            "    {" +
            "      \"id\": 2," +
            "      \"content\": \"mvc\"" +
            "    }," +
            "    {" +
            "      \"id\": 3," +
            "      \"content\": \"security\"" +
            "    }" +
            "  ]" +
            "}";
    private String post2Json = "{\"id\": 2," +
            "  \"title\": \"Java Core\"," +
            "  \"content\": \"2 Steps\"," +
            "  \"tags\": [" +
            "    {" +
            "      \"id\": 4," +
            "      \"content\": \"basic core\"" +
            "    }," +
            "    {" +
            "      \"id\": 5," +
            "      \"content\": \"advanced topics\"" +
            "    }" +
            "  ]" +
            "}";
    String expected = "[" + post1Json + "," + post2Json + "]";


    @Test
    public void testPostController() throws Exception {

        given(service.getAll()).willReturn(posts);

        mockMvc.perform(get("/posts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Spring")))
                .andExpect(jsonPath("$[0].content", is("3 Steps")))
                .andExpect(jsonPath("$[0].tags", hasSize(3)))
                .andExpect(jsonPath("$[0].tags[*].id", containsInAnyOrder(1,2,3)))
                .andExpect(jsonPath("$[0].tags[*].content", containsInAnyOrder(
                        "boot","mvc","security")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("Java Core")))
                .andExpect(jsonPath("$[1].content", is("2 Steps")))
                .andExpect(jsonPath("$[1].tags", hasSize(2)))
                .andExpect(jsonPath("$[1].tags[*].id", containsInAnyOrder(4,5)))
                .andExpect(jsonPath("$[1].tags[*].content", containsInAnyOrder(
                        "basic core","advanced topics")))
        ;

    }

}

