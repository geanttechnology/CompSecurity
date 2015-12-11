// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.dynamic:
//            zzf, zza, LifecycleDelegate

class zzapr
    implements zzf
{

    final zza zzapr;

    public void zza(LifecycleDelegate lifecycledelegate)
    {
        com.google.android.gms.dynamic.zza.zza(zzapr, lifecycledelegate);
        for (lifecycledelegate = com.google.android.gms.dynamic.zza.zza(zzapr).iterator(); lifecycledelegate.hasNext(); ((a)lifecycledelegate.next()).zzb(com.google.android.gms.dynamic.zza.zzb(zzapr))) { }
        com.google.android.gms.dynamic.zza.zza(zzapr).clear();
        com.google.android.gms.dynamic.zza.zza(zzapr, null);
    }

    cleDelegate(zza zza1)
    {
        zzapr = zza1;
        super();
    }
}
