// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzo
{

    private static final String TAG = com/google/android/gms/location/places/internal/zzo.getSimpleName();
    private static final long zzaAQ;
    private final Handler mHandler;
    private final Runnable zzaAS;
    private ArrayList zzaAT;
    private ArrayList zzaAU;
    private final Object zzqt;

    public void zzA(String s, String s1)
    {
        Object obj = zzqt;
        obj;
        JVM INSTR monitorenter ;
        if (zzaAT == null)
        {
            zzaAT = new ArrayList();
            zzaAU = new ArrayList();
            mHandler.postDelayed(zzaAS, zzaAQ);
        }
        zzaAT.add(s);
        zzaAU.add(s1);
        if (zzaAT.size() >= 10000)
        {
            if (Log.isLoggable(TAG, 5))
            {
                Log.w(TAG, "Event buffer full, flushing");
            }
            zzaAS.run();
            mHandler.removeCallbacks(zzaAS);
            return;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static 
    {
        zzaAQ = TimeUnit.SECONDS.toMillis(1L);
    }
}
