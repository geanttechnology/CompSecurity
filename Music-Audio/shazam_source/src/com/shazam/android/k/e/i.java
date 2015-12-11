// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.e;

import com.shazam.a.b;
import com.shazam.a.c;
import com.shazam.android.ak.a.d;
import com.shazam.model.Track;
import java.net.URL;
import java.util.Map;

public final class i
{

    private final d a;
    private final b b;
    private final com.shazam.a.a.d c;
    private final com.shazam.android.persistence.r.b d;

    public i(d d1, b b1, com.shazam.a.a.d d2, com.shazam.android.persistence.r.b b2)
    {
        a = d1;
        b = b1;
        c = d2;
        d = b2;
    }

    public final Track a(String s)
    {
        String s1 = a.a();
        b b1 = b;
        com.shazam.a.c.a a1 = new com.shazam.a.c.a();
        a1.a.put("id", s);
        s = new URL(b1.a(s1, new c(a1, (byte)0)));
        s = c.a(s);
        if (s != null)
        {
            d.a(s);
        }
        return s;
    }
}
