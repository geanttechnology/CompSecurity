// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;


public final class MyGrouponsTabs extends Enum
{

    private static final MyGrouponsTabs $VALUES[];
    public static final MyGrouponsTabs ALL;
    public static final MyGrouponsTabs AVAILABLE;
    public static final MyGrouponsTabs EXPIRING;
    public static final MyGrouponsTabs NEARBY;

    private MyGrouponsTabs(String s, int i)
    {
        super(s, i);
    }

    public static MyGrouponsTabs valueOf(String s)
    {
        return (MyGrouponsTabs)Enum.valueOf(com/groupon/MyGrouponsTabs, s);
    }

    public static MyGrouponsTabs[] values()
    {
        return (MyGrouponsTabs[])$VALUES.clone();
    }

    static 
    {
        AVAILABLE = new MyGrouponsTabs("AVAILABLE", 0);
        EXPIRING = new MyGrouponsTabs("EXPIRING", 1);
        NEARBY = new MyGrouponsTabs("NEARBY", 2);
        ALL = new MyGrouponsTabs("ALL", 3);
        $VALUES = (new MyGrouponsTabs[] {
            AVAILABLE, EXPIRING, NEARBY, ALL
        });
    }
}
