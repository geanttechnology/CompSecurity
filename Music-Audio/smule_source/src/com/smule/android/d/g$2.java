// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import com.smule.android.network.managers.ap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.android.d:
//            o, g, p, h, 
//            q, u

class b
    implements o
{

    final h a;
    final boolean b;
    final g c;

    public void a(p p1, q q1)
    {
        if (p1.d())
        {
            a.a(null);
            if (b)
            {
                c.c.a(p1, q1);
            }
        } else
        {
            java.util.Entry entry;
            u u1;
            for (Iterator iterator = q1.a.entrySet().iterator(); iterator.hasNext(); ap.a().a((String)entry.getKey(), u1.e.intValue(), u1.f))
            {
                entry = (java.util.Entry)iterator.next();
                u1 = (u)entry.getValue();
            }

            a.a(q1.a);
            if (b)
            {
                c.c.a(p1, q1);
                return;
            }
        }
    }

    k.managers.ap(g g1, h h1, boolean flag)
    {
        c = g1;
        a = h1;
        b = flag;
        super();
    }
}
