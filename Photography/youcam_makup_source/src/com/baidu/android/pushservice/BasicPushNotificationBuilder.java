// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgeBasicPushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice:
//            LoadExecutor

public class BasicPushNotificationBuilder
{

    private BridgeBasicPushNotificationBuilder a;

    public BasicPushNotificationBuilder(Context context)
    {
        (new Thread(context) {

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

            
            {
                a = BasicPushNotificationBuilder.this;
                b = context;
                super();
            }
        }).start();
    }

    public BasicPushNotificationBuilder(Context context, BridgeBasicPushNotificationBuilder bridgebasicpushnotificationbuilder)
    {
        a = bridgebasicpushnotificationbuilder;
    }

    private void a(int i)
    {
        long l = i;
        try
        {
            Thread.sleep(l);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    static void a(BasicPushNotificationBuilder basicpushnotificationbuilder, BridgeBasicPushNotificationBuilder bridgebasicpushnotificationbuilder)
    {
        basicpushnotificationbuilder.a = bridgebasicpushnotificationbuilder;
    }

    public Notification construct(Context context)
    {
        if (!LoadExecutor.loadPush(context))
        {
            return null;
        } else
        {
            return a.construct(context);
        }
    }

    public BridgeBasicPushNotificationBuilder getInner()
    {
        return a;
    }
}
