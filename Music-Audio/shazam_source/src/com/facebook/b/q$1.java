// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.facebook.b:
//            q

final class <init> extends Handler
{

    final q a;

    public final void handleMessage(Message message)
    {
        q q1 = a;
        if (message.what == q1.d)
        {
            message = message.getData();
            if (message.getString("com.facebook.platform.status.ERROR_TYPE") != null)
            {
                q1.a(null);
            } else
            {
                q1.a(message);
            }
            q1.a.unbindService(q1);
        }
    }

    text(q q1)
    {
        a = q1;
        super();
    }
}
