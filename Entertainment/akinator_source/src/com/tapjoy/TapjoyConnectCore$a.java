// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.TimerTask;

// Referenced classes of package com.tapjoy:
//            TapjoyConnectCore, TapjoyLog

final class <init> extends TimerTask
{

    final TapjoyConnectCore a;

    public final void run()
    {
        TapjoyConnectCore.c(a);
        TapjoyLog.i("TapjoyConnect", (new StringBuilder("elapsed_time: ")).append(TapjoyConnectCore.d(a)).append(" (").append(TapjoyConnectCore.d(a) / 1000L / 60L).append("m ").append((TapjoyConnectCore.d(a) / 1000L) % 60L).append("s)").toString());
        android.content.itor itor = TapjoyConnectCore.b().getSharedPreferences("tjcPrefrences", 0).edit();
        itor.putLong("tapjoy_elapsed_time", TapjoyConnectCore.d(a));
        itor.commit();
        if (TapjoyConnectCore.d(a) >= 0xdbba0L)
        {
            TapjoyLog.i("TapjoyConnect", "timer done...");
            if (TapjoyConnectCore.c() != null && TapjoyConnectCore.c().length() > 0)
            {
                TapjoyLog.i("TapjoyConnect", "Calling PPA actionComplete...");
                a.actionComplete(TapjoyConnectCore.c());
            }
            cancel();
        }
    }

    private es.Editor(TapjoyConnectCore tapjoyconnectcore)
    {
        a = tapjoyconnectcore;
        super();
    }

    a(TapjoyConnectCore tapjoyconnectcore, byte byte0)
    {
        this(tapjoyconnectcore);
    }
}
