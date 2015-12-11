// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.j.a.f.b;
import com.j.a.g.o;
import com.j.a.g.t;

// Referenced classes of package com.j.a.d:
//            ag

class m
    implements Runnable
{

    final ag a;

    m(ag ag1)
    {
        a = ag1;
        super();
    }

    public void run()
    {
        if (o.a(ag.a(a)) && ag.a(a).findViewById(b.b()).getTag().equals(t.a.name()))
        {
            if (com.j.a.d.ag.b(a) == null)
            {
                ag.a(a, "waiting..");
            }
            if (ag.c(a) == null)
            {
                com.j.a.d.ag.b(a, "waiting...");
            }
            ((TextView)ag.a(a).findViewById(b.d())).setText((new StringBuilder()).append("Experiment: ").append(com.j.a.d.ag.b(a)).toString());
            ((TextView)ag.a(a).findViewById(b.c())).setText((new StringBuilder()).append("Variation: ").append(ag.c(a)).toString());
        }
    }
}
