// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

// Referenced classes of package com.google.android.gms.dynamic:
//            zze, zzd, zzc

public final class zzh extends zzc.zza
{

    private Fragment zzafl;

    private zzh(Fragment fragment)
    {
        zzafl = fragment;
    }

    public static zzh zza(Fragment fragment)
    {
        if (fragment != null)
        {
            return new zzh(fragment);
        } else
        {
            return null;
        }
    }

    public final Bundle getArguments()
    {
        return zzafl.getArguments();
    }

    public final int getId()
    {
        return zzafl.getId();
    }

    public final boolean getRetainInstance()
    {
        return zzafl.getRetainInstance();
    }

    public final String getTag()
    {
        return zzafl.getTag();
    }

    public final int getTargetRequestCode()
    {
        return zzafl.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint()
    {
        return zzafl.getUserVisibleHint();
    }

    public final zzd getView()
    {
        return zze.zzy(zzafl.getView());
    }

    public final boolean isAdded()
    {
        return zzafl.isAdded();
    }

    public final boolean isDetached()
    {
        return zzafl.isDetached();
    }

    public final boolean isHidden()
    {
        return zzafl.isHidden();
    }

    public final boolean isInLayout()
    {
        return zzafl.isInLayout();
    }

    public final boolean isRemoving()
    {
        return zzafl.isRemoving();
    }

    public final boolean isResumed()
    {
        return zzafl.isResumed();
    }

    public final boolean isVisible()
    {
        return zzafl.isVisible();
    }

    public final void setHasOptionsMenu(boolean flag)
    {
        zzafl.setHasOptionsMenu(flag);
    }

    public final void setMenuVisibility(boolean flag)
    {
        zzafl.setMenuVisibility(flag);
    }

    public final void setRetainInstance(boolean flag)
    {
        zzafl.setRetainInstance(flag);
    }

    public final void setUserVisibleHint(boolean flag)
    {
        zzafl.setUserVisibleHint(flag);
    }

    public final void startActivity(Intent intent)
    {
        zzafl.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i)
    {
        zzafl.startActivityForResult(intent, i);
    }

    public final void zzn(zzd zzd)
    {
        zzd = (View)zze.zzp(zzd);
        zzafl.registerForContextMenu(zzd);
    }

    public final void zzo(zzd zzd)
    {
        zzd = (View)zze.zzp(zzd);
        zzafl.unregisterForContextMenu(zzd);
    }

    public final zzd zzsa()
    {
        return zze.zzy(zzafl.getActivity());
    }

    public final zzc zzsb()
    {
        return zza(zzafl.getParentFragment());
    }

    public final zzd zzsc()
    {
        return zze.zzy(zzafl.getResources());
    }

    public final zzc zzsd()
    {
        return zza(zzafl.getTargetFragment());
    }
}
