// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v7.lj;
import android.support.v7.ll;
import android.support.v7.lm;
import android.support.v7.yn;
import android.support.v7.yp;
import android.support.v7.yw;
import android.support.v7.yz;
import android.support.v7.zu;
import android.support.v7.zv;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.e;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions, c, e, d

public class SupportMapFragment extends Fragment
    implements TraceFieldInterface
{
    static class a
        implements yw
    {

        private final Fragment a;
        private final yp b;

        public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            try
            {
                layoutinflater = b.a(ll.a(layoutinflater), ll.a(viewgroup), bundle);
            }
            // Misplaced declaration of an exception variable
            catch (LayoutInflater layoutinflater)
            {
                throw new e(layoutinflater);
            }
            return (View)ll.a(layoutinflater);
        }

        public void a()
        {
            try
            {
                b.b();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public void a(Activity activity, Bundle bundle, Bundle bundle1)
        {
            bundle = (GoogleMapOptions)bundle.getParcelable("MapOptions");
            try
            {
                b.a(ll.a(activity), bundle, bundle1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                throw new e(activity);
            }
        }

        public void a(Bundle bundle)
        {
            Bundle bundle1;
            bundle1 = bundle;
            if (bundle != null)
            {
                break MISSING_BLOCK_LABEL_14;
            }
            bundle1 = new Bundle();
            bundle = a.i();
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            if (bundle.containsKey("MapOptions"))
            {
                zu.a(bundle1, "MapOptions", bundle.getParcelable("MapOptions"));
            }
            b.a(bundle1);
            return;
            bundle;
            throw new e(bundle);
        }

        public void a(com.google.android.gms.maps.e e1)
        {
            try
            {
                b.a(new android.support.v7.zi.a(this, e1) {

                    final com.google.android.gms.maps.e a;
                    final a b;

                    public void a(yn yn1)
                        throws RemoteException
                    {
                        a.a(new com.google.android.gms.maps.c(yn1));
                    }

            
            {
                b = a1;
                a = e1;
                super();
            }
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (com.google.android.gms.maps.e e1)
            {
                throw new e(e1);
            }
        }

        public void b()
        {
            try
            {
                b.c();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public void b(Bundle bundle)
        {
            try
            {
                b.b(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new e(bundle);
            }
        }

        public void c()
        {
            try
            {
                b.d();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public void d()
        {
            try
            {
                b.e();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public void e()
        {
            try
            {
                b.f();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
        }

        public yp f()
        {
            return b;
        }

        public a(Fragment fragment, yp yp1)
        {
            b = (yp)x.a(yp1);
            a = (Fragment)x.a(fragment);
        }
    }

    static class b extends lj
    {

        protected lm a;
        private final Fragment b;
        private Activity c;
        private final List d = new ArrayList();

        private void a(Activity activity)
        {
            c = activity;
            g();
        }

        static void a(b b1, Activity activity)
        {
            b1.a(activity);
        }

        protected void a(lm lm1)
        {
            a = lm1;
            g();
        }

        public void a(com.google.android.gms.maps.e e1)
        {
            if (a() != null)
            {
                ((a)a()).a(e1);
                return;
            } else
            {
                d.add(e1);
                return;
            }
        }

        public void g()
        {
            if (c == null || a == null || a() != null)
            {
                break MISSING_BLOCK_LABEL_139;
            }
            yp yp1;
            com.google.android.gms.maps.d.a(c);
            yp1 = zv.a(c).b(ll.a(c));
            if (yp1 == null)
            {
                return;
            }
            RemoteException remoteexception;
            a.a(new a(b, yp1));
            com.google.android.gms.maps.e e1;
            for (Iterator iterator = d.iterator(); iterator.hasNext(); ((a)a()).a(e1))
            {
                e1 = (com.google.android.gms.maps.e)iterator.next();
            }

            try
            {
                d.clear();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
            catch (c c1) { }
        }

        b(Fragment fragment)
        {
            b = fragment;
        }
    }


    private final b a = new b(this);
    private com.google.android.gms.maps.c b;

    public SupportMapFragment()
    {
    }

    protected yp a()
    {
        a.g();
        if (a.a() == null)
        {
            return null;
        } else
        {
            return ((a)a.a()).f();
        }
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = a.a(layoutinflater, viewgroup, bundle);
        layoutinflater.setClickable(true);
        return layoutinflater;
    }

    public void a(Activity activity)
    {
        super.a(activity);
        b.a(a, activity);
    }

    public void a(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.a(activity, attributeset, bundle);
        b.a(a, activity);
        attributeset = GoogleMapOptions.a(activity, attributeset);
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("MapOptions", attributeset);
        a.a(activity, bundle1, bundle);
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        a.a(bundle);
    }

    public void a(com.google.android.gms.maps.e e1)
    {
        x.b("getMapAsync must be called on the main thread.");
        a.a(e1);
    }

    public final com.google.android.gms.maps.c b()
    {
        Object obj = a();
        if (obj != null)
        {
            try
            {
                obj = ((yp) (obj)).a();
            }
            catch (RemoteException remoteexception)
            {
                throw new e(remoteexception);
            }
            if (obj != null)
            {
                if (b == null || b.a().asBinder() != ((yn) (obj)).asBinder())
                {
                    b = new com.google.android.gms.maps.c(((yn) (obj)));
                }
                return b;
            }
        }
        return null;
    }

    public void d(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/SupportMapFragment.getClassLoader());
        }
        super.d(bundle);
    }

    public void e(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/SupportMapFragment.getClassLoader());
        }
        super.e(bundle);
        a.b(bundle);
    }

    public void g()
    {
        a.d();
        super.g();
    }

    public void g(Bundle bundle)
    {
        super.g(bundle);
    }

    public void onLowMemory()
    {
        a.f();
        super.onLowMemory();
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

    public void u()
    {
        super.u();
        a.b();
    }

    public void v()
    {
        a.c();
        super.v();
    }

    public void w()
    {
        a.e();
        super.w();
    }
}
