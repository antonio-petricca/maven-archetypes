package com.ap.archetypes.jboss_web_api.ejb.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value = {
    
    @NamedQuery(
        name = "tables.findAll",
        query = "select E from TablesEntity E"
    )

})

@Entity
@Table(name = "information_schema.tables")
public class TablesEntity implements Serializable {

    @Id
    @Column(name = "table_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
