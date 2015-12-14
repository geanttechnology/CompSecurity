// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal;

import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.server.d;

// Referenced classes of package com.facebook.ads.internal:
//            h

class a
    implements Runnable
{

    final d a;
    final h b;

    public void run()
    {
        c c1 = a.b();
        if (c1 == null || c1.a() == null)
        {
            throw new IllegalStateException("invalid placement in response");
        } else
        {
            h.a(b, c1);
            com.facebook.ads.internal.h.c(b);
            return;
        }
    }

    er.d(h h1, d d1)
    {
        b = h1;
        a = d1;
        super();
    }
}
