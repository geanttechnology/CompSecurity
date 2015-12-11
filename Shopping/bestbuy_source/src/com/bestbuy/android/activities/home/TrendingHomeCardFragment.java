// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.api.lib.models.home.Recommendation;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import dy;
import gu;
import hn;
import java.util.ArrayList;
import ll;
import nb;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity, HomeTabFragment

public class TrendingHomeCardFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private hn a;
    private Activity b;
    private BBYProductViewPager c;
    private LinearLayout g;
    private View h;
    private View i;
    private View j;
    private dy k;
    private Recommendation l;

    public TrendingHomeCardFragment()
    {
    }

    public void a(gu gu)
    {
        l = (Recommendation)gu;
    }

    public void a(ArrayList arraylist)
    {
        k = new dy(b, arraylist, getParentFragment(), true, "GHP");
        c.setAdapter(k);
        c.startAnimation(ll.a(b));
        if (arraylist.size() == 1)
        {
            c.setPagingEnabled(false);
        }
        ((HomeActivity)b).loadTrendingNowRecommendations("GHP", "homeloadtrendingnow", arraylist);
    }

    public void b()
    {
        if (j != null)
        {
            ll.a(j);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b = activity;
    }

    public void onClick(View view)
    {
        if (view == g)
        {
            view = new PLPFragmentContainer();
            PLPFragment plpfragment = new PLPFragment(true, "Trending", "Trending Now", "all", null, "Home", 10);
            android.support.v4.app.Fragment fragment = ((FragmentActivity)b).getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (fragment instanceof HomeTabFragment)
            {
                ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(view, true);
                view.a(plpfragment, true);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (i == null || i.getVisibility() != 0)
        {
            j = viewgroup;
            i = layoutinflater.inflate(0x7f03010e, viewgroup, false);
            h = i.findViewById(0x7f0c0064);
            c = (BBYProductViewPager)i.findViewById(0x7f0c005e);
            c.setPageMargin(15);
            g = (LinearLayout)i.findViewById(0x7f0c0073);
            g.setOnClickListener(this);
            a = new hn(b, this, h, l);
            a.executeOnExecutor(nb.h, new Void[0]);
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
            a = new hn(b, this, h);
            a.executeOnExecutor(nb.h, new Void[0]);
        }
        if (k != null)
        {
            k.notifyDataSetChanged();
        }
    }
}
