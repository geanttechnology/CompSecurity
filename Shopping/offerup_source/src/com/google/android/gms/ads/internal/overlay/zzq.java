// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import com.google.android.gms.internal.zzid;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzk

class zzq
    implements Runnable
{

    private boolean mCancelled;
    private zzk zzCo;

    zzq(zzk zzk1)
    {
        mCancelled = false;
        zzCo = zzk1;
    }

    public void cancel()
    {
        mCancelled = true;
        zzid.zzIE.removeCallbacks(this);
    }

    public void run()
    {
        if (!mCancelled)
        {
            zzCo.zzeX();
            zzfg();
        }
    }

    public void zzfg()
    {
        zzid.zzIE.postDelayed(this, 250L);
    }
}
