// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;


public final class width extends Enum
{

    private static final p1072 $VALUES[];
    public static final p1072 p1072;
    public static final p1072 p1080;
    public static final p1072 p720;
    private int val;
    private int width;

    public static width fromString(String s)
    {
        if (s.equals("1080p"))
        {
            return p1080;
        }
        if (s.equals("720p"))
        {
            return p720;
        } else
        {
            return null;
        }
    }

    public static p720 valueOf(String s)
    {
        return (p720)Enum.valueOf(com/socialin/android/videogenerator/ProjectVideoGenerator$VideoResolution, s);
    }

    public static p720[] values()
    {
        return (p720[])$VALUES.clone();
    }

    public final int getHeight()
    {
        return val;
    }

    public final int getWidth()
    {
        return width;
    }

    static 
    {
        p720 = new <init>("p720", 0, 720);
        p1080 = new <init>("p1080", 1, 1080);
        p1072 = new <init>("p1072", 2, 1072);
        $VALUES = (new .VALUES[] {
            p720, p1080, p1072
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        val = j;
        switch (j)
        {
        default:
            width = (val * 4) / 3;
            return;

        case 720: 
            width = 1280;
            return;

        case 1072: 
            width = 1920;
            return;

        case 1080: 
            width = 1920;
            break;
        }
    }
}
