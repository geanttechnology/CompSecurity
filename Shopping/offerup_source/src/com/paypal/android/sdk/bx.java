// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.text.TextUtils;

// Referenced classes of package com.paypal.android.sdk:
//            bw, cj, ch, ck

final class bx
    implements Runnable
{

    private cj a;
    private bw b;

    bx(bw bw1, cj cj1)
    {
        b = bw1;
        a = cj1;
        super();
    }

    public final void run()
    {
        bw.d();
        (new StringBuilder("Mock executing ")).append(a.n()).append(" request: ").append(a.f());
        if (b.c(a))
        {
            String s = b.b();
            a.h().a();
            a.b(s);
            bw.a(a, b.c());
        } else
        {
            String s1 = a.e();
            if (TextUtils.isEmpty(s1))
            {
                throw new RuntimeException((new StringBuilder("Empty mock value for ")).append(a.h()).toString());
            }
            a.h().a();
            a.b(s1);
            bw.a(a);
        }
        if (!a.a())
        {
            try
            {
                bw.d();
                (new StringBuilder("sleep for [")).append(bw.a(b)).append(" ms].");
                Thread.sleep(bw.a(b));
                bw.d();
                (new StringBuilder("end [")).append(bw.a(b)).append(" ms] sleep");
            }
            catch (InterruptedException interruptedexception)
            {
                a.h().a();
            }
            bw.b(b).a(a);
        }
    }
}
