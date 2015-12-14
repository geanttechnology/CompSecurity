// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgeBasicPushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice:
//            BasicPushNotificationBuilder, LoadExecutor

class b extends Thread
{

    final BasicPushNotificationBuilder a;
    private final Context b;

    public void run()
    {
        if (!LoadExecutor.loadPush(b))
        {
            return;
        } else
        {
            BasicPushNotificationBuilder.a(a, new BridgeBasicPushNotificationBuilder());
            return;
        }
    }

    ationBuilder(BasicPushNotificationBuilder basicpushnotificationbuilder, Context context)
    {
        a = basicpushnotificationbuilder;
        b = context;
        super();
    }
}
