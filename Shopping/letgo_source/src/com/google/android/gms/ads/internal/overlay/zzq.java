// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import android.support.v7.tp;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzk

class zzq
    implements Runnable
{

    private boolean mCancelled;
    private zzk zzAy;

    zzq(zzk zzk1)
    {
        mCancelled = false;
        zzAy = zzk1;
    }

    public void cancel()
    {
        mCancelled = true;
        tp.a.removeCallbacks(this);
    }

    public void run()
    {
        if (!mCancelled)
        {
            zzAy.zzeR();
            zzfa();
        }
    }

    public void zzfa()
    {
        tp.a.postDelayed(this, 250L);
    }
}
