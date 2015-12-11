// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;


public final class ConfidenceBin extends Enum
{

    private static final ConfidenceBin $VALUES[];
    public static final ConfidenceBin HIGH;
    public static final ConfidenceBin LOW;
    public static final ConfidenceBin MEDIUM;

    private ConfidenceBin(String s, int i)
    {
        super(s, i);
    }

    public static ConfidenceBin valueOf(String s)
    {
        return (ConfidenceBin)Enum.valueOf(com/amazon/dee/result/bif/ConfidenceBin, s);
    }

    public static ConfidenceBin[] values()
    {
        return (ConfidenceBin[])$VALUES.clone();
    }

    public String getBinName()
    {
        return toString();
    }

    static 
    {
        LOW = new ConfidenceBin("LOW", 0);
        MEDIUM = new ConfidenceBin("MEDIUM", 1);
        HIGH = new ConfidenceBin("HIGH", 2);
        $VALUES = (new ConfidenceBin[] {
            LOW, MEDIUM, HIGH
        });
    }
}
