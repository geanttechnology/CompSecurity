// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.ftue;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.client.ftue:
//            AppstoreFtueService

public class ResetReceiver extends BroadcastReceiver
{

    public ResetReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        context.startService((new Intent(context, com/amazon/client/ftue/AppstoreFtueService)).setAction("com.amazon.mas.client.startup.ftue.RESET").putExtras(intent.getExtras()));
    }
}
