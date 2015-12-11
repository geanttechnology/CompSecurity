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

        final zzc zzYB;

        public void run()
        {
            zzYB.zzYA = false;
            long l = SystemClock.elapsedRealtime();
            boolean flag = zzYB.zzz(l);
            zzYB.zzV(flag);
        }

        private zza()
        {
            zzYB = zzc.this;
            super();
        }

    }


    protected final Handler mHandler;
    protected boolean zzYA;
    protected final long zzYy;
    protected final Runnable zzYz;

    public zzc(String s, String s1, String s2)
    {
        this(s, s1, s2, 1000L);
    }

    public zzc(String s, String s1, String s2, long l)
    {
        super(s, s1, s2);
        mHandler = new Handler(Looper.getMainLooper());
        zzYz = new zza();
        zzYy = l;
        zzV(false);
    }

    protected final void zzV(boolean flag)
    {
label0:
        {
            if (zzYA != flag)
            {
                zzYA = flag;
                if (!flag)
                {
                    break label0;
                }
                mHandler.postDelayed(zzYz, zzYy);
            }
            return;
        }
        mHandler.removeCallbacks(zzYz);
    }

    public void zzmP()
    {
        zzV(false);
    }

    protected abstract boolean zzz(long l);
}
