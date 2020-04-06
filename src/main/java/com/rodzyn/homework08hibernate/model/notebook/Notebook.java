package com.rodzyn.homework08hibernate.model.notebook;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notebooks")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String note;
    private LocalDateTime createDate = LocalDateTime.now() ;
    private LocalDateTime updateDate;

    public Notebook(String title, String note) {
        this.title = title;
        this.note = note;
        getCreateDate();
        this.updateDate = updateDate;
    }

    public Notebook() {
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updatetime) {
        this.updateDate = updatetime;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime localDateTime) {
        this.createDate = localDateTime;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", localDate='" + createDate + '\'' +
                '}';
    }
}
