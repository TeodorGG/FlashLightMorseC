package com.example.flashlightmorsec;

public class MorseEnCode {
    public static String morseEncode(char x)
    {

        switch (x)
        {
            case 'a':
            case 'A':
                return ".-";
            case 'b':
            case 'B':
                return "-...";
            case 'c':
            case 'C':
                return "-.-.";
            case 'd':
            case 'D':
                return "-..";
            case 'e':
            case 'E':
                return ".";
            case 'f':
            case 'F':
                return "..-.";
            case 'g':
            case 'G':
                return "--.";
            case 'h':
            case 'H':
                return "....";
            case 'i':
            case 'I':
                return "..";
            case 'j':
            case 'J':
                return ".---";
            case 'k':
            case 'K':
                return "-.-";
            case 'l':
            case 'L':
                return ".-..";
            case 'm':
            case 'M':
                return "--";
            case 'n':
            case 'N':
                return "-.";
            case 'o':
            case 'O':
                return "---";
            case 'p':
            case 'P':
                return ".--.";
            case 'q':
            case 'Q':
                return "--.-";
            case 'r':
            case 'R':
                return ".-.";
            case 's':
            case 'S':
                return "...";
            case 't':
            case 'T':
                return "-";
            case 'u':
            case 'U':
                return "..-";
            case 'v':
            case 'V':
                return "...-";
            case 'w':
            case 'W':
                return ".--";
            case 'x':
            case 'X':
                return "-..-";
            case 'y':
            case 'Y':
                return "-.--";
            case 'z':
            case 'Z':
                return "--..";

        }
        return "";
    }
}
