// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzd

public abstract class zzc extends zzd
{
    private class zza
        implements Runnable
    {

        final zzc zzWJ;

        public void run()
        {
            zzWJ.zzWI = false;
            long l = SystemClock.elapsedRealtime();
            boolean flag = zzWJ.zzz(l);
            zzWJ.zzU(flag);
        }

        private zza()
        {
            zzWJ = zzc.this;
            super();
        }

    }


    protected final Handler mHandler;
    protected final long zzWG;
    protected final Runnable zzWH;
    protected boolean zzWI;

    public zzc(String s, String s1, String s2)
    {
        this(s, s1, s2, 1000L);
    }

    public zzc(String s, String s1, String s2, long l)
    {
        super(s, s1, s2);
        mHandler = new Handler(Looper.getMainLooper());
        zzWH = new zza();
        zzWG = l;
        zzU(false);
    }

    protected final void zzU(boolean flag)
    {
label0:
        {
            if (zzWI != flag)
            {
                zzWI = flag;
                if (!flag)
                {
                    break label0;
                }
                mHandler.postDelayed(zzWH, zzWG);
            }
            return;
        }
        mHandler.removeCallbacks(zzWH);
    }

    public void zzmt()
    {
        zzU(false);
    }

    protected abstract boolean zzz(long l);
}
