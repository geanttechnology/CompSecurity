// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification.getui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.platform.AppLocale;

// Referenced classes of package com.amazon.mShop.pushnotification.getui:
//            GetuiIntentService

public class GetuiMsgReceiver extends BroadcastReceiver
{

    public GetuiMsgReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("zh_CN".equals(AppLocale.getInstance().getCurrentLocaleName()))
        {
            intent = new Intent(intent);
            intent.setClass(context, com/amazon/mShop/pushnotification/getui/GetuiIntentService);
            context.getApplicationContext().startService(intent);
        }
    }
}
