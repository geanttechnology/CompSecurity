// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanorama, StreetViewPanoramaOptions, OnStreetViewPanoramaReadyCallback

public class StreetViewPanoramaFragment extends Fragment
{

    private final zzb zzaJi = new zzb();
    private StreetViewPanorama zzaJj;

    public StreetViewPanoramaFragment()
    {
    /* block-local class not found */
    class zzb {}

    }

    public static StreetViewPanoramaFragment newInstance()
    {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        StreetViewPanoramaFragment streetviewpanoramafragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetviewpanoramaoptions);
        streetviewpanoramafragment.setArguments(bundle);
        return streetviewpanoramafragment;
    }

    public final StreetViewPanorama getStreetViewPanorama()
    {
        Object obj = zzxO();
        if (obj != null)
        {
            try
            {
                obj = ((IStreetViewPanoramaFragmentDelegate) (obj)).getStreetViewPanorama();
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
            if (obj != null)
            {
                if (zzaJj == null || zzaJj.zzxN().asBinder() != ((IStreetViewPanoramaDelegate) (obj)).asBinder())
                {
                    zzaJj = new StreetViewPanorama(((IStreetViewPanoramaDelegate) (obj)));
                }
                return zzaJj;
            }
        }
        return null;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
        zzx.zzci("getStreetViewPanoramaAsync() must be called on the main thread");
        zzaJi.getStreetViewPanoramaAsync(onstreetviewpanoramareadycallback);
    }

    public void onActivityCreated(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/StreetViewPanoramaFragment.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        zzb.zza(zzaJi, activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        zzaJi.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return zzaJi.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroy()
    {
        zzaJi.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        zzaJi.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        zzb.zza(zzaJi, activity);
        attributeset = new Bundle();
        zzaJi.onInflate(activity, attributeset, bundle);
    }

    public void onLowMemory()
    {
        zzaJi.onLowMemory();
        super.onLowMemory();
    }

    public void onPause()
    {
        zzaJi.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        zzaJi.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/StreetViewPanoramaFragment.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        zzaJi.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }

    protected IStreetViewPanoramaFragmentDelegate zzxO()
    {
        zzaJi.zzxL();
    /* block-local class not found */
    class zza {}

        if (zzaJi.zzrZ() == null)
        {
            return null;
        } else
        {
            return ((zza)zzaJi.zzrZ()).zzxO();
        }
    }
}
