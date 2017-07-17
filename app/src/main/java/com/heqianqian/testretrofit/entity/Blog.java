package com.heqianqian.testretrofit.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Blog
 * Created by heqianqian on 2017/3/26.
 */
public class Blog {

    @SerializedName("id")
    public long id;

    @SerializedName("date")
    public String date;

    @SerializedName("author")
    public String author;

    @SerializedName("title")
    public String title;

    @SerializedName("content")
    public String content;

    public Blog() {
    }

    public Blog(long id, String date, String author, String title, String content) {
        this.id = id;
        this.date = date;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
