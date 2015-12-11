// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.a.a.t;
import com.j.a.g.w;

// Referenced classes of package com.j.a.e:
//            i, a

class e
    implements com.a.a.o.a
{

    final String a;
    final i b;
    final a c;

    e(a a1, String s, i j)
    {
        c = a1;
        a = s;
        b = j;
        super();
    }

    public void onErrorResponse(t t)
    {
        w.a(a, "Getting Properties From Server", t);
        b.a(t);
    }
}
