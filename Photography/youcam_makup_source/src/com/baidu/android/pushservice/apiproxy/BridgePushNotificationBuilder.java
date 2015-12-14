// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice.apiproxy;

import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import com.baidu.android.pushservice.internal.PushNotificationBuilder;

public abstract class BridgePushNotificationBuilder
{

    protected PushNotificationBuilder mInstance = new PushNotificationBuilder() {

        final BridgePushNotificationBuilder a;

        public Notification construct(Context context)
        {
            return a.construct(context);
        }

            
            {
                a = BridgePushNotificationBuilder.this;
                super();
            }
    };

    public BridgePushNotificationBuilder()
    {
    }

    public BridgePushNotificationBuilder(PushNotificationBuilder pushnotificationbuilder)
    {
        mInstance = pushnotificationbuilder;
    }

    public abstract Notification construct(Context context);

    public PushNotificationBuilder getInner()
    {
        return mInstance;
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
