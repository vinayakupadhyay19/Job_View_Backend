package com.vinayak.joblisting.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.SystemPropertyUtils;


@Document(collection="JobPost")
public class Post {
	private String id;
	private String profile;
	private String desc;
	private int exp;
	private String techs[];

	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println(id);
		this.id = id;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String[] getTechs() {
		return techs;
	}
	public void setTechs(String[] techs) {
		this.techs = techs;
	}
	public Post() {
		super();
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", profile=" + profile + ", desc=" + desc + ", exp=" + exp + ", techs="
				+ Arrays.toString(techs) + "]";
	}
	
	
	
	
}
