// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            LoginData, Notification

public class LoginResponse
{

    private LoginData loginData;
    private Notification notification;

    public LoginResponse()
    {
    }

    public LoginData getLoginData()
    {
        return loginData;
    }

    public Notification getNotification()
    {
        return notification;
    }

    public void setLoginData(LoginData logindata)
    {
        loginData = logindata;
    }

    public void setNotification(Notification notification1)
    {
        notification = notification1;
    }
}
