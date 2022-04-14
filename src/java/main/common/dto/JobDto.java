package common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "jobId",
    "jobTitle",
    "jobDescription",
    "experience",
    "project"
})
public class JobDto {

    @JsonProperty("jobId")
    private Integer jobId;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("jobDescription")
    private String jobDescription;
    @JsonProperty("experience")
    private List<String> experience;
    @JsonProperty("project")
    private List<ProjectDto> project;

    public JobDto() {
        // default constructor
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public List<ProjectDto> getProject() {
        return project;
    }

    public void setProject(List<ProjectDto> project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JobDto jobDto = (JobDto) o;

        return new EqualsBuilder()
            .append(jobId, jobDto.jobId)
            .append(jobTitle, jobDto.jobTitle)
            .append(jobDescription, jobDto.jobDescription)
            .append(experience, jobDto.experience)
            .append(project, jobDto.project)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(jobId)
            .append(jobTitle)
            .append(jobDescription)
            .append(experience)
            .append(project)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("jobId", jobId)
            .append("jobTitle", jobTitle)
            .append("jobDescription", jobDescription)
            .append("experience", experience)
            .append("project", project)
            .toString();
    }
}
