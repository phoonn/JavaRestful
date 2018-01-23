import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Wrapper {
    @JsonProperty("Temperature")
    private Temperature Temperature;

    @JsonProperty("LocalObservationDateTime")
    private String LocalObservationDateTime;

    public String getLocalObservationDateTime() {
        return LocalObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        LocalObservationDateTime = localObservationDateTime;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.Temperature = temperature;
    }
}
