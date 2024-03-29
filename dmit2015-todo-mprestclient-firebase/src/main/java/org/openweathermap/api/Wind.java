
package org.openweathermap.api;

import java.util.LinkedHashMap;
import java.util.Map;
import jakarta.annotation.Generated;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;

@JsonbPropertyOrder({
    "speed",
    "deg"
})
@Generated("jsonschema2pojo")
public class Wind {

    @JsonbProperty("speed")
    private Double speed;
    @JsonbProperty("deg")
    private Integer deg;
    @JsonbTransient
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonbProperty("speed")
    public Double getSpeed() {
        return speed;
    }

    @JsonbProperty("speed")
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @JsonbProperty("deg")
    public Integer getDeg() {
        return deg;
    }

    @JsonbProperty("deg")
    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
