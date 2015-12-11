// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;


public final class ScoreSource extends Enum
{

    private static final ScoreSource $VALUES[];
    public static final ScoreSource ASR;
    public static final ScoreSource SLU;

    private ScoreSource(String s, int i)
    {
        super(s, i);
    }

    public static ScoreSource valueOf(String s)
    {
        return (ScoreSource)Enum.valueOf(com/amazon/dee/result/bif/ScoreSource, s);
    }

    public static ScoreSource[] values()
    {
        return (ScoreSource[])$VALUES.clone();
    }

    static 
    {
        ASR = new ScoreSource("ASR", 0);
        SLU = new ScoreSource("SLU", 1);
        $VALUES = (new ScoreSource[] {
            ASR, SLU
        });
    }
}
