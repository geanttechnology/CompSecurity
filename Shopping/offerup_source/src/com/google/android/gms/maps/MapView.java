// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions, GoogleMap, OnMapReadyCallback

public class MapView extends FrameLayout
{

    private GoogleMap zzaIO;
    private final zzb zzaIU;

    public MapView(Context context)
    {
        super(context);
        zzaIU = new zzb(this, context, null);
        init();
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        zzaIU = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeset));
        init();
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        zzaIU = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeset));
        init();
    }

    public MapView(Context context, GoogleMapOptions googlemapoptions)
    {
        super(context);
        zzaIU = new zzb(this, context, googlemapoptions);
        init();
    }

    private void init()
    {
        setClickable(true);
    }

    public final GoogleMap getMap()
    {
        if (zzaIO != null)
        {
            return zzaIO;
        }
        zzaIU.zzxL();
        if (zzaIU.zzrZ() == null)
        {
            return null;
        }
        try
        {
            zzaIO = new GoogleMap(((zza)zzaIU.zzrZ()).zzxM().getMap());
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return zzaIO;
    }

    public void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        zzx.zzci("getMapAsync() must be called on the main thread");
        zzaIU.getMapAsync(onmapreadycallback);
    }

    public final void onCreate(Bundle bundle)
    {
        zzaIU.onCreate(bundle);
        if (zzaIU.zzrZ() == null)
        {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy()
    {
        zzaIU.onDestroy();
    }

    public final void onEnterAmbient(Bundle bundle)
    {
        zzx.zzci("onEnterAmbient() must be called on the main thread");
        zzaIU.onEnterAmbient(bundle);
    }

    public final void onExitAmbient()
    {
        zzx.zzci("onExitAmbient() must be called on the main thread");
        zzaIU.onExitAmbient();
    }

    public final void onLowMemory()
    {
        zzaIU.onLowMemory();
    }

    public final void onPause()
    {
        zzaIU.onPause();
    }

    public final void onResume()
    {
        zzaIU.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        zzaIU.onSaveInstanceState(bundle);
    }

    private class zzb extends com.google.android.gms.dynamic.zza
    {

        private final Context mContext;
        protected zzf zzaIS;
        private final List zzaIT = new ArrayList();
        private final ViewGroup zzaIZ;
        private final GoogleMapOptions zzaJa;

        public void getMapAsync(OnMapReadyCallback onmapreadycallback)
        {
            if (zzrZ() != null)
            {
                ((zza)zzrZ()).getMapAsync(onmapreadycallback);
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
                ((zza)zzrZ()).onEnterAmbient(bundle);
            }
        }

        public void onExitAmbient()
        {
            if (zzrZ() != null)
            {
                ((zza)zzrZ()).onExitAmbient();
            }
        }

        protected void zza(zzf zzf1)
        {
            zzaIS = zzf1;
            zzxL();
        }

        public void zzxL()
        {
            if (zzaIS == null || zzrZ() != null)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            IMapViewDelegate imapviewdelegate;
            MapsInitializer.initialize(mContext);
            imapviewdelegate = zzy.zzaG(mContext).zza(zze.zzy(mContext), zzaJa);
            if (imapviewdelegate == null)
            {
                return;
            }
            RemoteException remoteexception;
            zzaIS.zza(new zza(zzaIZ, imapviewdelegate));
            OnMapReadyCallback onmapreadycallback;
            for (Iterator iterator = zzaIT.iterator(); iterator.hasNext(); ((zza)zzrZ()).getMapAsync(onmapreadycallback))
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

        zzb(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
        {
            zzaIZ = viewgroup;
            mContext = context;
            zzaJa = googlemapoptions;
        }
    }


    private class zza
        implements MapLifecycleDelegate
    {

        private final ViewGroup zzaIV;
        private final IMapViewDelegate zzaIW;
        private View zzaIX;

        public void getMapAsync(OnMapReadyCallback onmapreadycallback)
        {
            try
            {
                class _cls1 extends com.google.android.gms.maps.internal.zzl.zza
                {

                    final OnMapReadyCallback zzaIQ;
                    final zza zzaIY;

                    public void zza(IGoogleMapDelegate igooglemapdelegate)
                    {
                        zzaIQ.onMapReady(new GoogleMap(igooglemapdelegate));
                    }

                _cls1(OnMapReadyCallback onmapreadycallback)
                {
                    zzaIY = zza.this;
                    zzaIQ = onmapreadycallback;
                    super();
                }
                }

                zzaIW.getMapAsync(new _cls1(onmapreadycallback));
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
            try
            {
                zzaIW.onCreate(bundle);
                zzaIX = (View)zze.zzp(zzaIW.getView());
                zzaIV.removeAllViews();
                zzaIV.addView(zzaIX);
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
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy()
        {
            try
            {
                zzaIW.onDestroy();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onDestroyView()
        {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onEnterAmbient(Bundle bundle)
        {
            try
            {
                zzaIW.onEnterAmbient(bundle);
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
                zzaIW.onExitAmbient();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
        {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory()
        {
            try
            {
                zzaIW.onLowMemory();
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
                zzaIW.onPause();
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
                zzaIW.onResume();
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
                zzaIW.onSaveInstanceState(bundle);
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

        public IMapViewDelegate zzxM()
        {
            return zzaIW;
        }

        public zza(ViewGroup viewgroup, IMapViewDelegate imapviewdelegate)
        {
            zzaIW = (IMapViewDelegate)zzx.zzw(imapviewdelegate);
            zzaIV = (ViewGroup)zzx.zzw(viewgroup);
        }
    }

}
