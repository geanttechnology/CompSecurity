// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;


public final class PZLogLevel extends Enum
{

    private static final PZLogLevel $VALUES[];
    public static final PZLogLevel pzNOLOGS;
    public static final PZLogLevel pzlogDEBUG;
    public static final PZLogLevel pzlogDEBUG1;
    public static final PZLogLevel pzlogDEBUG2;
    public static final PZLogLevel pzlogDEBUG3;
    public static final PZLogLevel pzlogDEBUG4;
    public static final PZLogLevel pzlogERROR;
    public static final PZLogLevel pzlogINFO;
    public static final PZLogLevel pzlogWARNING;

    private PZLogLevel(String s, int i)
    {
        super(s, i);
    }

    public static PZLogLevel valueOf(String s)
    {
        return (PZLogLevel)Enum.valueOf(com/packetzoom/speed/PZLogLevel, s);
    }

    public static PZLogLevel[] values()
    {
        return (PZLogLevel[])$VALUES.clone();
    }

    static 
    {
        pzNOLOGS = new PZLogLevel("pzNOLOGS", 0);
        pzlogERROR = new PZLogLevel("pzlogERROR", 1);
        pzlogWARNING = new PZLogLevel("pzlogWARNING", 2);
        pzlogINFO = new PZLogLevel("pzlogINFO", 3);
        pzlogDEBUG = new PZLogLevel("pzlogDEBUG", 4);
        pzlogDEBUG1 = new PZLogLevel("pzlogDEBUG1", 5);
        pzlogDEBUG2 = new PZLogLevel("pzlogDEBUG2", 6);
        pzlogDEBUG3 = new PZLogLevel("pzlogDEBUG3", 7);
        pzlogDEBUG4 = new PZLogLevel("pzlogDEBUG4", 8);
        $VALUES = (new PZLogLevel[] {
            pzNOLOGS, pzlogERROR, pzlogWARNING, pzlogINFO, pzlogDEBUG, pzlogDEBUG1, pzlogDEBUG2, pzlogDEBUG3, pzlogDEBUG4
        });
    }
}
