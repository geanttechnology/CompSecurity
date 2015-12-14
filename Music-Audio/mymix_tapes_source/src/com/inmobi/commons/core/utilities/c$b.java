// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.inmobi.commons.core.utilities:
//            c, Logger

static final class er extends BroadcastReceiver
{

    private static final String a = com/inmobi/commons/core/utilities/c$b.getSimpleName();

    public void onReceive(Context context, Intent intent)
    {
        if (intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null) goto _L2; else goto _L3
_L3:
        context = context.getActiveNetworkInfo();
        if (context == null || !context.isConnected()) goto _L2; else goto _L4
_L4:
        boolean flag = true;
_L6:
        c.a(flag);
        Logger.a(er.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Network connectivity changed. Is network available:").append(flag).toString());
        return;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }


    er()
    {
    }
}
