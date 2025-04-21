package com.book.bookonline.dto;

public enum CategoryType {

    RESEARCH_HISTORY("Arasdirma - Tarih"),

    SCIENCE("Bilim"),

    COMIC("Cizgi Roman"),

    CHILD_AND_YOUTH("Cocuk ve Genclik"),

    LESSON_TEST_BOOKS("Ders/Sinav Kitablari"),

    RELIGION("Din Tasavvuf"),

    LITERATURE("Edebiyyat"),

    EDUCATION_REFERENCE("Egitim Basvuru"),

    PHILOSOPHY("Felsefe"),

    FOREIGN_LANGUAGES("Xarici Diller"),

    HOBBY("Hobi"),

    MYTH_LEGEND("Mitoloji Efsane"),

    HUMOR("Mizah"),

    PRESTIGE_BOOKS("Presij Kitablari"),

    ART_DESIGN("Sanat -Tasarim"),

    AUDIO_BOOKS("Sesli Kitablar"),

    OTHER("Diger");

    private final String value;

    CategoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
