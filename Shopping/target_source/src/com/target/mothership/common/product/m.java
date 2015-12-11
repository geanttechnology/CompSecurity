// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class m extends Enum
{

    private static final m $VALUES[];
    public static final m Ineligible;
    public static final m PickUpInStore;
    public static final m ShipToStore;
    public static final m Unavailable;

    private m(String s, int i)
    {
        super(s, i);
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/target/mothership/common/product/m, s);
    }

    public static m[] values()
    {
        return (m[])$VALUES.clone();
    }

    static 
    {
        PickUpInStore = new m("PickUpInStore", 0);
        ShipToStore = new m("ShipToStore", 1);
        Ineligible = new m("Ineligible", 2);
        Unavailable = new m("Unavailable", 3);
        $VALUES = (new m[] {
            PickUpInStore, ShipToStore, Ineligible, Unavailable
        });
    }
}
