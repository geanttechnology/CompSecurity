// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzmn, zzby, zzbu, zzgy, 
//            zzgz

class zzGQ
{

    public final long zzGP = zzp.zzbz().currentTimeMillis();
    public final zzgy zzGQ;
    final zzgz zzGR;

    public boolean hasExpired()
    {
        long l = zzGP;
        return ((Long)zzby.zzvn.get()).longValue() + l < zzp.zzbz().currentTimeMillis();
    }

    public (zzgz zzgz, zzgy zzgy)
    {
        zzGR = zzgz;
        super();
        zzGQ = zzgy;
    }
}
