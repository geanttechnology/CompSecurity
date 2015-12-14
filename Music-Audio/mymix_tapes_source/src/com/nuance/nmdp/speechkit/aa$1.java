// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import aq;
import ay;
import g;

// Referenced classes of package com.nuance.nmdp.speechkit:
//            aa, v

final class a
    implements aq
{

    private aa a;

    public final void a(g g)
    {
        if (aa.a(a) != null)
        {
            if (aa.b(a) == g)
            {
                aa.a(a, a(aa.c(a)), b(aa.c(a)), aa.a(a));
                aa.d(a);
                aa.e(a);
                aa.a(a, null);
            }
        } else
        if (aa.b(a) == g)
        {
            aa.f(a).onSpeakingDone(a, a(aa.c(a)), null, b(aa.c(a)));
            if (aa.g(a).c() > 0)
            {
                g = (a)aa.g(a).a();
                aa.a(a, g);
                return;
            } else
            {
                aa.d(a);
                aa.e(a);
                return;
            }
        }
    }

    public final void a(g g, int i, String s, String s1)
    {
        if (aa.b(a) == g)
        {
            aa.a(a, new v(i, s, s1));
        }
    }

    public final void b(g g)
    {
        if (aa.b(a) == g)
        {
            aa.f(a).onSpeakingBegin(a, a(aa.c(a)), b(aa.c(a)));
        }
    }

    izer.Listener(aa aa1)
    {
        a = aa1;
        super();
    }
}
