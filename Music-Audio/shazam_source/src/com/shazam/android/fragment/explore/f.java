// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.explore;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.MapView;
import com.shazam.a.a.g;
import com.shazam.android.advert.h.a;
import com.shazam.android.aq.s;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.k.b.l;
import com.shazam.android.v.k;
import com.shazam.android.widget.FakeDeterminateProgressBarView;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.i.b.al.d;
import com.shazam.i.b.c;
import com.shazam.i.b.n.b;
import com.shazam.i.b.o.c.e;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.configuration.ExploreConfiguration;
import com.shazam.model.configuration.location.LocationConfiguration;
import java.util.ArrayList;

// Referenced classes of package com.shazam.android.fragment.explore:
//            e, d, a, g

public final class f extends BaseFragment
    implements com.google.android.gms.maps.c.f, a, com.shazam.android.fragment.explore.e, com.twotoasters.clusterkraf.Clusterkraf.ProcessingListener
{

    private final LocationConfiguration aj;
    private com.shazam.android.fragment.explore.g ak;
    private final l b;
    private final com.shazam.android.persistence.h.d c;
    private MapView d;
    private FakeDeterminateProgressBarView e;
    private com.google.android.gms.maps.c f;
    private android.widget.AbsListView.OnScrollListener g;
    private final com.shazam.android.w.a.b h;
    private final com.shazam.android.i.a i;

    public f()
    {
        Context context = com.shazam.i.b.c.a();
        Object obj = com.shazam.i.b.n.b.b();
        if (!((ExploreConfiguration) (obj)).e())
        {
            obj = new com.shazam.i.b.al.d._cls1();
        } else
        {
            if (d.a == null)
            {
                d.a = new s(com.shazam.i.b.au.a.a(), com.shazam.i.c.b.a(), com.shazam.i.b.ah.f.a(), com.shazam.i.j.a.b(), com.shazam.i.b.au.b.a(), ((ExploreConfiguration) (obj)));
            }
            obj = d.a;
        }
        this(((l) (new com.shazam.android.fragment.explore.d(context, ((com.shazam.model.Provider) (obj)), new com.shazam.android.persistence.h.a(com.shazam.i.b.c.a())))), ((com.shazam.android.persistence.h.d) (new com.shazam.android.persistence.h.c(com.shazam.i.b.ah.f.a()))), ((com.shazam.android.w.a.b) (new com.shazam.android.w.a.a())), ((com.shazam.android.i.a) (new com.shazam.android.i.b(new com.shazam.android.v.b(new com.shazam.android.i.c(new com.shazam.android.widget.image.b.a(com.shazam.i.b.ay.d.a.a.a(), com.shazam.i.b.c.a().getResources(), com.shazam.i.b.ay.d.a.b.a())), new com.shazam.android.widget.e.a(com.shazam.i.b.ay.d.a.a.a()), new k(com.shazam.i.b.n.b.b(), new g(), com.shazam.i.b.ah.f.a()), com.shazam.i.b.a.a().getMemoryClass(), com.shazam.i.b.ay.d.a.b.a(), com.shazam.i.b.c.a().getResources(), com.shazam.i.b.o.c.e.a(), com.shazam.i.b.ay.a.a.b())))), com.shazam.i.b.n.b.Q());
    }

    private f(l l1, com.shazam.android.persistence.h.d d1, com.shazam.android.w.a.b b1, com.shazam.android.i.a a1, LocationConfiguration locationconfiguration)
    {
        b = l1;
        c = d1;
        h = b1;
        i = a1;
        aj = locationconfiguration;
    }

    private void a(int j)
    {
        if (g != null)
        {
            g.onScrollStateChanged(null, j);
        }
    }

    public static Fragment d()
    {
        return new f();
    }

    public final void a(ArrayList arraylist)
    {
        if (f != null)
        {
            i.a(f, arraylist, getActivity(), this);
        }
    }

    public final boolean a()
    {
        if (!com.shazam.b.e.a.c(android.provider.Settings.Secure.getString(getActivity().getContentResolver(), "location_providers_allowed")))
        {
            com.shazam.android.fragment.explore.a.d().a(getActivity().getSupportFragmentManager(), "Dialog");
        } else
        if (f == null || !h.a(f))
        {
            return false;
        }
        return true;
    }

    public final void b(ArrayList arraylist)
    {
        e.a();
        i.a(arraylist);
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.EXPLORE);
    }

    public final void onAttach(Activity activity)
    {
        super.onAttach(activity);
        ak = (com.shazam.android.fragment.explore.g)getParentFragment();
        if (com.google.android.gms.maps.d.a(activity) != 0)
        {
            ak.a();
        } else
        if (activity instanceof android.widget.AbsListView.OnScrollListener)
        {
            g = (android.widget.AbsListView.OnScrollListener)activity;
            return;
        }
    }

    public final void onClusteringFinished()
    {
        if (isResumed())
        {
            a(0);
            e.a();
        }
    }

    public final void onClusteringStarted()
    {
        e.a(2000L);
        a(2);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030047, viewgroup, false));
    }

    public final void onDestroy()
    {
        super.onDestroy();
        (new StringBuilder("Calling onDestroy on MapView:")).append(d).append(" with GoogleMap:").append(f);
        d.a();
        if (f != null)
        {
            f.a(false);
        }
    }

    public final void onLowMemory()
    {
        super.onLowMemory();
        com.google.android.gms.maps.MapView.b b1 = d.a;
        if (((com.google.android.gms.b.b) (b1)).a != null)
        {
            ((com.google.android.gms.b.b) (b1)).a.d();
        }
    }

    public final void onPause()
    {
        super.onPause();
        com.google.android.gms.maps.MapView.b b1 = d.a;
        if (((com.google.android.gms.b.b) (b1)).a != null)
        {
            ((com.google.android.gms.b.b) (b1)).a.b();
        } else
        {
            b1.a(5);
        }
        if (f != null)
        {
            i.a();
            b.a();
            c.a(f);
        }
    }

    public final void onResume()
    {
        super.onResume();
        com.google.android.gms.maps.MapView.b b1 = d.a;
        b1.a(null, new com.google.android.gms.b.b._cls4(b1));
        if (f != null)
        {
            c.b(f);
            b.a(this);
            b.a(getLoaderManager());
            e.a(6000L);
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        com.google.android.gms.maps.MapView.b b1 = d.a;
        if (((com.google.android.gms.b.b) (b1)).a != null)
        {
            ((com.google.android.gms.b.b) (b1)).a.b(bundle);
        } else
        if (((com.google.android.gms.b.b) (b1)).b != null)
        {
            bundle.putAll(((com.google.android.gms.b.b) (b1)).b);
            return;
        }
    }

    public final void onStart()
    {
        super.onStart();
        h.a();
    }

    public final void onStop()
    {
        super.onStop();
        h.b();
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        d = (MapView)view.findViewById(0x7f11014f);
        e = (FakeDeterminateProgressBarView)view.findViewById(0x7f110150);
        view = d;
        com.google.android.gms.maps.MapView.b b1 = ((MapView) (view)).a;
        b1.a(bundle, new com.google.android.gms.b.b._cls2(b1, bundle));
        if (((com.google.android.gms.b.b) (((MapView) (view)).a)).a == null)
        {
            bundle = view.getContext();
            int j = GooglePlayServicesUtil.isGooglePlayServicesAvailable(bundle);
            String s2 = com.google.android.gms.common.internal.i.a(bundle, j, GooglePlayServicesUtil.zzaf(bundle));
            String s1 = com.google.android.gms.common.internal.i.a(bundle, j);
            LinearLayout linearlayout = new LinearLayout(view.getContext());
            linearlayout.setOrientation(1);
            linearlayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            view.addView(linearlayout);
            view = new TextView(view.getContext());
            view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
            view.setText(s2);
            linearlayout.addView(view);
            if (s1 != null)
            {
                view = new Button(bundle);
                view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2));
                view.setText(s1);
                linearlayout.addView(view);
                view.setOnClickListener(new com.google.android.gms.b.b._cls3(bundle, j));
            }
        }
        f = d.getMap();
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        f.a(aj.a());
        view = f;
        if (this == null)
        {
            try
            {
                ((com.google.android.gms.maps.c) (view)).a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                throw new com.google.android.gms.maps.model.d(view);
            }
        }
        ((com.google.android.gms.maps.c) (view)).a.a(new com.google.android.gms.maps.c._cls4(view, this));
        return;
        ak.a();
        return;
    }
}
