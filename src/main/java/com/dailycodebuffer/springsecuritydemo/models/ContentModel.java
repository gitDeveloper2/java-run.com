package com.dailycodebuffer.springsecuritydemo.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content")
public class ContentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "content")
    private String content;
    @Column(name = "published")
    private String published;
    @Column(name = "Title")
    private String Title;
    
    
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ContentModel() {
		
	}
	public ContentModel(Long id, String content, String published, String url, String title) {
		super();
		this.id = id;
		this.content = content;
		this.published = published;
		this.url=url;
		this.Title=title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublished() {
		return published;
	}
	public void setPublished(String published) {
		this.published = published;
	}
	@Override
	public String toString() {
		return "ContentModel [id=" + id + ", url=" + url + ", content=" + content + ", published=" + published
				+ ", Title=" + Title + "]";
	}
	
   


}
