package com.develop.loginov.fullstack.model;

import java.util.List;
import java.util.Objects;

public class Event {
    private final int id;
    private final int pictureId;
    private final int authorId;

    private final String name;
    private final String description;
    private final String authorName;
    private final String pictureUrl;
    private final List<Record> records;

    public Event(int id,
                 int pictureId,
                 int authorId,
                 String name,
                 String description,
                 String authorName,
                 List<Record> records) {
        this.id = id;
        this.pictureId = pictureId;
        this.authorId = authorId;
        this.name = name;
        this.description = description;
        this.authorName = authorName;
        this.records = records;
        pictureUrl = "";
    }


    public Event(int id,
                 int authorId,
                 String name,
                 String description,
                 String authorName,
                 String pictureUrl,
                 List<Record> records) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.description = description;
        this.authorName = authorName;
        this.pictureUrl = pictureUrl;
        this.records = records;
        pictureId = -1;
    }

    public void addAll(final List<Record> records) {
        records.removeIf(Objects::isNull);
        this.records.addAll(records);
    }

    public int getId() {
        return id;
    }

    public int getPictureId() {
        return pictureId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public List<Record> getRecords() {
        return records;
    }
}
