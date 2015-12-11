// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.penthera.virtuososdk.service:
//            VirtuosoService

public class VirtuosoServiceStarter extends BroadcastReceiver
{

    public VirtuosoServiceStarter()
    {
    }

    private static void startService(Context context, Intent intent)
    {
        intent.setComponent(new ComponentName(context.getPackageName(), com/penthera/virtuososdk/service/VirtuosoService.getName()));
        context.startService(intent);
    }

    void handleBoot(Context context)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.BOOT_COMPLETED");
        startService(context, intent);
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        if (s == null)
        {
            return;
        }
        if (s.equals("android.intent.action.BOOT_COMPLETED"))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.a("VirtuosoServiceStarter", "ServiceStarter(): INTENT_BOOT");
            handleBoot(context);
            return;
        }
        if (s.equals("virtuoso.intent.action.DOWNLOAD_UPDATE"))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i("VirtuosoServiceStarter", "ServiceStarter(): INTENT_DOWNLOAD_UPDATE");
            startService(context, intent);
            return;
        }
        if (s.equals("virtuoso.intent.action.START_VIRTUOSO_SERVICE_LOGGING"))
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i("VirtuosoServiceStarter", "ServiceStarter(): START_VIRTUOSO_SERVICE_LOGGING");
            startService(context, intent);
            return;
        } else
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.i("VirtuosoServiceStarter", (new StringBuilder("ServiceStarter(): Uknown Intent Action: ")).append(s).toString());
            return;
        }
    }
}
