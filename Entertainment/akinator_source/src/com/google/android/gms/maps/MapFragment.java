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
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap, GoogleMapOptions, OnMapReadyCallback

public class MapFragment extends Fragment
{

    private final zzb zzaIN = new zzb();
    private GoogleMap zzaIO;

    public MapFragment()
    {
    /* block-local class not found */
    class zzb {}

    }

    public static MapFragment newInstance()
    {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googlemapoptions)
    {
        MapFragment mapfragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googlemapoptions);
        mapfragment.setArguments(bundle);
        return mapfragment;
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
        zzaIN.getMapAsync(onmapreadycallback);
    }

    public void onActivityCreated(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/MapFragment.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        zzb.zza(zzaIN, activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        zzaIN.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = zzaIN.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater.setClickable(true);
        return layoutinflater;
    }

    public void onDestroy()
    {
        zzaIN.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        zzaIN.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle)
    {
        zzx.zzci("onEnterAmbient must be called on the main thread.");
        zzaIN.onEnterAmbient(bundle);
    }

    public final void onExitAmbient()
    {
        zzx.zzci("onExitAmbient must be called on the main thread.");
        zzaIN.onExitAmbient();
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        zzb.zza(zzaIN, activity);
        attributeset = GoogleMapOptions.createFromAttributes(activity, attributeset);
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("MapOptions", attributeset);
        zzaIN.onInflate(activity, bundle1, bundle);
    }

    public void onLowMemory()
    {
        zzaIN.onLowMemory();
        super.onLowMemory();
    }

    public void onPause()
    {
        zzaIN.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        zzaIN.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/MapFragment.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        zzaIN.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }

    protected IMapFragmentDelegate zzxK()
    {
        zzaIN.zzxL();
    /* block-local class not found */
    class zza {}

        if (zzaIN.zzrZ() == null)
        {
            return null;
        } else
        {
            return ((zza)zzaIN.zzrZ()).zzxK();
        }
    }
}
