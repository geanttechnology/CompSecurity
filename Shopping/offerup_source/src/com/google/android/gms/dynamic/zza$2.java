// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.google.android.gms.dynamic:
//            zza, LifecycleDelegate

class zzapu
    implements a
{

    final zza zzapr;
    final Activity zzaps;
    final Bundle zzapt;
    final Bundle zzapu;

    public int getState()
    {
        return 0;
    }

    public void zzb(LifecycleDelegate lifecycledelegate)
    {
        zza.zzb(zzapr).onInflate(zzaps, zzapt, zzapu);
    }

    cleDelegate(zza zza1, Activity activity, Bundle bundle, Bundle bundle1)
    {
        zzapr = zza1;
        zzaps = activity;
        zzapt = bundle;
        zzapu = bundle1;
        super();
    }
}
