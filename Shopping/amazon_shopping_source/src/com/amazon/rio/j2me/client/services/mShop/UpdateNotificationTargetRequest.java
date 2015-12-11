// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            NotificationTarget

public class UpdateNotificationTargetRequest
{

    private NotificationTarget newNotificationTarget;
    private NotificationTarget oldNotificationTarget;

    public UpdateNotificationTargetRequest()
    {
    }

    public NotificationTarget getNewNotificationTarget()
    {
        return newNotificationTarget;
    }

    public NotificationTarget getOldNotificationTarget()
    {
        return oldNotificationTarget;
    }

    public void setNewNotificationTarget(NotificationTarget notificationtarget)
    {
        newNotificationTarget = notificationtarget;
    }

    public void setOldNotificationTarget(NotificationTarget notificationtarget)
    {
        oldNotificationTarget = notificationtarget;
    }
}
