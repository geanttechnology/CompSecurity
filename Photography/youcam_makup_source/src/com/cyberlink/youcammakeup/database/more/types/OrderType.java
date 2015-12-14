// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.types;


public final class OrderType extends Enum
{

    public static final OrderType a;
    public static final OrderType b;
    public static final OrderType c;
    private static final OrderType d[];

    private OrderType(String s, int i)
    {
        super(s, i);
    }

    public static OrderType valueOf(String s)
    {
        return (OrderType)Enum.valueOf(com/cyberlink/youcammakeup/database/more/types/OrderType, s);
    }

    public static OrderType[] values()
    {
        return (OrderType[])d.clone();
    }

    static 
    {
        a = new OrderType("Download", 0);
        b = new OrderType("New", 1);
        c = new OrderType("Top", 2);
        d = (new OrderType[] {
            a, b, c
        });
    }
}
