// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.measurement:
//            zzg, zzc, zzf, zzh

class zzaLh
    implements Runnable
{

    final zzc zzaLh;
    final zzg zzaLi;

    public void run()
    {
        zzaLh.zzyl().zza(zzaLh);
        for (Iterator iterator = zzg.zza(zzaLi).iterator(); iterator.hasNext(); ((zzh)iterator.next()).zza(zzaLh)) { }
        zzg.zza(zzaLi, zzaLh);
    }

    (zzg zzg1, zzc zzc1)
    {
        zzaLi = zzg1;
        zzaLh = zzc1;
        super();
    }
}
