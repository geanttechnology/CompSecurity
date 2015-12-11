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
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.p;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap, GoogleMapOptions, MapsInitializer

public class MapFragment extends Fragment
    implements TraceFieldInterface
{
    static class a
        implements LifecycleDelegate
    {

        private final Fragment Po;
        private final IMapFragmentDelegate Pp;

        public IMapFragmentDelegate gV()
        {
            return Pp;
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
            bundle = Po.getArguments();
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            if (bundle.containsKey("MapOptions"))
            {
                p.a(bundle1, "MapOptions", bundle.getParcelable("MapOptions"));
            }
            Pp.onCreate(bundle1);
            return;
            bundle;
            throw new RuntimeRemoteException(bundle);
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            try
            {
                layoutinflater = Pp.onCreateView(c.h(layoutinflater), c.h(viewgroup), bundle);
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
                Pp.onDestroy();
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
                Pp.onDestroyView();
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
                Pp.onInflate(c.h(activity), bundle, bundle1);
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
                Pp.onLowMemory();
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
                Pp.onPause();
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
                Pp.onResume();
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
                Pp.onSaveInstanceState(bundle);
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

        public a(Fragment fragment, IMapFragmentDelegate imapfragmentdelegate)
        {
            Pp = (IMapFragmentDelegate)er.f(imapfragmentdelegate);
            Po = (Fragment)er.f(fragment);
        }
    }

    static class b extends com.google.android.gms.dynamic.a
    {

        private final Fragment Po;
        protected d Pq;
        private Activity nd;

        static void a(b b1, Activity activity)
        {
            b1.setActivity(activity);
        }

        private void setActivity(Activity activity)
        {
            nd = activity;
            gW();
        }

        protected void a(d d1)
        {
            Pq = d1;
            gW();
        }

        public void gW()
        {
            if (nd == null || Pq == null || fj() != null)
            {
                break MISSING_BLOCK_LABEL_70;
            }
            MapsInitializer.initialize(nd);
            IMapFragmentDelegate imapfragmentdelegate = q.A(nd).f(c.h(nd));
            Pq.a(new a(Po, imapfragmentdelegate));
            return;
            Object obj;
            obj;
            throw new RuntimeRemoteException(((RemoteException) (obj)));
            obj;
        }

        b(Fragment fragment)
        {
            Po = fragment;
        }
    }


    private final b Pm = new b(this);
    private GoogleMap Pn;

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

    protected IMapFragmentDelegate gV()
    {
        Pm.gW();
        if (Pm.fj() == null)
        {
            return null;
        } else
        {
            return ((a)Pm.fj()).gV();
        }
    }

    public final GoogleMap getMap()
    {
        Object obj = gV();
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
                if (Pn == null || Pn.gM().asBinder() != ((IGoogleMapDelegate) (obj)).asBinder())
                {
                    Pn = new GoogleMap(((IGoogleMapDelegate) (obj)));
                }
                return Pn;
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
        b.a(Pm, activity);
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("MapFragment");
        TraceMachine.enterMethod(_nr_trace, "MapFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        Pm.onCreate(bundle);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "MapFragment#onCreate", null);
          goto _L1
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "MapFragment#onCreateView", null);
_L1:
        layoutinflater = Pm.onCreateView(layoutinflater, viewgroup, bundle);
        TraceMachine.exitMethod();
        return layoutinflater;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "MapFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
        Pm.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        Pm.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        b.a(Pm, activity);
        attributeset = GoogleMapOptions.createFromAttributes(activity, attributeset);
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("MapOptions", attributeset);
        Pm.onInflate(activity, bundle1, bundle);
    }

    public void onLowMemory()
    {
        Pm.onLowMemory();
        super.onLowMemory();
    }

    public void onPause()
    {
        Pm.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        Pm.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/MapFragment.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        Pm.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }
}
