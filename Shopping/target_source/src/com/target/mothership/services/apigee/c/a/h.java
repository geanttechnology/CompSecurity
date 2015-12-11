// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;


public final class h extends Enum
{

    private static final h $VALUES[];
    public static final h PICKUP_IN_STORE;
    public static final h SHIP_TO_HOME;
    public static final h SHIP_TO_STORE;
    private String mValue;

    private h(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static h valueOf(String s)
    {
        return (h)Enum.valueOf(com/target/mothership/services/apigee/c/a/h, s);
    }

    public static h[] values()
    {
        return (h[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        SHIP_TO_HOME = new h("SHIP_TO_HOME", 0, "home");
        PICKUP_IN_STORE = new h("PICKUP_IN_STORE", 1, "store");
        SHIP_TO_STORE = new h("SHIP_TO_STORE", 2, "STS");
        $VALUES = (new h[] {
            SHIP_TO_HOME, PICKUP_IN_STORE, SHIP_TO_STORE
        });
    }
}
