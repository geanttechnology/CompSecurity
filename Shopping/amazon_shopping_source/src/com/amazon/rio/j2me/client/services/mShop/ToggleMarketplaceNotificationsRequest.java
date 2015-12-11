// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            NotificationTarget

public class ToggleMarketplaceNotificationsRequest
{

    private Boolean enableNotifications;
    private NotificationTarget notificationTarget;
    private Boolean recognizedRequiredOnly;

    public ToggleMarketplaceNotificationsRequest()
    {
    }

    public Boolean getEnableNotifications()
    {
        return enableNotifications;
    }

    public NotificationTarget getNotificationTarget()
    {
        return notificationTarget;
    }

    public Boolean getRecognizedRequiredOnly()
    {
        return recognizedRequiredOnly;
    }

    public void setEnableNotifications(Boolean boolean1)
    {
        enableNotifications = boolean1;
    }

    public void setNotificationTarget(NotificationTarget notificationtarget)
    {
        notificationTarget = notificationtarget;
    }
}
