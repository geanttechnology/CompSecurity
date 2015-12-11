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
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            OnStreetViewPanoramaReadyCallback

class zzafl
    implements StreetViewLifecycleDelegate
{

    private final IStreetViewPanoramaFragmentDelegate zzaJk;
    private final Fragment zzafl;

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
        try
        {
            class _cls1 extends com.google.android.gms.maps.internal.zzv.zza
            {

                final SupportStreetViewPanoramaFragment.zza zzaJD;
                final OnStreetViewPanoramaReadyCallback zzaJl;

                public void zza(IStreetViewPanoramaDelegate istreetviewpanoramadelegate)
                {
                    zzaJl.onStreetViewPanoramaReady(new StreetViewPanorama(istreetviewpanoramadelegate));
                }

            _cls1(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
            {
                zzaJD = SupportStreetViewPanoramaFragment.zza.this;
                zzaJl = onstreetviewpanoramareadycallback;
                super();
            }
            }

            zzaJk.getStreetViewPanoramaAsync(new _cls1(onstreetviewpanoramareadycallback));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
        {
            throw new RuntimeRemoteException(onstreetviewpanoramareadycallback);
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
        if (bundle.containsKey("StreetViewPanoramaOptions"))
        {
            com.google.android.gms.maps.internal.zzx.zza(bundle1, "StreetViewPanoramaOptions", bundle.getParcelable("StreetViewPanoramaOptions"));
        }
        zzaJk.onCreate(bundle1);
        return;
        bundle;
        throw new RuntimeRemoteException(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        try
        {
            layoutinflater = zzaJk.onCreateView(zze.zzy(layoutinflater), zze.zzy(viewgroup), bundle);
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
            zzaJk.onDestroy();
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
            zzaJk.onDestroyView();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
    {
        try
        {
            zzaJk.onInflate(zze.zzy(activity), null, bundle1);
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
            zzaJk.onLowMemory();
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
            zzaJk.onPause();
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
            zzaJk.onResume();
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
            zzaJk.onSaveInstanceState(bundle);
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

    public IStreetViewPanoramaFragmentDelegate zzxO()
    {
        return zzaJk;
    }

    public legate(Fragment fragment, IStreetViewPanoramaFragmentDelegate istreetviewpanoramafragmentdelegate)
    {
        zzaJk = (IStreetViewPanoramaFragmentDelegate)zzx.zzw(istreetviewpanoramafragmentdelegate);
        zzafl = (Fragment)zzx.zzw(fragment);
    }
}
