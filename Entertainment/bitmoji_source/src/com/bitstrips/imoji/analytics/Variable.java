// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;


public final class Variable extends Enum
{

    private static final Variable $VALUES[];
    public static final Variable ABANDONED;
    public static final Variable TIME_TO_SELECT;
    private final String name;

    private Variable(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static Variable valueOf(String s)
    {
        return (Variable)Enum.valueOf(com/bitstrips/imoji/analytics/Variable, s);
    }

    public static Variable[] values()
    {
        return (Variable[])$VALUES.clone();
    }

    public String toString()
    {
        return name;
    }

    static 
    {
        TIME_TO_SELECT = new Variable("TIME_TO_SELECT", 0, "Time to select");
        ABANDONED = new Variable("ABANDONED", 1, "Abandoned");
        $VALUES = (new Variable[] {
            TIME_TO_SELECT, ABANDONED
        });
    }
}
