package com.rodzyn.homework08hibernate.model.notebook;

import javax.persistence.*;

@Entity
@Table(name = "notebooks")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String note;
    private String createDate;
    private String updateDate;

    public Notebook(String title, String note, String createDate, String updateDate) {
        this.title = title;
        this.note = note;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Notebook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String udpateDate) {
        this.updateDate = udpateDate;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", createDate='" + createDate + '\'' +
                ", udpateDate='" + updateDate + '\'' +
                '}';
    }
}
