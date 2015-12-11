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

public class SupportMapFragment extends Fragment
{
    static class a
        implements LifecycleDelegate
    {

        private final IMapFragmentDelegate BW;
        private final Fragment Cg;

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
            bundle = Cg.getArguments();
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
            Cg = (Fragment)eg.f(fragment);
        }
    }

    static class b extends com.google.android.gms.dynamic.a
    {

        protected d BX;
        private final Fragment Cg;
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
            BX.a(new a(Cg, imapfragmentdelegate));
            return;
            Object obj;
            obj;
            throw new RuntimeRemoteException(((RemoteException) (obj)));
            obj;
        }

        b(Fragment fragment)
        {
            Cg = fragment;
        }
    }


    private GoogleMap BU;
    private final b Cf = new b(this);

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

    protected IMapFragmentDelegate ew()
    {
        Cf.ex();
        if (Cf.cZ() == null)
        {
            return null;
        } else
        {
            return ((a)Cf.cZ()).ew();
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
            bundle.setClassLoader(com/google/android/gms/maps/SupportMapFragment.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b.a(Cf, activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Cf.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return Cf.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroy()
    {
        Cf.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        Cf.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        b.a(Cf, activity);
        attributeset = GoogleMapOptions.createFromAttributes(activity, attributeset);
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("MapOptions", attributeset);
        Cf.onInflate(activity, bundle1, bundle);
    }

    public void onLowMemory()
    {
        Cf.onLowMemory();
        super.onLowMemory();
    }

    public void onPause()
    {
        Cf.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Cf.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/SupportMapFragment.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        Cf.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }
}
