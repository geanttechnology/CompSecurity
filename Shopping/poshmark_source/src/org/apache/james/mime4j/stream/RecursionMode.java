// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;


public final class RecursionMode extends Enum
{

    private static final RecursionMode $VALUES[];
    public static final RecursionMode M_FLAT;
    public static final RecursionMode M_NO_RECURSE;
    public static final RecursionMode M_RAW;
    public static final RecursionMode M_RECURSE;

    private RecursionMode(String s, int i)
    {
        super(s, i);
    }

    public static RecursionMode valueOf(String s)
    {
        return (RecursionMode)Enum.valueOf(org/apache/james/mime4j/stream/RecursionMode, s);
    }

    public static RecursionMode[] values()
    {
        return (RecursionMode[])$VALUES.clone();
    }

    static 
    {
        M_RECURSE = new RecursionMode("M_RECURSE", 0);
        M_NO_RECURSE = new RecursionMode("M_NO_RECURSE", 1);
        M_RAW = new RecursionMode("M_RAW", 2);
        M_FLAT = new RecursionMode("M_FLAT", 3);
        $VALUES = (new RecursionMode[] {
            M_RECURSE, M_NO_RECURSE, M_RAW, M_FLAT
        });
    }
}
