// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.pushnotification;

import com.amazon.mShop.model.auth.UserSubscriber;
import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsResponse;

public interface NotificationSubscriber
    extends UserSubscriber
{

    public abstract void onDeviceTokenUpdated();

    public abstract void onMarketplaceToggled(String s, boolean flag);

    public abstract void onSubscriptionUpdated();

    public abstract void onSubscriptionsReceived(GetNotificationSubscriptionsResponse getnotificationsubscriptionsresponse);
}
