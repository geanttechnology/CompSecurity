// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

// Referenced classes of package com.google.android.gms.dynamic:
//            zza, LifecycleDelegate

class zzack
    implements a
{

    final zza zzach;
    final Bundle zzack;
    final FrameLayout zzacl;
    final LayoutInflater zzacm;
    final ViewGroup zzacn;

    public int getState()
    {
        return 2;
    }

    public void zzb(LifecycleDelegate lifecycledelegate)
    {
        zzacl.removeAllViews();
        zzacl.addView(zza.zzb(zzach).onCreateView(zzacm, zzacn, zzack));
    }

    cleDelegate(zza zza1, FrameLayout framelayout, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        zzach = zza1;
        zzacl = framelayout;
        zzacm = layoutinflater;
        zzacn = viewgroup;
        zzack = bundle;
        super();
    }
}
