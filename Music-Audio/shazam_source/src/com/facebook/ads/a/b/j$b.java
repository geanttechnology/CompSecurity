// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.os.Handler;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.u;
import java.lang.ref.WeakReference;

// Referenced classes of package com.facebook.ads.a.b:
//            j

private static final class nit> extends u
{

    public final void run()
    {
        j j1;
        j1 = (j)super.a.get();
        break MISSING_BLOCK_LABEL_11;
        if (j1 != null && (j1.i || !j1.j))
        {
            android.view.View view = j1.d;
            nit> nit> = j1.f;
            if (view != null && nit> != null)
            {
                if (g.a(j1.c, view, j1.e))
                {
                    nit>.a();
                    j1.j = true;
                    return;
                } else
                {
                    nit>.b();
                    j1.g.postDelayed(j1.h, j1.b);
                    return;
                }
            }
        }
        return;
    }

    public ce(j j1)
    {
        super(j1);
    }
}
