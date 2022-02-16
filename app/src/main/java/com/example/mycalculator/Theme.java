package com.example.mycalculator;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

public enum Theme {
    LIGHT(R.style.CalculatorLight, R.string.light_theme, "LIGHT"),
    DARK(R.style.CalculatorDark, R.string.dark_theme, "DARK");

    @StyleRes
    private final int style;

    @StringRes
    private final int title;

    private final String key;

    Theme(int style, int title, String key) {
        this.style = style;
        this.title = title;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getStyle() {
        return style;
    }

    public int getTitle() {
        return title;
    }
}

