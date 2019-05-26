package com.develop.loginov.fullstack.model.helper;

import com.develop.loginov.fullstack.R;

import java.util.Random;

public final class HardCodeHelper {
    private static final int[] drawables = new int[]{R.drawable.event1,
                                                     R.drawable.event2,
//                                                     R.drawable.event4,
                                                     R.drawable.event5,
                                                     R.drawable.event6,
                                                     R.drawable.event3};
    private static final int[] texts = new int[]{R.string.big_text1,
                                                 R.string.big_text2,
                                                 R.string.big_text3,
                                                 R.string.big_text4,
                                                 R.string.big_text5};

    private static final String[] names = new String[]{"PolyHack", "PolyContest", "PolyVolonter"};

    private static final String[] authors = new String[]{"Роман Хоружий",
                                                         "Сеня Дружинин",
                                                         "Арина Касимова",
                                                         "Петр Курняков"};

    private static final String[] dates = new String[]{"03/10/19",
                                                       "10/08/20",
                                                       "12/10/19",
                                                       "13/11/19",
                                                       "10/10/19",
                                                       "28/06/21",
                                                       "12/07/19",
                                                       "12/01/20",
                                                       "12/10/19",
                                                       "17/02/20",
                                                       "01/09/21"};

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

    public static int getTextId() {
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
