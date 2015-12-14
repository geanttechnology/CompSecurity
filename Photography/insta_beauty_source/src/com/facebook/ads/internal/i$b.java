// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal;

import android.os.Handler;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.t;

// Referenced classes of package com.facebook.ads.internal:
//            i

final class .t extends t
{

    public void run()
    {
        i j = (i)a();
        if (j == null)
        {
            return;
        }
        if (g.a(i.a(j)))
        {
            j.a();
            return;
        } else
        {
            i.c(j).postDelayed(i.b(j), 5000L);
            return;
        }
    }

    public .g(i j)
    {
        super(j);
    }
}
