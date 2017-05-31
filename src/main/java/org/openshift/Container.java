
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
    "name",
    "image",
    "ports",
    "env",
    "resources",
    "volumeMounts",
    "livenessProbe",
    "readinessProbe",
    "terminationMessagePath",
    "imagePullPolicy",
    "securityContext"
})
public class Container {

    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;
    @JsonProperty("ports")
    private List<Port> ports = null;
    @JsonProperty("env")
    private List<Env> env = null;
    @JsonProperty("resources")
    private Resources_ resources;
    @JsonProperty("volumeMounts")
    private List<VolumeMount> volumeMounts = null;
    @JsonProperty("livenessProbe")
    private LivenessProbe livenessProbe;
    @JsonProperty("readinessProbe")
    private ReadinessProbe readinessProbe;
    @JsonProperty("terminationMessagePath")
    private String terminationMessagePath;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("securityContext")
    private SecurityContext securityContext;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Container() {
    }

    /**
     * 
     * @param livenessProbe
     * @param volumeMounts
     * @param resources
     * @param ports
     * @param imagePullPolicy
     * @param name
     * @param securityContext
     * @param image
     * @param env
     * @param terminationMessagePath
     * @param readinessProbe
     */
    public Container(String name, String image, List<Port> ports, List<Env> env, Resources_ resources, List<VolumeMount> volumeMounts, LivenessProbe livenessProbe, ReadinessProbe readinessProbe, String terminationMessagePath, String imagePullPolicy, SecurityContext securityContext) {
        super();
        this.name = name;
        this.image = image;
        this.ports = ports;
        this.env = env;
        this.resources = resources;
        this.volumeMounts = volumeMounts;
        this.livenessProbe = livenessProbe;
        this.readinessProbe = readinessProbe;
        this.terminationMessagePath = terminationMessagePath;
        this.imagePullPolicy = imagePullPolicy;
        this.securityContext = securityContext;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("ports")
    public List<Port> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    @JsonProperty("env")
    public List<Env> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<Env> env) {
        this.env = env;
    }

    @JsonProperty("resources")
    public Resources_ getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(Resources_ resources) {
        this.resources = resources;
    }

    @JsonProperty("volumeMounts")
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    @JsonProperty("livenessProbe")
    public LivenessProbe getLivenessProbe() {
        return livenessProbe;
    }

    @JsonProperty("livenessProbe")
    public void setLivenessProbe(LivenessProbe livenessProbe) {
        this.livenessProbe = livenessProbe;
    }

    @JsonProperty("readinessProbe")
    public ReadinessProbe getReadinessProbe() {
        return readinessProbe;
    }

    @JsonProperty("readinessProbe")
    public void setReadinessProbe(ReadinessProbe readinessProbe) {
        this.readinessProbe = readinessProbe;
    }

    @JsonProperty("terminationMessagePath")
    public String getTerminationMessagePath() {
        return terminationMessagePath;
    }

    @JsonProperty("terminationMessagePath")
    public void setTerminationMessagePath(String terminationMessagePath) {
        this.terminationMessagePath = terminationMessagePath;
    }

    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    @JsonProperty("securityContext")
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(SecurityContext securityContext) {
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
        return new HashCodeBuilder().append(name).append(image).append(ports).append(env).append(resources).append(volumeMounts).append(livenessProbe).append(readinessProbe).append(terminationMessagePath).append(imagePullPolicy).append(securityContext).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Container) == false) {
            return false;
        }
        Container rhs = ((Container) other);
        return new EqualsBuilder().append(name, rhs.name).append(image, rhs.image).append(ports, rhs.ports).append(env, rhs.env).append(resources, rhs.resources).append(volumeMounts, rhs.volumeMounts).append(livenessProbe, rhs.livenessProbe).append(readinessProbe, rhs.readinessProbe).append(terminationMessagePath, rhs.terminationMessagePath).append(imagePullPolicy, rhs.imagePullPolicy).append(securityContext, rhs.securityContext).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
