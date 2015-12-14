// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import com.baidu.android.pushservice.apiproxy.BridgePushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice:
//            CustomPushNotificationBuilder

class b extends Thread
{

    final CustomPushNotificationBuilder a;
    private final int b;

    public void run()
    {
        do
        {
            if (a.mInstance != null || CustomPushNotificationBuilder.a(a))
            {
                if (CustomPushNotificationBuilder.a(a))
                {
                    return;
                } else
                {
                    a.mInstance.setStatusbarIcon(b);
                    return;
                }
            }
            CustomPushNotificationBuilder.a(a, 50);
        } while (true);
    }

    uilder(CustomPushNotificationBuilder custompushnotificationbuilder, int i)
    {
        a = custompushnotificationbuilder;
        b = i;
        super();
    }
}
