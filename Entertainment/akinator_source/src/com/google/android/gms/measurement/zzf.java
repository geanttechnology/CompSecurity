// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.measurement:
//            zzc, zzd, zzg

public abstract class zzf
{

    private final zzg zzaKZ;
    protected final zzc zzaLa;
    private final List zzaLb = new ArrayList();

    protected zzf(zzg zzg, zzmn zzmn)
    {
        zzx.zzw(zzg);
        zzaKZ = zzg;
        zzg = new zzc(this, zzmn);
        zzg.zzyo();
        zzaLa = zzg;
    }

    protected void zza(zzc zzc1)
    {
    }

    protected void zzd(zzc zzc1)
    {
        for (Iterator iterator = zzaLb.iterator(); iterator.hasNext(); ((zzd)iterator.next()).zza(this, zzc1)) { }
    }

    public zzc zzhG()
    {
        zzc zzc1 = zzaLa.zzye();
        zzd(zzc1);
        return zzc1;
    }

    protected zzg zzym()
    {
        return zzaKZ;
    }

    public zzc zzyp()
    {
        return zzaLa;
    }

    public List zzyq()
    {
        return zzaLa.zzyg();
    }
}
