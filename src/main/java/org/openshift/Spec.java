
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
    "strategy",
    "triggers",
    "replicas",
    "test",
    "selector",
    "template"
})
public class Spec {

    @JsonProperty("strategy")
    private Strategy strategy;
    @JsonProperty("triggers")
    private List<Trigger> triggers = null;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("test")
    private Boolean test;
    @JsonProperty("selector")
    private Selector selector;
    @JsonProperty("template")
    private Template template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Spec() {
    }

    /**
     * 
     * @param template
     * @param selector
     * @param replicas
     * @param test
     * @param strategy
     * @param triggers
     */
    public Spec(Strategy strategy, List<Trigger> triggers, Integer replicas, Boolean test, Selector selector, Template template) {
        super();
        this.strategy = strategy;
        this.triggers = triggers;
        this.replicas = replicas;
        this.test = test;
        this.selector = selector;
        this.template = template;
    }

    @JsonProperty("strategy")
    public Strategy getStrategy() {
        return strategy;
    }

    @JsonProperty("strategy")
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @JsonProperty("triggers")
    public List<Trigger> getTriggers() {
        return triggers;
    }

    @JsonProperty("triggers")
    public void setTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("test")
    public Boolean getTest() {
        return test;
    }

    @JsonProperty("test")
    public void setTest(Boolean test) {
        this.test = test;
    }

    @JsonProperty("selector")
    public Selector getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    @JsonProperty("template")
    public Template getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(Template template) {
        this.template = template;
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
        return new HashCodeBuilder().append(strategy).append(triggers).append(replicas).append(test).append(selector).append(template).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spec) == false) {
            return false;
        }
        Spec rhs = ((Spec) other);
        return new EqualsBuilder().append(strategy, rhs.strategy).append(triggers, rhs.triggers).append(replicas, rhs.replicas).append(test, rhs.test).append(selector, rhs.selector).append(template, rhs.template).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
