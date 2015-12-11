// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.zzbg;

// Referenced classes of package com.google.android.gms.internal:
//            zzmy, zzmp, zzml, zzmj, 
//            zzms, zzmo, zzmm

class zzaGW extends zzmy
{

    final zzml zzaGV;
    private final zzaGW zzaGW;

    protected zzaGW zza(zzmj zzmj1)
    {
        return null;
    }

    protected void zza(zzmp zzmp1)
    {
        zzaGW zzagw = zzmp1.zzym();
        zzaGV.zza(zzagw);
        if (zzagw.getStatus() == Status.zzQU && zzagw.zzyn() == zza.zzaHg && zzagw.zzyo() != null && zzagw.zzyo().length > 0)
        {
            zzml.zza(zzaGV).zze(zzagw.zzyp().zzyh(), zzagw.zzyo());
            zzbg.zzam("Resource successfully load from Network.");
            zzaGW.zza(zzmp1);
            return;
        }
        StringBuilder stringbuilder = (new StringBuilder()).append("Response status: ");
        if (zzagw.getStatus().isSuccess())
        {
            zzmp1 = "SUCCESS";
        } else
        {
            zzmp1 = "FAILURE";
        }
        zzbg.zzam(stringbuilder.append(zzmp1).toString());
        if (zzagw.getStatus().isSuccess())
        {
            zzbg.zzam((new StringBuilder()).append("Response source: ").append(zzagw.zzyn().toString()).toString());
            zzbg.zzam((new StringBuilder()).append("Response size: ").append(zzagw.zzyo().length).toString());
        }
        zzaGV.zza(zzagw.zzyp(), zzaGW);
    }

    zza(zzml zzml1, zzmo zzmo, zzmm zzmm, zza zza1)
    {
        zzaGV = zzml1;
        super(zzmo, zzmm);
        zzaGW = zza1;
    }
}
