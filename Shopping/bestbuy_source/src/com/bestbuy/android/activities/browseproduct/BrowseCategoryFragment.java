// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.browse.Category;
import com.bestbuy.android.api.lib.models.browse.UberCategoryList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import dy;
import ed;
import hg;
import ii;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ll;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct:
//            BrowseSuperSubCategoryFragment

public class BrowseCategoryFragment extends BBYBaseFragment
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener
{

    public LinearLayout a;
    private UberCategoryList b;
    private ed c;
    private BBYProductViewPager g;
    private LinearLayout h;
    private hg i;
    private ii j;
    private Activity k;
    private View l;
    private View m;
    private ListView n;
    private boolean o;
    private boolean p;
    private boolean q;
    private dy r;
    private String s;
    private CustomSwipeToRefresh t;
    private boolean u;

    public BrowseCategoryFragment()
    {
        o = false;
        p = false;
        q = false;
    }

    public BrowseCategoryFragment(boolean flag)
    {
        o = false;
        p = false;
        q = false;
        q = flag;
    }

    static UberCategoryList a(BrowseCategoryFragment browsecategoryfragment)
    {
        return browsecategoryfragment.b;
    }

    static String a(BrowseCategoryFragment browsecategoryfragment, String s1)
    {
        browsecategoryfragment.s = s1;
        return s1;
    }

    static String b(BrowseCategoryFragment browsecategoryfragment)
    {
        return browsecategoryfragment.s;
    }

    static boolean c(BrowseCategoryFragment browsecategoryfragment)
    {
        return browsecategoryfragment.q;
    }

    static Activity d(BrowseCategoryFragment browsecategoryfragment)
    {
        return browsecategoryfragment.k;
    }

    static CustomSwipeToRefresh e(BrowseCategoryFragment browsecategoryfragment)
    {
        return browsecategoryfragment.t;
    }

    private void e()
    {
        for (int i1 = 0; i1 < b.getHeader().size(); i1++)
        {
            Category category = (Category)b.getHeader().get(i1);
        }

    }

    public void a(UberCategoryList ubercategorylist)
    {
        if (o)
        {
            o = false;
            m.setVisibility(8);
        } else
        {
            p = true;
        }
        b = ubercategorylist;
        a(l).setVisibility(8);
        if (ubercategorylist != null && !ubercategorylist.getHeader().isEmpty())
        {
            e();
            c = new ed(k, 0, ubercategorylist.getHeader());
            n.setAdapter(c);
        }
    }

    public void a(ArrayList arraylist)
    {
        a.setVisibility(0);
        g.setVisibility(0);
        if (p)
        {
            p = false;
            m.setVisibility(8);
        } else
        {
            o = true;
        }
        r = new dy(k, arraylist, this, true, "product");
        g.setAdapter(r);
        g.startAnimation(ll.a(k));
        if (arraylist.size() == 1)
        {
            g.setPagingEnabled(false);
        }
        g.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final BrowseCategoryFragment a;

            public void onPageScrollStateChanged(int i1)
            {
                if (i1 == 0)
                {
                    a.c();
                } else
                if (i1 == 1)
                {
                    a.d();
                    return;
                }
            }

            public void onPageScrolled(int i1, float f, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
            }

            
            {
                a = BrowseCategoryFragment.this;
                super();
            }
        });
        ((HomeActivity)k).loadMostPopularRecommendations("product", "productsloadmostpopular", arraylist);
    }

    public void b()
    {
        if (a != null && !q)
        {
            ll.a(a);
        }
    }

    public void c()
    {
        t.setEnabled(true);
    }

    public void d()
    {
        t.setEnabled(false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!q)
        {
            ((BBYBaseFragmentActivity)k).showActionBarHome();
            a.setVisibility(0);
        } else
        {
            ((BBYBaseFragmentActivity)k).hideActionBarHomeAndSearchBox(k);
        }
        if (i.isCancelled() && !q)
        {
            i.d();
        }
        if (j.isCancelled())
        {
            j.d();
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        k = activity;
    }

    public void onClick(View view)
    {
        if (view == h)
        {
            view = new PLPFragmentContainer();
            PLPFragment plpfragment = new PLPFragment(true, "MostPopular", "Most Popular", "all", null, "Products", 10);
            ((BaseTabContainer)getParentFragment()).a(view, true);
            view.a(plpfragment, true);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (l == null)
        {
            l = layoutinflater.inflate(0x7f030016, viewgroup, false);
            layoutinflater = layoutinflater.inflate(0x7f030019, n, false);
            g = (BBYProductViewPager)layoutinflater.findViewById(0x7f0c0074);
            a = (LinearLayout)layoutinflater.findViewById(0x7f0c0071);
            g.setPageMargin(15);
            m = l.findViewById(0x7f0c0064);
            n = (ListView)l.findViewById(0x102000a);
            n.addHeaderView(layoutinflater);
            layoutinflater = new View(k);
            layoutinflater.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, 3));
            layoutinflater.setBackgroundResource(0x7f0b0008);
            n.addHeaderView(layoutinflater);
            layoutinflater = new View(k);
            layoutinflater.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, 1));
            layoutinflater.setBackgroundResource(0x7f0b0008);
            n.addFooterView(layoutinflater);
            h = (LinearLayout)l.findViewById(0x7f0c0073);
            h.setOnClickListener(this);
            t = (CustomSwipeToRefresh)l.findViewById(0x7f0c006e);
            t.setColorScheme(0x7f0b0000, 0x7f0b0063, 0x7f0b0000, 0x7f0b0063);
            t.setOnRefreshListener(this);
            u = ChatRunningStatus.getChatRunning();
            if (!u)
            {
                c();
            } else
            {
                d();
            }
            i = new hg(k, this, null, "all", null, 1, 10, false);
            if (q)
            {
                a.setVisibility(8);
            } else
            {
                i.executeOnExecutor(nb.h, new Void[0]);
            }
            j = new ii(k, this, m);
            j.executeOnExecutor(nb.h, new Void[0]);
        } else
        {
            ((ViewGroup)l.getParent()).removeView(l);
        }
        n.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BrowseCategoryFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                Category category;
                category = (Category)BrowseCategoryFragment.a(a).getHeader().get(i1 - 2);
                BrowseCategoryFragment.a(a, category.getName());
                adapterview = new HashMap();
                adapterview.put(lu.bo, "browse,deptCat");
                adapterview.put(lu.bp, "PRD");
                lu.b(BrowseCategoryFragment.b(a), adapterview);
                if (category.getWidgetType().equalsIgnoreCase("group")) goto _L2; else goto _L1
_L1:
                if (category.getGroups() == null || category.getGroups().size() <= 0) goto _L4; else goto _L3
_L3:
                adapterview = new BrowseSuperSubCategoryFragment(category, BrowseCategoryFragment.c(a));
                if (a.getParentFragment() == null) goto _L6; else goto _L5
_L5:
                if (!(a.getParentFragment() instanceof BaseTabContainer)) goto _L8; else goto _L7
_L7:
                ((BaseTabContainer)a.getParentFragment()).a(adapterview, true);
_L2:
                return;
_L8:
                ((BaseFragmentContainer)a.getParentFragment()).a(adapterview, true);
                return;
_L6:
                ((HomeActivity)BrowseCategoryFragment.d(a)).addFragment(0x7f0c0033, adapterview, "BrowseSuperSubCategoryFragment");
                return;
_L4:
                adapterview = category.getSearchPath();
                if (adapterview != null && !adapterview.isEmpty())
                {
                    view = adapterview.substring(adapterview.indexOf("query")).replace("query=", "");
                    adapterview = view;
                    if (view.contains("="))
                    {
                        adapterview = view.split("=")[0];
                    }
                    view = new PLPFragment(category.getName(), adapterview, true, category.getName());
                    if (a.getParentFragment() != null)
                    {
                        if (a.getParentFragment() instanceof BaseTabContainer)
                        {
                            adapterview = new PLPFragmentContainer();
                            ((BaseTabContainer)a.getParentFragment()).a(adapterview, true);
                        } else
                        {
                            adapterview = new PLPFragmentContainer(true);
                            view.b(true);
                            ((HomeActivity)BrowseCategoryFragment.d(a)).addFragment(0x7f0c0033, adapterview, "PLPFragmentContainer");
                        }
                        adapterview.a(view, true);
                        return;
                    } else
                    {
                        ((HomeActivity)BrowseCategoryFragment.d(a)).addFragment(0x7f0c0033, view, "PLPFragment");
                        return;
                    }
                }
                if (true) goto _L2; else goto _L9
_L9:
            }

            
            {
                a = BrowseCategoryFragment.this;
                super();
            }
        });
        return l;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        if (m.getVisibility() == 0)
        {
            m.setVisibility(8);
        }
        i.cancel(true);
        j.cancel(true);
    }

    public void onRefresh()
    {
        d();
        (new Handler()).postDelayed(new Runnable() {

            final BrowseCategoryFragment a;

            public void run()
            {
                BrowseCategoryFragment.e(a).setRefreshing(false);
                if (a.getActivity() != null)
                {
                    Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
                    HashMap hashmap = new HashMap();
                    if (BrowseCategoryFragment.c(a))
                    {
                        hashmap.put("bb.prevPageLink", "Wish list page: Blue Assist");
                    } else
                    {
                        hashmap.put("bb.prevPageLink", "Products Tab: Blue Assist");
                    }
                    lu.b(lu.aT, hashmap);
                    a.startActivityForResult(intent, 8998);
                }
            }

            
            {
                a = BrowseCategoryFragment.this;
                super();
            }
        }, 1500L);
    }

    public void onResume()
    {
        super.onResume();
        u = ChatRunningStatus.getChatRunning();
        if (!u)
        {
            c();
        } else
        {
            d();
        }
        ((BBYBaseFragmentActivity)k).updateActionBarTitle("Products");
        if (l())
        {
            i = new hg(k, this, null, "all", null, 1, 10, false);
            if (q)
            {
                a.setVisibility(8);
            } else
            {
                i.executeOnExecutor(nb.h, new Void[0]);
            }
            j = new ii(k, this, m);
            j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        if (r != null)
        {
            r.notifyDataSetChanged();
        }
    }
}
