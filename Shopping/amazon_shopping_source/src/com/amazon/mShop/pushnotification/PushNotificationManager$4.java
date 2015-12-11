// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.util.Log;
import com.amazon.mShop.control.pushnotification.MShopNotificationSubScriber;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.gno.GNOItemAdapter;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            PushNotificationManager

class ubScriber extends MShopNotificationSubScriber
{

    final PushNotificationManager this$0;

    public void onError(Exception exception, ServiceCall servicecall)
    {
        if (PushNotificationManager.access$000() && !Util.isEmpty(exception.getMessage()))
        {
            Log.e(PushNotificationManager.TAG, exception.getMessage());
        }
        MShopPushNotificationUtils.setLastMarketPlace(null);
    }

    public void onMarketplaceToggled(String s, boolean flag)
    {
        if (s.equals(AppLocale.getInstance().getMarketPlaceIdByLocale(AppLocale.getInstance().getCurrentLocaleName())))
        {
            com.amazon.mShop.platform.ce().getDataStore().putBoolean("isSupportNotifications", flag);
            MShopPushNotificationUtils.setLastMarketPlace(AppLocale.getInstance().getCurrentLocaleName());
            GNODrawer.getGNOItemAdapter().updateVisibleItems();
        }
    }

    ubScriber()
    {
        this$0 = PushNotificationManager.this;
        super();
    }
}
