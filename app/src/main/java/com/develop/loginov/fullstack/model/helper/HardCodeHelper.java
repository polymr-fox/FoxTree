package com.develop.loginov.fullstack.model.helper;

import com.develop.loginov.fullstack.R;

import java.util.Random;

public final class HardCodeHelper {
    private static final int[] drawables = new int[]{R.drawable.event1,
                                                     R.drawable.event2,
                                                     R.drawable.event3};
    private static final int[] texts = new int[]{

    };
    private static final String[] names = new String[]{"PolyHack", "PolyContest", "PolyVolonter"};

    private static final String[] authors = new String[]{"Роман Хоружий",
                                                         "Арсений Дружинин",
                                                         "Арина Касимова"};

    private static final String[] dates = new String[]{"03/10/2019",
                                                       "10/08/2020",
                                                       "12/10/2019",
                                                       "13/11/2019",
                                                       "10/10/2019",
                                                       "28/06/2021",
                                                       "12/07/2019",
                                                       "12/01/2020",
                                                       "12/10/2019",
                                                       "17/02/2020",
                                                       "01/09/2021"};

    private static final String[] places = new String[]{"СПбПУ, ГЗ, 237",
                                                        "СПбПУ, НИК, 2.17.1",
                                                        "СПбПУ, Гидрак, 102",
                                                        "СПбПУ, 9к, 501",
                                                        "СПбПУ, 3к, 301",
                                                        "СПбПУ, 2к, 148",
                                                        "СПбПУ, 1к, 187",
                                                        "СПбПУ, 3к, 207",
                                                        "СПбПУ, 11к, 374",
                                                        "СПбПУ, НИК, 2.17.2",
                                                        "СПбПУ, ГЗ, 235"};

    private static Random random = new Random();

    public HardCodeHelper() {
    }

    public static String getDate() {
        int index = random.nextInt(dates.length);
        return dates[index];
    }

    public static String getPlace() {
        int index = random.nextInt(places.length);
        return places[index];
    }

    public static String getName() {
        int index = random.nextInt(names.length);
        return names[index];
    }

    public static int getText() {
        int index = random.nextInt(texts.length);
        return texts[index];
    }

    public static String getAuthorName() {
        int index = random.nextInt(authors.length);
        return authors[index];
    }

    public static int getDrawable() {
        int index = random.nextInt(drawables.length);
        return drawables[index];
    }

    public static int getMembers() {
        return random.nextInt(50);
    }

    public static int getRate() {
        return random.nextInt(100) - 50;
    }
}
