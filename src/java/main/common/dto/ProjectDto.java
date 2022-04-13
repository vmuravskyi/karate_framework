package common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "projectName",
    "technology"
})
public class ProjectDto {

    @JsonProperty("projectName")
    private String projectName;
    @JsonProperty("technology")
    private List<String> technology;

    public ProjectDto() {
        // default constructor
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getTechnology() {
        return technology;
    }

    public void setTechnology(List<String> technology) {
        this.technology = technology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProjectDto that = (ProjectDto) o;

        return new EqualsBuilder()
            .append(projectName, that.projectName)
            .append(technology, that.technology)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(projectName)
            .append(technology)
            .toHashCode();
    }

}
