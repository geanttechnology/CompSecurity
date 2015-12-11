// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzdz, zzbb

class zzyB
    implements c
{

    final e zzyB;
    final zzdz zzyu;

    public void zza(zzbb zzbb1)
    {
        synchronized (zzdz.zzc(zzyu))
        {
            zzdz.zza(zzyu, 0);
            if (zzdz.zzg(zzyu) != null && zzyB != zzdz.zzg(zzyu))
            {
                zzb.v("New JS engine is loaded, marking previous one as destroyable.");
                zzdz.zzg(zzyu).zzdR();
            }
            zzdz.zza(zzyu, zzyB);
        }
        return;
        exception;
        zzbb1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzc(Object obj)
    {
        zza((zzbb)obj);
    }

    e(zzdz zzdz1, e e)
    {
        zzyu = zzdz1;
        zzyB = e;
        super();
    }
}
