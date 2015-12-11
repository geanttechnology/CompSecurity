// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g.a;

import android.os.Handler;
import com.facebook.ads.a.f.u;
import com.facebook.ads.a.g.a.a.a;
import java.lang.ref.WeakReference;

// Referenced classes of package com.facebook.ads.a.g.a:
//            a

private static final class t> extends u
{

    public final void run()
    {
        com.facebook.ads.a.g.a.a a1;
        for (a1 = (com.facebook.ads.a.g.a.a)super.a.get(); a1 == null || a1 == null;)
        {
            return;
        }

        int i = a.c(a1).getCurrentPosition();
        if (i > a.d(a1))
        {
            a(a1, i);
        }
        a.e(a1).postDelayed(this, 250L);
    }

    public (com.facebook.ads.a.g.a.a a1)
    {
        super(a1);
    }
}
