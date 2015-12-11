// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.offers.Offer;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYPromoPager;
import hq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kf;
import kh;
import ki;
import ll;
import lu;
import nb;
import ng;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeFragment

public class GHPBannersHomeCard extends BBYBaseFragment
    implements kh, ki
{

    private final String a = com/bestbuy/android/activities/home/GHPBannersHomeCard.getSimpleName();
    private FrameLayout b;
    private LinearLayout c;
    private hq g;
    private FragmentActivity h;
    private LinearLayout i;
    private Fragment j;
    private BBYPromoPager k;
    private View l;
    private ImageView m;
    private int n;

    public GHPBannersHomeCard()
    {
    }

    static int a(GHPBannersHomeCard ghpbannershomecard)
    {
        return ghpbannershomecard.n;
    }

    private String b(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j1 = list.size();
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            stringbuilder.append((String)list.get(i1));
            j1--;
            if (i1 != j1)
            {
                stringbuilder.append("+");
            }
        }

        return stringbuilder.toString();
    }

    private void d()
    {
        g = new hq(h, this, b);
        g.executeOnExecutor(nb.h, new Void[0]);
    }

    public void a(Offer offer, int i1)
    {
        Object obj = new HashMap();
        ((HashMap) (obj)).put("bb.prevPageLink", (new StringBuilder()).append(lu.bi).append(i1).toString());
        lu.b(lu.as, ((HashMap) (obj)));
        obj = offer.getSkus();
        if (((ArrayList) (obj)).size() >= 1)
        {
            offer = new MdotWebFragment();
            String s = getResources().getString(0x7f080071);
            Bundle bundle2 = new Bundle();
            bundle2.putString(s, b(((List) (obj))));
            offer.setArguments(bundle2);
            ((BaseTabContainer)j.getParentFragment()).a(offer, true);
            return;
        }
        if (((ArrayList) (obj)).size() == 1)
        {
            try
            {
                MdotWebFragment mdotwebfragment = new MdotWebFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean("ProductObject", true);
                bundle.putString("SKU", offer.getSku());
                bundle.putString("ProductID", offer.getProductId());
                mdotwebfragment.setArguments(bundle);
                ((BaseTabContainer)j.getParentFragment()).a(mdotwebfragment, true);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Offer offer)
            {
                kf.a(a, offer);
            }
            return;
        } else
        {
            MdotWebFragment mdotwebfragment1 = new MdotWebFragment();
            Bundle bundle1 = new Bundle();
            bundle1.putString("mDotURL", offer.getUrl());
            mdotwebfragment1.setArguments(bundle1);
            ((BaseTabContainer)j.getParentFragment()).a(mdotwebfragment1, true);
            return;
        }
    }

    public void a(List list)
    {
        if (i != null)
        {
            i.setVisibility(0);
        }
        if (list.size() == 1)
        {
            m.setVisibility(0);
            k.setVisibility(8);
            list = (Offer)list.get(0);
            String s = list.getImageUrl();
            if (s != null && s.length() > 0)
            {
                ng.a(s, m, false, null, 0, null);
            }
            m.setOnClickListener(new android.view.View.OnClickListener(list) {

                final Offer a;
                final GHPBannersHomeCard b;

                public void onClick(View view)
                {
                    b.a(a, GHPBannersHomeCard.a(b));
                }

            
            {
                b = GHPBannersHomeCard.this;
                a = offer;
                super();
            }
            });
        } else
        {
            k.a(h, list, null);
            k.setPromoPagerListener(this);
            k.setShowPullDownListener(this);
            m.setVisibility(8);
            k.setVisibility(0);
        }
        b.setVisibility(8);
    }

    public void b()
    {
        if (i != null)
        {
            ll.a(i);
            c.setVisibility(8);
            b.setVisibility(8);
        }
    }

    public void c()
    {
        ((HomeFragment)j).g();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        h = (FragmentActivity)activity;
        j = getParentFragment();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (l == null || l.getVisibility() != 0)
        {
            l = layoutinflater.inflate(0x7f030043, viewgroup, false);
            b = (FrameLayout)l.findViewById(0x7f0c0064);
            c = (LinearLayout)l.findViewById(0x7f0c010a);
            k = (BBYPromoPager)c.findViewById(0x7f0c010b);
            m = (ImageView)l.findViewById(0x7f0c010c);
            i = (LinearLayout)viewgroup;
            d();
        } else
        {
            ((ViewGroup)l.getParent()).removeView(l);
        }
        return l;
    }

    public void onResume()
    {
        super.onResume();
        if (l())
        {
            d();
        }
    }
}
