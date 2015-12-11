// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            MapsInitializer, OnMapReadyCallback

class zzafl extends zza
{

    private Activity mActivity;
    protected zzf zzaIS;
    private final List zzaIT = new ArrayList();
    private final Fragment zzafl;

    private void setActivity(Activity activity)
    {
        mActivity = activity;
        zzxL();
    }

    static void zza(zzxL zzxl, Activity activity)
    {
        zzxl.setActivity(activity);
    }

    public void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        if (zzrZ() != null)
        {
            ((zzrZ)zzrZ()).getMapAsync(onmapreadycallback);
            return;
        } else
        {
            zzaIT.add(onmapreadycallback);
            return;
        }
    }

    public void onEnterAmbient(Bundle bundle)
    {
        if (zzrZ() != null)
        {
            ((zzrZ)zzrZ()).onEnterAmbient(bundle);
        }
    }

    public void onExitAmbient()
    {
        if (zzrZ() != null)
        {
            ((zzrZ)zzrZ()).onExitAmbient();
        }
    }

    protected void zza(zzf zzf1)
    {
        zzaIS = zzf1;
        zzxL();
    }

    public void zzxL()
    {
        if (mActivity == null || zzaIS == null || zzrZ() != null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        com.google.android.gms.maps.internal.IMapFragmentDelegate imapfragmentdelegate;
        MapsInitializer.initialize(mActivity);
        imapfragmentdelegate = zzy.zzaG(mActivity).zzt(zze.zzy(mActivity));
        if (imapfragmentdelegate == null)
        {
            return;
        }
        RemoteException remoteexception;
        zzaIS.zza(new <init>(zzafl, imapfragmentdelegate));
        OnMapReadyCallback onmapreadycallback;
        for (Iterator iterator = zzaIT.iterator(); iterator.hasNext(); ((zzaIT)zzrZ()).getMapAsync(onmapreadycallback))
        {
            onmapreadycallback = (OnMapReadyCallback)iterator.next();
        }

        try
        {
            zzaIT.clear();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception) { }
    }

    AvailableException(Fragment fragment)
    {
        zzafl = fragment;
    }
}
