









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.GwtEntityGenerator










package scrum.client.impediments;

import java.util.*;

public abstract class GImpediment
            extends scrum.client.common.AGwtEntity {

    public GImpediment() {
    }

    public GImpediment(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "impediment";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- project ---

    private String projectId;

    public final scrum.client.project.Project getProject() {
        return getDao().getProject(this.projectId);
    }

    public final Impediment setProject(scrum.client.project.Project project) {
        this.projectId = project.getId();
        propertyChanged("project", this.projectId);
        return (Impediment)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        return equals(this.projectId, project);
    }

    // --- solution ---

    private java.lang.String solution ;

    public final java.lang.String getSolution() {
        return this.solution ;
    }

    public final Impediment setSolution(java.lang.String solution) {
        this.solution = solution ;
        propertyChanged("solution", this.solution);
        return (Impediment)this;
    }

    public final boolean isSolution(java.lang.String solution) {
        return equals(this.solution, solution);
    }

    // --- solved ---

    private boolean solved ;

    public final boolean isSolved() {
        return this.solved ;
    }

    public final Impediment setSolved(boolean solved) {
        this.solved = solved ;
        propertyChanged("solved", this.solved);
        return (Impediment)this;
    }

    public final boolean isSolved(boolean solved) {
        return equals(this.solved, solved);
    }

    // --- label ---

    private java.lang.String label ;

    public final java.lang.String getLabel() {
        return this.label ;
    }

    public final Impediment setLabel(java.lang.String label) {
        this.label = label ;
        propertyChanged("label", this.label);
        return (Impediment)this;
    }

    public final boolean isLabel(java.lang.String label) {
        return equals(this.label, label);
    }

    // --- description ---

    private java.lang.String description ;

    public final java.lang.String getDescription() {
        return this.description ;
    }

    public final Impediment setDescription(java.lang.String description) {
        this.description = description ;
        propertyChanged("description", this.description);
        return (Impediment)this;
    }

    public final boolean isDescription(java.lang.String description) {
        return equals(this.description, description);
    }

    // --- update properties by map ---

    public void updateProperties(Map props) {
        projectId = (String) props.get("projectId");
        solution  = (java.lang.String) props.get("solution");
        solved  = (Boolean) props.get("solved");
        label  = (java.lang.String) props.get("label");
        description  = (java.lang.String) props.get("description");
    }

    @Override
    public void storeProperties(Map properties) {
        super.storeProperties(properties);
        properties.put("project", this.projectId);
        properties.put("solution", this.solution);
        properties.put("solved", this.solved);
        properties.put("label", this.label);
        properties.put("description", this.description);
    }

}