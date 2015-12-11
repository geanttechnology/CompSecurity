// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification.gcm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.google.android.gcm.GCMBaseIntentService;

// Referenced classes of package com.amazon.mShop.pushnotification.gcm:
//            GCMNotificationProvider

public class MShopGCMIntentService extends GCMBaseIntentService
{

    protected static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static int sRetryCounter;

    public MShopGCMIntentService()
    {
        super(new String[] {
            "16912134167"
        });
    }

    protected void onDeletedMessages(Context context, int i)
    {
    }

    public void onError(Context context, String s)
    {
        PushNotificationManager.getInstance().setCurrentPushNotificationErrorId(s);
    }

    protected void onMessage(Context context, Intent intent)
    {
        if (!PushNotificationManager.getInstance().matchNotificationProvider(com/amazon/mShop/pushnotification/gcm/GCMNotificationProvider))
        {
            return;
        } else
        {
            PushNotificationManager.getInstance().handlePushMessage(context, intent);
            return;
        }
    }

    protected boolean onRecoverableError(Context context, String s)
    {
        PushNotificationManager.getInstance().setCurrentPushNotificationErrorId(s);
        int i = sRetryCounter;
        sRetryCounter = i + 1;
        if (i <= 5)
        {
            return true;
        } else
        {
            sRetryCounter = 0;
            return false;
        }
    }

    protected void onRegistered(Context context, String s)
    {
        if (DEBUG)
        {
            Log.d("PushNotification", (new StringBuilder()).append("Registered..ID:").append(s).toString());
        }
        PushNotificationManager.getInstance().updateDeviceToken(s);
        com.amazon.mShop.util.MShopPushNotificationUtils.PushNotificationMessageReceiver.sendPushNotificationRegisteredMessageBroadcast(context, s);
    }

    protected void onUnregistered(Context context, String s)
    {
    }

}
