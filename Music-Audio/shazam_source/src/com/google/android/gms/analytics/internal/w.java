// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.d.ja;
import com.google.android.gms.d.jd;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, o, r, m

public final class w extends p
{

    private final jd a = new jd();

    w(r r1)
    {
        super(r1);
    }

    protected final void a()
    {
        super.i.b().a().a(a);
        Object obj = super.i.e();
        String s = ((m) (obj)).c();
        if (s != null)
        {
            a.a = s;
        }
        obj = ((m) (obj)).b();
        if (obj != null)
        {
            a.b = ((String) (obj));
        }
    }

    public final jd b()
    {
        o();
        return a;
    }
}
