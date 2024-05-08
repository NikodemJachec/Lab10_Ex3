import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Main {
    public static void main(String[] args) {
        try {
            String jsonResponse = JokeApiClient.jokeApiRequest();
            System.out.println("JSON Response: " + jsonResponse);

            Joke joke = convertJsonToJoke(jsonResponse);
            System.out.println("Joke object: " + joke);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Joke convertJsonToJoke(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Joke.class);
    }
}