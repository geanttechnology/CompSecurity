// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            n, af, l

class a
    implements Runnable
{

    final b a;
    final n b;

    public void run()
    {
        if (b.f.o == null || b.f.o.h() != null)
        {
            return;
        }
        int i;
        if (a.() == null)
        {
            i = 255;
        } else
        {
            i = ((Integer)a.()).intValue();
        }
        if (b.n != null && b.n == b.f.o && i == b.f.q && i == b.f.p)
        {
            b.f.k();
            b.f.l().setVisibility(0);
            return;
        } else
        {
            n.a(b, b.f.o, i, b.f.r);
            return;
        }
    }

    (n n1,  )
    {
        b = n1;
        a = ;
        super();
    }
}
