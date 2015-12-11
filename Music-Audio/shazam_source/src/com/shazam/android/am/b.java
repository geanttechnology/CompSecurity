// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import com.google.api.a.a.a.s;
import com.google.api.a.c.a.a.a;
import com.google.api.a.d.v;
import com.google.api.a.e.c;
import com.shazam.n.m;

// Referenced classes of package com.shazam.android.am:
//            g, p, f

public final class b
    implements g
{

    private final v a;
    private final c b;
    private final m c;
    private final a d;

    public b(v v, c c1, m m, a a1)
    {
        a = v;
        b = c1;
        c = m;
        d = a1;
    }

    public final f a(String s1)
    {
        s1 = (new s()).a(s1);
        s1 = d.a(s1, "shazam_google_now");
        return new p((new com.google.api.services.now.Now.Builder(a, b, s1)).build(), c);
    }
}
