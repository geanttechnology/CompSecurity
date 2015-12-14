// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;

// Referenced classes of package com.picsart.shop:
//            v, o, ShopItemActivity, k

final class t>
    implements v
{

    private Activity a;
    private o b;

    public final transient void a(int i)
    {
        if (a == null || a.isFinishing())
        {
            return;
        } else
        {
            Intent intent = new Intent(a, com/picsart/shop/ShopItemActivity);
            intent.putExtra("selectedShopItem", (Parcelable)o.d(b).b(i));
            b.startActivityForResult(intent, 100);
            return;
        }
    }

    (o o1, Activity activity)
    {
        b = o1;
        a = activity;
        super();
    }
}
