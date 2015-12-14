// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;

// Referenced classes of package com.baidu.android.pushservice:
//            PushNotificationBuilder, LoadExecutor

class b extends Thread
{

    final PushNotificationBuilder a;
    private final Context b;

    public void run()
    {
        PushNotificationBuilder pushnotificationbuilder = a;
        boolean flag;
        if (LoadExecutor.loadPush(b))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        PushNotificationBuilder.a(pushnotificationbuilder, flag);
    }

    (PushNotificationBuilder pushnotificationbuilder, Context context)
    {
        a = pushnotificationbuilder;
        b = context;
        super();
    }
}
