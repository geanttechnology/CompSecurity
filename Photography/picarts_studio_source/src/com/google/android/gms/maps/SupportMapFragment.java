// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap, GoogleMapOptions, OnMapReadyCallback

public class SupportMapFragment extends Fragment
{

    private GoogleMap zzaIO;
    private final zzb zzaJA = new zzb();

    public SupportMapFragment()
    {
    }

    public static SupportMapFragment newInstance()
    {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions googlemapoptions)
    {
        SupportMapFragment supportmapfragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googlemapoptions);
        supportmapfragment.setArguments(bundle);
        return supportmapfragment;
    }

    public final GoogleMap getMap()
    {
        Object obj = zzxK();
        if (obj != null)
        {
            try
            {
                obj = ((IMapFragmentDelegate) (obj)).getMap();
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
            if (obj != null)
            {
                if (zzaIO == null || zzaIO.zzxy().asBinder() != ((IGoogleMapDelegate) (obj)).asBinder())
                {
                    zzaIO = new GoogleMap(((IGoogleMapDelegate) (obj)));
                }
                return zzaIO;
            }
        }
        return null;
    }

    public void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        zzx.zzci("getMapAsync must be called on the main thread.");
        zzaJA.getMapAsync(onmapreadycallback);
    }

    public void onActivityCreated(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/SupportMapFragment.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        zzb.zza(zzaJA, activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        zzaJA.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = zzaJA.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater.setClickable(true);
        return layoutinflater;
    }

    public void onDestroy()
    {
        zzaJA.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        zzaJA.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle)
    {
        zzx.zzci("onEnterAmbient must be called on the main thread.");
        zzaJA.onEnterAmbient(bundle);
    }

    public final void onExitAmbient()
    {
        zzx.zzci("onExitAmbient must be called on the main thread.");
        zzaJA.onExitAmbient();
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        zzb.zza(zzaJA, activity);
        attributeset = GoogleMapOptions.createFromAttributes(activity, attributeset);
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("MapOptions", attributeset);
        zzaJA.onInflate(activity, bundle1, bundle);
    }

    public void onLowMemory()
    {
        zzaJA.onLowMemory();
        super.onLowMemory();
    }

    public void onPause()
    {
        zzaJA.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        zzaJA.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/SupportMapFragment.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        zzaJA.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }

    protected IMapFragmentDelegate zzxK()
    {
        zzaJA.zzxL();
        if (zzaJA.zzrZ() == null)
        {
            return null;
        } else
        {
            return ((zza)zzaJA.zzrZ()).zzxK();
        }
    }

    /* member class not found */
    class zzb {}


    /* member class not found */
    class zza {}

}
