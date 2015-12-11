// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cw;
import java.util.ArrayList;
import lu;

public class RecommendationsFragment extends BBYBaseFragment
{

    private ArrayList a;
    private ArrayList b;
    private boolean c;
    private LinearLayout g;
    private ListView h;
    private View i;
    private cw j;
    private String k;
    private Fragment l;

    public RecommendationsFragment(boolean flag, ArrayList arraylist, ArrayList arraylist1)
    {
        c = flag;
        a = arraylist;
        b = arraylist1;
    }

    static String a(RecommendationsFragment recommendationsfragment, String s)
    {
        recommendationsfragment.k = s;
        return s;
    }

    static ArrayList a(RecommendationsFragment recommendationsfragment)
    {
        return recommendationsfragment.b;
    }

    static String b(RecommendationsFragment recommendationsfragment)
    {
        return recommendationsfragment.k;
    }

    static ArrayList c(RecommendationsFragment recommendationsfragment)
    {
        return recommendationsfragment.a;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        lu.a((new StringBuilder()).append(lu.aA).append(": Promotions").toString());
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        l = getParentFragment();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300e0, viewgroup, false);
        g = (LinearLayout)layoutinflater.findViewById(0x7f0c0364);
        i = layoutinflater.findViewById(0x7f0c0064);
        h = (ListView)layoutinflater.findViewById(0x7f0c0365);
        j = new cw(d, 0, a);
        h.setAdapter(j);
        h.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RecommendationsFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                RecommendationsFragment.a(a, (String)RecommendationsFragment.a(a).get(i1));
                adapterview = new PLPFragment(true, RecommendationsFragment.b(a), (String)RecommendationsFragment.c(a).get(i1), 50);
                ((BaseFragmentContainer)a.getParentFragment()).a(adapterview, true);
            }

            
            {
                a = RecommendationsFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, false);
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("Promotions");
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
    }
}
