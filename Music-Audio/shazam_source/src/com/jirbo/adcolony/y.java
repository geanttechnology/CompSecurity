// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            x, aj, ac, ab, 
//            ae, ai

final class y
{

    ac a;
    boolean b;
    ArrayList c;

    y(ac ac1)
    {
        b = false;
        c = new ArrayList();
        a = ac1;
    }

    final x a(String s)
    {
        int j = c.size();
        for (int i = 0; i < j; i++)
        {
            x x1 = (x)c.get(i);
            if (x1.a.equals(s))
            {
                return x1;
            }
        }

        b = true;
        s = new x(s);
        c.add(s);
        return s;
    }

    final void a()
    {
        int i = 0;
        if (b)
        {
            aj.a.b("Saving zone state...");
            b = false;
            a.c c1 = new a.c();
            String as[] = a.a.k;
            for (int j = as.length; i < j; i++)
            {
                x x1 = a(as[i]);
                a.g g = new a.g();
                g.b("uuid", x1.a);
                g.a("skipped_plays", x1.b);
                g.a("play_order_index", x1.c);
                c1.a(g);
            }

            ai.a(new ae("zone_state.txt"), c1);
            aj.a.b("Saved zone state");
        }
    }
}
