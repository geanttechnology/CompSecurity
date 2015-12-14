// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.picsart.shop:
//            ShopActivity, h

final class b extends BroadcastReceiver
{

    private ShopActivity a;

    private b(ShopActivity shopactivity)
    {
        a = shopactivity;
        super();
    }

    b(ShopActivity shopactivity, byte byte0)
    {
        this(shopactivity);
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (ShopActivity.a(a) != null)
        {
            ShopActivity.a(a).a(true);
        }
    }
}
