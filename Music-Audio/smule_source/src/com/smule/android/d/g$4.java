// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.app.Activity;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.android.d:
//            k, g, p, r, 
//            c

class a
    implements k
{

    final g a;

    public void a(r r1, p p1)
    {
        if (g.b(a) != null && !g.e(a).isFinishing())
        {
            aa.a(g.e(), (new StringBuilder()).append("Consume finished: ").append(p1).append(", purchase: ").append(r1).toString());
            g.b(a).a(p1.c(), r1.c());
        }
    }

    (g g1)
    {
        a = g1;
        super();
    }
}
