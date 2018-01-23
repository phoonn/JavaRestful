import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class AnotherWayRestful {
    public static void main(String[] args) throws MalformedURLException {
        try {

            URL url = new URL("http://dataservice.accuweather.com/currentconditions/v1/49959?apikey=fBBXgQ2ajpfORIsveVrj5pDi8tPqbb9i");

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(conn.getResponseCode()!=200){
                System.out.println(conn.getResponseCode());
            }

            Scanner scanner = new Scanner(url.openStream());
            String inline = "";
            while (scanner.hasNext()){
                inline +=scanner.nextLine();
            }

            ObjectMapper mapper = new ObjectMapper();

            Wrapper[] value = mapper.readValue(inline,Wrapper[].class);

            System.out.print(value[0].getTemperature().getMetric().getValue());

        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
