// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rockerhieu.emojicon.emoji;

import java.io.Serializable;

public class Emojicon
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String emoji;
    private int icon;
    private char value;

    private Emojicon()
    {
    }

    public Emojicon(String s)
    {
        emoji = s;
    }

    public static Emojicon fromChar(char c)
    {
        Emojicon emojicon = new Emojicon();
        emojicon.emoji = Character.toString(c);
        return emojicon;
    }

    public static Emojicon fromChars(String s)
    {
        Emojicon emojicon = new Emojicon();
        emojicon.emoji = s;
        return emojicon;
    }

    public static Emojicon fromCodePoint(int i)
    {
        Emojicon emojicon = new Emojicon();
        emojicon.emoji = newString(i);
        return emojicon;
    }

    public static Emojicon fromResource(int i, int j)
    {
        Emojicon emojicon = new Emojicon();
        emojicon.icon = i;
        emojicon.value = (char)j;
        return emojicon;
    }

    public static final String newString(int i)
    {
        if (Character.charCount(i) == 1)
        {
            return String.valueOf(i);
        } else
        {
            return new String(Character.toChars(i));
        }
    }

    public String getEmoji()
    {
        return emoji;
    }

    public int getIcon()
    {
        return icon;
    }

    public char getValue()
    {
        return value;
    }
}
