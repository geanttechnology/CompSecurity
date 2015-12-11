// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.net.Uri;

// Referenced classes of package com.flurry.sdk:
//            fy, dw, dz, hj, 
//            fx

class it>
    implements fy
{

    final dw a;

    public void a(hj hj1)
    {
        if (dw.a(a) != null)
        {
            int i = a.getDuration();
            int j = a.getCurrentPosition();
            if (i >= 0 && dw.b(a) != null && ((float)j - dw.c(a) > 1000F || dw.c(a) <= 300F))
            {
                dw.a(a, j);
                dw.b(a).a(dw.d(a).toString(), i, j);
                return;
            }
        }
    }

    public void notify(fx fx)
    {
        a((hj)fx);
    }

    (dw dw1)
    {
        a = dw1;
        super();
    }
}
