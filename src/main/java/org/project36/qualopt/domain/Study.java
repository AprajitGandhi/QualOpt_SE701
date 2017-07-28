package org.project36.qualopt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Study.
 */
@Entity
@Table(name = "study")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Study implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "incentive")
    private String incentive;

    @Column(name = "has_pay")
    private Boolean hasPay;

    @OneToMany(mappedBy = "study")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Researcher> researchers = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "study_participant",
               joinColumns = @JoinColumn(name="studies_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="participants_id", referencedColumnName="id"))
    private Set<Participant> participants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Study name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Study description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncentive() {
        return incentive;
    }

    public Study incentive(String incentive) {
        this.incentive = incentive;
        return this;
    }

    public void setIncentive(String incentive) {
        this.incentive = incentive;
    }

    public Boolean isHasPay() {
        return hasPay;
    }

    public Study hasPay(Boolean hasPay) {
        this.hasPay = hasPay;
        return this;
    }

    public void setHasPay(Boolean hasPay) {
        this.hasPay = hasPay;
    }

    public Set<Researcher> getResearchers() {
        return researchers;
    }

    public Study researchers(Set<Researcher> researchers) {
        this.researchers = researchers;
        return this;
    }

    public Study addResearcher(Researcher researcher) {
        this.researchers.add(researcher);
        researcher.setStudy(this);
        return this;
    }

    public Study removeResearcher(Researcher researcher) {
        this.researchers.remove(researcher);
        researcher.setStudy(null);
        return this;
    }

    public void setResearchers(Set<Researcher> researchers) {
        this.researchers = researchers;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public Study participants(Set<Participant> participants) {
        this.participants = participants;
        return this;
    }

    public Study addParticipant(Participant participant) {
        this.participants.add(participant);
        participant.getStudies().add(this);
        return this;
    }

    public Study removeParticipant(Participant participant) {
        this.participants.remove(participant);
        participant.getStudies().remove(this);
        return this;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Study study = (Study) o;
        if (study.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), study.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Study{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", incentive='" + getIncentive() + "'" +
            ", hasPay='" + isHasPay() + "'" +
            "}";
    }
}
