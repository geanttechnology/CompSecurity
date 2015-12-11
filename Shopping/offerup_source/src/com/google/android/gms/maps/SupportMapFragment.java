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
    private final zzb zzaJA = new zzb(this);

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
        com.google.android.gms.maps.zzb.zza(zzaJA, activity);
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
        com.google.android.gms.maps.zzb.zza(zzaJA, activity);
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

    private class zzb extends com.google.android.gms.dynamic.zza
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

        static void zza(zzb zzb1, Activity activity)
        {
            zzb1.setActivity(activity);
        }

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
            if (mActivity == null || zzaIS == null || zzrZ() != null)
            {
                break MISSING_BLOCK_LABEL_139;
            }
            IMapFragmentDelegate imapfragmentdelegate;
            MapsInitializer.initialize(mActivity);
            imapfragmentdelegate = zzy.zzaG(mActivity).zzt(zze.zzy(mActivity));
            if (imapfragmentdelegate == null)
            {
                return;
            }
            RemoteException remoteexception;
            zzaIS.zza(new zza(zzafl, imapfragmentdelegate));
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

        zzb(Fragment fragment)
        {
            zzafl = fragment;
        }
    }


    private class zza
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
                    final zza zzaJB;

                    public void zza(IGoogleMapDelegate igooglemapdelegate)
                    {
                        zzaIQ.onMapReady(new GoogleMap(igooglemapdelegate));
                    }

                _cls1(OnMapReadyCallback onmapreadycallback)
                {
                    zzaJB = zza.this;
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

        public zza(Fragment fragment, IMapFragmentDelegate imapfragmentdelegate)
        {
            zzaIP = (IMapFragmentDelegate)zzx.zzw(imapfragmentdelegate);
            zzafl = (Fragment)zzx.zzw(fragment);
        }
    }

}
