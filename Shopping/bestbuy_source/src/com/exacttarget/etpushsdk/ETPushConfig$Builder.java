// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETPushConfig, ETPush

public class pushConfig
{

    private final ETPushConfig pushConfig;

    public ETPushConfig build()
    {
        if (TextUtils.isEmpty(pushConfig.b))
        {
            throw new IllegalArgumentException("etAppId may not be null or empty.");
        }
        if (TextUtils.isEmpty(pushConfig.c))
        {
            throw new IllegalArgumentException("accessToken may not be null or empty.");
        }
        if (TextUtils.isEmpty(pushConfig.d))
        {
            throw new IllegalArgumentException("gcmSenderId may not be null or empty.");
        }
        if (pushConfig.j != null)
        {
            ETPush.c(pushConfig.j, false);
        }
        if (pushConfig.k != null)
        {
            ETPush.b(pushConfig.k, false);
        }
        if (pushConfig.l != null)
        {
            ETPush.a(pushConfig.l, false);
        }
        if (!TextUtils.isEmpty(pushConfig.m))
        {
            ETPush.a(pushConfig.m, false);
        }
        if (pushConfig.n != null)
        {
            ETPush.a(pushConfig.n, false);
        }
        if (pushConfig.p > 0)
        {
            ETPush.a(Integer.valueOf(pushConfig.p), false);
        }
        ETPush.setLogLevel(pushConfig.o);
        return pushConfig;
    }

    public pushConfig setAccessToken(String s)
    {
        pushConfig.c = s;
        return this;
    }

    public pushConfig setAnalyticsEnabled(boolean flag)
    {
        pushConfig.e = flag;
        return this;
    }

    public pushConfig setCloudPageRecipientClass(Class class1)
    {
        pushConfig.j = class1;
        return this;
    }

    public pushConfig setCloudPagesEnabled(boolean flag)
    {
        pushConfig.i = flag;
        return this;
    }

    public pushConfig setEtAppId(String s)
    {
        pushConfig.b = s;
        return this;
    }

    public pushConfig setGcmSenderId(String s)
    {
        pushConfig.d = s;
        return this;
    }

    public pushConfig setLocationEnabled(boolean flag)
    {
        pushConfig.g = flag;
        return this;
    }

    public pushConfig setLogLevel(int i)
    {
        pushConfig.o = i;
        return this;
    }

    public pushConfig setLogToFile(boolean flag)
    {
        return this;
    }

    public pushConfig setNotificationAction(String s)
    {
        pushConfig.m = s;
        return this;
    }

    public pushConfig setNotificationActionUri(Uri uri)
    {
        pushConfig.n = uri;
        return this;
    }

    public pushConfig setNotificationRecipientClass(Class class1)
    {
        pushConfig.l = class1;
        return this;
    }

    public pushConfig setNotificationResourceId(int i)
    {
        pushConfig.p = i;
        return this;
    }

    public pushConfig setOpenDirectRecipientClass(Class class1)
    {
        pushConfig.k = class1;
        return this;
    }

    public pushConfig setPiAnalyticsEnabled(boolean flag)
    {
        pushConfig.f = flag;
        return this;
    }

    public pushConfig setProximityEnabled(boolean flag)
    {
        pushConfig.h = flag;
        return this;
    }

    public (Application application)
    {
        pushConfig = new ETPushConfig(application, null);
    }
}
