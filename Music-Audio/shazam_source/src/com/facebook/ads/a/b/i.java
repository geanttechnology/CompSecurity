// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.ads.b;

// Referenced classes of package com.facebook.ads.a.b:
//            e, d

public final class i extends BroadcastReceiver
{

    String a;
    Context b;
    private e c;
    private d d;

    public i(Context context, String s, d d1, e e1)
    {
        b = context;
        a = s;
        c = e1;
        d = d1;
    }

    public final void onReceive(Context context, Intent intent)
    {
        context = intent.getAction().split(":")[0];
        if (c != null && context != null)
        {
            if ("com.facebook.ads.interstitial.clicked".equals(context))
            {
                context = intent.getStringExtra("com.facebook.ads.interstitial.ad.click.url");
                boolean flag = intent.getBooleanExtra("com.facebook.ads.interstitial.ad.player.handles.click", true);
                c.a(context, flag);
                return;
            }
            if ("com.facebook.ads.interstitial.dismissed".equals(context))
            {
                c.c();
                return;
            }
            if ("com.facebook.ads.interstitial.displayed".equals(context))
            {
                c.b();
                return;
            }
            if ("com.facebook.ads.interstitial.impression.logged".equals(context))
            {
                c.a();
                return;
            }
            if ("com.facebook.ads.interstitial.error".equals(context))
            {
                context = c;
                intent = d;
                b b1 = b.e;
                context.b(intent);
                return;
            }
        }
    }
}
