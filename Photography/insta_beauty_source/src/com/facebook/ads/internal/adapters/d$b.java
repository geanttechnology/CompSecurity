// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.os.Handler;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.t;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            d

final class  extends t
{

    public void run()
    {
        d d1;
        d1 = (d)a();
        break MISSING_BLOCK_LABEL_8;
        if (d1 != null && (d.a(d1) || !d.b(d1)))
        {
            android.view.View view = d.c(d1);
              = d.d(d1);
            if (view != null &&  != null)
            {
                if (g.a(d.e(d1), view, d.f(d1)))
                {
                    .a();
                    d.a(d1, true);
                    return;
                } else
                {
                    .b();
                    d.i(d1).postDelayed(com.facebook.ads.internal.adapters.d.g(d1), d.h(d1));
                    return;
                }
            }
        }
        return;
    }

    public (d d1)
    {
        super(d1);
    }
}
