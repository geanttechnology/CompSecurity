// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.dynamic:
//            zzf, zza, LifecycleDelegate

class zzach
    implements zzf
{

    final zza zzach;

    public void zza(LifecycleDelegate lifecycledelegate)
    {
        com.google.android.gms.dynamic.zza.zza(zzach, lifecycledelegate);
        for (lifecycledelegate = com.google.android.gms.dynamic.zza.zza(zzach).iterator(); lifecycledelegate.hasNext(); ((a)lifecycledelegate.next()).zzb(com.google.android.gms.dynamic.zza.zzb(zzach))) { }
        com.google.android.gms.dynamic.zza.zza(zzach).clear();
        com.google.android.gms.dynamic.zza.zza(zzach, null);
    }

    cleDelegate(zza zza1)
    {
        zzach = zza1;
        super();
    }
}
