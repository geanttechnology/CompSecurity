// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.widget.VideoView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            cj, ck

final class cl
    implements Runnable
{

    final cj a;
    final ck b;
    private final WeakReference c;

    cl(ck ck1, cj cj1)
    {
        b = ck1;
        a = cj1;
        super();
        c = new WeakReference(a);
    }

    public final void run()
    {
        cj cj1 = (cj)c.get();
        if (!b.b && cj1 != null)
        {
            long l = cj1.d.getCurrentPosition();
            if (cj1.e != l)
            {
                float f = (float)l / 1000F;
                cj.a(cj1.a, "timeupdate", "time", String.valueOf(f));
                cj1.e = l;
            }
            b.a();
        }
    }
}
