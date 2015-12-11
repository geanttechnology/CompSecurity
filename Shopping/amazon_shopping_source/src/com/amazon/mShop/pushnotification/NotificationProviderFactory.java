// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.pushnotification.gcm.GCMNotificationProvider;
import com.amazon.mShop.pushnotification.getui.GetuiNotificationProvider;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationProvider

public class NotificationProviderFactory
{

    private static NotificationProviderFactory sInstance;

    public NotificationProviderFactory()
    {
    }

    public static NotificationProviderFactory getInstance()
    {
        com/amazon/mShop/pushnotification/NotificationProviderFactory;
        JVM INSTR monitorenter ;
        NotificationProviderFactory notificationproviderfactory;
        if (sInstance == null)
        {
            sInstance = new NotificationProviderFactory();
        }
        notificationproviderfactory = sInstance;
        com/amazon/mShop/pushnotification/NotificationProviderFactory;
        JVM INSTR monitorexit ;
        return notificationproviderfactory;
        Exception exception;
        exception;
        throw exception;
    }

    public NotificationProvider newNotificationProvider()
    {
        if ("zh_CN".equals(AppLocale.getInstance().getCurrentLocaleName()))
        {
            return new GetuiNotificationProvider();
        } else
        {
            return new GCMNotificationProvider();
        }
    }
}
