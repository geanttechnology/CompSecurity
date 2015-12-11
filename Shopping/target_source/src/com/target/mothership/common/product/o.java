// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class o extends Enum
{

    private static final o $VALUES[];
    public static final o ANY;
    public static final o PICKUP_IN_STORE;
    public static final o SHIP_TO_STORE;
    public static final o UNKNOWN;

    private o(String s, int i)
    {
        super(s, i);
    }

    public static o valueOf(String s)
    {
        return (o)Enum.valueOf(com/target/mothership/common/product/o, s);
    }

    public static o[] values()
    {
        return (o[])$VALUES.clone();
    }

    static 
    {
        ANY = new o("ANY", 0);
        PICKUP_IN_STORE = new o("PICKUP_IN_STORE", 1);
        SHIP_TO_STORE = new o("SHIP_TO_STORE", 2);
        UNKNOWN = new o("UNKNOWN", 3);
        $VALUES = (new o[] {
            ANY, PICKUP_IN_STORE, SHIP_TO_STORE, UNKNOWN
        });
    }
}
