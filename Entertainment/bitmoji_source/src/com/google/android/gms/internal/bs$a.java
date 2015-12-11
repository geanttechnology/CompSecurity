// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            bs, cz

private static final class aA
{

    private final Runnable kW;
    private volatile boolean nG;

    static boolean a(aA aa)
    {
        return aa.nG;
    }

    public void aA()
    {
        cz.pT.postDelayed(kW, 250L);
    }

    public void cancel()
    {
        nG = true;
        cz.pT.removeCallbacks(kW);
    }

    public _cls1.nI(bs bs1)
    {
        nG = false;
        kW = new Runnable(bs1) {

            private final WeakReference nH;
            final bs nI;
            final bs.a nJ;

            public void run()
            {
                bs bs2 = (bs)nH.get();
                if (!bs.a.a(nJ) && bs2 != null)
                {
                    bs2.az();
                    nJ.aA();
                }
            }

            
            {
                nJ = bs.a.this;
                nI = bs1;
                super();
                nH = new WeakReference(nI);
            }
        };
    }
}
