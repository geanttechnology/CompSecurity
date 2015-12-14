// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;


public final class Domain extends Enum
{

    private static final Domain $VALUES[];
    public static final Domain BETA;
    public static final Domain PROD;

    private Domain(String s, int i)
    {
        super(s, i);
    }

    public static Domain valueOf(String s)
    {
        return (Domain)Enum.valueOf(com/amazon/device/crashmanager/Domain, s);
    }

    public static Domain[] values()
    {
        return (Domain[])$VALUES.clone();
    }

    static 
    {
        PROD = new Domain("PROD", 0);
        BETA = new Domain("BETA", 1);
        $VALUES = (new Domain[] {
            PROD, BETA
        });
    }
}
