// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.deviceinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.deviceinfo:
//            DeviceInfoLoader

public class MasEventReceiver extends BroadcastReceiver
{
    public static class MasAction
    {

        public static final String AuthenticationSuccessAction = "com.amazon.mas.client.authentication.action.AUTHENTICATION_SUCCESS_ACTION";
        public static final String DdiRefreshSuccessful = "com.amazon.mas.client.tokenrefresh.TokenRefreshService.ddi.refresh.successful";
        public static final String UserDeregisteredAction = "com.amazon.mas.client.authentication.action.USER_DEREGISTERED_ACTION";

        public MasAction()
        {
        }
    }


    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/deviceinfo/MasEventReceiver);

    public MasEventReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent == null)
        {
            return;
        } else
        {
            log.debug((new StringBuilder()).append("Received broadcast: ").append(intent.getAction()).toString());
            DeviceInfoLoader.getInstance().refresh(context);
            return;
        }
    }

    public void register(Context context)
    {
        try
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("com.amazon.mas.client.tokenrefresh.TokenRefreshService.ddi.refresh.successful");
            intentfilter.addAction("com.amazon.mas.client.authentication.action.AUTHENTICATION_SUCCESS_ACTION");
            intentfilter.addAction("com.amazon.mas.client.authentication.action.USER_DEREGISTERED_ACTION");
            context.registerReceiver(this, intentfilter);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Failed to register MasEventReceiver", context);
        }
    }

    public void unregister(Context context)
    {
        try
        {
            context.unregisterReceiver(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Failed to unregister MasEventReceiver", context);
        }
    }

}
