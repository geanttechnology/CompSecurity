// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.controller.adapter.m;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.controller.adapter.q;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.CampaignGroup;
import com.cyberlink.beautycircle.model.ProductBrand;
import com.cyberlink.beautycircle.model.ProductPrice;
import com.cyberlink.beautycircle.model.ProductType;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.network.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DFPAdUtility;
import com.cyberlink.beautycircle.utility.a;
import com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g, h, s, BottomBarFragment

public class PageProductsFragment extends g
{

    public static final Long s = Long.valueOf(-1L);
    private ViewGroup A;
    private View B;
    private View C;
    private View D;
    private View E;
    private View F;
    private View G;
    private View H;
    private View I;
    private AbsListView J;
    private AbsListView K;
    private AbsListView L;
    private AbsListView M;
    private DFPAdUtility N;
    private ViewGroup O;
    private SlideShowView P;
    private ArrayAdapter Q;
    private ArrayAdapter R;
    private ArrayAdapter S;
    private ArrayAdapter T;
    private int U;
    private Long V;
    private Long W;
    private Long X;
    private s Y;
    private CampaignGroup Z;
    private a aa;
    private n ab;
    public int t;
    android.view.View.OnClickListener u;
    android.widget.AdapterView.OnItemClickListener v;
    android.widget.AdapterView.OnItemClickListener w;
    android.widget.AdapterView.OnItemClickListener x;
    android.widget.AdapterView.OnItemClickListener y;
    private BottomBarFragment z;

    public PageProductsFragment()
    {
        z = null;
        A = null;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = null;
        H = null;
        I = null;
        P = null;
        Q = null;
        R = null;
        S = null;
        T = null;
        t = 0;
        V = s;
        W = s;
        X = s;
        Z = null;
        u = new android.view.View.OnClickListener() {

            final PageProductsFragment a;

            public void onClick(View view)
            {
                a.a();
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        };
        v = new android.widget.AdapterView.OnItemClickListener() {

            final PageProductsFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (ProductType)adapterview.getItemAtPosition(i1);
                if (a.h != null)
                {
                    ((q)a.h).c = adapterview;
                    a.h.clear();
                    a.h.c();
                }
                ((TextView)a.getView().findViewById(j.product_btn_type_text)).setText(adapterview.toString());
                a.n();
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        };
        w = new android.widget.AdapterView.OnItemClickListener() {

            final PageProductsFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (ProductPrice)adapterview.getItemAtPosition(i1);
                if (a.h != null)
                {
                    ((q)a.h).b = adapterview;
                    a.h.clear();
                    a.h.c();
                }
                ((TextView)a.getView().findViewById(j.product_btn_price_text)).setText(adapterview.toString());
                a.n();
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        };
        x = new android.widget.AdapterView.OnItemClickListener() {

            final PageProductsFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                if (i1 == 0)
                {
                    adapterview = "";
                } else
                {
                    adapterview = ((TextView)view).getText().toString();
                }
                view = com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.e(a).getFilter();
                if (view != null)
                {
                    view.filter(adapterview);
                }
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        };
        y = new android.widget.AdapterView.OnItemClickListener() {

            final PageProductsFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                adapterview = (ProductBrand)adapterview.getItemAtPosition(i1);
                if (a.h != null)
                {
                    ((q)a.h).a = adapterview;
                    a.h.clear();
                    a.h.c();
                }
                ((TextView)a.getView().findViewById(j.product_btn_brand_text)).setText(adapterview.toString());
                a.n();
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        };
        aa = new a() {

            final PageProductsFragment a;

            public void a(UserInfo userinfo)
            {
                com.perfectcorp.utility.e.b(new Object[0]);
                if (a.h != null)
                {
                    a.h.g = true;
                }
                if (a.a && a.isResumed())
                {
                    PageProductsFragment.l(a);
                }
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        };
        ab = new h(this);
    }

    static CampaignGroup a(PageProductsFragment pageproductsfragment)
    {
        return pageproductsfragment.Z;
    }

    static CampaignGroup a(PageProductsFragment pageproductsfragment, CampaignGroup campaigngroup)
    {
        pageproductsfragment.Z = campaigngroup;
        return campaigngroup;
    }

    private void a(View view)
    {
        C.setOnClickListener(new android.view.View.OnClickListener() {

            final PageProductsFragment a;

            public void onClick(View view1)
            {
                PageProductsFragment.f(a);
                a.a(view1, PageProductsFragment.g(a));
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        });
        D.setOnClickListener(new android.view.View.OnClickListener() {

            final PageProductsFragment a;

            public void onClick(View view1)
            {
                PageProductsFragment.h(a);
                a.a(view1, PageProductsFragment.i(a));
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        });
        E.setOnClickListener(new android.view.View.OnClickListener() {

            final PageProductsFragment a;

            public void onClick(View view1)
            {
                com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.j(a);
                a.a(view1, com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.k(a));
            }

            
            {
                a = PageProductsFragment.this;
                super();
            }
        });
        AccountManager.a(aa);
    }

    private void a(View view, LayoutInflater layoutinflater)
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        P = (SlideShowView)view.findViewById(j.products_ad_panel);
        O = (ViewGroup)view.findViewById(j.products_ad_container);
        A = (ViewGroup)view.findViewById(j.products_panel);
        Q = new ArrayAdapter(fragmentactivity, k.bc_view_item_product_type, j.title);
        R = new ArrayAdapter(fragmentactivity, k.bc_view_item_product_price, j.title);
        S = new ArrayAdapter(fragmentactivity, k.bc_view_item_product_brand_index, j.title, new String[] {
            "All", "A", "B", "C", "D", "E", "F", "G", "H", "I", 
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
            "T", "U", "V", "W", "X", "Y", "Z"
        });
        T = new ArrayAdapter(fragmentactivity, k.bc_view_item_product_brand, j.title);
        C = (ViewGroup)view.findViewById(j.product_btn_type);
        D = (ViewGroup)view.findViewById(j.product_btn_price);
        E = (ViewGroup)view.findViewById(j.product_btn_brand);
        F = layoutinflater.inflate(k.bc_view_panel_product_type, (ViewGroup)view, false);
        F.setOnClickListener(u);
        J = (AbsListView)F.findViewById(j.product_type_list);
        J.setChoiceMode(1);
        J.setAdapter(Q);
        J.setOnItemClickListener(v);
        J.setItemChecked(0, true);
        G = layoutinflater.inflate(k.bc_view_panel_product_price, (ViewGroup)view, false);
        G.setOnClickListener(u);
        K = (AbsListView)G.findViewById(j.product_price_list);
        K.setChoiceMode(1);
        K.setAdapter(R);
        K.setOnItemClickListener(w);
        K.setItemChecked(0, true);
        H = layoutinflater.inflate(k.bc_view_panel_product_brand, (ViewGroup)view, false);
        H.setOnClickListener(u);
        L = (AbsListView)H.findViewById(j.product_brand_index_list);
        L.setChoiceMode(1);
        L.setAdapter(S);
        L.setOnItemClickListener(x);
        L.setItemChecked(0, true);
        M = (AbsListView)H.findViewById(j.product_brand_list);
        M.setChoiceMode(1);
        M.setAdapter(T);
        M.setOnItemClickListener(y);
        M.setItemChecked(0, true);
        a(layoutinflater, view, null, Integer.valueOf(k.bc_view_footer));
        h = new q(getActivity(), g, k.bc_view_item_product, ab);
        I = view.findViewById(j.home_btn);
        a(view, true, true, false, "product");
        a(view, 0, true);
    }

    static void a(PageProductsFragment pageproductsfragment, int i1)
    {
        pageproductsfragment.c(i1);
    }

    static SlideShowView b(PageProductsFragment pageproductsfragment)
    {
        return pageproductsfragment.P;
    }

    private void b(View view)
    {
        ((ListView)g).setOnItemClickListener(null);
        C.setOnClickListener(null);
        D.setOnClickListener(null);
        E.setOnClickListener(null);
        AccountManager.b(aa);
    }

    static ArrayAdapter c(PageProductsFragment pageproductsfragment)
    {
        return pageproductsfragment.Q;
    }

    private void c(int i1)
    {
        boolean flag;
        flag = false;
        U = U | i1;
        if (U != 7) goto _L2; else goto _L1
_L1:
        int j1;
        if (V == s)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        j1 = T.getCount();
        i1 = 0;
_L15:
        Object obj;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        obj = (ProductBrand)T.getItem(i1);
        if (((ProductBrand) (obj)).id != V.longValue()) goto _L4; else goto _L3
_L3:
        ((q)h).a = ((ProductBrand) (obj));
        ((TextView)getView().findViewById(j.product_btn_brand_text)).setText(((ProductBrand) (obj)).toString());
        j1 = 1;
_L18:
        i1 = j1;
        if (W == s) goto _L6; else goto _L5
_L5:
        int k1;
        int l1;
        l1 = Q.getCount();
        k1 = 0;
_L16:
        i1 = j1;
        if (k1 >= l1) goto _L6; else goto _L7
_L7:
        obj = (ProductType)Q.getItem(k1);
        if (((ProductType) (obj)).typeId != W.longValue()) goto _L9; else goto _L8
_L8:
        ((q)h).c = ((ProductType) (obj));
        ((TextView)getView().findViewById(j.product_btn_type_text)).setText(((ProductType) (obj)).toString());
        i1 = 1;
_L6:
        j1 = i1;
        if (X == s) goto _L11; else goto _L10
_L10:
        l1 = R.getCount();
        k1 = ((flag) ? 1 : 0);
_L17:
        j1 = i1;
        if (k1 >= l1) goto _L11; else goto _L12
_L12:
        obj = (ProductPrice)R.getItem(k1);
        if (((ProductPrice) (obj)).id != X.longValue()) goto _L14; else goto _L13
_L13:
        ((q)h).b = ((ProductPrice) (obj));
        ((TextView)getView().findViewById(j.product_btn_price_text)).setText(((ProductPrice) (obj)).toString());
        j1 = 1;
_L11:
        if (j1 != 0)
        {
            h.c();
            Y.a();
        }
_L2:
        return;
_L4:
        i1++;
          goto _L15
_L9:
        k1++;
          goto _L16
_L14:
        k1++;
          goto _L17
        j1 = 0;
          goto _L18
    }

    static ArrayAdapter d(PageProductsFragment pageproductsfragment)
    {
        return pageproductsfragment.R;
    }

    static ArrayAdapter e(PageProductsFragment pageproductsfragment)
    {
        return pageproductsfragment.T;
    }

    static void f(PageProductsFragment pageproductsfragment)
    {
        pageproductsfragment.q();
    }

    static View g(PageProductsFragment pageproductsfragment)
    {
        return pageproductsfragment.F;
    }

    static void h(PageProductsFragment pageproductsfragment)
    {
        pageproductsfragment.r();
    }

    static View i(PageProductsFragment pageproductsfragment)
    {
        return pageproductsfragment.G;
    }

    static void j(PageProductsFragment pageproductsfragment)
    {
        pageproductsfragment.s();
    }

    static View k(PageProductsFragment pageproductsfragment)
    {
        return pageproductsfragment.H;
    }

    static void l(PageProductsFragment pageproductsfragment)
    {
        pageproductsfragment.t();
    }

    private void p()
    {
        if (t == 0 && P != null && h != null)
        {
            if (!h.g && Z != null && Z.campaigns != null && !Z.campaigns.isEmpty())
            {
                if (P.a())
                {
                    P.setCampaignGroup(Z);
                    return;
                }
            } else
            {
                CampaignGroup.a("product").a(new com.perfectcorp.utility.m() {

                    final PageProductsFragment a;

                    public void a(int i1)
                    {
                        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.b(a).setCampaignGroup(null);
                    }

                    public void a(CampaignGroup campaigngroup)
                    {
                        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.a(a, campaigngroup);
                        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.b(a).setCampaignGroup(com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.a(a));
                    }

                    public void b(Object obj)
                    {
                        a((CampaignGroup)obj);
                    }

            
            {
                a = PageProductsFragment.this;
                super();
            }
                });
                return;
            }
        }
    }

    private void q()
    {
        if (Q != null && (h == null || h.g || Q.getCount() <= 1))
        {
            com.cyberlink.beautycircle.model.network.r.a().a(new com.perfectcorp.utility.m() {

                final PageProductsFragment a;

                public void a(int i1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "listAllTypes:", Integer.valueOf(i1)
                    });
                    if (PageProductsFragment.c(a).isEmpty())
                    {
                        PageProductsFragment.c(a).add(ProductType.b());
                        PageProductsFragment.c(a).notifyDataSetChanged();
                    }
                }

                public void a(d d1)
                {
                    PageProductsFragment.c(a).clear();
                    PageProductsFragment.c(a).add(ProductType.b());
                    PageProductsFragment.c(a).addAll(d1.b);
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.a(a, 1);
                    PageProductsFragment.c(a).notifyDataSetChanged();
                }

                public void b(Object obj)
                {
                    a((d)obj);
                }

            
            {
                a = PageProductsFragment.this;
                super();
            }
            });
        }
    }

    private void r()
    {
        if (R != null && (h == null || h.g || R.getCount() <= 1))
        {
            com.cyberlink.beautycircle.model.network.r.c().a(new com.perfectcorp.utility.m() {

                final PageProductsFragment a;

                public void a(int i1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "listPriceRange:", Integer.valueOf(i1)
                    });
                    if (com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).isEmpty())
                    {
                        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).add(ProductPrice.b());
                        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).notifyDataSetChanged();
                    }
                }

                public void a(d d1)
                {
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).clear();
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).add(ProductPrice.b());
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).addAll(d1.b);
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.a(a, 2);
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.d(a).notifyDataSetChanged();
                }

                public void b(Object obj)
                {
                    a((d)obj);
                }

            
            {
                a = PageProductsFragment.this;
                super();
            }
            });
        }
    }

    private void s()
    {
        if (T != null && (h == null || h.g || T.getCount() <= 1))
        {
            com.cyberlink.beautycircle.model.network.r.b().a(new com.perfectcorp.utility.m() {

                final PageProductsFragment a;

                public void a(int i1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "listBrandIndexs:", Integer.valueOf(i1)
                    });
                    if (com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.e(a).isEmpty())
                    {
                        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.e(a).add(ProductBrand.b());
                        com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.e(a).notifyDataSetChanged();
                    }
                }

                public void a(d d1)
                {
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.e(a).clear();
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.e(a).add(ProductBrand.b());
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.e(a).addAll(d1.b);
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.a(a, 4);
                    com.cyberlink.beautycircle.controller.fragment.PageProductsFragment.e(a).notifyDataSetChanged();
                }

                public void b(Object obj)
                {
                    a((d)obj);
                }

            
            {
                a = PageProductsFragment.this;
                super();
            }
            });
        }
    }

    private void t()
    {
        q();
        r();
        s();
        p();
        if (h != null && (h.g || h.i()))
        {
            h.d(false);
            q q1 = (q)h;
            boolean flag;
            if (t == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            q1.b(flag);
            h.c();
            if (h.g)
            {
                o();
                h.g = false;
            }
        }
    }

    void a()
    {
        if (B != null)
        {
            A.removeView(B);
            B = null;
        }
        C.setSelected(false);
        D.setSelected(false);
        E.setSelected(false);
        if (z != null)
        {
            z.a();
        }
    }

    void a(View view, View view1)
    {
        if (B == view1)
        {
            a();
        } else
        {
            if (B != null)
            {
                A.removeView(B);
                C.setSelected(false);
                D.setSelected(false);
                E.setSelected(false);
            }
            view.setSelected(true);
            B = view1;
            A.addView(view1, -1, -1);
            if (z != null)
            {
                z.b();
                return;
            }
        }
    }

    public void a(BottomBarFragment bottombarfragment)
    {
        z = bottombarfragment;
        if (z != null && g != null)
        {
            z.a(g, k, null);
        }
    }

    public void a(Long long1, Long long2, Long long3, String s1, s s2)
    {
        Y = s2;
        if (s1 != null && s1.equalsIgnoreCase(AccountManager.a()))
        {
            V = long1;
            W = long2;
            X = long3;
            return;
        } else
        {
            Y.b();
            return;
        }
    }

    public void b(int i1)
    {
        super.b(i1);
        t();
        if (t != 0)
        {
            O.setVisibility(8);
            l.setVisibility(8);
            return;
        }
        if (N == null)
        {
            N = DFPAdUtility.a(com.cyberlink.beautycircle.utility.DFPAdUtility.DFPAdUnitId.c, O, getActivity());
            return;
        } else
        {
            N.a(true);
            return;
        }
    }

    public void b(BottomBarFragment bottombarfragment)
    {
        z = bottombarfragment;
        if (z != null && g != null)
        {
            z.a(g, k);
        }
    }

    public void f()
    {
        if (B != null)
        {
            a();
        }
        d();
        super.f();
    }

    public void k()
    {
        super.k();
        com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.m("product"));
    }

    public void m()
    {
        super.m();
        p();
    }

    void n()
    {
        a();
    }

    void o()
    {
        a();
        View view = C.findViewById(j.product_btn_type_text);
        if (view instanceof TextView)
        {
            ((TextView)view).setText(getString(com.cyberlink.beautycircle.m.bc_products_type));
        }
        J.setItemChecked(0, true);
        J.setSelection(0);
        view = D.findViewById(j.product_btn_price_text);
        if (view instanceof TextView)
        {
            ((TextView)view).setText(getString(com.cyberlink.beautycircle.m.bc_products_price));
        }
        K.setItemChecked(0, true);
        K.setSelection(0);
        view = E.findViewById(j.product_btn_brand_text);
        if (view instanceof TextView)
        {
            ((TextView)view).setText(getString(com.cyberlink.beautycircle.m.bc_products_brand));
        }
        L.setItemChecked(0, true);
        L.setSelection(0);
        M.setItemChecked(0, true);
        M.setSelection(0);
        if (h != null)
        {
            ((q)h).b();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(k.bc_fragment_page_products, viewgroup, false);
        a(viewgroup, layoutinflater);
        a(viewgroup);
        b();
        return viewgroup;
    }

    public void onDestroyView()
    {
        com.perfectcorp.utility.e.c(new Object[0]);
        b(getView());
        if (N != null && O != null)
        {
            N.a(O);
        }
        super.onDestroyView();
    }

    public void onPause()
    {
        super.onPause();
        if (N != null)
        {
            N.b();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (N != null)
        {
            N.a();
        }
        a(g, k, I);
    }

}
