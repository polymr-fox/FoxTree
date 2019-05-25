package com.develop.loginov.fullstack.model;

public class Record {
    private int id;
    private String name;
    private String description;
    private String pictureUrl;
    private int pictureId;
    private long time;

    /**
     * without network
     * @param id
     * @param name
     * @param description
     * @param pictureId
     * @param time
     */
    public Record(final int id,
                  final String name,
                  final String description,
                  final int pictureId,
                  final long time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pictureId = pictureId;
        this.time = time;
    }

    /**
     * main constructor
     * @param id
     * @param name
     * @param description
     * @param pictureUrl
     * @param time
     */
    public Record(final int id,
                  final String name,
                  final String description,
                  final String pictureUrl,
                  final long time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.time = time;
    }
}
