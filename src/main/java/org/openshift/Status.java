
package org.openshift;

import java.util.HashMap;
import java.util.List;
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
    "latestVersion",
    "observedGeneration",
    "replicas",
    "updatedReplicas",
    "availableReplicas",
    "unavailableReplicas",
    "details",
    "conditions"
})
public class Status {

    @JsonProperty("latestVersion")
    private Integer latestVersion;
    @JsonProperty("observedGeneration")
    private Integer observedGeneration;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("updatedReplicas")
    private Integer updatedReplicas;
    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("unavailableReplicas")
    private Integer unavailableReplicas;
    @JsonProperty("details")
    private Details details;
    @JsonProperty("conditions")
    private List<Condition> conditions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Status() {
    }

    /**
     * 
     * @param conditions
     * @param updatedReplicas
     * @param replicas
     * @param latestVersion
     * @param details
     * @param availableReplicas
     * @param unavailableReplicas
     * @param observedGeneration
     */
    public Status(Integer latestVersion, Integer observedGeneration, Integer replicas, Integer updatedReplicas, Integer availableReplicas, Integer unavailableReplicas, Details details, List<Condition> conditions) {
        super();
        this.latestVersion = latestVersion;
        this.observedGeneration = observedGeneration;
        this.replicas = replicas;
        this.updatedReplicas = updatedReplicas;
        this.availableReplicas = availableReplicas;
        this.unavailableReplicas = unavailableReplicas;
        this.details = details;
        this.conditions = conditions;
    }

    @JsonProperty("latestVersion")
    public Integer getLatestVersion() {
        return latestVersion;
    }

    @JsonProperty("latestVersion")
    public void setLatestVersion(Integer latestVersion) {
        this.latestVersion = latestVersion;
    }

    @JsonProperty("observedGeneration")
    public Integer getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Integer observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("updatedReplicas")
    public Integer getUpdatedReplicas() {
        return updatedReplicas;
    }

    @JsonProperty("updatedReplicas")
    public void setUpdatedReplicas(Integer updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
    }

    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    @JsonProperty("unavailableReplicas")
    public Integer getUnavailableReplicas() {
        return unavailableReplicas;
    }

    @JsonProperty("unavailableReplicas")
    public void setUnavailableReplicas(Integer unavailableReplicas) {
        this.unavailableReplicas = unavailableReplicas;
    }

    @JsonProperty("details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details details) {
        this.details = details;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
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
        return new HashCodeBuilder().append(latestVersion).append(observedGeneration).append(replicas).append(updatedReplicas).append(availableReplicas).append(unavailableReplicas).append(details).append(conditions).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Status) == false) {
            return false;
        }
        Status rhs = ((Status) other);
        return new EqualsBuilder().append(latestVersion, rhs.latestVersion).append(observedGeneration, rhs.observedGeneration).append(replicas, rhs.replicas).append(updatedReplicas, rhs.updatedReplicas).append(availableReplicas, rhs.availableReplicas).append(unavailableReplicas, rhs.unavailableReplicas).append(details, rhs.details).append(conditions, rhs.conditions).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
