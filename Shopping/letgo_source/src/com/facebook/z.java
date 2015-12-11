// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.Handler;

// Referenced classes of package com.facebook:
//            k, GraphRequest

class z
{

    private final GraphRequest a;
    private final Handler b;
    private final long c = k.h();
    private long d;
    private long e;
    private long f;

    z(Handler handler, GraphRequest graphrequest)
    {
        a = graphrequest;
        b = handler;
    }

    void a()
    {
        if (d > e)
        {
            Object obj = a.g();
            if (f > 0L && (obj instanceof GraphRequest.e))
            {
                long l = d;
                long l1 = f;
                obj = (GraphRequest.e)obj;
                if (b == null)
                {
                    ((GraphRequest.e) (obj)).a(l, l1);
                } else
                {
                    b.post(new Runnable(((GraphRequest.e) (obj)), l, l1) {

                        final GraphRequest.e a;
                        final long b;
                        final long c;
                        final z d;

                        public void run()
                        {
                            a.a(b, c);
                        }

            
            {
                d = z.this;
                a = e1;
                b = l;
                c = l1;
                super();
            }
                    });
                }
                e = d;
            }
        }
    }

    void a(long l)
    {
        d = d + l;
        if (d >= e + c || d >= f)
        {
            a();
        }
    }

    void b(long l)
    {
        f = f + l;
    }
}
