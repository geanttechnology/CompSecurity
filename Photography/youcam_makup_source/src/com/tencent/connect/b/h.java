// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.tencent.connect.b:
//            g, e

class h extends Handler
{

    final e a;
    private g b;

    public h(e e1, g g1, Looper looper)
    {
        a = e1;
        super(looper);
        b = g1;
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            g.a(b, (String)message.obj);
            return;

        case 2: // '\002'
            b.a();
            return;

        case 3: // '\003'
            e.a(e.a(a), (String)message.obj);
            break;
        }
    }
}
