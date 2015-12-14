// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia.api;

import android.net.Uri;
import com.baidu.android.pushservice.internal.BasicPushNotificationBuilder;
import com.baidu.android.pushservice.internal.PushNotificationBuilder;

public class  extends 
{

    private BasicPushNotificationBuilder a;

    PushNotificationBuilder a()
    {
        return a;
    }

    public void setNotificationDefaults(int i)
    {
        a.setNotificationDefaults(i);
    }

    public void setNotificationFlags(int i)
    {
        a.setNotificationFlags(i);
    }

    public void setNotificationSound(Uri uri)
    {
        a.setNotificationSound(uri);
    }

    public void setNotificationText(String s)
    {
        a.setNotificationText(s);
    }

    public void setNotificationTitle(String s)
    {
        a.setNotificationTitle(s);
    }

    public void setNotificationVibrate(long al[])
    {
        a.setNotificationVibrate(al);
    }

    public void setStatusbarIcon(int i)
    {
        a.setStatusbarIcon(i);
    }

    public ()
    {
        a = new BasicPushNotificationBuilder();
    }
}
