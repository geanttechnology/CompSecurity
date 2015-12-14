// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;


// Referenced classes of package com.inmobi.signals:
//            g, c, a

class 
    implements Runnable
{

    final g a;

    public void run()
    {
        c c1 = g.a(a);
        if (!c1.a())
        {
            g.b(a).a(System.currentTimeMillis());
            if (!c1.e())
            {
                g.a(a, c1, g.a(a, c1.b()));
            }
        }
        g.a(a, false);
    }

    (g g1)
    {
        a = g1;
        super();
    }
}
