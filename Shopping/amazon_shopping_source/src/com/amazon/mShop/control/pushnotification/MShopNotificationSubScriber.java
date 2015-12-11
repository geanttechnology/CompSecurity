// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.pushnotification;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsResponse;

// Referenced classes of package com.amazon.mShop.control.pushnotification:
//            NotificationSubscriber

public class MShopNotificationSubScriber
    implements NotificationSubscriber
{

    public MShopNotificationSubScriber()
    {
    }

    public void onDeviceTokenUpdated()
    {
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
    }

    public void onMarketplaceToggled(String s, boolean flag)
    {
    }

    public void onRequiresUserLogin(com.amazon.mShop.model.auth.UserSubscriber.Callback callback)
    {
    }

    public void onSubscriptionUpdated()
    {
    }

    public void onSubscriptionsReceived(GetNotificationSubscriptionsResponse getnotificationsubscriptionsresponse)
    {
    }
}
