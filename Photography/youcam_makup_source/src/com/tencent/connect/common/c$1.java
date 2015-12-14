// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.b;
import com.tencent.tauth.d;

// Referenced classes of package com.tencent.connect.common:
//            c, a

class a extends Handler
{

    final a a;
    final c b;

    public void handleMessage(Message message)
    {
        if (message.what == 0)
        {
            c.a(b).a(message.obj);
            return;
        } else
        {
            c.a(b).a(new d(message.what, (String)message.obj, null));
            return;
        }
    }

    (c c1, Looper looper, a a1)
    {
        b = c1;
        a = a1;
        super(looper);
    }
}
