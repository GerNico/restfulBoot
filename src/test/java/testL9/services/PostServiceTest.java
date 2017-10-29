package testL9.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import testL9.model.Post;
import testL9.model.Tag;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PostServiceTest {

    @Autowired
    private PostService postService;

    private Post post1 = new Post(1, "Spring", "3 Steps",
            Arrays.asList(new Tag(1, "boot"),
                    new Tag(2, "mvc"),
                    new Tag(3, "security")));
    private Post post2 = new Post(2, "Java Core", "2 Steps",
            Arrays.asList(new Tag(4, "basic core"),
                    new Tag(5, "advanced topics")));
    private List<Post> posts = Arrays.asList(post1, post2);

    @Before
    public void initial() {
        postService.save(post1);
    }

    @Test
    public void getPostTestEquals() throws Exception {
        Post actual = postService.get(1);
        assertEquals(actual, post1);
    }

    @Test
    public void getAllTest() {
        postService.save(post2);
        List<Post> actualPosts = postService.getAll();
        for (int i = 0; i < posts.size(); i++) {
            assertEquals(actualPosts.get(i), posts.get(i));
        }
    }

    @Test
    public void deleteTest() {
        if (postService.get(2) == null) {
            postService.save(post2);
        }
        Post actual = postService.get(2);
        assertEquals(actual, post2);
        postService.delete(2);
        actual = postService.get(2);
        assertNull(actual);
    }


    @Test
    public void updateTest() {
        if (postService.get(2) == null) {
            postService.save(post2);
        }
        Post updated = new Post(2, "Java Core Updated", "3 Steps",
                Arrays.asList(new Tag(4, "basic core"),
                        new Tag(5, "advanced topics, design patterns"),
                        new Tag(6, "Java8 Intro")));
        postService.save(updated);
        Post actual = postService.get(2);
        assertEquals(actual, updated);
    }
}