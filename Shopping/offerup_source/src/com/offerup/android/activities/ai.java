// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.Item;

// Referenced classes of package com.offerup.android.activities:
//            BuyActivity

final class ai
{

    private Item a;
    private Double b;

    private ai(BuyActivity buyactivity, Item item, Double double1)
    {
        a = item;
        b = double1;
    }

    ai(BuyActivity buyactivity, Item item, Double double1, byte byte0)
    {
        this(buyactivity, item, double1);
    }

    static Item a(ai ai1)
    {
        return ai1.a;
    }

    static Double b(ai ai1)
    {
        return ai1.b;
    }
}
