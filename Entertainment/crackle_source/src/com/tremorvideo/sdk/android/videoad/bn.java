// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import com.tremorvideo.sdk.android.b.c;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bf, n

public class bn extends bf
{

    boolean a;
    Context b;
    n c;
    c d;

    public bn(bf.a a1, Context context, n n1)
    {
        super(a1);
        a = false;
        b = context;
        c = n1;
    }

    protected void e()
    {
        d = c.z();
        if (d != null)
        {
            d.a(b);
            a(bf.b.b);
        }
    }

    protected void f()
    {
        a(bf.b.e);
    }

    protected void g()
    {
        d = c.z();
        if (d != null)
        {
            d.a(b);
            a(bf.b.b);
        }
    }

    public String toString()
    {
        return "JobProcessMovieBoard";
    }
}
