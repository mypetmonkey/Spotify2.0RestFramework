package com.spotify2.test;

import org.testng.annotations.Test;
import com.spotify2.pojo.ErrorRoot;
import com.spotify2.pojo.Playlist;
import applicationAPI.PlaylistApi;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Epic("Spotify2.0 Oauth")
@Feature("Playlist API")
public class PlaylistTest {
	
	
	@Story("Create a playlist")
	@Issue("1234567")
	@TmsLink("tc-132")
    @Link("https://example.org")
	@Description("This is description")
	@Test(description = "Should be able to create a playlist")
	public void shouldBeAbletoCreateAPlaylist() {
		Playlist reqplaylist=new Playlist()
		.setName("My New Playlist")
		.setDescription("bhojpuri song collection")
		.setPublic(false);
		
		Response response=PlaylistApi.post(reqplaylist);
		assertThat(response.getStatusCode(), equalTo(201));
	    Playlist respPlaylist = response.as(Playlist.class);
		
	assertThat(respPlaylist.getName(),equalTo(reqplaylist.getName()));
	assertThat(respPlaylist.getDescription(),equalTo(reqplaylist.getDescription()));
	assertThat(respPlaylist.getPublic(),equalTo(reqplaylist.getPublic()));
	
	}
	
	
	
	
	
	@Test
	public void shouldBeAbletoGetAPlaylist() {
		Playlist reqplaylist=new Playlist()
				.setName("Updated Playlist Name- kumar sanu")
				.setDescription("Updated playlist description kumar sanu")
				.setPublic(true);
		
	 Response response = PlaylistApi.get("28jAHBHOLa7pOBNMOkuuOj");
	 assertThat(response.getStatusCode(),equalTo(200));
	 Playlist responsePlaylist = response.as(Playlist.class);

		assertThat(reqplaylist.getName(),equalTo(responsePlaylist.getName()));
		assertThat(reqplaylist.getDescription(),equalTo(responsePlaylist.getDescription()));
		assertThat(reqplaylist.getPublic(),equalTo(responsePlaylist.getPublic()));

	}
	
	
	
	
	
	@Test
	public void shouldBeAbletoUpdateAPlaylist() {
		
		Playlist reqplaylist=new Playlist()
				.setName("My New Playlist Bhojpuri")
				.setDescription("bhojpuri song collection")
				.setPublic(false);
		
		Response response=PlaylistApi.put(reqplaylist, "7qklEIaair760Fpq86m7hU");
		assertThat(response.getStatusCode(), equalTo(200));
		
	}
	
	
	
	
		@Test
		public void shouldNotBeAbletoCreateAPlaylist() {
			Playlist reqplaylis=new Playlist()
					.setName("")
					.setDescription("bhojpuri song collection")
					.setPublic(false);
			
			Response response=PlaylistApi.post(reqplaylis);
			assertThat(response.getStatusCode(), equalTo(400));
			ErrorRoot error = response.as(ErrorRoot.class);
			
			assertThat(error.getError().getStatus(),equalTo(400) );
			assertThat(error.getError().getMessage(), equalTo("Missing required field: name"));
			
		}
		
		
		
		@Test
		public void shouldNotBeAbletoCreateAPlaylistwithExpiredToken() {
			String invalid_Token = "12345";
			Playlist reqplaylist=new Playlist()
					.setName("My New Playlist")
					.setDescription("bhojpuri song collection")
					.setPublic(false);
			
			Response response=PlaylistApi.post(invalid_Token,reqplaylist);
			assertThat(response.getStatusCode(), equalTo(401));
			ErrorRoot error = response.as(ErrorRoot.class);

	assertThat(error.getError().getStatus(),equalTo(401) );
	assertThat(error.getError().getMessage(), equalTo("Invalid access token"));
			
		}
		
	}

