// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;


public final class format extends Enum
{

    private static final webm $VALUES[];
    public static final webm mp4;
    public static final webm webm;
    private String format;
    private int val;

    public static format formatFromString(String s)
    {
        if (s.equals("WEBM"))
        {
            return webm;
        }
        if (s.equals("MP4"))
        {
            return mp4;
        } else
        {
            return null;
        }
    }

    public static mp4 valueOf(String s)
    {
        return (mp4)Enum.valueOf(com/socialin/android/videogenerator/ProjectVideoGenerator$VideoFormat, s);
    }

    public static mp4[] values()
    {
        return (mp4[])$VALUES.clone();
    }

    public final String getFormat()
    {
        return format;
    }

    static 
    {
        mp4 = new <init>("mp4", 0, 1);
        webm = new <init>("webm", 1, 2);
        $VALUES = (new .VALUES[] {
            mp4, webm
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        val = j;
        switch (j)
        {
        default:
            format = "mp4";
            return;

        case 1: // '\001'
            format = "mp4";
            return;

        case 2: // '\002'
            format = "webm";
            break;
        }
    }
}
