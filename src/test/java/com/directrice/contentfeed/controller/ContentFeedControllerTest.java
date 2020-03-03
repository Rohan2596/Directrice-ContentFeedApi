package com.directrice.contentfeed.controller;


import com.directrice.contentfeed.dto.AddContentFeedDTO;
import com.directrice.contentfeed.response.Response;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class ContentFeedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private AddContentFeedDTO addContentFeedDTO;



    //CONTROLLER TESTS CASES FOR AddContentFeedDTO

    @Test
    void givenValidAddContentFeedDto_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO("Tech crunch disrupt",
             "By Rohan kadam",
             "Tech crunch disrupt is one of best disrupt to " +
                     "Silicon valley competion in best for startup ecosystem.",
             imageurls,
             discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(201,result.getResponse().getStatus());
        Assert.assertEquals("Content Added Successfully.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }

    @Test
    void givenInValidTitle_Null_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO(null,
                "rohan kadam",
                "sdfsdfsdfsdfsfsdfsfsfsfsdfsffsdfdsf",
                imageurls,
                discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(400,result.getResponse().getStatus());
        Assert.assertEquals("Title length should be min 6 and max 30.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }

    @Test
    void givenInValidTitle_Min_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO("tech",
                "rohan kadam",
                "sdfsdfsdfsdfsfsdfsfsfsfsdfsffsdfdsf",
                imageurls,
                discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(400,result.getResponse().getStatus());
        Assert.assertEquals("Title length should be min 6 and max 30.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }

    @Test
    void givenInValidTitle_Max_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO("tech crunchcvxvxxzvdxvsdfdsczxvdfdsa sd  aa dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd",
                "rohan kadam",
                "sdfsdfsdfsdfsfsdfsfsfsfsdfsffsdfdsf",
                imageurls,
                discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(400,result.getResponse().getStatus());
        Assert.assertEquals("Title length should be min 6 and max 30.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }


    @Test
    void givenInValidAuthor_Null_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO("Tech crunch",
                null,
                "sdfsdfsdfsdfsfsdfsfsfsfsdfsffsdfdsf",
                imageurls,
                discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(400,result.getResponse().getStatus());
        Assert.assertEquals("Author length should be min 6 and max 30.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }

    @Test
    void givenInValidAuthor_Min_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO("Tech crunch",
                "dsf",
                "sdfsdfsdfsdfsfsdfsfsfsfsdfsffsdfdsf",
                imageurls,
                discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(400,result.getResponse().getStatus());
        Assert.assertEquals("Author length should be min 6 and max 30.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }

    @Test
    void givenInValidAuthor_Max_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO("Tech crunch",
                "sdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffsdfffffffffffffffffffds",
                "sdfsdfsdfsdfsfsdfsfsfsfsdfsffsdfdsf",
                imageurls,
                discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(400,result.getResponse().getStatus());
        Assert.assertEquals("Author length should be min 6 and max 30.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }

    @Test
    void givenInValidDescription_Null_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO("Tech crunch",
                "sdffffffffffffffffffffds",
                null,
                imageurls,
                discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(400,result.getResponse().getStatus());
        Assert.assertEquals("Description length should be min 30 and max 500.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }

    @Test
    void givenInValidDescription_Min_WhenAuthenticated_shouldReturnValidResponse() throws Exception {
        String [] imagelist={"image1","image2","image3"};
        String [] fields={"Bitcoin","Etherum","Dollars"};
        List<String> imageurls= Arrays.asList(imagelist);
        List<String> discoverFields=Arrays.asList(fields);
        this.addContentFeedDTO=new AddContentFeedDTO("Tech crunch",
                "sdffffffffffffffffffffds",
                "dfdsfsfsfsdfdsfsdfdsf",
                imageurls,
                discoverFields);
        String addContentFeedDTO=new Gson().toJson(this.addContentFeedDTO);
        MvcResult result = this.mockMvc.perform(post("/directrice/content/add")
                .content(addContentFeedDTO)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        Assert.assertEquals(400,result.getResponse().getStatus());
        Assert.assertEquals("Description length should be min 30 and max 500.",
                new Gson().fromJson(result.getResponse().getContentAsString(), Response.class).message);

    }




}
