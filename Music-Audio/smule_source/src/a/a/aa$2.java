// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import org.json.JSONArray;

// Referenced classes of package a.a:
//            ed, aa, em, ao, 
//            do, ee, dm, ax, 
//            dx, dw, ae

final class nit> extends ed
{

    final Throwable a;
    final long b;
    final aa c;

    public final void a()
    {
        if (c.f.b())
        {
            return;
        }
        synchronized (c.p)
        {
            if (c.B < 10)
            {
                Object obj = new ao(a, b);
                ((ao) (obj)).a("current_session", c.k);
                ((ao) (obj)).a(c.l);
                obj.f = "he";
                if (c.p.a())
                {
                    obj = (new JSONArray()).put(((ao) (obj)).a());
                    (new ee((new dm(aa.a)).a(ax.b.f(), ((JSONArray) (obj))), new dx((new dw(c.u.k(), "/android_v2/handle_exceptions")).a()), null)).run();
                    obj = c;
                    obj.B = ((aa) (obj)).B + 1;
                    c.p.b();
                }
            }
        }
    }

    .Throwable(aa aa1, Throwable throwable, long l)
    {
        c = aa1;
        a = throwable;
        b = l;
        super();
    }
}
