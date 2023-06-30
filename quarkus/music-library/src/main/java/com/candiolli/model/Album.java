package com.candiolli.model;

import java.io.Serializable;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.rest.core.annotation.RestResource;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Audited
@Entity
@Table
@AuditTable(value = "album_audit")
//@Data
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "productor_id", nullable = false)
    @RestResource(exported = false)
    private Productor productor;

    @Column(name = "dt_create", nullable = false)
    private String dateCreate;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Productor getProductor()
    {
        return productor;
    }

    public void setProductor(Productor productor)
    {
        this.productor = productor;
    }

    public String getDateCreate()
    {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate)
    {
        this.dateCreate = dateCreate;
    }
}
