
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
    "exec",
    "timeoutSeconds",
    "periodSeconds",
    "successThreshold",
    "failureThreshold"
})
public class LivenessProbe {

    @JsonProperty("exec")
    private Exec exec;
    @JsonProperty("timeoutSeconds")
    private Integer timeoutSeconds;
    @JsonProperty("periodSeconds")
    private Integer periodSeconds;
    @JsonProperty("successThreshold")
    private Integer successThreshold;
    @JsonProperty("failureThreshold")
    private Integer failureThreshold;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LivenessProbe() {
    }

    /**
     * 
     * @param timeoutSeconds
     * @param failureThreshold
     * @param periodSeconds
     * @param exec
     * @param successThreshold
     */
    public LivenessProbe(Exec exec, Integer timeoutSeconds, Integer periodSeconds, Integer successThreshold, Integer failureThreshold) {
        super();
        this.exec = exec;
        this.timeoutSeconds = timeoutSeconds;
        this.periodSeconds = periodSeconds;
        this.successThreshold = successThreshold;
        this.failureThreshold = failureThreshold;
    }

    @JsonProperty("exec")
    public Exec getExec() {
        return exec;
    }

    @JsonProperty("exec")
    public void setExec(Exec exec) {
        this.exec = exec;
    }

    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonProperty("periodSeconds")
    public Integer getPeriodSeconds() {
        return periodSeconds;
    }

    @JsonProperty("periodSeconds")
    public void setPeriodSeconds(Integer periodSeconds) {
        this.periodSeconds = periodSeconds;
    }

    @JsonProperty("successThreshold")
    public Integer getSuccessThreshold() {
        return successThreshold;
    }

    @JsonProperty("successThreshold")
    public void setSuccessThreshold(Integer successThreshold) {
        this.successThreshold = successThreshold;
    }

    @JsonProperty("failureThreshold")
    public Integer getFailureThreshold() {
        return failureThreshold;
    }

    @JsonProperty("failureThreshold")
    public void setFailureThreshold(Integer failureThreshold) {
        this.failureThreshold = failureThreshold;
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
        return new HashCodeBuilder().append(exec).append(timeoutSeconds).append(periodSeconds).append(successThreshold).append(failureThreshold).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LivenessProbe) == false) {
            return false;
        }
        LivenessProbe rhs = ((LivenessProbe) other);
        return new EqualsBuilder().append(exec, rhs.exec).append(timeoutSeconds, rhs.timeoutSeconds).append(periodSeconds, rhs.periodSeconds).append(successThreshold, rhs.successThreshold).append(failureThreshold, rhs.failureThreshold).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
