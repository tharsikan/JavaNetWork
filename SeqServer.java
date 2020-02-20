import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SeqServer {
    private static HttpURLConnection connection;
    public static String readFile(InputStream file) throws IOException,FileNotFoundException {
        String line;
        StringBuffer resposeContent = new StringBuffer();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(file));
            while ((line = bfr.readLine() ) != null) {
                resposeContent.append(line);
            }
            return resposeContent.toString();
    }
    public static void readFile(String file) throws IOException,FileNotFoundException {
        String line;
        BufferedReader bfr = new BufferedReader(new FileReader(file));
        while ((line = bfr.readLine() ) != null) {
            System.out.println(line);
        }
    }


    public static void main(String[] args) {
        System.out.println("hello");

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(50000);

            System.out.println(connection.getResponseCode());

            //readFile("src/Hello.txt");
            System.out.println(readFile(connection.getInputStream()));



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("jjjjjj");
        }
        finally {
            connection.disconnect();
        }
    }
}

