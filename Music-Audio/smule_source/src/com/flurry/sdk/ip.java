// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public abstract class ip extends Enum
{

    public static final ip a;
    public static final ip b;
    private static final ip c[];

    private ip(String s, int i)
    {
        super(s, i);
    }


    public static ip valueOf(String s)
    {
        return (ip)Enum.valueOf(com/flurry/sdk/ip, s);
    }

    public static ip[] values()
    {
        return (ip[])c.clone();
    }

    static 
    {
        a = new ip("DEFAULT", 0) {

        };
        b = new ip("STRING", 1) {

        };
        c = (new ip[] {
            a, b
        });
    }
}
