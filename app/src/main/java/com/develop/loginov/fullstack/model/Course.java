package com.develop.loginov.fullstack.model;

public class Course {


    private final int id;
    private final int authorId;

    private String name;
    private String authorName;
    private String description;
    private int pictureId;
    private int maxMemberCount;
    private int currentMembersCount;
    private boolean close;

    public Course(final int id,
                  final int authorId,
                  final String name,
                  final String authorName,
                  final String description,
                  int pictureId,
                  final int maxMemberCount,
                  final int currentMembersCount,
                  final boolean close) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.authorName = authorName;
        this.description = description;
        this.pictureId = pictureId;
        this.maxMemberCount = maxMemberCount;
        this.currentMembersCount = currentMembersCount;
        this.close = close;
    }

    public static Course of(final String name,
                            final String authorName,
                            final int pictureId,
                            final int maxMemberCount,
                            final int currentMembersCount) {

        return new Course(0, 0, name, authorName, "lol", pictureId, maxMemberCount, currentMembersCount, false);
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
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

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }
}
