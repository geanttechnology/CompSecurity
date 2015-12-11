// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            gl, fq, gn, gk, 
//            gq, gu

final class fr
    implements gl
{

    private final int a;
    private final gq b;
    private final boolean c;
    private fq d;

    fr(fq fq1, int i, gq gq, boolean flag)
    {
        d = fq1;
        super();
        a = i;
        b = gq;
        c = flag;
    }

    public final gq a()
    {
        return b;
    }

    public final gu a(gq gq)
    {
        if (a < fq.a(d).u().size())
        {
            gq = new fr(d, a + 1, gq, c);
            return ((gk)fq.a(d).u().get(a)).a(gq);
        } else
        {
            return d.a(gq, c);
        }
    }
}
