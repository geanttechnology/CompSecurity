// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice.apiproxy;

import android.app.Notification;
import android.content.Context;
import com.baidu.android.pushservice.internal.PushNotificationBuilder;

// Referenced classes of package com.baidu.android.pushservice.apiproxy:
//            BridgePushNotificationBuilder

class a extends PushNotificationBuilder
{

    final BridgePushNotificationBuilder a;

    public Notification construct(Context context)
    {
        return a.construct(context);
    }

    (BridgePushNotificationBuilder bridgepushnotificationbuilder)
    {
        a = bridgepushnotificationbuilder;
        super();
    }
}
