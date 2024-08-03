/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Legion
 */
public class Catalog {

    /**
     * @return the titles
     */
    public String getTitles() {
        return titles;
    }

    /**
     * @param titles the titles to set
     */
    public void setTitles(String titles) {
        this.titles = titles;
    }

    /**
     * @return the genres
     */
    public String getGenres() {
        return genres;
    }

    /**
     * @param genres the genres to set
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * @return the authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * @return the publicationDate
     */
    public Date getPublicationDate() {
        return publicationDate;
    }

    /**
     * @param publicationDate the publicationDate to set
     */
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    private String titles;
    private String genres;
    private String authors;
    private Date publicationDate;
}
