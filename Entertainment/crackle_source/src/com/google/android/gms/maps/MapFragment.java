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
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.p;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap, GoogleMapOptions, MapsInitializer

public class MapFragment extends Fragment
{
    static class a
        implements LifecycleDelegate
    {

        private final Fragment BV;
        private final IMapFragmentDelegate BW;

        public IMapFragmentDelegate ew()
        {
            return BW;
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
            bundle = BV.getArguments();
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            if (bundle.containsKey("MapOptions"))
            {
                p.a(bundle1, "MapOptions", bundle.getParcelable("MapOptions"));
            }
            BW.onCreate(bundle1);
            return;
            bundle;
            throw new RuntimeRemoteException(bundle);
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            try
            {
                layoutinflater = BW.onCreateView(c.h(layoutinflater), c.h(viewgroup), bundle);
            }
            // Misplaced declaration of an exception variable
            catch (LayoutInflater layoutinflater)
            {
                throw new RuntimeRemoteException(layoutinflater);
            }
            return (View)c.b(layoutinflater);
        }

        public void onDestroy()
        {
            try
            {
                BW.onDestroy();
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
                BW.onDestroyView();
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
                BW.onInflate(c.h(activity), bundle, bundle1);
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
                BW.onLowMemory();
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
                BW.onPause();
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
                BW.onResume();
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
                BW.onSaveInstanceState(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeRemoteException(bundle);
            }
        }

        public a(Fragment fragment, IMapFragmentDelegate imapfragmentdelegate)
        {
            BW = (IMapFragmentDelegate)eg.f(imapfragmentdelegate);
            BV = (Fragment)eg.f(fragment);
        }
    }

    static class b extends com.google.android.gms.dynamic.a
    {

        private final Fragment BV;
        protected d BX;
        private Activity gs;

        static void a(b b1, Activity activity)
        {
            b1.setActivity(activity);
        }

        private void setActivity(Activity activity)
        {
            gs = activity;
            ex();
        }

        protected void a(d d1)
        {
            BX = d1;
            ex();
        }

        public void ex()
        {
            if (gs == null || BX == null || cZ() != null)
            {
                break MISSING_BLOCK_LABEL_70;
            }
            MapsInitializer.initialize(gs);
            IMapFragmentDelegate imapfragmentdelegate = q.u(gs).f(c.h(gs));
            BX.a(new a(BV, imapfragmentdelegate));
            return;
            Object obj;
            obj;
            throw new RuntimeRemoteException(((RemoteException) (obj)));
            obj;
        }

        b(Fragment fragment)
        {
            BV = fragment;
        }
    }


    private final b BT = new b(this);
    private GoogleMap BU;

    public MapFragment()
    {
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

    protected IMapFragmentDelegate ew()
    {
        BT.ex();
        if (BT.cZ() == null)
        {
            return null;
        } else
        {
            return ((a)BT.cZ()).ew();
        }
    }

    public final GoogleMap getMap()
    {
        Object obj = ew();
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
                if (BU == null || BU.en().asBinder() != ((IGoogleMapDelegate) (obj)).asBinder())
                {
                    BU = new GoogleMap(((IGoogleMapDelegate) (obj)));
                }
                return BU;
            }
        }
        return null;
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
        b.a(BT, activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        BT.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BT.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroy()
    {
        BT.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        BT.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        b.a(BT, activity);
        attributeset = GoogleMapOptions.createFromAttributes(activity, attributeset);
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("MapOptions", attributeset);
        BT.onInflate(activity, bundle1, bundle);
    }

    public void onLowMemory()
    {
        BT.onLowMemory();
        super.onLowMemory();
    }

    public void onPause()
    {
        BT.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        BT.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/MapFragment.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        BT.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }
}
