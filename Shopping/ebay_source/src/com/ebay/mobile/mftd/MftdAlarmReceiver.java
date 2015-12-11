// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.mftd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.ebay.mobile.mftd:
//            MftdService

public class MftdAlarmReceiver extends BroadcastReceiver
{

    private static final String TAG = "MftdAlarmReceiver";

    public MftdAlarmReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.v("MftdAlarmReceiver", "onReceive, starting MftdService");
        Intent intent1 = new Intent(context, com/ebay/mobile/mftd/MftdService);
        intent1.setAction(intent.getAction());
        context.startService(intent1);
    }
}
