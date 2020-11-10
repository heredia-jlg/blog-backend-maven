package com.jlgh.blog.entities;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Posts")
public class Post {

    @Id
    public String id;
    public String time;
    public String text;
    public String title;
    public String tags;

    public Post()
    {
        super();
    }
    public Post( String text, String title, String tags) {
        this.text = text;
        this.title = title;
        this.tags = tags;
    }

    public void setTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm");
        String formattedDate = myDateObj.format(myFormatObj);
        this.time = formattedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(text, post.text) &&
                Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash( text, title);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
