
package org.openshift;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "recreateParams",
    "resources"
})
public class Strategy {

    @JsonProperty("type")
    private String type;
    @JsonProperty("recreateParams")
    private RecreateParams recreateParams;
    @JsonProperty("resources")
    private Resources resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Strategy() {
    }

    /**
     * 
     * @param resources
     * @param recreateParams
     * @param type
     */
    public Strategy(String type, RecreateParams recreateParams, Resources resources) {
        super();
        this.type = type;
        this.recreateParams = recreateParams;
        this.resources = resources;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("recreateParams")
    public RecreateParams getRecreateParams() {
        return recreateParams;
    }

    @JsonProperty("recreateParams")
    public void setRecreateParams(RecreateParams recreateParams) {
        this.recreateParams = recreateParams;
    }

    @JsonProperty("resources")
    public Resources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(recreateParams).append(resources).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Strategy) == false) {
            return false;
        }
        Strategy rhs = ((Strategy) other);
        return new EqualsBuilder().append(type, rhs.type).append(recreateParams, rhs.recreateParams).append(resources, rhs.resources).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
