// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;

public class zzm extends com.google.android.gms.ads.internal.client.zzw.zza
{

    private static final Object zzpy = new Object();
    private static zzm zzpz;
    private final Context mContext;
    private boolean zzpA;

    zzm(Context context)
    {
        mContext = context;
        zzpA = false;
    }

    public static zzm zzq(Context context)
    {
        synchronized (zzpy)
        {
            if (zzpz == null)
            {
                zzpz = new zzm(context.getApplicationContext());
            }
            context = zzpz;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void zza()
    {
label0:
        {
            synchronized (zzpy)
            {
                if (!zzpA)
                {
                    break label0;
                }
                zzb.zzaH("Mobile ads is initialized already.");
            }
            return;
        }
        zzpA = true;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
