// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appnexus.opensdk.b.b;

// Referenced classes of package com.appnexus.opensdk:
//            o

final class Receiver extends BroadcastReceiver
{

    final o a;

    public final void onReceive(Context context, Intent intent)
    {
        boolean flag = true;
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
            a.i();
            b.b(b.b, b.a(.screen_off_stop));
        } else
        if (intent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
            if (o.a(a) > 0)
            {
                a.h();
            } else
            if (com.appnexus.opensdk.o.b(a))
            {
                a.i();
                a.h();
            } else
            {
                flag = false;
            }
            if (flag)
            {
                b.b(b.b, b.a(.screen_on_start));
                return;
            }
        }
    }

    (o o1)
    {
        a = o1;
        super();
    }
}
