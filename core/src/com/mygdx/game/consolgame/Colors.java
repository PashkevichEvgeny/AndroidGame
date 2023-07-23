package com.mygdx.game.consolgame;

public class Colors {
    public static final String RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String BRIGHT_WHITE = "\u001B[97m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String CLEAR_SCREEN = "\033[H";
    public static final String BRIGHT_YELLOW_ON_BLUE = "\u001B[93m" + BLUE_BACKGROUND;
    public static final String BRIGHT_YELLOW_ON_GREEN = "\u001B[93m" + GREEN_BACKGROUND;

    public static void clear(){
        System.out.println(CLEAR_SCREEN);
    }
}