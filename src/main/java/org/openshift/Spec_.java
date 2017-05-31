
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
    "volumes",
    "containers",
    "restartPolicy",
    "terminationGracePeriodSeconds",
    "dnsPolicy",
    "securityContext"
})
public class Spec_ {

    @JsonProperty("volumes")
    private List<Volume> volumes = null;
    @JsonProperty("containers")
    private List<Container> containers = null;
    @JsonProperty("restartPolicy")
    private String restartPolicy;
    @JsonProperty("terminationGracePeriodSeconds")
    private Integer terminationGracePeriodSeconds;
    @JsonProperty("dnsPolicy")
    private String dnsPolicy;
    @JsonProperty("securityContext")
    private SecurityContext_ securityContext;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Spec_() {
    }

    /**
     * 
     * @param terminationGracePeriodSeconds
     * @param containers
     * @param securityContext
     * @param dnsPolicy
     * @param restartPolicy
     * @param volumes
     */
    public Spec_(List<Volume> volumes, List<Container> containers, String restartPolicy, Integer terminationGracePeriodSeconds, String dnsPolicy, SecurityContext_ securityContext) {
        super();
        this.volumes = volumes;
        this.containers = containers;
        this.restartPolicy = restartPolicy;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        this.dnsPolicy = dnsPolicy;
        this.securityContext = securityContext;
    }

    @JsonProperty("volumes")
    public List<Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    @JsonProperty("containers")
    public List<Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public Integer getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Integer terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    @JsonProperty("dnsPolicy")
    public String getDnsPolicy() {
        return dnsPolicy;
    }

    @JsonProperty("dnsPolicy")
    public void setDnsPolicy(String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
    }

    @JsonProperty("securityContext")
    public SecurityContext_ getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(SecurityContext_ securityContext) {
        this.securityContext = securityContext;
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
        return new HashCodeBuilder().append(volumes).append(containers).append(restartPolicy).append(terminationGracePeriodSeconds).append(dnsPolicy).append(securityContext).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spec_) == false) {
            return false;
        }
        Spec_ rhs = ((Spec_) other);
        return new EqualsBuilder().append(volumes, rhs.volumes).append(containers, rhs.containers).append(restartPolicy, rhs.restartPolicy).append(terminationGracePeriodSeconds, rhs.terminationGracePeriodSeconds).append(dnsPolicy, rhs.dnsPolicy).append(securityContext, rhs.securityContext).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
