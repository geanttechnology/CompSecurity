// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.a.a.t;
import com.j.a.g.w;

// Referenced classes of package com.j.a.e:
//            j, a

class au
    implements com.a.a.o.a
{

    final String a;
    final j b;
    final a c;

    au(a a1, String s, j j1)
    {
        c = a1;
        a = s;
        b = j1;
        super();
    }

    public void onErrorResponse(t t)
    {
        w.a(a, "Posting App Icon", t);
        if (b != null)
        {
            b.a(t);
        }
    }
}
