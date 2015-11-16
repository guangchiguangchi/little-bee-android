package com.guangchiguangchi.little_bee_android.models;

public class TaskModel {

    private String id;
    private String title;
    private String content;
    private String status;
    private String projectname;
    private String spendtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getSpendtime() {
        return spendtime;
    }

    public void setSpendtime(String spendtime) {
        this.spendtime = spendtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
