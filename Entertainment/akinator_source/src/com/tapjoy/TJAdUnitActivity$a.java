// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.tapjoy:
//            TJAdUnitActivity, TapjoyLog

final class <init> extends BroadcastReceiver
{

    final TJAdUnitActivity a;

    public final void onReceive(Context context, Intent intent)
    {
        if (intent.getBooleanExtra("noConnectivity", false))
        {
            TapjoyLog.i("TJAdUnitActivity", "Network connectivity lost during ad unit activity");
            a.showErrorDialog();
        }
    }

    private ver(TJAdUnitActivity tjadunitactivity)
    {
        a = tjadunitactivity;
        super();
    }

    ver(TJAdUnitActivity tjadunitactivity, byte byte0)
    {
        this(tjadunitactivity);
    }
}
