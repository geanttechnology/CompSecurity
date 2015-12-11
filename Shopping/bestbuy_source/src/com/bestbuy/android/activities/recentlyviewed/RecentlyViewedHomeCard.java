// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.recentlyviewed;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.api.lib.models.home.Recommendation;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedAlsoViewed;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedAlsoViewedRecommendations;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedAlsoViewedResponse;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedData;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RecentlyViewedSku;
import com.bestbuy.android.api.lib.models.home.recentlyviewed.RelatedSkus;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import ds;
import dy;
import gu;
import he;
import hk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ll;
import nb;

public class RecentlyViewedHomeCard extends BBYBaseFragment
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener
{

    private LinearLayout a;
    private ArrayList b;
    private View c;
    private View g;
    private hk h;
    private he i;
    private BBYProductViewPager j;
    private LinearLayout k;
    private ListView l;
    private ArrayList m;
    private ds n;
    private LinearLayout o;
    private RelativeLayout p;
    private BBYProduct q;
    private dy r;
    private Recommendation s;
    private List t;
    private RecentlyViewedAlsoViewedResponse u;

    public RecentlyViewedHomeCard()
    {
        b = new ArrayList();
        m = new ArrayList();
    }

    static BBYProduct a(RecentlyViewedHomeCard recentlyviewedhomecard, BBYProduct bbyproduct)
    {
        recentlyviewedhomecard.q = bbyproduct;
        return bbyproduct;
    }

    static he a(RecentlyViewedHomeCard recentlyviewedhomecard, he he)
    {
        recentlyviewedhomecard.i = he;
        return he;
    }

    static String a(RecentlyViewedHomeCard recentlyviewedhomecard, ArrayList arraylist)
    {
        return recentlyviewedhomecard.d(arraylist);
    }

    static ArrayList a(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.m;
    }

    static void a(RecentlyViewedHomeCard recentlyviewedhomecard, RecentlyViewedAlsoViewedResponse recentlyviewedalsoviewedresponse)
    {
        recentlyviewedhomecard.b(recentlyviewedalsoviewedresponse);
    }

    static ArrayList b(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.b;
    }

    private void b(RecentlyViewedAlsoViewedResponse recentlyviewedalsoviewedresponse)
    {
        ArrayList arraylist = new ArrayList();
        if (recentlyviewedalsoviewedresponse != null && recentlyviewedalsoviewedresponse.getSi() != null && recentlyviewedalsoviewedresponse.getSi().getResponse() != null && recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations() != null && recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus() != null && recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().size() > 0 && recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(0) != null && ((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(0)).getRelatedSkus() != null)
        {
            for (int i1 = 0; i1 < ((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(0)).getRelatedSkus().size(); i1++)
            {
                BBYProduct bbyproduct = new BBYProduct();
                bbyproduct.setEp(((RelatedSkus)((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(0)).getRelatedSkus().get(i1)).getEp());
                bbyproduct.setPriceBlock(((RelatedSkus)((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(0)).getRelatedSkus().get(i1)).getPriceBlock());
                bbyproduct.setSkuId(((RelatedSkus)((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(0)).getRelatedSkus().get(i1)).getSkuId());
                bbyproduct.setSummary(((RelatedSkus)((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(0)).getRelatedSkus().get(i1)).getSummary());
                arraylist.add(bbyproduct);
            }

            b(arraylist);
        }
    }

    static LinearLayout c(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.k;
    }

    private String c(ArrayList arraylist)
    {
        StringBuilder stringbuilder;
        int i1;
        if (arraylist.size() < 3)
        {
            i1 = arraylist.size();
        } else
        {
            i1 = 3;
        }
        stringbuilder = new StringBuilder();
        for (int j1 = 0; j1 < i1; j1++)
        {
            stringbuilder.append(((BBYProduct)arraylist.get(j1)).getSkuId());
            if (j1 != i1 - 1)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder.toString();
    }

    private String d(ArrayList arraylist)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (arraylist != null && arraylist.size() > 0)
        {
            for (int i1 = 0; i1 < arraylist.size(); i1++)
            {
                stringbuilder.append(((BBYProduct)arraylist.get(i1)).getSkuId());
                if (i1 != arraylist.size() - 1)
                {
                    stringbuilder.append(',');
                }
            }

        }
        return stringbuilder.toString();
    }

    static List d(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.t;
    }

    static ListView e(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.l;
    }

    static RelativeLayout f(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.p;
    }

    static he g(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.i;
    }

    static BBYProduct h(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.q;
    }

    static RecentlyViewedAlsoViewedResponse i(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.u;
    }

    static View j(RecentlyViewedHomeCard recentlyviewedhomecard)
    {
        return recentlyviewedhomecard.g;
    }

    public void a(RecentlyViewedAlsoViewedResponse recentlyviewedalsoviewedresponse)
    {
        u = recentlyviewedalsoviewedresponse;
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        for (int i1 = 0; i1 < recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().size(); i1++)
        {
            BBYProduct bbyproduct = new BBYProduct();
            bbyproduct.setEp(((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(i1)).getEp());
            bbyproduct.setPriceBlock(((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(i1)).getPriceBlock());
            bbyproduct.setSkuId(((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(i1)).getSkuId());
            bbyproduct.setSummary(((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(i1)).getSummary());
            arraylist1.add(((RecentlyViewedSku)recentlyviewedalsoviewedresponse.getSi().getResponse().getRecommendations().getSkus().get(i1)).getRelatedUrl());
            arraylist.add(bbyproduct);
        }

        a(((List) (arraylist1)));
        a(arraylist);
        b(recentlyviewedalsoviewedresponse);
    }

    public void a(gu gu)
    {
        s = (Recommendation)gu;
    }

    public void a(ArrayList arraylist)
    {
        a.setVisibility(0);
        ArrayList arraylist1 = new ArrayList();
        arraylist1.addAll(arraylist);
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BBYProduct bbyproduct1 = (BBYProduct)iterator.next();
            if (bbyproduct1.getPriceBlock() == null)
            {
                arraylist1.remove(bbyproduct1);
            }
        } while (true);
        arraylist.clear();
        arraylist.addAll(arraylist1);
        if (arraylist != null && (arraylist == null || !arraylist.isEmpty())) goto _L2; else goto _L1
_L1:
        b();
_L4:
        if (c != null)
        {
            c.setVisibility(8);
        }
        return;
_L2:
        b.clear();
        b.addAll(arraylist);
        r = new dy(d, b, getParentFragment(), true, "recentlyviewed");
        j.setAdapter(r);
        j.startAnimation(ll.a(d));
        if (arraylist.size() == 1)
        {
            j.setPagingEnabled(false);
        }
        if (b != null && !b.isEmpty())
        {
            k.setVisibility(0);
            BBYProduct bbyproduct = (BBYProduct)b.get(0);
            l.setVisibility(8);
            if (q != null)
            {
                ((HomeActivity)d).sendRecommendations("homeloadrecentlyviewed", "GHP", d(arraylist), q);
            } else
            {
                ((HomeActivity)d).sendRecommendations("homeloadrecentlyviewed", "GHP", d(arraylist), bbyproduct);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(List list)
    {
        t = list;
    }

    public void b()
    {
        if (a != null)
        {
            ll.a(a);
        }
    }

    public void b(ArrayList arraylist)
    {
        if (arraylist != null && !arraylist.isEmpty())
        {
            p.setVisibility(8);
            g.setVisibility(8);
            k.setVisibility(0);
            l.setVisibility(0);
            m.clear();
            m.addAll(arraylist);
            n.notifyDataSetChanged();
            if (q != null)
            {
                ((HomeActivity)d).sendRecommendations("homeloadalsoviewed", "GHP", c(arraylist), q);
                return;
            } else
            {
                ((HomeActivity)d).sendRecommendations("homeloadalsoviewed", "GHP", c(arraylist), (BBYProduct)arraylist.get(0));
                return;
            }
        } else
        {
            p.setVisibility(0);
            g.setVisibility(8);
            l.setVisibility(8);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onClick(View view)
    {
        if (view == o)
        {
            view = new PLPFragmentContainer();
            PLPFragment plpfragment = new PLPFragment(true, "RecenltyViewed", "Recenlty Viewed", "all", null, "Home", 10);
            android.support.v4.app.Fragment fragment = ((FragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (fragment instanceof HomeTabFragment)
            {
                ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(view, true);
                view.a(plpfragment, true);
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = (LinearLayout)layoutinflater.inflate(0x7f030052, viewgroup, false);
        o = (LinearLayout)a.findViewById(0x7f0c0073);
        c = a.findViewById(0x7f0c0064);
        g = a.findViewById(0x7f0c012c);
        j = (BBYProductViewPager)a.findViewById(0x7f0c005e);
        k = (LinearLayout)a.findViewById(0x7f0c012b);
        p = (RelativeLayout)a.findViewById(0x7f0c00b9);
        l = (ListView)a.findViewById(0x7f0c012d);
        o.setOnClickListener(this);
        l.setOnTouchListener(new android.view.View.OnTouchListener() {

            final RecentlyViewedHomeCard a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }

            
            {
                a = RecentlyViewedHomeCard.this;
                super();
            }
        });
        l.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RecentlyViewedHomeCard a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (BBYProduct)RecentlyViewedHomeCard.a(a).get(i1);
                ((HomeActivity)a.d).openPDP(adapterview.getSkuId(), false, (new StringBuilder()).append("").append(adapterview.getSummary().getProductId()).toString(), true, adapterview, "GHP", "");
                ((HomeActivity)a.d).sendRecommendations("homeclickcustomeralsoviewed", "GHP", adapterview);
            }

            
            {
                a = RecentlyViewedHomeCard.this;
                super();
            }
        });
        j.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final RecentlyViewedHomeCard a;

            public void onPageScrollStateChanged(int i1)
            {
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                String s1;
label0:
                {
                    if (RecentlyViewedHomeCard.b(a) != null && !RecentlyViewedHomeCard.b(a).isEmpty())
                    {
                        RecentlyViewedHomeCard.c(a).setVisibility(0);
                        RecentlyViewedHomeCard.a(a, (BBYProduct)RecentlyViewedHomeCard.b(a).get(i1));
                        s1 = (String)RecentlyViewedHomeCard.d(a).get(i1);
                        RecentlyViewedHomeCard.e(a).setVisibility(8);
                        RecentlyViewedHomeCard.f(a).setVisibility(8);
                        if (RecentlyViewedHomeCard.g(a) != null)
                        {
                            RecentlyViewedHomeCard.g(a).cancel(true);
                        }
                        if (RecentlyViewedHomeCard.h(a) != null)
                        {
                            ((HomeActivity)a.d).sendRecommendations("homeloadrecentlyviewed", "GHP", RecentlyViewedHomeCard.a(a, RecentlyViewedHomeCard.b(a)), RecentlyViewedHomeCard.h(a));
                        }
                        if (i1 != 0)
                        {
                            break label0;
                        }
                        RecentlyViewedHomeCard.a(a, RecentlyViewedHomeCard.i(a));
                    }
                    return;
                }
                RecentlyViewedHomeCard.a(a, new he(a.d, a, s1, RecentlyViewedHomeCard.j(a)));
                RecentlyViewedHomeCard.g(a).execute(new Void[0]);
            }

            
            {
                a = RecentlyViewedHomeCard.this;
                super();
            }
        });
        n = new ds(d, m);
        l.setAdapter(n);
        h = new hk(d, this, c, s);
        h.executeOnExecutor(nb.h, new Void[0]);
        return a;
    }

    public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
    {
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (l())
        {
            h = new hk(d, this, c, s);
            h.executeOnExecutor(nb.h, new Void[0]);
        }
        if (r != null)
        {
            r.notifyDataSetChanged();
        }
    }
}
