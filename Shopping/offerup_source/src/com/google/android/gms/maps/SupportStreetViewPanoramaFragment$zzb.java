// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
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
//            MapsInitializer, OnStreetViewPanoramaReadyCallback

class zzafl extends zza
{

    private Activity mActivity;
    protected zzf zzaIS;
    private final List zzaJn = new ArrayList();
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

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
        if (zzrZ() != null)
        {
            ((zzrZ)zzrZ()).getStreetViewPanoramaAsync(onstreetviewpanoramareadycallback);
            return;
        } else
        {
            zzaJn.add(onstreetviewpanoramareadycallback);
            return;
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
            break MISSING_BLOCK_LABEL_132;
        }
        try
        {
            MapsInitializer.initialize(mActivity);
            com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate istreetviewpanoramafragmentdelegate = zzy.zzaG(mActivity).zzu(zze.zzy(mActivity));
            zzaIS.zza(new <init>(zzafl, istreetviewpanoramafragmentdelegate));
            OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback;
            for (Iterator iterator = zzaJn.iterator(); iterator.hasNext(); ((zzaJn)zzrZ()).getStreetViewPanoramaAsync(onstreetviewpanoramareadycallback))
            {
                onstreetviewpanoramareadycallback = (OnStreetViewPanoramaReadyCallback)iterator.next();
            }

        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
        {
            return;
        }
        zzaJn.clear();
    }

    ion(Fragment fragment)
    {
        zzafl = fragment;
    }
}
