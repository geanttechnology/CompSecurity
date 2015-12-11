// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import org.json.JSONArray;

// Referenced classes of package crittercism.android:
//            cq, ay, df, bd, 
//            cf, cs, ce, bi, 
//            ck, cj, ba

final class nit> extends cq
{

    final Throwable a;
    final long b;
    final ay c;

    public final void a()
    {
        if (c.g.c())
        {
            return;
        }
        synchronized (c.n)
        {
            if (c.A < 10)
            {
                Object obj = new bd(a, b);
                ((bd) (obj)).a("current_session", c.l);
                ((bd) (obj)).a(c.m);
                obj.c = "he";
                if (c.n.a())
                {
                    obj = (new JSONArray()).put(((bd) (obj)).a());
                    (new cs((new ce(ay.a)).a(bi.b.g(), ((JSONArray) (obj))), new ck((new cj(c.w.a(), "/android_v2/handle_exceptions")).a()), null)).run();
                    obj = c;
                    obj.A = ((ay) (obj)).A + 1;
                    c.n.b();
                }
            }
        }
    }

    (ay ay1, Throwable throwable, long l)
    {
        c = ay1;
        a = throwable;
        b = l;
        super();
    }
}
