/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsOpoytsev;

import java.io.Serializable;

public class Post implements Serializable{
    protected int postID;
    protected String title;
    protected String postText;
    protected String [] tags;
    protected String datetime;
    protected int userID;
    public Post(Post p){
        this.postID = p.postID;
        this.title = p.title;
        this.postText = p.postText;
        this.tags = p.tags;
        this.datetime = p.datetime;
    }

    public Post() {
        //System.out.println("creating object 'Post'");
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostText() {
        return postText;
    }

    public void setText(String text) {
        this.postText = text;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
  
}
