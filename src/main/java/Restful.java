
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;

import java.net.URI;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class Restful {
    public static void main(String[] args){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(getBaseURI());
        Temperature temperature = new Temperature();
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        String output = invocationBuilder.get(String.class);
        System.out.println(output);
        Wrapper[] response = invocationBuilder.get(Wrapper[].class);
        System.out.print(response[0].getTemperature().getMetric().getValue());
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://dataservice.accuweather.com/currentconditions/v1/49959?apikey=fBBXgQ2ajpfORIsveVrj5pDi8tPqbb9i")
                .build();
    }
}
