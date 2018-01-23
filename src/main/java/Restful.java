import org.springframework.util.StringUtils;

import java.net.URI;
import java.util.Scanner;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class Restful {
    public static void main(String[] args){

        Client client = ClientBuilder.newClient();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name :");
        String input = scanner.nextLine();

        WebTarget target = client.target(getCitySearchURI(input));
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        if (invocationBuilder.get().getStatus()!=200 || invocationBuilder.get(String.class).equals("[]")){
            System.out.println("City not Found");
            return;
        }
        String string = invocationBuilder.get(String.class);
        City[] cities = invocationBuilder.get(City[].class);
        String cityCode = cities[0].getKey();
        target = client.target(getTemeratureURI(cityCode));
        invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        if (invocationBuilder.get().getStatus()!=200){
            System.out.println("City not Found");
            return;
        }

//        String output = invocationBuilder.get(String.class);
//        System.out.println(output);
        Wrapper[] response = invocationBuilder.get(Wrapper[].class);
        System.out.print(input+" : "+response[0].getTemperature().getMetric().getValue()+response[0].getTemperature().getMetric().getUnit());
    }

    private static URI getTemeratureURI(String code) {
        return UriBuilder.fromUri("http://dataservice.accuweather.com/currentconditions/v1/"+code+"?apikey=fBBXgQ2ajpfORIsveVrj5pDi8tPqbb9i")
                .build();
    }
    private static URI getCitySearchURI(String city){
        return UriBuilder.fromUri("http://apidev.accuweather.com/locations/v1/search?q="+city+"&apikey=hoArfRosT1215")
                .build();
    }
}
