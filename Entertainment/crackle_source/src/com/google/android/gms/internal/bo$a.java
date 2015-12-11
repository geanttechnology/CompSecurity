// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            bo, cs

private static final class ah
{

    private final Runnable ep;
    private volatile boolean gV;

    static boolean a(ah ah1)
    {
        return ah1.gV;
    }

    public void ah()
    {
        cs.iI.postDelayed(ep, 250L);
    }

    public void cancel()
    {
        gV = true;
        cs.iI.removeCallbacks(ep);
    }

    public _cls1.gX(bo bo1)
    {
        gV = false;
        ep = new Runnable(bo1) {

            private final WeakReference gW;
            final bo gX;
            final bo.a gY;

            public void run()
            {
                bo bo2 = (bo)gW.get();
                if (!bo.a.a(gY) && bo2 != null)
                {
                    bo2.ag();
                    gY.ah();
                }
            }

            
            {
                gY = bo.a.this;
                gX = bo1;
                super();
                gW = new WeakReference(gX);
            }
        };
    }
}
