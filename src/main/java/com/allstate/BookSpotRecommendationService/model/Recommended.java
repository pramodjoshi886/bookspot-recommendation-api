package com.allstate.BookSpotRecommendationService.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recommended")
public class Recommended {

    private String bookId;
    private String bookTitle;
    private String bookImageLink;
    private String previewLink;
    private String username;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookImageLink() {
        return bookImageLink;
    }

    public void setBookImageLink(String bookImageLink) {
        this.bookImageLink = bookImageLink;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    @Override
    public String toString() {
        return "Recommended{" +
                "bookId='" + bookId + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookImageLink='" + bookImageLink + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public Recommended() {
        super();
    }
}
