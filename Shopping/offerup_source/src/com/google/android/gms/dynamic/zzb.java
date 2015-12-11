// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.google.android.gms.dynamic:
//            zze, zzd, zzc

public final class zzb extends zzc.zza
{

    private Fragment zzapz;

    private zzb(Fragment fragment)
    {
        zzapz = fragment;
    }

    public static zzb zza(Fragment fragment)
    {
        if (fragment != null)
        {
            return new zzb(fragment);
        } else
        {
            return null;
        }
    }

    public final Bundle getArguments()
    {
        return zzapz.getArguments();
    }

    public final int getId()
    {
        return zzapz.getId();
    }

    public final boolean getRetainInstance()
    {
        return zzapz.getRetainInstance();
    }

    public final String getTag()
    {
        return zzapz.getTag();
    }

    public final int getTargetRequestCode()
    {
        return zzapz.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint()
    {
        return zzapz.getUserVisibleHint();
    }

    public final zzd getView()
    {
        return zze.zzy(zzapz.getView());
    }

    public final boolean isAdded()
    {
        return zzapz.isAdded();
    }

    public final boolean isDetached()
    {
        return zzapz.isDetached();
    }

    public final boolean isHidden()
    {
        return zzapz.isHidden();
    }

    public final boolean isInLayout()
    {
        return zzapz.isInLayout();
    }

    public final boolean isRemoving()
    {
        return zzapz.isRemoving();
    }

    public final boolean isResumed()
    {
        return zzapz.isResumed();
    }

    public final boolean isVisible()
    {
        return zzapz.isVisible();
    }

    public final void setHasOptionsMenu(boolean flag)
    {
        zzapz.setHasOptionsMenu(flag);
    }

    public final void setMenuVisibility(boolean flag)
    {
        zzapz.setMenuVisibility(flag);
    }

    public final void setRetainInstance(boolean flag)
    {
        zzapz.setRetainInstance(flag);
    }

    public final void setUserVisibleHint(boolean flag)
    {
        zzapz.setUserVisibleHint(flag);
    }

    public final void startActivity(Intent intent)
    {
        zzapz.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i)
    {
        zzapz.startActivityForResult(intent, i);
    }

    public final void zzn(zzd zzd)
    {
        zzd = (View)zze.zzp(zzd);
        zzapz.registerForContextMenu(zzd);
    }

    public final void zzo(zzd zzd)
    {
        zzd = (View)zze.zzp(zzd);
        zzapz.unregisterForContextMenu(zzd);
    }

    public final zzd zzsa()
    {
        return zze.zzy(zzapz.getActivity());
    }

    public final zzc zzsb()
    {
        return zza(zzapz.getParentFragment());
    }

    public final zzd zzsc()
    {
        return zze.zzy(zzapz.getResources());
    }

    public final zzc zzsd()
    {
        return zza(zzapz.getTargetFragment());
    }
}
