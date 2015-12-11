// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.support.design.widget.al;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            lj, ks, kr, kq, 
//            hl, lk

final class jw
    implements lj
{

    private boolean a;
    private ks b;
    private kr c;

    jw(ks ks1, al al, kr kr1)
    {
        b = ks1;
        c = kr1;
        super();
    }

    public final long a(kq kq1, long l)
    {
        try
        {
            l = b.a(kq1, l);
        }
        // Misplaced declaration of an exception variable
        catch (kq kq1)
        {
            if (!a)
            {
                a = true;
            }
            throw kq1;
        }
        if (l == -1L)
        {
            if (!a)
            {
                a = true;
                c.close();
            }
            return -1L;
        } else
        {
            kq1.a(c.b(), kq1.b - l, l);
            c.o();
            return l;
        }
    }

    public final lk a()
    {
        return b.a();
    }

    public final void close()
    {
        if (!a && !hl.a(this, TimeUnit.MILLISECONDS))
        {
            a = true;
        }
        b.close();
    }
}
