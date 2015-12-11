// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;


public final class ac extends Enum
{

    private static final ac $VALUES[];
    public static final ac NoData;
    public static final ac ParseError;
    public static final ac UnknownError;

    private ac(String s, int i)
    {
        super(s, i);
    }

    public static ac valueOf(String s)
    {
        return (ac)Enum.valueOf(com/target/mothership/services/ac, s);
    }

    public static ac[] values()
    {
        return (ac[])$VALUES.clone();
    }

    static 
    {
        NoData = new ac("NoData", 0);
        ParseError = new ac("ParseError", 1);
        UnknownError = new ac("UnknownError", 2);
        $VALUES = (new ac[] {
            NoData, ParseError, UnknownError
        });
    }
}
