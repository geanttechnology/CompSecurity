// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class sa extends BroadcastReceiver
{

    boolean a;
    final rx b;
    private Handler c;

    sa(rx rx1)
    {
        b = rx1;
        super();
    }

    public final void a()
    {
        if (c == null)
        {
            c = new Handler();
        }
        if (!a)
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.SCREEN_OFF");
            intentfilter.addAction("android.intent.action.SCREEN_ON");
            b.a.registerReceiver(this, intentfilter);
            a = true;
        }
    }

    public final void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()))
        {
            if (!b.b.l() && b.b.h() > 0)
            {
                c.postDelayed(new sb(this), 0x2bf20L);
            }
            return;
        } else
        {
            c.removeCallbacksAndMessages(null);
            return;
        }
    }
}
