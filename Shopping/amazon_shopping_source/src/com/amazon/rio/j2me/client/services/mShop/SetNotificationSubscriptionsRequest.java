// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            NotificationTarget

public class SetNotificationSubscriptionsRequest
{

    private NotificationTarget notificationTarget;
    private List subscriptions;

    public SetNotificationSubscriptionsRequest()
    {
    }

    public NotificationTarget getNotificationTarget()
    {
        return notificationTarget;
    }

    public List getSubscriptions()
    {
        return subscriptions;
    }

    public void setNotificationTarget(NotificationTarget notificationtarget)
    {
        notificationTarget = notificationtarget;
    }

    public void setSubscriptions(List list)
    {
        subscriptions = list;
    }
}
