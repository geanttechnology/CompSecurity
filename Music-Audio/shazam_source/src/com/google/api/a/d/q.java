// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;


// Referenced classes of package com.google.api.a.d:
//            p, r, v, h, 
//            i

public final class q
{

    public final v a;
    public final r b;

    q(v v, r r1)
    {
        a = v;
        b = r1;
    }

    public final p a(h h, i i)
    {
        return a("POST", h, i);
    }

    public final p a(String s, h h, i i)
    {
        p p1 = new p(a);
        if (b != null)
        {
            b.a(p1);
        }
        p1.a(s);
        if (h != null)
        {
            p1.a(h);
        }
        if (i != null)
        {
            p1.f = i;
        }
        return p1;
    }
}
