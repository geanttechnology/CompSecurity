// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            NotificationTarget

public class CheckLoginRequest
{

    private NotificationTarget notificationTarget;
    private String oneClickDeviceName;

    public CheckLoginRequest()
    {
    }

    public NotificationTarget getNotificationTarget()
    {
        return notificationTarget;
    }

    public String getOneClickDeviceName()
    {
        return oneClickDeviceName;
    }

    public void setNotificationTarget(NotificationTarget notificationtarget)
    {
        notificationTarget = notificationtarget;
    }

    public void setOneClickDeviceName(String s)
    {
        oneClickDeviceName = s;
    }
}
