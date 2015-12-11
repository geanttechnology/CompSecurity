// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.support.v7.wf;
import android.support.v7.wk;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            p, m, r

public class w extends p
{

    private final wk a = new wk();

    w(r r)
    {
        super(r);
    }

    protected void a()
    {
        r().a().a(a);
        b();
    }

    public void b()
    {
        Object obj = v();
        String s = ((m) (obj)).c();
        if (s != null)
        {
            a.a(s);
        }
        obj = ((m) (obj)).b();
        if (obj != null)
        {
            a.b(((String) (obj)));
        }
    }

    public wk c()
    {
        D();
        return a;
    }
}
