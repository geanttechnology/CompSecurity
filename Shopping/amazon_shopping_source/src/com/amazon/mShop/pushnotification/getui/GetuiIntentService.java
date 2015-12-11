// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification.getui;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.pushnotification.getui:
//            GetuiNotificationProvider

public class GetuiIntentService extends IntentService
{

    private static final String TAG = com/amazon/mShop/pushnotification/getui/GetuiIntentService.getSimpleName();

    public GetuiIntentService()
    {
        super(TAG);
    }

    protected void onHandleIntent(Intent intent)
    {
_L2:
        return;
        if (!PushNotificationManager.getInstance().matchNotificationProvider(com/amazon/mShop/pushnotification/getui/GetuiNotificationProvider) || intent == null) goto _L2; else goto _L1
_L1:
        switch (intent.getIntExtra("type", 0))
        {
        default:
            return;

        case 1: // '\001'
            intent = intent.getStringExtra("vcid");
            if (DebugSettings.isDebugEnabled())
            {
                Log.i(TAG, (new StringBuilder()).append("vcid:").append(intent).toString());
            }
            PushNotificationManager.getInstance().updateDeviceToken(intent);
            return;

        case 2: // '\002'
            intent = intent.getStringExtra("url");
            if (DebugSettings.isDebugEnabled())
            {
                Log.i(TAG, (new StringBuilder()).append("download url:").append(intent).toString());
            }
            if (!Util.isEmpty(intent))
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("getui_master_app_download_url", intent);
                if (!Util.isEmpty(PushNotificationManager.getInstance().getCurrentMShopDeviceToken()))
                {
                    PushNotificationManager.getInstance().updateDataStore(null);
                    return;
                }
            }
            break;

        case 3: // '\003'
            String s = new String(intent.getByteArrayExtra("payload"));
            if (DebugSettings.isDebugEnabled())
            {
                Log.i(TAG, (new StringBuilder()).append("payload:").append(s).toString());
            }
            PushNotificationManager.getInstance().handlePushMessage(getApplicationContext(), intent);
            return;
        }
        if (true) goto _L2; else goto _L3
_L3:
    }

}
