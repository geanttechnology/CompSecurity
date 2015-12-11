// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;


public final class PlayEventType extends Enum
{

    private static final PlayEventType $VALUES[];
    public static final PlayEventType Ad;
    public static final PlayEventType Buffering;
    public static final PlayEventType Error;
    public static final PlayEventType Finish;
    public static final PlayEventType Pause;
    public static final PlayEventType Play;
    public static final PlayEventType Resume;
    public static final PlayEventType Skip;
    public static final PlayEventType Time;

    private PlayEventType(String s, int i)
    {
        super(s, i);
    }

    public static PlayEventType valueOf(String s)
    {
        return (PlayEventType)Enum.valueOf(com/rdio/android/core/reporting/PlayEventType, s);
    }

    public static PlayEventType[] values()
    {
        return (PlayEventType[])$VALUES.clone();
    }

    public final String toServerString()
    {
        return name().toLowerCase();
    }

    static 
    {
        Play = new PlayEventType("Play", 0);
        Time = new PlayEventType("Time", 1);
        Pause = new PlayEventType("Pause", 2);
        Resume = new PlayEventType("Resume", 3);
        Skip = new PlayEventType("Skip", 4);
        Finish = new PlayEventType("Finish", 5);
        Error = new PlayEventType("Error", 6);
        Buffering = new PlayEventType("Buffering", 7);
        Ad = new PlayEventType("Ad", 8);
        $VALUES = (new PlayEventType[] {
            Play, Time, Pause, Resume, Skip, Finish, Error, Buffering, Ad
        });
    }
}
