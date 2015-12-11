// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


public final class f extends Enum
{

    private static final f $VALUES[];
    public static final f Electronic;
    public static final f NONE_SELECTED;
    public static final f ShipToHome;
    public static final f ShipToStore;
    public static final f Special;
    public static final f StorePickup;

    private f(String s, int i)
    {
        super(s, i);
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/target/mothership/common/a/f, s);
    }

    public static f[] values()
    {
        return (f[])$VALUES.clone();
    }

    static 
    {
        ShipToHome = new f("ShipToHome", 0);
        StorePickup = new f("StorePickup", 1);
        Special = new f("Special", 2);
        ShipToStore = new f("ShipToStore", 3);
        Electronic = new f("Electronic", 4);
        NONE_SELECTED = new f("NONE_SELECTED", 5);
        $VALUES = (new f[] {
            ShipToHome, StorePickup, Special, ShipToStore, Electronic, NONE_SELECTED
        });
    }
}
