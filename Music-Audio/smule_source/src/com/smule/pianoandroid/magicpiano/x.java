// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicApplication

class x extends BroadcastReceiver
{

    long a;
    final MagicApplication b;

    public x(MagicApplication magicapplication, long l)
    {
        b = magicapplication;
        super();
        a = 0L;
        a = l;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (SystemClock.uptimeMillis() - a < 60000L)
        {
            MagicApplication.access$000(b, a);
            return;
        }
        context = intent.getAction();
        if (!b.isApplicationSentToBackground() && context.equals("android.intent.action.DEVICE_STORAGE_LOW"))
        {
            b.showToast(b.getResources().getString(0x7f0c017a), 0);
            aa.c(MagicApplication.access$100(), "DeviceStorageMonitorService low");
        }
        MagicApplication.access$000(b, SystemClock.uptimeMillis());
    }
}
