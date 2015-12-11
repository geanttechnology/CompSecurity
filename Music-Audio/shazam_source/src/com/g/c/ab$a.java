// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.g.c:
//            ab, u

private static final class a extends Handler
{

    private final ab a;

    public final void handleMessage(Message message)
    {
        ab ab3;
        switch (message.what)
        {
        default:
            u.a.post(new Runnable(message) {

                final Message a;
                final ab.a b;

                public final void run()
                {
                    throw new AssertionError((new StringBuilder("Unhandled stats message.")).append(a.what).toString());
                }

            
            {
                b = ab.a.this;
                a = message;
                super();
            }
            });
            return;

        case 0: // '\0'
            message = a;
            message.d = ((ab) (message)).d + 1L;
            return;

        case 1: // '\001'
            message = a;
            message.e = ((ab) (message)).e + 1L;
            return;

        case 2: // '\002'
            ab ab1 = a;
            long l = message.arg1;
            ab1.m = ab1.m + 1;
            ab1.g = l + ab1.g;
            int i = ab1.m;
            ab1.j = ab1.g / (long)i;
            return;

        case 3: // '\003'
            ab ab2 = a;
            long l1 = message.arg1;
            ab2.n = ab2.n + 1;
            ab2.h = l1 + ab2.h;
            int j = ab2.m;
            ab2.k = ab2.h / (long)j;
            return;

        case 4: // '\004'
            ab3 = a;
            break;
        }
        message = (Long)message.obj;
        ab3.l = ab3.l + 1;
        ab3.f = ab3.f + message.longValue();
        int k = ab3.l;
        ab3.i = ab3.f / (long)k;
    }

    public oper(Looper looper, ab ab1)
    {
        super(looper);
        a = ab1;
    }
}
