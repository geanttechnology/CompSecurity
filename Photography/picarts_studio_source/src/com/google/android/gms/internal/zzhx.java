// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzhu

public class zzhx
{

    private final String zzHG;
    private int zzIi;
    private int zzIj;
    private final zzhu zzpV;
    private final Object zzpd;

    zzhx(zzhu zzhu1, String s)
    {
        zzpd = new Object();
        zzpV = zzhu1;
        zzHG = s;
    }

    public zzhx(String s)
    {
        this(zzp.zzby(), s);
    }

    public Bundle toBundle()
    {
        Bundle bundle;
        synchronized (zzpd)
        {
            bundle = new Bundle();
            bundle.putInt("pmnli", zzIi);
            bundle.putInt("pmnll", zzIj);
        }
        return bundle;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzf(int i, int j)
    {
        synchronized (zzpd)
        {
            zzIi = i;
            zzIj = j;
            zzpV.zza(zzHG, this);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
