package fr.istic.taa.jaxrs.domain;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Fiche {
    private long id;
    private String libelle;
    private Date datebutoire;
    private User user;
    private Date time;
    private String lieu;
    private String note;
    private String url;
    private List<Tag> tag;
    private Section section;
    
    public Fiche(){ }
    public Fiche(String libelle, Date datebutoire, Date time, String lieu, String url, List<Tag>tag, String note, Section section){
        this.libelle = libelle;
        this. datebutoire= datebutoire;
        this. time= time;
        this. lieu= lieu;
        this. note= note;
        this. tag= tag;
        this.url=url;
        this.section=section;
    }
    public Fiche(String libelle, Date datebutoire, User user, Date time, String lieu, String url, List<Tag>tag, String note, Section section){
        this.libelle = libelle;
        this. datebutoire= datebutoire;
        this. user= user;
        this. time= time;
        this. lieu= lieu;
        this. note= note;
        this. tag= tag;
        this.url=url;
        this.section=section;
    }



    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public Date getdatebutoire() {
        return datebutoire;
    }

    public void setdatebutoire(Date datebutoire) {
        this.datebutoire = datebutoire;
    }
    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @ManyToMany(mappedBy = "fiche", cascade = CascadeType.PERSIST)
    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
    //    @Override
//    public String toString(){
//        return "Fiche [id=" + id + ", libelle=" + libelle + ", fiche=" + getLibelle() +"]";
//    }

   
}