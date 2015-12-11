// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.parse:
//            PushService, ServiceUtils

public class GcmBroadcastReceiver extends BroadcastReceiver
{

    public GcmBroadcastReceiver()
    {
    }

    public final void onReceive(Context context, Intent intent)
    {
        ServiceUtils.runWakefulIntentInService(context, intent, com/parse/PushService);
    }
}
