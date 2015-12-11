// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.view.ViewGroup;
import com.j.a.f.b;

// Referenced classes of package com.j.a.d:
//            ag

class o
    implements Runnable
{

    final ag a;

    o(ag ag1)
    {
        a = ag1;
        super();
    }

    public void run()
    {
        if (ag.a(a).findViewById(b.a()) == null)
        {
            ag.a(a, com.j.a.g.o.b());
            ag.a(a).addView(ag.h(a));
        }
    }
}
