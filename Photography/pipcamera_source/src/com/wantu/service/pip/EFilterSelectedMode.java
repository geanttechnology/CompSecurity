// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.pip;


public final class EFilterSelectedMode extends Enum
{

    private static final EFilterSelectedMode $VALUES[];
    public static final EFilterSelectedMode BACKGROUND;
    public static final EFilterSelectedMode BOTH;
    public static final EFilterSelectedMode FORGROUND;

    private EFilterSelectedMode(String s, int i)
    {
        super(s, i);
    }

    public static EFilterSelectedMode valueOf(String s)
    {
        return (EFilterSelectedMode)Enum.valueOf(com/wantu/service/pip/EFilterSelectedMode, s);
    }

    public static EFilterSelectedMode[] values()
    {
        return (EFilterSelectedMode[])$VALUES.clone();
    }

    static 
    {
        FORGROUND = new EFilterSelectedMode("FORGROUND", 0);
        BACKGROUND = new EFilterSelectedMode("BACKGROUND", 1);
        BOTH = new EFilterSelectedMode("BOTH", 2);
        $VALUES = (new EFilterSelectedMode[] {
            FORGROUND, BACKGROUND, BOTH
        });
    }
}
