// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import com.j.a.a.b;
import com.j.a.a.d;
import com.j.a.c.e;
import com.j.a.e.az;
import com.j.a.e.i;
import com.j.a.g.m;
import com.j.a.g.w;

// Referenced classes of package com.j.a.d:
//            e, aj, j

class g
    implements i
{

    final com.j.a.g.a.d a;
    final com.j.a.d.e b;

    g(com.j.a.d.e e1, com.j.a.g.a.d d1)
    {
        b = e1;
        a = d1;
        super();
    }

    public void a(e e1)
    {
        boolean flag;
        flag = true;
        w.a("Got TLProperties!!");
        com.j.a.d.e.b(b, true);
        if (e.a(b) == null)
        {
            flag = false;
        }
        com.j.a.d.e.b(b, e1);
        if (e.a(b, e.a(b)))
        {
            return;
        }
        try
        {
            aj.a().a(e.a(b));
            b.a(false, null);
            e.c(b).a().a(null);
            com.j.a.d.e.b(b);
            com.j.a.d.e.e(b);
            if (e.f(b) && !az.a().a)
            {
                az.a().a(null);
            }
            if (e.a(b).l() != null && e.a(b, e.a(b).l()) && !e.g(b))
            {
                az.a().d();
            }
            if (e.h(b) != null && m.a(e.h(b), "com.google.android.c2dm.permission.RECEIVE"))
            {
                w.a("Getting Push token");
                com.j.a.d.e.i(b).a(false);
            }
            if (e.j(b) != null)
            {
                e.j(b).a();
            }
            if (a != null)
            {
                a.a();
            }
            if (!Boolean.valueOf(flag).booleanValue())
            {
                e.c(b).d();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            w.b("error processing tlproperties response", e1);
        }
        return;
    }

    public void a(Exception exception)
    {
        w.b("Getting Properties from server", exception);
        com.j.a.d.e.e(b);
        if (a != null)
        {
            a.b();
        }
        if (e.j(b) != null)
        {
            e.j(b).b();
        }
    }
}
