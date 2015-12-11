// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            OnStreetViewPanoramaReadyCallback

class zzaIV
    implements StreetViewLifecycleDelegate
{

    private final ViewGroup zzaIV;
    private final IStreetViewPanoramaViewDelegate zzaJw;
    private View zzaJx;

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
        try
        {
            class _cls1 extends com.google.android.gms.maps.internal.zzv.zza
            {

                final OnStreetViewPanoramaReadyCallback zzaJl;
                final StreetViewPanoramaView.zza zzaJy;

                public void zza(IStreetViewPanoramaDelegate istreetviewpanoramadelegate)
                {
                    zzaJl.onStreetViewPanoramaReady(new StreetViewPanorama(istreetviewpanoramadelegate));
                }

            _cls1(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
            {
                zzaJy = StreetViewPanoramaView.zza.this;
                zzaJl = onstreetviewpanoramareadycallback;
                super();
            }
            }

            zzaJw.getStreetViewPanoramaAsync(new _cls1(onstreetviewpanoramareadycallback));
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
        try
        {
            zzaJw.onCreate(bundle);
            zzaJx = (View)zze.zzp(zzaJw.getView());
            zzaIV.removeAllViews();
            zzaIV.addView(zzaJx);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new RuntimeRemoteException(bundle);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }

    public void onDestroy()
    {
        try
        {
            zzaJw.onDestroy();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void onDestroyView()
    {
        throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
    {
        throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    public void onLowMemory()
    {
        try
        {
            zzaJw.onLowMemory();
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
            zzaJw.onPause();
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
            zzaJw.onResume();
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
            zzaJw.onSaveInstanceState(bundle);
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

    public IStreetViewPanoramaViewDelegate zzxS()
    {
        return zzaJw;
    }

    public aViewDelegate(ViewGroup viewgroup, IStreetViewPanoramaViewDelegate istreetviewpanoramaviewdelegate)
    {
        zzaJw = (IStreetViewPanoramaViewDelegate)zzx.zzw(istreetviewpanoramaviewdelegate);
        zzaIV = (ViewGroup)zzx.zzw(viewgroup);
    }
}
