// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.offers.Offer;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYLEPromoPager;
import hp;
import java.util.List;
import ke;
import ll;
import nb;
import ng;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WebWrapperContainer

public class LEBannerHomeCard extends BBYBaseFragment
    implements ke
{

    private FrameLayout a;
    private FrameLayout b;
    private hp c;
    private LinearLayout g;
    private BBYLEPromoPager h;
    private View i;
    private ImageView j;

    public LEBannerHomeCard()
    {
    }

    private void c()
    {
        c = new hp(d, this, a);
        c.executeOnExecutor(nb.h, new Void[0]);
    }

    public void a(Offer offer)
    {
        offer = new WebWrapperContainer(offer);
        FragmentTransaction fragmenttransaction = ((HomeActivity)d).getSupportFragmentManager().beginTransaction();
        fragmenttransaction.add(0x7f0c0033, offer, "WebWrapperContainer");
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();
    }

    public void a(List list)
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
        if (list.size() == 1)
        {
            j.setVisibility(0);
            h.setVisibility(8);
            list = (Offer)list.get(0);
            String s = list.getImageUrl();
            if (s != null && s.length() > 0)
            {
                ng.a(s, j, false);
            }
            j.setOnClickListener(new android.view.View.OnClickListener(list) {

                final Offer a;
                final LEBannerHomeCard b;

                public void onClick(View view)
                {
                    b.a(a);
                }

            
            {
                b = LEBannerHomeCard.this;
                a = offer;
                super();
            }
            });
        } else
        {
            h.a(d, list, null);
            h.setPromoPagerListener(this);
            j.setVisibility(8);
            h.setVisibility(0);
        }
        a.setVisibility(8);
    }

    public void b()
    {
        if (g != null)
        {
            ll.a(g);
            b.setVisibility(8);
            a.setVisibility(8);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (i == null || i.getVisibility() != 0)
        {
            i = layoutinflater.inflate(0x7f03005e, viewgroup, false);
            a = (FrameLayout)i.findViewById(0x7f0c0064);
            b = (FrameLayout)i.findViewById(0x7f0c010a);
            h = (BBYLEPromoPager)b.findViewById(0x7f0c010b);
            j = (ImageView)i.findViewById(0x7f0c010c);
            g = (LinearLayout)viewgroup;
            c();
        } else
        {
            ((ViewGroup)i.getParent()).removeView(i);
        }
        return i;
    }

    public void onResume()
    {
        super.onResume();
        if (l())
        {
            c();
        }
    }
}
