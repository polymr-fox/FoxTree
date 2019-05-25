package com.develop.loginov.fullstack.model;

public class Course {
    private final int id;
    private final int authorId;

    private String name;
    private String authorName;
    private String description;
    private int maxMemberCount;
    private int currentMembersCount;

    public Course(final int id,
                  final int authorId,
                  final String name,
                  final String authorName,
                  final String description,
                  final int maxMemberCount,
                  final int currentMembersCount) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.authorName = authorName;
        this.description = description;
        this.maxMemberCount = maxMemberCount;
        this.currentMembersCount = currentMembersCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxMemberCount(int maxMemberCount) {
        this.maxMemberCount = maxMemberCount;
    }

    public void setCurrentMembersCount(int currentMembersCount) {
        this.currentMembersCount = currentMembersCount;
    }

    public int getId() {
        return id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxMemberCount() {
        return maxMemberCount;
    }

    public int getCurrentMembersCount() {
        return currentMembersCount;
    }
}
