// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import com.baidu.android.pushservice.apiproxy.BridgePushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice:
//            PushNotificationBuilder

class b extends Thread
{

    final PushNotificationBuilder a;
    private final int b;

    public void run()
    {
        do
        {
            if (a.mInstance != null || PushNotificationBuilder.a(a))
            {
                if (PushNotificationBuilder.a(a))
                {
                    return;
                } else
                {
                    a.mInstance.setStatusbarIcon(b);
                    return;
                }
            }
            PushNotificationBuilder.a(a, 50);
        } while (true);
    }

    ationBuilder(PushNotificationBuilder pushnotificationbuilder, int i)
    {
        a = pushnotificationbuilder;
        b = i;
        super();
    }
}
