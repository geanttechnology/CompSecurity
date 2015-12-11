// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;


public final class SpeechActions extends Enum
{

    private static final SpeechActions $VALUES[];
    public static final SpeechActions CANCEL;
    public static final SpeechActions CLEAR;
    public static final SpeechActions CLOSE;
    public static final SpeechActions FEEDBACK;
    public static final SpeechActions HELP;
    public static final SpeechActions IGNORE_REENTRY;
    public static final SpeechActions JUST_A_NUMBER;
    public static final SpeechActions JUST_SOME_WORDS;
    public static final SpeechActions LESS;
    public static final SpeechActions MORE;
    public static final SpeechActions OPEN;
    public static final SpeechActions PAUSE;
    public static final SpeechActions PLAY;
    public static final SpeechActions READ_MODE;
    public static final SpeechActions REPEAT;
    public static final SpeechActions REWIND;
    public static final SpeechActions SEARCH;
    public static final SpeechActions SEEK;
    public static final SpeechActions UNDO;
    public static final SpeechActions UNRECOGNIZED;

    private SpeechActions(String s, int i)
    {
        super(s, i);
    }

    public static SpeechActions valueOf(String s)
    {
        return (SpeechActions)Enum.valueOf(com/comcast/cim/android/accessibility/SpeechActions, s);
    }

    public static SpeechActions[] values()
    {
        return (SpeechActions[])$VALUES.clone();
    }

    static 
    {
        UNRECOGNIZED = new SpeechActions("UNRECOGNIZED", 0);
        LESS = new SpeechActions("LESS", 1);
        MORE = new SpeechActions("MORE", 2);
        REPEAT = new SpeechActions("REPEAT", 3);
        CLEAR = new SpeechActions("CLEAR", 4);
        CLOSE = new SpeechActions("CLOSE", 5);
        SEARCH = new SpeechActions("SEARCH", 6);
        OPEN = new SpeechActions("OPEN", 7);
        REWIND = new SpeechActions("REWIND", 8);
        PLAY = new SpeechActions("PLAY", 9);
        PAUSE = new SpeechActions("PAUSE", 10);
        SEEK = new SpeechActions("SEEK", 11);
        UNDO = new SpeechActions("UNDO", 12);
        CANCEL = new SpeechActions("CANCEL", 13);
        HELP = new SpeechActions("HELP", 14);
        READ_MODE = new SpeechActions("READ_MODE", 15);
        JUST_A_NUMBER = new SpeechActions("JUST_A_NUMBER", 16);
        JUST_SOME_WORDS = new SpeechActions("JUST_SOME_WORDS", 17);
        FEEDBACK = new SpeechActions("FEEDBACK", 18);
        IGNORE_REENTRY = new SpeechActions("IGNORE_REENTRY", 19);
        $VALUES = (new SpeechActions[] {
            UNRECOGNIZED, LESS, MORE, REPEAT, CLEAR, CLOSE, SEARCH, OPEN, REWIND, PLAY, 
            PAUSE, SEEK, UNDO, CANCEL, HELP, READ_MODE, JUST_A_NUMBER, JUST_SOME_WORDS, FEEDBACK, IGNORE_REENTRY
        });
    }
}
