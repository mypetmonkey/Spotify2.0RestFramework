package applicationAPI;


import com.spotify2.pojo.Playlist;

import apiUtility.RestResourse;
import static apiUtility.TokenManager.*;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PlaylistApi {
	

	@Step
	public static Response post(Playlist reqplaylist) {
		return RestResourse.post("/users/31zy4x3sktopajcaffdfppza3dqq/playlists", getToken(), reqplaylist);
		
		}
	@Step
   public static Response post(String token,Playlist reqplaylist) {
	return RestResourse.post("/users/31zy4x3sktopajcaffdfppza3dqq/playlists", token,reqplaylist);
		}
	
	@Step
	public static Response get(String playlistID) {
		return RestResourse.get("/playlists/"+playlistID, getToken());
		
	}
	@Step
	public static Response put(Playlist reqplaylist,String playlistID) {
		return RestResourse.put("/playlists/"+playlistID, getToken(), reqplaylist);
	}
}
