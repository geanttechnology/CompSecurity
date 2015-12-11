// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            NotificationTarget

public class LoginRequest
{

    private String email;
    private NotificationTarget notificationTarget;
    private String oneClickDeviceName;
    private String password;

    public LoginRequest()
    {
    }

    public String getEmail()
    {
        return email;
    }

    public NotificationTarget getNotificationTarget()
    {
        return notificationTarget;
    }

    public String getOneClickDeviceName()
    {
        return oneClickDeviceName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setNotificationTarget(NotificationTarget notificationtarget)
    {
        notificationTarget = notificationtarget;
    }

    public void setOneClickDeviceName(String s)
    {
        oneClickDeviceName = s;
    }

    public void setPassword(String s)
    {
        password = s;
    }
}
