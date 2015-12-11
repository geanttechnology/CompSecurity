// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.google.android.gms.dynamic:
//            zza, LifecycleDelegate

class zzack
    implements a
{

    final zza zzach;
    final Activity zzaci;
    final Bundle zzacj;
    final Bundle zzack;

    public int getState()
    {
        return 0;
    }

    public void zzb(LifecycleDelegate lifecycledelegate)
    {
        zza.zzb(zzach).onInflate(zzaci, zzacj, zzack);
    }

    cleDelegate(zza zza1, Activity activity, Bundle bundle, Bundle bundle1)
    {
        zzach = zza1;
        zzaci = activity;
        zzacj = bundle;
        zzack = bundle1;
        super();
    }
}
