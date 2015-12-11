// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


public final class ho extends Enum
{

    public static final ho a;
    public static final ho b;
    private static final ho c[];

    private ho(String s, int i)
    {
        super(s, i);
    }

    public static ho valueOf(String s)
    {
        return (ho)Enum.valueOf(com/tapjoy/internal/ho, s);
    }

    public static final ho[] values()
    {
        return (ho[])c.clone();
    }

    static 
    {
        a = new ho("STRICT", 0);
        b = new ho("BROWSER_COMPATIBLE", 1);
        c = (new ho[] {
            a, b
        });
    }
}
