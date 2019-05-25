package com.develop.loginov.fullstack.model;

import com.develop.loginov.fullstack.R;

public class Record {
    private final int id;
    private String name;
    private String content;
    private String pictureUrl;
    private int pictureId;
    private final long time;

    /**
     * without network
     *
     * @param id
     * @param name
     * @param content
     * @param pictureId
     * @param time
     */
    public Record(final int id,
                  final String name,
                  final String content,
                  final int pictureId,
                  final long time) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.pictureId = pictureId;
        this.time = time;
    }

    /**
     * main constructor
     *
     * @param id
     * @param name
     * @param content
     * @param pictureUrl
     * @param time
     */
    public Record(final int id,
                  final String name,
                  final String content,
                  final String pictureUrl,
                  final long time) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.pictureUrl = pictureUrl;
        this.time = time;
    }

    public static Record of(final String name, final String content) {
        return new Record(0, name, content, R.mipmap.ic_launcher_round, 0);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public long getTime() {
        return time;
    }
}
