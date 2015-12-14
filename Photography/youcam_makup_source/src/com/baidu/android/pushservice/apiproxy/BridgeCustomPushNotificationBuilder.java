// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice.apiproxy;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import com.baidu.android.pushservice.internal.CustomPushNotificationBuilder;
import com.baidu.android.pushservice.internal.PushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice.apiproxy:
//            BridgePushNotificationBuilder

public class BridgeCustomPushNotificationBuilder extends BridgePushNotificationBuilder
{

    public BridgeCustomPushNotificationBuilder(int i, int j, int k, int l)
    {
        mInstance = new CustomPushNotificationBuilder(i, j, k, l);
    }

    public BridgeCustomPushNotificationBuilder(CustomPushNotificationBuilder custompushnotificationbuilder)
    {
        mInstance = custompushnotificationbuilder;
    }

    public Notification construct(Context context)
    {
        return mInstance.construct(context);
    }

    public CustomPushNotificationBuilder getInner()
    {
        return (CustomPushNotificationBuilder)mInstance;
    }

    public volatile PushNotificationBuilder getInner()
    {
        return getInner();
    }

    public void setLayoutDrawable(int i)
    {
        ((CustomPushNotificationBuilder)mInstance).setLayoutDrawable(i);
    }

    public void setNotificationDefaults(int i)
    {
        mInstance.setNotificationDefaults(i);
    }

    public void setNotificationFlags(int i)
    {
        mInstance.setNotificationFlags(i);
    }

    public void setNotificationSound(Uri uri)
    {
        mInstance.setNotificationSound(uri);
    }

    public void setNotificationText(String s)
    {
        mInstance.setNotificationText(s);
    }

    public void setNotificationTitle(String s)
    {
        mInstance.setNotificationTitle(s);
    }

    public void setNotificationVibrate(long al[])
    {
        mInstance.setNotificationVibrate(al);
    }

    public void setStatusbarIcon(int i)
    {
        mInstance.setStatusbarIcon(i);
    }
}
