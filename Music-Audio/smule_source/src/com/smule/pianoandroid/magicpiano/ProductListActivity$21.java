// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, b, ProductListFragment

class a extends BroadcastReceiver
{

    final ProductListActivity a;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction() == "BALANCE_UPDATE_EVENT")
        {
            ProductListActivity.c(a).c();
            return;
        }
        if (intent.getAction() == "SUBSCRIPTION_UPDATED")
        {
            ProductListActivity.d(a).c();
            return;
        } else
        {
            aa.b(ProductListActivity.a, "Unknown Broadcast received!");
            return;
        }
    }

    (ProductListActivity productlistactivity)
    {
        a = productlistactivity;
        super();
    }
}
