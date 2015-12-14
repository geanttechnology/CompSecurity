// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgeCustomPushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice:
//            CustomPushNotificationBuilder, LoadExecutor

class f extends Thread
{

    final CustomPushNotificationBuilder a;
    private final Context b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;

    public void run()
    {
        if (!LoadExecutor.loadPush(b))
        {
            CustomPushNotificationBuilder.a(a, true);
            return;
        } else
        {
            a.mInstance = new BridgeCustomPushNotificationBuilder(c, d, e, f);
            return;
        }
    }

    ationBuilder(CustomPushNotificationBuilder custompushnotificationbuilder, Context context, int i, int j, int k, int l)
    {
        a = custompushnotificationbuilder;
        b = context;
        c = i;
        d = j;
        e = k;
        f = l;
        super();
    }
}
