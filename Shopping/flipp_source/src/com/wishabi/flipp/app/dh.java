// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.wishabi.flipp.util.p;

// Referenced classes of package com.wishabi.flipp.app:
//            MainActivity

final class dh extends BroadcastReceiver
{

    final MainActivity a;

    dh(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        long l = System.nanoTime();
        context = p.a();
        if (context != null)
        {
            context.edit().putLong("app_open_last_recreate_nano", l).commit();
        }
        a.recreate();
    }
}
