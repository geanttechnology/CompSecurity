// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.g.c:
//            ah, d, u

public final class ab
{
    private static final class a extends Handler
    {

        private final ab a;

        public final void handleMessage(Message message)
        {
            ab ab3;
            switch (message.what)
            {
            default:
                u.a.post(new Runnable(this, message) {

                    final Message a;
                    final a b;

                    public final void run()
                    {
                        throw new AssertionError((new StringBuilder("Unhandled stats message.")).append(a.what).toString());
                    }

            
            {
                b = a1;
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
                long l1 = message.arg1;
                ab1.m = ab1.m + 1;
                ab1.g = l1 + ab1.g;
                int i1 = ab1.m;
                ab1.j = ab1.g / (long)i1;
                return;

            case 3: // '\003'
                ab ab2 = a;
                long l2 = message.arg1;
                ab2.n = ab2.n + 1;
                ab2.h = l2 + ab2.h;
                int j1 = ab2.m;
                ab2.k = ab2.h / (long)j1;
                return;

            case 4: // '\004'
                ab3 = a;
                break;
            }
            message = (Long)message.obj;
            ab3.l = ab3.l + 1;
            ab3.f = ab3.f + message.longValue();
            int k1 = ab3.l;
            ab3.i = ab3.f / (long)k1;
        }

        public a(Looper looper, ab ab1)
        {
            super(looper);
            a = ab1;
        }
    }


    final HandlerThread a = new HandlerThread("Picasso-Stats", 10);
    final d b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    public ab(d d1)
    {
        b = d1;
        a.start();
        ah.a(a.getLooper());
        c = new a(a.getLooper(), this);
    }

    final void a()
    {
        c.sendEmptyMessage(0);
    }

    final void a(Bitmap bitmap, int i1)
    {
        int j1 = ah.a(bitmap);
        c.sendMessage(c.obtainMessage(i1, j1, 0));
    }
}
