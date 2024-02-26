package com.cbfacademy.apiassessment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;




// Use the random port to test out test from a random port.
@SpringBootTest(webEnvironment = SpringBootTest. WebEnvironment.RANDOM_PORT)

// The name of the class we will use to test.
class RecipeControllerTest {

  @LocalServerPort
  private int port;

  private URL base;
 
  // Used to perform HTTP request to the endpoints we wan to test. 
  @Autowired
  private TestRestTemplate restTemplate;

// This injection will mock the RecipeController class in order to allow for mock testing.
  @MockBean
  private RecipeService recipeService;



  @BeforeEach
  public void setUp() throws Exception {
    this.base = new URL("http://localhost:" + port + "/api/recipes");
    MockitoAnnotations.openMocks(this);
  }


@Test 
@DisplayName("/searchByRecipe endpoint which returns expected response for Search Recipe By Name")
void testSearchRecipeByName() throws Exception {

String recipeName = "Recipe Peanut Pie";
List <Recipe> recipes = new ArrayList<>();
recipes.add(new Recipe());
when(recipeService.searchRecipeByName(recipeName)).thenReturn(recipes);

ResponseEntity<List> response = ((Object) restTemplate.getForEntity(base.toString() + "/name/" + recipeName, List.class).getBody()).hasSize(1); 

assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);



    }   

}