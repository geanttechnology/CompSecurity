// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import bu;
import com.bestbuy.android.activities.plpstoreavailability.PLPStoreSelectionActivity;
import com.bestbuy.android.base.BBYBaseFragment;
import ea;
import java.util.ArrayList;

public class BlueAssistStoreListFragment extends BBYBaseFragment
{

    private ListView a;
    private ea b;
    private ArrayList c;
    private View g;
    private bu h;
    private boolean i;
    private Activity j;
    private int k;
    private boolean l;
    private android.widget.AbsListView.OnScrollListener m = new android.widget.AbsListView.OnScrollListener() {

        final BlueAssistStoreListFragment a;

        public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
        {
            if (BlueAssistStoreListFragment.a(a))
            {
                BlueAssistStoreListFragment.d(a).a(i1, j1, k1, BlueAssistStoreListFragment.b(a), BlueAssistStoreListFragment.c(a));
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i1)
        {
            BlueAssistStoreListFragment.a(a, true);
        }

            
            {
                a = BlueAssistStoreListFragment.this;
                super();
            }
    };

    public BlueAssistStoreListFragment(Activity activity)
    {
        c = new ArrayList();
        i = false;
        k = 0;
        l = true;
        j = activity;
    }

    public BlueAssistStoreListFragment(Activity activity, ArrayList arraylist)
    {
        c = new ArrayList();
        i = false;
        k = 0;
        l = true;
        j = activity;
        c.addAll(arraylist);
    }

    static boolean a(BlueAssistStoreListFragment blueassiststorelistfragment)
    {
        return blueassiststorelistfragment.i;
    }

    static boolean a(BlueAssistStoreListFragment blueassiststorelistfragment, boolean flag)
    {
        blueassiststorelistfragment.i = flag;
        return flag;
    }

    static boolean b(BlueAssistStoreListFragment blueassiststorelistfragment)
    {
        return blueassiststorelistfragment.l;
    }

    static int c(BlueAssistStoreListFragment blueassiststorelistfragment)
    {
        return blueassiststorelistfragment.k;
    }

    static bu d(BlueAssistStoreListFragment blueassiststorelistfragment)
    {
        return blueassiststorelistfragment.h;
    }

    public void a(Activity activity, ArrayList arraylist, int i1, boolean flag)
    {
        if (i1 <= 1)
        {
            c.clear();
            a.removeFooterView(g);
        }
        c.addAll(arraylist);
        if (i1 <= 1)
        {
            l = true;
            k = 0;
            g = activity.getLayoutInflater().inflate(0x7f0300fc, null);
            a.addFooterView(g, null, false);
            if (activity instanceof PLPStoreSelectionActivity)
            {
                b = new ea(activity, c, true, false, false);
            } else
            {
                b = new ea(activity, c, true, false, true);
            }
            a.setAdapter(b);
        } else
        {
            b.notifyDataSetChanged();
        }
        if (!flag)
        {
            a.removeFooterView(g);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof PLPStoreSelectionActivity)
        {
            h = (bu)activity;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003e, viewgroup, false);
        a = (ListView)layoutinflater.findViewById(0x7f0c0106);
        if (j instanceof PLPStoreSelectionActivity)
        {
            b = new ea(j, c, true, false, false);
            a.setOnScrollListener(m);
        } else
        {
            b = new ea(j, c, true, false, true);
        }
        a.setAdapter(b);
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
    }
}
