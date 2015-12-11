// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions, OnMapReadyCallback

class zzafl
    implements MapLifecycleDelegate
{

    private final IMapFragmentDelegate zzaIP;
    private final Fragment zzafl;

    public void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        try
        {
            class _cls1 extends com.google.android.gms.maps.internal.zzl.zza
            {

                final OnMapReadyCallback zzaIQ;
                final SupportMapFragment.zza zzaJB;

                public void zza(IGoogleMapDelegate igooglemapdelegate)
                {
                    zzaIQ.onMapReady(new GoogleMap(igooglemapdelegate));
                }

            _cls1(OnMapReadyCallback onmapreadycallback)
            {
                zzaJB = SupportMapFragment.zza.this;
                zzaIQ = onmapreadycallback;
                super();
            }
            }

            zzaIP.getMapAsync(new _cls1(onmapreadycallback));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnMapReadyCallback onmapreadycallback)
        {
            throw new RuntimeRemoteException(onmapreadycallback);
        }
    }

    public void onCreate(Bundle bundle)
    {
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        bundle1 = new Bundle();
        bundle = zzafl.getArguments();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (bundle.containsKey("MapOptions"))
        {
            com.google.android.gms.maps.internal.zzx.zza(bundle1, "MapOptions", bundle.getParcelable("MapOptions"));
        }
        zzaIP.onCreate(bundle1);
        return;
        bundle;
        throw new RuntimeRemoteException(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        try
        {
            layoutinflater = zzaIP.onCreateView(zze.zzy(layoutinflater), zze.zzy(viewgroup), bundle);
        }
        // Misplaced declaration of an exception variable
        catch (LayoutInflater layoutinflater)
        {
            throw new RuntimeRemoteException(layoutinflater);
        }
        return (View)zze.zzp(layoutinflater);
    }

    public void onDestroy()
    {
        try
        {
            zzaIP.onDestroy();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void onDestroyView()
    {
        try
        {
            zzaIP.onDestroyView();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void onEnterAmbient(Bundle bundle)
    {
        try
        {
            zzaIP.onEnterAmbient(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new RuntimeRemoteException(bundle);
        }
    }

    public void onExitAmbient()
    {
        try
        {
            zzaIP.onExitAmbient();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
    {
        bundle = (GoogleMapOptions)bundle.getParcelable("MapOptions");
        try
        {
            zzaIP.onInflate(zze.zzy(activity), bundle, bundle1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeRemoteException(activity);
        }
    }

    public void onLowMemory()
    {
        try
        {
            zzaIP.onLowMemory();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void onPause()
    {
        try
        {
            zzaIP.onPause();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void onResume()
    {
        try
        {
            zzaIP.onResume();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        try
        {
            zzaIP.onSaveInstanceState(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new RuntimeRemoteException(bundle);
        }
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }

    public IMapFragmentDelegate zzxK()
    {
        return zzaIP;
    }

    public legate(Fragment fragment, IMapFragmentDelegate imapfragmentdelegate)
    {
        zzaIP = (IMapFragmentDelegate)zzx.zzw(imapfragmentdelegate);
        zzafl = (Fragment)zzx.zzw(fragment);
    }
}
