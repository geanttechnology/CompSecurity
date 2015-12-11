// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import io.presage.try.h;

// Referenced classes of package io.presage.formats.multiwebviews:
//            a

final class f extends BroadcastReceiver
{

    final a a;

    f(a a1)
    {
        a = a1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()))
        {
            int i = io.presage.formats.multiwebviews.a.c(a).getContext().getApplicationContext().getResources().getConfiguration().orientation;
            if (io.presage.formats.multiwebviews.a.d(a) != i)
            {
                io.presage.formats.multiwebviews.a.a(a, i);
                if (io.presage.formats.multiwebviews.a.e(a) != null)
                {
                    io.presage.formats.multiwebviews.a.e(a).a(a.b());
                }
            }
        }
    }
}
