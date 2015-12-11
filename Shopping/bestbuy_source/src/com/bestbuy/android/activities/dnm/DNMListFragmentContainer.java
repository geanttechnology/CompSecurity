// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import ahr;
import ahx;
import ahy;
import android.app.Activity;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import kf;
import nb;
import pp;
import qm;
import qn;
import qo;
import qp;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMListFragment, DNMSearchFragment

public class DNMListFragmentContainer extends BaseFragmentContainer
    implements ahx, qo, qp
{

    private static final String a = com/bestbuy/android/activities/dnm/DNMListFragmentContainer.getSimpleName();
    private Activity b;
    private String c;
    private nb g;
    private BBYStore h;
    private qm i;
    private View j;
    private View k;
    private boolean l;

    public DNMListFragmentContainer()
    {
        j = null;
        k = null;
        l = false;
    }

    public DNMListFragmentContainer(String s, BBYStore bbystore)
    {
        j = null;
        k = null;
        l = false;
        c = s;
        h = bbystore;
    }

    static qm a(DNMListFragmentContainer dnmlistfragmentcontainer)
    {
        return dnmlistfragmentcontainer.i;
    }

    static qm a(DNMListFragmentContainer dnmlistfragmentcontainer, qm qm1)
    {
        dnmlistfragmentcontainer.i = qm1;
        return qm1;
    }

    static boolean a(DNMListFragmentContainer dnmlistfragmentcontainer, boolean flag)
    {
        dnmlistfragmentcontainer.l = flag;
        return flag;
    }

    private void f()
    {
        if (h == null)
        {
            a(new DNMListFragment(getString(0x7f080156), g.y(), g.z(), c), true);
            return;
        } else
        {
            a(new DNMListFragment((new StringBuilder()).append(h.getStoreDetails().getName()).append(" Store").toString(), h.getStoreId(), c), true);
            return;
        }
    }

    private boolean g()
    {
        return ((LocationManager)b.getSystemService("location")).isProviderEnabled("gps");
    }

    public Fragment b()
    {
        if (getChildFragmentManager() != null)
        {
            return getChildFragmentManager().findFragmentById(0x7f0c009e);
        } else
        {
            return null;
        }
    }

    public void c()
    {
        if (g())
        {
            f();
            return;
        } else
        {
            a(new DNMSearchFragment(c), true);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        g.h(true);
        if (c != null && c.equals(getString(0x7f08006c)))
        {
            bundle = getResources().getString(0x7f08028d);
        } else
        {
            bundle = getResources().getString(0x7f080129);
        }
        ((HomeActivity)b).updateSearchHint(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b = activity;
        g = nb.a();
        (new Handler()).post(new Runnable(activity) {

            final Activity a;
            final DNMListFragmentContainer b;

            public void run()
            {
                DNMListFragmentContainer.a(b, (new qn(a)).a(ahy.a).a(b).a(b).b());
                DNMListFragmentContainer.a(b).b();
                DNMListFragmentContainer.a(b, true);
            }

            
            {
                b = DNMListFragmentContainer.this;
                a = activity;
                super();
            }
        });
    }

    public void onConnected(Bundle bundle)
    {
        l = false;
        j.setVisibility(8);
        k.setVisibility(0);
        ahy.b.a(i, BBYBaseFragmentActivity.REQUEST, this);
    }

    public void onConnectionFailed(pp pp1)
    {
        l = false;
        j.setVisibility(8);
        k.setVisibility(0);
        if (pp1.a())
        {
            try
            {
                pp1.a(b, 9000);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (pp pp1)
            {
                pp1.printStackTrace();
            }
            return;
        } else
        {
            kf.b(a, (new StringBuilder()).append("Location services connection failed with code ").append(pp1.c()).toString());
            return;
        }
    }

    public void onConnectionSuspended(int i1)
    {
        kf.b(a, (new StringBuilder()).append("Location services suspended cause:  ").append(i1).toString());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03002e, viewgroup, false);
        j = layoutinflater.findViewById(0x7f0c0064);
        k = layoutinflater.findViewById(0x7f0c009e);
        if (l)
        {
            k.setVisibility(8);
            j.setVisibility(0);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        g.h(false);
        String s = getResources().getString(0x7f0802ef);
        ((HomeActivity)b).updateSearchHint(s);
        ((BBYBaseFragmentActivity)b).showActionBarHome();
        ((BBYBaseFragmentActivity)b).updateActionBarTitle(g.T());
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (i.d())
        {
            i.c();
        }
    }

    public void onLocationChanged(Location location)
    {
        l = false;
        j.setVisibility(8);
        k.setVisibility(0);
        if (location != null)
        {
            g.a(location.getLatitude());
            g.b(location.getLongitude());
            if (i.d())
            {
                ahy.b.a(i, this);
            }
            c();
        }
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)b).hideActionBarHome();
        if (!g())
        {
            a(new DNMSearchFragment(c), true);
        }
    }

    public void onStart()
    {
        super.onStart();
    }

}
