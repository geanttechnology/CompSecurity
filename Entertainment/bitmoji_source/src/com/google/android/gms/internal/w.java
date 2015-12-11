// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            da, cz, z, v

public final class w
{

    private final Runnable kW;
    private z kX;
    private boolean kY;

    public w(v v)
    {
        kY = false;
        kW = new Runnable(v) {

            private final WeakReference kZ;
            final v la;
            final w lb;

            public void run()
            {
                w.a(lb, false);
                v v1 = (v)kZ.get();
                if (v1 != null)
                {
                    v1.b(w.a(lb));
                }
            }

            
            {
                lb = w.this;
                la = v1;
                super();
                kZ = new WeakReference(la);
            }
        };
    }

    static z a(w w1)
    {
        return w1.kX;
    }

    static boolean a(w w1, boolean flag)
    {
        w1.kY = flag;
        return flag;
    }

    public void a(z z, long l)
    {
        if (kY)
        {
            da.w("An ad refresh is already scheduled.");
            return;
        } else
        {
            da.u((new StringBuilder()).append("Scheduling ad refresh ").append(l).append(" milliseconds from now.").toString());
            kX = z;
            kY = true;
            cz.pT.postDelayed(kW, l);
            return;
        }
    }

    public void cancel()
    {
        cz.pT.removeCallbacks(kW);
    }

    public void d(z z)
    {
        a(z, 60000L);
    }
}
