// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.control.pushnotification.MShopNotificationSubScriber;
import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            PushNotificationManager

class ubScriber extends MShopNotificationSubScriber
{

    final PushNotificationManager this$0;
    final String val$registrationId;

    public void onDeviceTokenUpdated()
    {
        updateDataStore(val$registrationId);
        Context context = (Context)com.amazon.mShop.platform.ce().getApplicationContext();
        KiangController.getInstance().kiangUpdate(context);
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        if (PushNotificationManager.access$000() && !Util.isEmpty(exception.getMessage()))
        {
            Log.e(PushNotificationManager.TAG, exception.getMessage());
        }
    }

    ubScriber()
    {
        this$0 = final_pushnotificationmanager;
        val$registrationId = String.this;
        super();
    }
}
