// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.c;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.google.android.gms.c:
//            b

final class a extends Handler
{

    final b a;

    public final void handleMessage(Message message)
    {
        Object obj;
        if (message != null)
        {
            obj = message.obj;
        }
        message = (Intent)message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(message.getAction()))
        {
            b.a(a).add(message);
        } else
        if (!b.a(a, message))
        {
            message.setPackage(b.b(a).getPackageName());
            b.b(a).sendBroadcast(message);
            return;
        }
    }

    Queue(b b1, Looper looper)
    {
        a = b1;
        super(looper);
    }
}
