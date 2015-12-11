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

class zzapu
    implements a
{

    final zza zzapr;
    final Bundle zzapu;
    final FrameLayout zzapv;
    final LayoutInflater zzapw;
    final ViewGroup zzapx;

    public int getState()
    {
        return 2;
    }

    public void zzb(LifecycleDelegate lifecycledelegate)
    {
        zzapv.removeAllViews();
        zzapv.addView(zza.zzb(zzapr).onCreateView(zzapw, zzapx, zzapu));
    }

    cleDelegate(zza zza1, FrameLayout framelayout, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        zzapr = zza1;
        zzapv = framelayout;
        zzapw = layoutinflater;
        zzapx = viewgroup;
        zzapu = bundle;
        super();
    }
}
