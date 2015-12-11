// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.google_api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

// Referenced classes of package com.groupon.google_api:
//            GeofenceTransitionService

public class GeofenceTransitionWakefulBroadcastReceiver extends WakefulBroadcastReceiver
{

    public GeofenceTransitionWakefulBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        intent.setComponent(new ComponentName(context.getPackageName(), com/groupon/google_api/GeofenceTransitionService.getName()));
        startWakefulService(context, intent);
    }
}
