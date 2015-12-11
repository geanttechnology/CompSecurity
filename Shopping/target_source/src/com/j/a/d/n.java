// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.view.View;
import android.view.ViewGroup;
import com.j.a.f.b;
import com.j.a.f.d;
import com.j.a.g.o;
import com.j.a.g.t;

// Referenced classes of package com.j.a.d:
//            ag

class n
    implements Runnable
{

    static final boolean a;
    final ag b;

    n(ag ag1)
    {
        b = ag1;
        super();
    }

    public void run()
    {
        if (!a && ag.a(b) == null)
        {
            throw new AssertionError();
        }
        if (!o.a(ag.a(b)) || !ag.a(b).findViewById(com.j.a.f.b.b()).getTag().equals(com.j.a.d.ag.d(b).name()))
        {
            b.j();
            ag.a(b, o.a(com.j.a.d.ag.d(b)));
            ag.e(b).addView(o.a(com.j.a.d.ag.d(b), com.j.a.d.ag.b(b), ag.c(b)));
            if (com.j.a.d.ag.d(b).equals(t.b) || com.j.a.d.ag.d(b).equals(t.d))
            {
                ag.e(b).setOnTouchListener(ag.f(b));
            }
            ag.a(b).addView(ag.e(b));
        } else
        if (com.j.a.d.ag.d(b).equals(t.a) && com.j.a.d.ag.b(b) != null && ag.c(b) != null && !com.j.a.d.ag.b(b).equals("null") && !ag.c(b).equals("null"))
        {
            ag.g(b);
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!com/j/a/d/ag.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
