// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.b.d;
import com.google.api.a.g.b.e;

// Referenced classes of package com.google.api.a.a.a:
//            j, p, i, q, 
//            s

public final class m
    implements j
{

    private final d a;
    private final String b;

    public m(String s, d d1)
    {
        b = (String)c.a(s);
        a = (d)c.a(d1);
    }

    public m(String s, e e)
    {
        this(s, p.a(e));
    }

    private void a(i i)
    {
        a.a(b, new p(i));
    }

    public final void onTokenErrorResponse(i i, q q)
    {
        a(i);
    }

    public final void onTokenResponse(i i, s s)
    {
        a(i);
    }
}
