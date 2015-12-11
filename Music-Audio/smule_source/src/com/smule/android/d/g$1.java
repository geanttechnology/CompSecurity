// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import com.smule.android.c.aa;

// Referenced classes of package com.smule.android.d:
//            n, g, p, j, 
//            c

class a
    implements n
{

    final g a;

    public void a(p p1)
    {
        if (!p1.c())
        {
            aa.b(g.e(), (new StringBuilder()).append("Problem setting up In-app Billing: ").append(p1).toString());
        }
        aa.a(g.e(), "Setup complete");
        if (g.a(a) != null && g.b(a) != null)
        {
            g g1 = a;
            boolean flag;
            if (p1.c() && g.a(a).b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            g.a(g1, flag);
            g.b(a).a(g.c(a));
        }
    }

    (g g1)
    {
        a = g1;
        super();
    }
}
