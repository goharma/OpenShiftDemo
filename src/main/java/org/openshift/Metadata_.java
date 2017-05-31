
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
    "creationTimestamp",
    "labels"
})
public class Metadata_ {

    @JsonProperty("creationTimestamp")
    private Object creationTimestamp;
    @JsonProperty("labels")
    private Labels_ labels;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metadata_() {
    }

    /**
     * 
     * @param labels
     * @param creationTimestamp
     */
    public Metadata_(Object creationTimestamp, Labels_ labels) {
        super();
        this.creationTimestamp = creationTimestamp;
        this.labels = labels;
    }

    @JsonProperty("creationTimestamp")
    public Object getCreationTimestamp() {
        return creationTimestamp;
    }

    @JsonProperty("creationTimestamp")
    public void setCreationTimestamp(Object creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @JsonProperty("labels")
    public Labels_ getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Labels_ labels) {
        this.labels = labels;
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
        return new HashCodeBuilder().append(creationTimestamp).append(labels).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metadata_) == false) {
            return false;
        }
        Metadata_ rhs = ((Metadata_) other);
        return new EqualsBuilder().append(creationTimestamp, rhs.creationTimestamp).append(labels, rhs.labels).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
