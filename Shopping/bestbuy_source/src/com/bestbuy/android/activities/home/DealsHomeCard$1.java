// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.util.HashMap;
import java.util.Map;
import kb;
import kt;
import ku;
import lu;
import mw;
import nb;

// Referenced classes of package com.bestbuy.android.activities.home:
//            DealsHomeCard

class a
    implements android.view.ener
{

    final mw a;
    final DealsHomeCard b;

    public void onClick(View view)
    {
        view = new HashMap();
        Object obj;
        if (a.i().equals("Hottest Deals"))
        {
            view.put("bb.prevPageLink", "Best Buy: Deals_Panel 1");
        } else
        if (a.i().equals("GiftIdeas"))
        {
            view.put("bb.prevPageLink", "Best Buy: Deals_Panel 2");
        } else
        if (a.i().equals("BestBuyOutlets"))
        {
            view.put("bb.prevPageLink", "Best Buy: Deals_Panel 3");
        } else
        if (a.i().equals("WeeklyAd"))
        {
            view.put("bb.prevPageLink", "Best Buy: Deals_Panel 4");
        } else
        if (a.i().equals("StudentDeals"))
        {
            view.put("bb.prevPageLink", "Best Buy: Deals_Panel 5");
        }
        lu.b(lu.bh, view);
        obj = ((BBYBaseFragmentActivity)b.d).getCurrentActionBarTitle();
        b.f.i(((String) (obj)));
        if (a.i().equals(b.getString(0x7f08008d)))
        {
            view = nb.a().c();
            if (!view.getBoolean(b.d.getResources().getString(0x7f08008a), false) && !view.getBoolean(b.d.getString(0x7f08004d), false))
            {
                int i = view.getInt(b.d.getString(0x7f080087), 1);
                String s;
                if (i >= 10)
                {
                    (new kt(b.d, ku.b)).a();
                } else
                {
                    view = view.edit();
                    view.putInt(b.d.getString(0x7f080087), i + 1);
                    view.commit();
                }
            }
        }
        if (a.e().equals("bbyWebViewController"))
        {
            view = kb.a("MdotWebFragment");
            obj = new Bundle();
            if (a.i().equals(b.getString(0x7f08008d)) && DealsHomeCard.a(b) != null && !DealsHomeCard.a(b).isEmpty())
            {
                s = (new StringBuilder()).append(a.f()).append("/stores?storeID=").append(DealsHomeCard.a(b)).toString();
                a.f(s);
            }
            ((Bundle) (obj)).putString("mDotURL", a.f());
            view.setArguments(((Bundle) (obj)));
            ((BaseTabContainer)DealsHomeCard.b(b).getParentFragment()).a(view, true);
            return;
        }
        a.e();
        view = "Best-Selling";
        HashMap hashmap = new HashMap();
        PLPFragmentContainer plpfragmentcontainer;
        if (a.i().equals(b.getString(0x7f08012a)))
        {
            hashmap.put(b.getString(0x7f08012c), "New");
            hashmap.put("currentoffers_facet", "Outlet+Items");
            view = "Best-Match";
        } else
        if (a.i().equals(b.getString(0x7f08006c)))
        {
            hashmap.put(b.getString(0x7f08012c), "Open-Box");
            view = "Best-Match";
        } else
        {
            hashmap.put(b.getString(0x7f08012c), a.i());
            hashmap.put("currentoffers_facet", "Outlet+Items");
        }
        plpfragmentcontainer = new PLPFragmentContainer();
        view = new PLPFragment(false, view, hashmap, ((String) (obj)), a.i(), 20);
        ((BaseTabContainer)DealsHomeCard.b(b).getParentFragment()).a(plpfragmentcontainer, true);
        plpfragmentcontainer.a(view, true);
    }

    Fragment(DealsHomeCard dealshomecard, mw mw1)
    {
        b = dealshomecard;
        a = mw1;
        super();
    }
}
