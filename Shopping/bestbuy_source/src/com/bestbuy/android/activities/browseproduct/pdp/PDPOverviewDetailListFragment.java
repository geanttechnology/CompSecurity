// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Names;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import ek;
import fd;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            StickyGroupExpandableListView

public class PDPOverviewDetailListFragment extends BBYBaseFragment
{

    private Activity a;
    private OverviewResponse b;
    private View c;
    private StickyGroupExpandableListView g;
    private ek h;
    private int i;
    private ArrayList j;

    public PDPOverviewDetailListFragment()
    {
    }

    public PDPOverviewDetailListFragment(int k, OverviewResponse overviewresponse, ArrayList arraylist)
    {
        b = overviewresponse;
        i = k;
        j = arraylist;
    }

    public ek b()
    {
        return h;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
        h = new ek(this, g, a, b, j);
        bundle = new fd(h);
        g.setAdapter(bundle);
        g.expandGroup(i);
        g.setSelectedGroup(i);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
        ((BBYBaseFragmentActivity)activity).updateOverviewActionBarTitle(b.getNames().getShortName(), 15);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = layoutinflater.inflate(0x7f0300a4, viewgroup, false);
        g = (StickyGroupExpandableListView)c.findViewById(0x7f0c0256);
        return c;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, true);
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).updateOverviewActionBarTitle(b.getNames().getShortName(), 15);
    }
}
