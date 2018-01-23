import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature extends Object {
    @JsonProperty("Metric")
    private Metric Metric;
    @JsonProperty("Imperial")
    private Imperial Imperial;

    //region Getters And Setters
    public Temperature.Metric getMetric() {
        return Metric;
    }

    public void setMetric(Temperature.Metric metric) {
        Metric = metric;
    }

    public Temperature.Imperial getImperial() {
        return Imperial;
    }

    public void setImperial(Temperature.Imperial imperial) {
        Imperial = imperial;
    }
    //endregion

    public class Metric{
        @JsonProperty("Value")
        private double Value;
        @JsonProperty("Unit")
        private String Unit;
        @JsonProperty("UnitType")
        private int UnitType;

        //region Getters And Setters
        public double getValue() {
            return Value;
        }

        public void setValue(double value) {
            Value = value;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String unit) {
            Unit = unit;
        }

        public int getUnitType() {
            return UnitType;
        }

        public void setUnitType(int unitType) {
            UnitType = unitType;
        }
        //endregion
    }
    public class Imperial{
        @JsonProperty("Value")
        private double Value;
        @JsonProperty("Unit")
        private String Unit;
        @JsonProperty("UnitType")
        private int UnitType;

        //region Getters And Setters
        public double getValue() {
            return Value;
        }

        public void setValue(double value) {
            Value = value;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String unit) {
            Unit = unit;
        }

        public int getUnitType() {
            return UnitType;
        }

        public void setUnitType(int unitType) {
            UnitType = unitType;
        }
        //endregion
    }
}
