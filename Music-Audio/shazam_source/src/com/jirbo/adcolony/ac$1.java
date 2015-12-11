// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ah, ac, aj, q, 
//            as, ae, ai, s, 
//            ab

final class nit> extends ah
{

    final ac a;

    final void a()
    {
        as as1 = n.e;
        aj.b.b("AdColony resuming");
        q.i = true;
        if (as1.b)
        {
            aj.d.b("AdColony.onResume() called multiple times in succession.");
        }
        as1.b = true;
        nit> nit> = ai.a(new ae("session_info.txt"));
        double d;
        if (nit> != null)
        {
            as1.c = nit>.("allow_resume", false);
            as1.f = nit>.("start_time");
            as1.g = nit>.("finish_time");
            as1.h = nit>.("session_time");
        } else
        {
            as1.d = true;
        }
        d = s.b();
        if (as1.c)
        {
            if (d - as1.g > (double)as1.a.a.d)
            {
                as1.a(as1.h);
                as1.f = d;
                as1.b();
            }
            as1.c = false;
            as1.a();
        } else
        {
            as1.f = d;
            as1.b();
        }
        q.f();
    }

    (ac ac1, ac ac2)
    {
        a = ac1;
        super(ac2);
    }
}
