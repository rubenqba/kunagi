// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.gwt.GwtEntityGenerator










package scrum.client.collaboration;

import java.util.*;
import ilarkesto.persistence.*;
import ilarkesto.logging.*;
import ilarkesto.base.*;
import ilarkesto.base.time.*;
import ilarkesto.auth.*;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GWikipage
            extends ilarkesto.gwt.client.AGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    public GWikipage() {
    }

    public GWikipage(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "wikipage";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- project ---

    private String projectId;

    public final scrum.client.project.Project getProject() {
        if (projectId == null) return null;
        return getDao().getProject(this.projectId);
    }

    public final boolean isProjectSet() {
        return projectId != null;
    }

    public final Wikipage setProject(scrum.client.project.Project project) {
        String id = project == null ? null : project.getId();
        if (equals(this.projectId, id)) return (Wikipage) this;
        this.projectId = id;
        propertyChanged("projectId", this.projectId);
        return (Wikipage)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        return equals(this.projectId, project);
    }

    // --- name ---

    private java.lang.String name ;

    public final java.lang.String getName() {
        return this.name ;
    }

    public final Wikipage setName(java.lang.String name) {
        if (isName(name)) return (Wikipage)this;
        this.name = name ;
        propertyChanged("name", this.name);
        return (Wikipage)this;
    }

    public final boolean isName(java.lang.String name) {
        return equals(this.name, name);
    }

    // --- text ---

    private java.lang.String text ;

    public final java.lang.String getText() {
        return this.text ;
    }

    public final Wikipage setText(java.lang.String text) {
        if (isText(text)) return (Wikipage)this;
        this.text = text ;
        propertyChanged("text", this.text);
        return (Wikipage)this;
    }

    public final boolean isText(java.lang.String text) {
        return equals(this.text, text);
    }

    // --- update properties by map ---

    public void updateProperties(Map props) {
        projectId = (String) props.get("projectId");
        name  = (java.lang.String) props.get("name");
        text  = (java.lang.String) props.get("text");
    }

    @Override
    public void storeProperties(Map properties) {
        super.storeProperties(properties);
        properties.put("projectId", this.projectId);
        properties.put("name", this.name);
        properties.put("text", this.text);
    }

}