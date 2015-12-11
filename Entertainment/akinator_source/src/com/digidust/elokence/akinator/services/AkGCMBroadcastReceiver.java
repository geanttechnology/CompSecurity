// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

// Referenced classes of package com.digidust.elokence.akinator.services:
//            GCMIntentService

public class AkGCMBroadcastReceiver extends WakefulBroadcastReceiver
{

    static final String GCM_SERVICE_CLASS = "com.digidust.elokence.akinator.services.GCMIntentService";

    public AkGCMBroadcastReceiver()
    {
    }

    protected String getGCMIntentServiceClassName(Context context)
    {
        return "com.digidust.elokence.akinator.services.GCMIntentService";
    }

    public void onReceive(Context context, Intent intent)
    {
        startWakefulService(context, intent.setComponent(new ComponentName(context.getPackageName(), com/digidust/elokence/akinator/services/GCMIntentService.getName())));
        setResultCode(-1);
    }
}
