// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package android.support.v7:
//            alj, alg, aki, aky

class alf
{
    private static class a extends Handler
    {

        private final alf a;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                aky.a.post(new Runnable(this, message) {

                    final Message a;
                    final a b;

                    public void run()
                    {
                        throw new AssertionError((new StringBuilder()).append("Unhandled stats message.").append(a.what).toString());
                    }

            
            {
                b = a1;
                a = message;
                super();
            }
                });
                return;

            case 0: // '\0'
                a.c();
                return;

            case 1: // '\001'
                a.d();
                return;

            case 2: // '\002'
                a.b(message.arg1);
                return;

            case 3: // '\003'
                a.c(message.arg1);
                return;

            case 4: // '\004'
                a.a((Long)message.obj);
                break;
            }
        }

        public a(Looper looper, alf alf1)
        {
            super(looper);
            a = alf1;
        }
    }


    final HandlerThread a = new HandlerThread("Picasso-Stats", 10);
    final aki b;
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

    alf(aki aki1)
    {
        b = aki1;
        a.start();
        c = new a(a.getLooper(), this);
    }

    private static long a(int i1, long l1)
    {
        return l1 / (long)i1;
    }

    private void a(Bitmap bitmap, int i1)
    {
        int j1 = alj.a(bitmap);
        c.sendMessage(c.obtainMessage(i1, j1, 0));
    }

    void a()
    {
        c.sendEmptyMessage(0);
    }

    void a(long l1)
    {
        c.sendMessage(c.obtainMessage(4, Long.valueOf(l1)));
    }

    void a(Bitmap bitmap)
    {
        a(bitmap, 2);
    }

    void a(Long long1)
    {
        l = l + 1;
        f = f + long1.longValue();
        i = a(l, f);
    }

    void b()
    {
        c.sendEmptyMessage(1);
    }

    void b(long l1)
    {
        m = m + 1;
        g = g + l1;
        j = a(m, g);
    }

    void b(Bitmap bitmap)
    {
        a(bitmap, 3);
    }

    void c()
    {
        d = d + 1L;
    }

    void c(long l1)
    {
        n = n + 1;
        h = h + l1;
        k = a(m, h);
    }

    void d()
    {
        e = e + 1L;
    }

    alg e()
    {
        return new alg(b.b(), b.a(), d, e, f, g, h, i, j, k, l, m, n, System.currentTimeMillis());
    }
}
