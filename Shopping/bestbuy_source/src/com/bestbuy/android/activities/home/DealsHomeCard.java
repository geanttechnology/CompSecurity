// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kb;
import kf;
import kt;
import ku;
import lu;
import mw;
import mx;
import my;
import nb;
import nc;

public class DealsHomeCard extends BBYBaseFragment
{

    private static final String a = com/bestbuy/android/activities/home/DealsHomeCard.getSimpleName();
    private Fragment b;
    private boolean c;
    private String g;

    public DealsHomeCard()
    {
        c = false;
    }

    static String a(DealsHomeCard dealshomecard)
    {
        return dealshomecard.g;
    }

    static Fragment b(DealsHomeCard dealshomecard)
    {
        return dealshomecard.b;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        b = getParentFragment();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Object obj;
        viewgroup = layoutinflater.inflate(0x7f03004e, viewgroup, false);
        bundle = (LinearLayout)viewgroup.findViewById(0x7f0c011d);
        obj = new nc();
        obj = new my(((nc) (obj)).a(d, nb.e, nb.d[2]), "Dealcards");
        if (obj == null) goto _L2; else goto _L1
_L1:
        View view = new View(viewgroup.getContext());
        view.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(10, 1));
        bundle.addView(view);
        int i = 0;
_L11:
        if (i >= ((my) (obj)).a().size()) goto _L2; else goto _L3
_L3:
        Iterator iterator = ((mx)((my) (obj)).a().get(i)).b().iterator();
_L7:
        if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
        Object obj1 = (mw)iterator.next();
        if (c && (((mw) (obj1)).i().equals(getString(0x7f080077)) || ((mw) (obj1)).i().equals(getString(0x7f080075))) || !c && ((mw) (obj1)).i().equals(getString(0x7f08008e))) goto _L7; else goto _L6
_L6:
        LinearLayout linearlayout;
        Object obj2;
        int j;
        linearlayout = (LinearLayout)layoutinflater.inflate(0x7f03004f, null);
        obj2 = (ImageView)linearlayout.findViewById(0x7f0c011f);
        j = getResources().getIdentifier(((mw) (obj1)).c(), "drawable", viewgroup.getContext().getPackageName());
        if (j != 0) goto _L9; else goto _L8
_L8:
        kf.e(a, (new StringBuilder()).append("Attempting to add image that does not exist: ").append(((mw) (obj1)).c()).toString());
          goto _L7
        layoutinflater;
        kf.e(a, (new StringBuilder()).append("Error attempting to load & display deals cards: ").append(layoutinflater.getLocalizedMessage()).toString());
_L2:
        return viewgroup;
_L9:
        ((ImageView) (obj2)).setBackgroundResource(j);
        ((ImageView) (obj2)).setFocusable(false);
        obj2 = ((mw) (obj1)).a();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        if (!((String) (obj2)).isEmpty())
        {
            linearlayout.setContentDescription(((CharSequence) (obj2)));
        }
        linearlayout.setOnClickListener(new android.view.View.OnClickListener(((mw) (obj1))) {

            final mw a;
            final DealsHomeCard b;

            public void onClick(View view1)
            {
                view1 = new HashMap();
                Object obj3;
                if (a.i().equals("Hottest Deals"))
                {
                    view1.put("bb.prevPageLink", "Best Buy: Deals_Panel 1");
                } else
                if (a.i().equals("GiftIdeas"))
                {
                    view1.put("bb.prevPageLink", "Best Buy: Deals_Panel 2");
                } else
                if (a.i().equals("BestBuyOutlets"))
                {
                    view1.put("bb.prevPageLink", "Best Buy: Deals_Panel 3");
                } else
                if (a.i().equals("WeeklyAd"))
                {
                    view1.put("bb.prevPageLink", "Best Buy: Deals_Panel 4");
                } else
                if (a.i().equals("StudentDeals"))
                {
                    view1.put("bb.prevPageLink", "Best Buy: Deals_Panel 5");
                }
                lu.b(lu.bh, view1);
                obj3 = ((BBYBaseFragmentActivity)b.d).getCurrentActionBarTitle();
                b.f.i(((String) (obj3)));
                if (a.i().equals(b.getString(0x7f08008d)))
                {
                    view1 = nb.a().c();
                    if (!view1.getBoolean(b.d.getResources().getString(0x7f08008a), false) && !view1.getBoolean(b.d.getString(0x7f08004d), false))
                    {
                        int k = view1.getInt(b.d.getString(0x7f080087), 1);
                        String s;
                        if (k >= 10)
                        {
                            (new kt(b.d, ku.b)).a();
                        } else
                        {
                            view1 = view1.edit();
                            view1.putInt(b.d.getString(0x7f080087), k + 1);
                            view1.commit();
                        }
                    }
                }
                if (a.e().equals("bbyWebViewController"))
                {
                    view1 = kb.a("MdotWebFragment");
                    obj3 = new Bundle();
                    if (a.i().equals(b.getString(0x7f08008d)) && DealsHomeCard.a(b) != null && !DealsHomeCard.a(b).isEmpty())
                    {
                        s = (new StringBuilder()).append(a.f()).append("/stores?storeID=").append(DealsHomeCard.a(b)).toString();
                        a.f(s);
                    }
                    ((Bundle) (obj3)).putString("mDotURL", a.f());
                    view1.setArguments(((Bundle) (obj3)));
                    ((BaseTabContainer)DealsHomeCard.b(b).getParentFragment()).a(view1, true);
                    return;
                }
                a.e();
                view1 = "Best-Selling";
                HashMap hashmap = new HashMap();
                PLPFragmentContainer plpfragmentcontainer;
                if (a.i().equals(b.getString(0x7f08012a)))
                {
                    hashmap.put(b.getString(0x7f08012c), "New");
                    hashmap.put("currentoffers_facet", "Outlet+Items");
                    view1 = "Best-Match";
                } else
                if (a.i().equals(b.getString(0x7f08006c)))
                {
                    hashmap.put(b.getString(0x7f08012c), "Open-Box");
                    view1 = "Best-Match";
                } else
                {
                    hashmap.put(b.getString(0x7f08012c), a.i());
                    hashmap.put("currentoffers_facet", "Outlet+Items");
                }
                plpfragmentcontainer = new PLPFragmentContainer();
                view1 = new PLPFragment(false, view1, hashmap, ((String) (obj3)), a.i(), 20);
                ((BaseTabContainer)DealsHomeCard.b(b).getParentFragment()).a(plpfragmentcontainer, true);
                plpfragmentcontainer.a(view1, true);
            }

            
            {
                b = DealsHomeCard.this;
                a = mw1;
                super();
            }
        });
        bundle.addView(linearlayout);
        obj1 = new View(viewgroup.getContext());
        ((View) (obj1)).setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)getResources().getDimension(0x7f090001), (int)getResources().getDimension(0x7f090002)));
        bundle.addView(((View) (obj1)));
          goto _L7
_L5:
        i++;
        if (true) goto _L11; else goto _L10
_L10:
    }

}
