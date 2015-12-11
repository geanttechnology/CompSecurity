// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

// Referenced classes of package com.google.android.gms.internal:
//            zzmx

public final class zzmr
{

    private static IntentFilter zzail = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    public static int zzao(Context context)
    {
        boolean flag = true;
        if (context == null || context.getApplicationContext() == null)
        {
            return -1;
        }
        Intent intent = context.getApplicationContext().registerReceiver(null, zzail);
        int i;
        int j;
        boolean flag1;
        if (intent == null)
        {
            i = 0;
        } else
        {
            i = intent.getIntExtra("plugged", 0);
        }
        if ((i & 7) != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (zzmx.zzqC())
        {
            flag1 = ((PowerManager)context.getSystemService("power")).isInteractive();
        } else
        {
            flag1 = ((PowerManager)context.getSystemService("power")).isScreenOn();
        }
        if (flag1)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        return j << 1 | i;
    }

    public static float zzap(Context context)
    {
        context = context.getApplicationContext().registerReceiver(null, zzail);
        float f = (0.0F / 0.0F);
        if (context != null)
        {
            int i = context.getIntExtra("level", -1);
            int j = context.getIntExtra("scale", -1);
            f = (float)i / (float)j;
        }
        return f;
    }

}
