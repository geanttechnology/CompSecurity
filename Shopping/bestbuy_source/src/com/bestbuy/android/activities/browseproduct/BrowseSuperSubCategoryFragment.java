// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.browse.Category;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import dy;
import ed;
import hg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ll;
import lu;
import nb;

public class BrowseSuperSubCategoryFragment extends BBYBaseFragment
    implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener
{

    public LinearLayout a;
    private List b;
    private ed c;
    private BBYProductViewPager g;
    private LinearLayout h;
    private hg i;
    private String j;
    private String k;
    private View l;
    private View m;
    private boolean n;
    private boolean o;
    private String p;
    private ListView q;
    private boolean r;
    private dy s;
    private String t;
    private CustomSwipeToRefresh u;
    private boolean v;

    public BrowseSuperSubCategoryFragment()
    {
        n = false;
        o = false;
        p = "";
        r = false;
    }

    public BrowseSuperSubCategoryFragment(Category category, boolean flag)
    {
        n = false;
        o = false;
        p = "";
        r = false;
        j = category.getCategoryId();
        k = category.getName();
        b = category.getGroups();
        r = flag;
    }

    static List a(BrowseSuperSubCategoryFragment browsesupersubcategoryfragment)
    {
        return browsesupersubcategoryfragment.b;
    }

    static CustomSwipeToRefresh b(BrowseSuperSubCategoryFragment browsesupersubcategoryfragment)
    {
        return browsesupersubcategoryfragment.u;
    }

    static boolean c(BrowseSuperSubCategoryFragment browsesupersubcategoryfragment)
    {
        return browsesupersubcategoryfragment.r;
    }

    private void e()
    {
        for (int i1 = 0; i1 < b.size(); i1++)
        {
            Category category = (Category)b.get(i1);
        }

    }

    public void a(Category category)
    {
        p = category.getName();
        Bundle bundle = getArguments();
        HashMap hashmap = new HashMap();
        if (bundle != null)
        {
            boolean flag;
            boolean flag1;
            if (bundle.getString("BaseCategory", "").isEmpty())
            {
                t = (new StringBuilder()).append(k).append(": ").append(p).toString();
            } else
            {
                t = (new StringBuilder()).append(bundle.getString("BaseCategory", "")).append(": ").append(k).append(": ").append(p).toString();
            }
            bundle.putString("BreadCrumb", t);
        } else
        {
            t = (new StringBuilder()).append(k).append(": ").append(p).toString();
        }
        flag1 = false;
        flag = flag1;
        if (category.getGroups() != null)
        {
            flag = flag1;
            if (category.getGroups().size() > 0)
            {
                flag = true;
            }
        }
        if (flag)
        {
            category = new BrowseSuperSubCategoryFragment(category, r);
            bundle = new Bundle();
            bundle.putString("BaseCategory", k);
            category.setArguments(bundle);
            if (getParentFragment() != null)
            {
                if (getParentFragment() instanceof BaseTabContainer)
                {
                    ((BaseTabContainer)getParentFragment()).a(category, true);
                } else
                {
                    ((BaseFragmentContainer)getParentFragment()).a(category, true);
                }
            } else
            {
                ((HomeActivity)d).addFragment(0x7f0c0033, category, "BrowseSuperSubCategoryFragment");
            }
            hashmap.put(lu.bo, "browse,deptCat");
            hashmap.put(lu.bp, "PRD");
            lu.b(t, hashmap);
        } else
        {
            Object obj = category.getSearchPath();
            if (obj != null && !((String) (obj)).isEmpty())
            {
                obj = new PLPFragment(category.getName(), ((String) (obj)), true, k, t);
                category = new Bundle();
                if (bundle != null)
                {
                    category.putString("Category", (new StringBuilder()).append(bundle.getString("BaseCategory", "")).append(":").append(k).toString());
                } else
                {
                    category.putString("Category", k);
                }
                ((PLPFragment) (obj)).setArguments(category);
                if (getParentFragment() != null)
                {
                    if (getParentFragment() instanceof BaseTabContainer)
                    {
                        category = new PLPFragmentContainer();
                        ((BaseTabContainer)getParentFragment()).a(category, true);
                    } else
                    {
                        category = new PLPFragmentContainer(true);
                        ((PLPFragment) (obj)).b(true);
                        ((HomeActivity)d).addFragment(0x7f0c0033, category, "PLPFragmentContainer");
                    }
                    category.a(((android.support.v4.app.Fragment) (obj)), true);
                    return;
                } else
                {
                    ((HomeActivity)d).addFragment(0x7f0c0033, ((android.support.v4.app.Fragment) (obj)), "PLPFragment");
                    return;
                }
            }
        }
    }

    public void a(ArrayList arraylist)
    {
        a.setVisibility(0);
        g.setVisibility(0);
        Bundle bundle;
        if (o)
        {
            o = false;
            m.setVisibility(8);
        } else
        {
            n = true;
        }
        bundle = getArguments();
        if (bundle != null)
        {
            if (bundle.getString("BaseCategory") != null && !bundle.getString("BaseCategory").isEmpty())
            {
                s = new dy(d, arraylist, this, true, (new StringBuilder()).append(bundle.getString("BaseCategory")).append(":").append(k).toString());
            }
        } else
        if (k != null && !k.isEmpty())
        {
            s = new dy(d, arraylist, this, true, k);
        } else
        {
            s = new dy(d, arraylist, this, true, "product");
        }
        g.setAdapter(s);
        g.startAnimation(ll.a(d));
        if (arraylist.size() == 1)
        {
            g.setPagingEnabled(false);
        }
        g.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final BrowseSuperSubCategoryFragment a;

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
                a = BrowseSuperSubCategoryFragment.this;
                super();
            }
        });
        ((HomeActivity)d).loadMostPopularRecommendations("product", "productsloadmostpopular", arraylist);
    }

    public void a(List list)
    {
        if (n)
        {
            n = false;
            m.setVisibility(8);
        } else
        {
            o = true;
        }
        b = list;
        if (list != null && !list.isEmpty())
        {
            e();
            c = new ed(d, 0, list);
            q.setAdapter(c);
        }
    }

    public void b()
    {
        if (a != null)
        {
            ll.a(a);
        }
    }

    public void c()
    {
        u.setEnabled(true);
    }

    public void d()
    {
        u.setEnabled(false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).hideActionBarHome();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public void onClick(View view)
    {
        if (view == h)
        {
            view = new PLPFragmentContainer();
            PLPFragment plpfragment = new PLPFragment(true, "MostPopular", "Most Popular", j, null, k, 50);
            ((BaseTabContainer)getParentFragment()).a(view, true);
            view.a(plpfragment, true);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = nb.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (l == null)
        {
            l = layoutinflater.inflate(0x7f030016, viewgroup, false);
            layoutinflater = layoutinflater.inflate(0x7f030019, q, false);
            g = (BBYProductViewPager)layoutinflater.findViewById(0x7f0c0074);
            g.setPageMargin(15);
            m = l.findViewById(0x7f0c0064);
            a = (LinearLayout)layoutinflater.findViewById(0x7f0c0071);
            q = (ListView)l.findViewById(0x102000a);
            q.addHeaderView(layoutinflater);
            viewgroup = new View(d);
            viewgroup.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, 3));
            viewgroup.setBackgroundResource(0x7f0b0008);
            q.addHeaderView(viewgroup);
            viewgroup = new View(d);
            viewgroup.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, 1));
            viewgroup.setBackgroundResource(0x7f0b0008);
            q.addFooterView(viewgroup);
            h = (LinearLayout)layoutinflater.findViewById(0x7f0c0073);
            h.setOnClickListener(this);
            u = (CustomSwipeToRefresh)l.findViewById(0x7f0c006e);
            u.setColorScheme(0x7f0b0000, 0x7f0b0063, 0x7f0b0000, 0x7f0b0063);
            u.setOnRefreshListener(this);
            v = ChatRunningStatus.getChatRunning();
            if (!v)
            {
                c();
            } else
            {
                d();
            }
            i = new hg(d, this, null, j, null, 1, 10, false);
            if (r)
            {
                a.setVisibility(8);
            } else
            {
                i.executeOnExecutor(nb.h, new Void[0]);
            }
            a(b);
        } else
        {
            ((ViewGroup)l.getParent()).removeView(l);
        }
        if (!r)
        {
            a.setVisibility(0);
        }
        q.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BrowseSuperSubCategoryFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (Category)BrowseSuperSubCategoryFragment.a(a).get(i1 - 2);
                if (!adapterview.getWidgetType().equalsIgnoreCase("group"))
                {
                    a.a(adapterview);
                }
            }

            
            {
                a = BrowseSuperSubCategoryFragment.this;
                super();
            }
        });
        return l;
    }

    public void onDestroy()
    {
        super.onDestroy();
        Bundle bundle = getArguments();
        HashMap hashmap = new HashMap();
        if (bundle != null)
        {
            hashmap.put(lu.bo, "browse,deptCat");
            hashmap.put(lu.bp, "PRD");
            if (bundle.getString("BaseCategory", "").isEmpty())
            {
                lu.b(k, hashmap);
                return;
            } else
            {
                lu.b(bundle.getString("BaseCategory", ""), hashmap);
                return;
            }
        } else
        {
            hashmap.put(lu.bo, "browse,products");
            hashmap.put(lu.bp, "PRD");
            lu.b(lu.D, hashmap);
            return;
        }
    }

    public void onRefresh()
    {
        d();
        (new Handler()).postDelayed(new Runnable() {

            final BrowseSuperSubCategoryFragment a;

            public void run()
            {
                BrowseSuperSubCategoryFragment.b(a).setRefreshing(false);
                if (a.getActivity() != null)
                {
                    Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
                    HashMap hashmap = new HashMap();
                    if (BrowseSuperSubCategoryFragment.c(a))
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
                a = BrowseSuperSubCategoryFragment.this;
                super();
            }
        }, 1500L);
    }

    public void onResume()
    {
        super.onResume();
        v = ChatRunningStatus.getChatRunning();
        if (!v)
        {
            c();
        } else
        {
            d();
        }
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(k);
        if (!r)
        {
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            a.setVisibility(0);
        } else
        {
            ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        }
        if (s != null)
        {
            s.notifyDataSetChanged();
        }
    }
}
