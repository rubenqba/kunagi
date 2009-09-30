// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.GwtEntityGenerator










package scrum.client.collaboration;

import java.util.*;
import ilarkesto.persistence.*;
import ilarkesto.logging.*;
import ilarkesto.base.*;
import ilarkesto.base.time.*;
import ilarkesto.auth.*;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GComment
            extends ilarkesto.gwt.client.AGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    public GComment() {
    }

    public GComment(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "comment";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- parent ---

    private String parentId;

    public final scrum.client.project.Requirement getParent() {
        if (parentId == null) return null;
        return getDao().getRequirement(this.parentId);
    }

    public final boolean isParentSet() {
        return parentId != null;
    }

    public final Comment setParent(scrum.client.project.Requirement parent) {
        String id = parent == null ? null : parent.getId();
        if (equals(this.parentId, id)) return (Comment) this;
        this.parentId = id;
        propertyChanged("parentId", this.parentId);
        return (Comment)this;
    }

    public final boolean isParent(scrum.client.project.Requirement parent) {
        return equals(this.parentId, parent);
    }

    // --- author ---

    private String authorId;

    public final scrum.client.admin.User getAuthor() {
        if (authorId == null) return null;
        return getDao().getUser(this.authorId);
    }

    public final boolean isAuthorSet() {
        return authorId != null;
    }

    public final Comment setAuthor(scrum.client.admin.User author) {
        String id = author == null ? null : author.getId();
        if (equals(this.authorId, id)) return (Comment) this;
        this.authorId = id;
        propertyChanged("authorId", this.authorId);
        return (Comment)this;
    }

    public final boolean isAuthor(scrum.client.admin.User author) {
        return equals(this.authorId, author);
    }

    // --- text ---

    private java.lang.String text ;

    public final java.lang.String getText() {
        return this.text ;
    }

    public final Comment setText(java.lang.String text) {
        if (isText(text)) return (Comment)this;
        this.text = text ;
        propertyChanged("text", this.text);
        return (Comment)this;
    }

    public final boolean isText(java.lang.String text) {
        return equals(this.text, text);
    }

    // --- update properties by map ---

    public void updateProperties(Map props) {
        parentId = (String) props.get("parentId");
        authorId = (String) props.get("authorId");
        text  = (java.lang.String) props.get("text");
    }

    @Override
    public void storeProperties(Map properties) {
        super.storeProperties(properties);
        properties.put("parentId", this.parentId);
        properties.put("authorId", this.authorId);
        properties.put("text", this.text);
    }

}