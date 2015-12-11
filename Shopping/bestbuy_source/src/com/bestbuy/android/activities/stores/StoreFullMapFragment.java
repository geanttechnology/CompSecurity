// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import ail;
import aim;
import aiq;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ani;
import ank;
import com.bestbuy.android.api.lib.models.remix.Store;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.MapBaseFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;

public class StoreFullMapFragment extends BBYBaseFragment
    implements aiq
{

    private View a;
    private aim b;
    private MapBaseFragment c;
    private ArrayList g;
    private ank h;

    public StoreFullMapFragment()
    {
        g = new ArrayList();
    }

    private void b()
    {
        if (b == null)
        {
            c = MapBaseFragment.a(this);
            FragmentTransaction fragmenttransaction = getChildFragmentManager().beginTransaction();
            fragmenttransaction.add(0x7f0c0107, c);
            fragmenttransaction.commit();
        }
    }

    public boolean a(ank ank1)
    {
        if (!ank1.equals(h))
        {
            ank1.a(ani.a(0x7f020183));
            h.a(ani.a(0x7f0201a6));
            h = ank1;
        }
        return false;
    }

    public void b_()
    {
        b = c.b();
        b.a(this);
        if (b != null)
        {
            int i = 0;
            while (i < 10) 
            {
                Object obj = (Store)g.get(i);
                obj = new LatLng(((Store) (obj)).getLat(), ((Store) (obj)).getLng());
                if (i == 0)
                {
                    b.a(ail.a(((LatLng) (obj)), 10F));
                    h = b.a((new MarkerOptions()).a(((LatLng) (obj))).a(ani.a(0x7f020183)));
                } else
                {
                    b.a((new MarkerOptions()).a(((LatLng) (obj))).a(ani.a(0x7f0201a6)));
                }
                i++;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f0300fb, viewgroup, false);
        g = getArguments().getParcelableArrayList("STORE_LIST");
        b();
        return a;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }
}
