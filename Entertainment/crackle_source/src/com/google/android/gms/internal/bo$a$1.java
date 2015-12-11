// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            bo

class gX
    implements Runnable
{

    private final WeakReference gW;
    final bo gX;
    final  gY;

    public void run()
    {
        bo bo1 = (bo)gW.get();
        if (!gW(gY) && bo1 != null)
        {
            bo1.ag();
            gY.();
        }
    }

    ( , bo bo1)
    {
        gY = ;
        gX = bo1;
        super();
        gW = new WeakReference(gX);
    }
}
