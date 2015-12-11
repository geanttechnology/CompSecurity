// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cd;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.dnm.DNMFacetFilter;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.dnm.DNMResponse;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.bbyobjects.BBYTextView;
import fh;
import ip;
import iq;
import java.util.ArrayList;
import java.util.Iterator;
import nb;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMPLPFacetAndFilterActivity, DNMDetailsModel, DNMSubListFragment, DNMListFragmentContainer

public class DNMListFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cd
{

    private RelativeLayout A;
    private DNMResponse B;
    private ArrayList C;
    private ArrayList D;
    private ArrayList E;
    private String F;
    private int G;
    private RelativeLayout H;
    private String I;
    private LinearLayout J;
    private RelativeLayout K;
    private LinearLayout L;
    private LayoutInflater M;
    private BBYTextView N;
    private android.widget.AbsListView.OnScrollListener O = new android.widget.AbsListView.OnScrollListener() {

        final DNMListFragment a;

        public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
        {
            if (DNMListFragment.m(a) && k1 > DNMListFragment.n(a))
            {
                DNMListFragment.a(a, k1);
                DNMListFragment.a(a, false);
            }
            if (!DNMListFragment.m(a) && i1 == k1 - j1 && k1 - DNMListFragment.o(a) < DNMListFragment.p(a))
            {
                DNMListFragment.b(a, DNMListFragment.q(a) + 1);
                (new iq(DNMListFragment.j(a), a, null, DNMListFragment.f(a), DNMListFragment.d(a), DNMListFragment.e(a), 50, DNMListFragment.q(a), 20, DNMListFragment.c(a), DNMListFragment.g(a), DNMListFragment.h(a), DNMListFragment.i(a))).executeOnExecutor(nb.h, new Void[0]);
                DNMListFragment.a(a, true);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i1)
        {
        }

            
            {
                a = DNMListFragment.this;
                super();
            }
    };
    private Activity a;
    private View b;
    private String c;
    private ImageView g;
    private double h;
    private double i;
    private View j;
    private int k;
    private String l;
    private BBYTextView m;
    private BBYTextView n;
    private LinearLayout o;
    private EditText p;
    private ListView q;
    private fh r;
    private View s;
    private ArrayList t;
    private ArrayList u;
    private ArrayList v;
    private boolean w;
    private int x;
    private String y;
    private int z;

    public DNMListFragment()
    {
        k = 1;
        t = new ArrayList();
        u = new ArrayList();
        v = new ArrayList();
        w = true;
        x = 0;
        C = new ArrayList();
        D = new ArrayList();
        E = new ArrayList();
        F = null;
        G = 0;
    }

    public DNMListFragment(String s1, double d1, double d2, String s2)
    {
        k = 1;
        t = new ArrayList();
        u = new ArrayList();
        v = new ArrayList();
        w = true;
        x = 0;
        C = new ArrayList();
        D = new ArrayList();
        E = new ArrayList();
        F = null;
        G = 0;
        c = s2;
        h = d1;
        i = d2;
        l = s1;
    }

    public DNMListFragment(String s1, String s2, String s3)
    {
        k = 1;
        t = new ArrayList();
        u = new ArrayList();
        v = new ArrayList();
        w = true;
        x = 0;
        C = new ArrayList();
        D = new ArrayList();
        E = new ArrayList();
        F = null;
        G = 0;
        c = s3;
        y = s2;
        l = s1;
    }

    static int a(DNMListFragment dnmlistfragment, int i1)
    {
        dnmlistfragment.x = i1;
        return i1;
    }

    static ArrayList a(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.u;
    }

    static void a(DNMListFragment dnmlistfragment, DNMFacetFilter dnmfacetfilter)
    {
        dnmlistfragment.b(dnmfacetfilter);
    }

    static void a(DNMListFragment dnmlistfragment, String s1)
    {
        dnmlistfragment.b(s1);
    }

    private void a(DNMFacetFilter dnmfacetfilter)
    {
        String s1 = dnmfacetfilter.getDisplayText();
        LinearLayout linearlayout = new LinearLayout(a);
        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        linearlayout.setOrientation(1);
        linearlayout.setPadding(10, 0, 0, 10);
        View view = M.inflate(0x7f0300b8, null);
        ((BBYTextView)view.findViewById(0x7f0c02f3)).setText(s1);
        view.findViewById(0x7f0c02f2).setOnClickListener(new android.view.View.OnClickListener(dnmfacetfilter) {

            final DNMFacetFilter a;
            final DNMListFragment b;

            public void onClick(View view1)
            {
                DNMListFragment.a(b, a);
            }

            
            {
                b = DNMListFragment.this;
                a = dnmfacetfilter;
                super();
            }
        });
        linearlayout.addView(view);
        linearlayout.setTag(dnmfacetfilter);
        L.addView(linearlayout, 0);
    }

    static boolean a(DNMListFragment dnmlistfragment, boolean flag)
    {
        dnmlistfragment.w = flag;
        return flag;
    }

    static int b(DNMListFragment dnmlistfragment, int i1)
    {
        dnmlistfragment.k = i1;
        return i1;
    }

    static ArrayList b(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.t;
    }

    private void b()
    {
        m = (BBYTextView)b.findViewById(0x7f0c00c4);
        n = (BBYTextView)b.findViewById(0x7f0c00c5);
        g = (ImageView)b.findViewById(0x7f0c00c2);
        o = (LinearLayout)b.findViewById(0x7f0c00c3);
        p = (EditText)b.findViewById(0x7f0c00c6);
        p.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final DNMListFragment a;

            public boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
            {
                if (i1 == 3)
                {
                    ((InputMethodManager)DNMListFragment.j(a).getSystemService("input_method")).hideSoftInputFromWindow(DNMListFragment.k(a).getWindowToken(), 0);
                    textview = DNMListFragment.k(a).getText().toString();
                    DNMListFragment.k(a).setVisibility(8);
                    DNMListFragment.l(a).setVisibility(0);
                    if (textview != null && textview.length() > 0)
                    {
                        DNMListFragment.a(a, textview);
                    }
                    DNMListFragment.k(a).setText("");
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = DNMListFragment.this;
                super();
            }
        });
        H = (RelativeLayout)b.findViewById(0x7f0c00c1);
        H.setOnClickListener(this);
        if (c != null && c.equals(getString(0x7f08006c)))
        {
            g.setImageResource(0x7f020133);
        } else
        {
            g.setImageResource(0x7f02007a);
        }
        if (l.equals(getString(0x7f080156)))
        {
            m.setText((new StringBuilder()).append(getString(0x7f080079)).append(" ").append(l).toString());
        } else
        {
            m.setText((new StringBuilder()).append(getString(0x7f080079)).append("\"").append(l).append("\"").toString());
        }
        n.setOnClickListener(this);
        if (y != null)
        {
            n.setVisibility(8);
        }
        n.setOnClickListener(this);
    }

    private void b(DNMFacetFilter dnmfacetfilter)
    {
        K.setVisibility(8);
        q.setVisibility(0);
        E.remove(dnmfacetfilter);
        L.removeView(L.findViewWithTag(dnmfacetfilter));
        (new iq(a, this, j, y, h, i, 50, k, 20, c, E, F, I)).executeOnExecutor(nb.h, new Void[0]);
    }

    private void b(String s1)
    {
        (new ip(a, this, j, s1, J)).executeOnExecutor(nb.h, new Void[0]);
    }

    static String c(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.c;
    }

    private void c()
    {
        t.clear();
        u.clear();
        k = 1;
        if (E != null && !E.isEmpty())
        {
            E.clear();
        }
        if (F != null && !F.isEmpty())
        {
            F = "";
        }
        if (C != null && !C.isEmpty())
        {
            C.clear();
        }
        if (D != null && !D.isEmpty())
        {
            D.clear();
        }
        (new iq(a, this, j, y, h, i, 50, k, 20, c, E, F, I)).executeOnExecutor(nb.h, new Void[0]);
    }

    static double d(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.h;
    }

    static double e(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.i;
    }

    static String f(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.y;
    }

    static ArrayList g(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.E;
    }

    static String h(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.F;
    }

    static String i(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.I;
    }

    static Activity j(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.a;
    }

    static EditText k(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.p;
    }

    static LinearLayout l(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.o;
    }

    static boolean m(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.w;
    }

    static int n(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.x;
    }

    static int o(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.G;
    }

    static int p(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.z;
    }

    static int q(DNMListFragment dnmlistfragment)
    {
        return dnmlistfragment.k;
    }

    public void a(DNMResponse dnmresponse)
    {
        B = dnmresponse;
        z = dnmresponse.getTotalCount();
        if (z == 0)
        {
            A.setVisibility(8);
            K.setVisibility(0);
            if (c.equals(getString(0x7f08012a)))
            {
                N.setText("There are no Clearance items in this area. \nPlease try another.");
            }
            q.setVisibility(8);
            L.removeAllViews();
            if (E != null)
            {
                for (dnmresponse = E.iterator(); dnmresponse.hasNext(); a((DNMFacetFilter)dnmresponse.next())) { }
            }
        } else
        {
            A.setVisibility(0);
            K.setVisibility(8);
            q.setVisibility(0);
            if (C == null || C.isEmpty())
            {
                C = dnmresponse.getFacetsFilters();
            }
            if (D == null || D.isEmpty())
            {
                D = dnmresponse.getSortOptions();
            }
            if (k <= 1)
            {
                s.findViewById(0x7f0c0303).setVisibility(0);
                q.removeFooterView(s);
                w = true;
                x = 0;
                if (dnmresponse.getDnmProducts().size() == 0)
                {
                    A.setVisibility(8);
                    K.setVisibility(0);
                    q.setVisibility(8);
                } else
                {
                    u.clear();
                    u.addAll(dnmresponse.getDnmProducts());
                    t.clear();
                    t.addAll(dnmresponse.getProducts());
                    v.clear();
                    v.addAll(dnmresponse.getProductSkus());
                    q.addFooterView(s, null, false);
                    G = 1;
                    r = new fh(a, 0x7f0300bb, t, u, f);
                    q.setAdapter(r);
                }
            } else
            {
                if (dnmresponse.getProducts() != null)
                {
                    t.addAll(dnmresponse.getProducts());
                }
                if (dnmresponse.getDnmProducts() != null)
                {
                    u.addAll(dnmresponse.getDnmProducts());
                }
                if (dnmresponse.getProductSkus() != null)
                {
                    v.addAll(dnmresponse.getProductSkus());
                }
                r.notifyDataSetChanged();
            }
            q.setOnScrollListener(O);
            if (z == v.size())
            {
                G = 0;
                s.findViewById(0x7f0c0303).setVisibility(8);
                s.findViewById(0x7f0c0304).setVisibility(0);
                if (A.getVisibility() != 0)
                {
                    s.findViewById(0x7f0c0303).setVisibility(8);
                }
                if (t.size() == 1)
                {
                    s.findViewById(0x7f0c0303).setVisibility(8);
                    s.findViewById(0x7f0c0304).setVisibility(0);
                }
            }
        }
    }

    public void a(String s1)
    {
        I = s1;
        k = 1;
        (new iq(a, this, j, y, h, i, 50, k, 20, c, E, F, s1)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void a(String s1, Address address)
    {
        y = "";
        h = address.getLatitude();
        i = address.getLongitude();
        m.setText((new StringBuilder()).append("Results for \"").append(s1).append("\"").toString());
        c();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = ((BBYBaseFragmentActivity)a).getCurrentActionBarTitle();
        f.i(bundle);
        ((BBYBaseFragmentActivity)a).hideActionBarHome();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
label0:
        {
            super.onActivityResult(i1, j1, intent);
            if (intent != null)
            {
                if (!intent.hasExtra("CLEAR_ALL"))
                {
                    break label0;
                }
                E.clear();
                F = "";
                c();
            }
            return;
        }
        if (intent.hasExtra("SELECTED_FACETS"))
        {
            E = (ArrayList)intent.getSerializableExtra("SELECTED_FACETS");
        }
        if (intent.hasExtra("SORT_ORDER"))
        {
            F = intent.getStringExtra("SORT_ORDER");
            if (F.equals("rating"))
            {
                F = "";
            }
        }
        if (!intent.hasExtra("BASE_FACETS"));
        k = 1;
        (new iq(a, this, j, y, h, i, 50, k, 20, c, E, F, I)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
        ((HomeActivity)activity).setOnDNMSearchListener(this);
    }

    public void onClick(View view)
    {
        if (view != n) goto _L2; else goto _L1
_L1:
        if (p.getVisibility() != 8) goto _L4; else goto _L3
_L3:
        p.setVisibility(0);
        o.setVisibility(8);
_L6:
        return;
_L4:
        p.setVisibility(8);
        o.setVisibility(0);
        return;
_L2:
        if (view == A)
        {
            view = new Intent(a, com/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity);
            view.putExtra("DNM_RESPONSE", B);
            view.putExtra("DNM_BASE_FACETS", C);
            view.putExtra("DNM_BASE_SORTOPTIONS", D);
            view.putExtra("STORE_ID", y);
            view.putExtra("LAT", h);
            view.putExtra("LNG", i);
            view.putExtra("RADIUS", 50);
            view.putExtra("DNM_TYPE", c);
            view.putExtra("SELECTED_SORT_OPTION", F);
            view.putExtra("SELECTED_FACETS", E);
            view.putExtra("SEARCH_QUERY", I);
            a.startActivityForResult(view, 4444);
            a.overridePendingTransition(0x7f04000e, 0x7f040005);
            return;
        }
        if (view == H)
        {
            Intent intent = new Intent(a, com/bestbuy/android/activities/dnm/DNMDetailsModel);
            if (c.equals("OpenBox"))
            {
                view = getString(0x7f08029d);
            } else
            {
                view = getString(0x7f08029c);
            }
            intent.putExtra("URL", (new StringBuilder()).append("file:///android_asset/").append(view).toString());
            intent.putExtra("DNM_TYPE", c);
            a.startActivity(intent);
            a.overridePendingTransition(0x7f04000e, 0x7f040005);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        M = layoutinflater;
        if (b == null)
        {
            b = layoutinflater.inflate(0x7f03002f, viewgroup, false);
            viewgroup = layoutinflater.inflate(0x7f030030, q, false);
            j = b.findViewById(0x7f0c0064);
            K = (RelativeLayout)b.findViewById(0x7f0c00b9);
            N = (BBYTextView)b.findViewById(0x7f0c00bb);
            L = (LinearLayout)b.findViewById(0x7f0c00bd);
            J = (LinearLayout)b.findViewById(0x7f0c00c0);
            q = (ListView)b.findViewById(0x7f0c00b8);
            q.addHeaderView(viewgroup);
            A = (RelativeLayout)b.findViewById(0x7f0c00be);
            A.setOnClickListener(this);
            q.setOnScrollListener(O);
            s = layoutinflater.inflate(0x7f0300bc, null);
            (new iq(a, this, j, y, h, i, 50, k, 20, c, E, F, I)).executeOnExecutor(nb.h, new Void[0]);
            b();
        } else
        {
            ((ViewGroup)b.getParent()).removeView(b);
        }
        q.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final DNMListFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
label0:
                {
                    if (i1 > 0)
                    {
                        adapterview = (DNMProduct)DNMListFragment.a(a).get(i1 - 1);
                        if (adapterview.getNoOfStoresItemAvlbl() <= 1)
                        {
                            break label0;
                        }
                        adapterview = new DNMSubListFragment((BBYProduct)DNMListFragment.b(a).get(i1 - 1), DNMListFragment.c(a), DNMListFragment.d(a), DNMListFragment.e(a), DNMListFragment.f(a), adapterview.getNoOfStoresItemAvlbl(), DNMListFragment.g(a), DNMListFragment.h(a), DNMListFragment.i(a));
                        ((DNMListFragmentContainer)a.getParentFragment()).a(adapterview, true);
                    }
                    return;
                }
                ((HomeActivity)DNMListFragment.j(a)).openPDP(adapterview.getSkuId(), "", adapterview.getProductId(), true, adapterview, false, false, false, "");
            }

            
            {
                a = DNMListFragment.this;
                super();
            }
        });
        return b;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)a).changeActionBarSearchAndQueryVisibility(a, true, "");
    }

    public void onPause()
    {
        super.onPause();
        InputMethodManager inputmethodmanager = (InputMethodManager)a.getSystemService("input_method");
        if (a.getCurrentFocus() != null && a.getCurrentFocus().getWindowToken() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)a).updateActionBarTitle("");
        if (l())
        {
            (new iq(a, this, j, y, h, i, 50, k, 20, c, E, F, I)).executeOnExecutor(nb.h, new Void[0]);
        }
    }
}
