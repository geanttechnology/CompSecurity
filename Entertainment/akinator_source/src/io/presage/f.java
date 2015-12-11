// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.presage.ads.NewAd;
import io.presage.utils.IADHandler;

// Referenced classes of package io.presage:
//            e, Presage

final class f extends BroadcastReceiver
{

    final NewAd a;
    final e b;

    f(e e1, NewAd newad)
    {
        b = e1;
        a = newad;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("id");
        if (!a.getId().equals(context))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        Presage.access$100(b.a).onAdClosed();
        Presage.access$200(b.a).unregisterReceiver(this);
        return;
        context;
    }
}
