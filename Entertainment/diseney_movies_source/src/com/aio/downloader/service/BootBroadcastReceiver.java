// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.aio.downloader.service:
//            MyService

public class BootBroadcastReceiver extends BroadcastReceiver
{

    public BootBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction()))
        {
            intent = new Intent(context, com/aio/downloader/service/MyService);
            intent.setFlags(0x10000000);
            context.startService(intent);
        }
    }
}
