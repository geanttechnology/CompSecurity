// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

// Referenced classes of package com.aviary.android.feather.common.utils:
//            ApiHelper

public final class BatteryUtils
{

    private BatteryUtils()
    {
    }

    private static Intent getChargingIntent(Context context)
    {
        if (context == null)
        {
            return null;
        } else
        {
            return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    private static boolean getIsCharging(int i)
    {
        while (i == 2 || i == 1 || ApiHelper.AT_LEAST_17 && i == 4) 
        {
            return true;
        }
        return false;
    }

    public static boolean isCharging(Context context, Intent intent)
    {
        Intent intent1;
label0:
        {
            if (intent != null)
            {
                intent1 = intent;
                if (intent.hasExtra("plugged"))
                {
                    break label0;
                }
            }
            intent1 = getChargingIntent(context);
        }
        if (intent1 == null)
        {
            return false;
        } else
        {
            return getIsCharging(intent1.getIntExtra("plugged", -1));
        }
    }
}
