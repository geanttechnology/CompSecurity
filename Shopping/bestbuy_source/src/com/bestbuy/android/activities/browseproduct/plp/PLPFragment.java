// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import ahr;
import ahx;
import ahy;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import ci;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.dnm.DNMDetailsModel;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.plpstoreavailability.PLPStoreSelectionActivity;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.activities.registry.MyEmptyWeddingRegistryList;
import com.bestbuy.android.activities.registry.MyEmptyWishListFragment;
import com.bestbuy.android.activities.registry.WishListFragmentContainer;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.activities.search.plp.SearchPLPSortAndFilterActivity;
import com.bestbuy.android.api.lib.models.remix.Store;
import com.bestbuy.android.api.lib.models.search.Documents;
import com.bestbuy.android.api.lib.models.search.RequestInfo;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.api.lib.models.solr.Facet;
import com.bestbuy.android.api.lib.models.solr.SolrRequestInfo;
import com.bestbuy.android.api.lib.models.solr.SolrResponse;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import es;
import hf;
import hj;
import hz;
import id;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jh;
import jx;
import kb;
import kf;
import lh;
import lu;
import nb;
import nr;
import pp;
import qm;
import qn;
import qo;
import qp;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPSortAndFilterActivity

public class PLPFragment extends BBYBaseFragment
    implements ahx, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener, android.view.View.OnClickListener, ci, qo, qp
{

    private String A;
    private boolean B;
    private boolean C;
    private ArrayList D;
    private Map E;
    private String F;
    private nb G;
    private String H;
    private ArrayList I;
    private int J;
    private RelativeLayout K;
    private LinearLayout L;
    private LayoutInflater M;
    private LinearLayout N;
    private ImageView O;
    private String P;
    private ArrayList Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private String Z;
    private View a;
    private String aa;
    private int ab;
    private int ac;
    private boolean ad;
    private String ae;
    private String af;
    private boolean ag;
    private CustomSwipeToRefresh ah;
    private boolean ai;
    private String aj;
    private ArrayList ak;
    private qm al;
    private boolean am;
    private boolean an;
    private SharedPreferences ao;
    private RelativeLayout ap;
    private BBYStore aq;
    private BBYTextView ar;
    private RelativeLayout as;
    private BBYButton at;
    private BBYTextView au;
    private BBYTextView av;
    private LinearLayout aw;
    private boolean ax;
    private android.widget.AbsListView.OnScrollListener ay = new android.widget.AbsListView.OnScrollListener() {

        final PLPFragment a;

        public void onScroll(AbsListView abslistview, int i1, int j1, int k1)
        {
            if (PLPFragment.h(a) && k1 > PLPFragment.i(a))
            {
                PLPFragment.a(a, k1);
                PLPFragment.a(a, false);
            }
            if (!PLPFragment.h(a) && i1 == k1 - j1 && (long)(k1 - PLPFragment.j(a)) < PLPFragment.k(a))
            {
                a.a(k1);
                PLPFragment.b(a, PLPFragment.l(a) + 1);
                if (PLPFragment.d(a))
                {
                    if (PLPFragment.m(a) != null)
                    {
                        (new id(a.d, a, null, PLPFragment.m(a), PLPFragment.n(a), PLPFragment.o(a), PLPFragment.p(a), null, PLPFragment.l(a), PLPFragment.q(a), true)).executeOnExecutor(nb.h, new Void[0]);
                    }
                } else
                if (PLPFragment.g(a))
                {
                    (new jh(a.d, a, null, PLPFragment.r(a), PLPFragment.l(a))).executeOnExecutor(nb.g, new Void[0]);
                } else
                if (PLPFragment.s(a))
                {
                    if (PLPFragment.t(a) != null)
                    {
                        (new hf(a.d, a, PLPFragment.u(a), "Best-Match", 20, PLPFragment.l(a), false, null, PLPFragment.b(a), PLPFragment.t(a))).execute(new Void[0]);
                    } else
                    {
                        (new hf(a.d, a, PLPFragment.u(a), "Best-Match", 20, PLPFragment.l(a), false, null, PLPFragment.b(a))).execute(new Void[0]);
                    }
                } else
                {
                    PLPFragment.b(a, false);
                }
                PLPFragment.a(a, true);
            }
        }

        public void onScrollStateChanged(AbsListView abslistview, int i1)
        {
        }

            
            {
                a = PLPFragment.this;
                super();
            }
    };
    private ListView b;
    private RelativeLayout c;
    private String g;
    private String h;
    private View i;
    private es j;
    private ArrayList k;
    private ArrayList l;
    private ArrayList m;
    private ArrayList n;
    private ArrayList o;
    private boolean p;
    private int q;
    private int r;
    private long s;
    private boolean t;
    private String u;
    private SolrResponse v;
    private SearchApi w;
    private String x;
    private View y;
    private View z;

    public PLPFragment()
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
    }

    public PLPFragment(String s1, SearchApi searchapi, boolean flag)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        u = s1;
        w = searchapi;
        t = flag;
    }

    public PLPFragment(String s1, String s2, boolean flag, String s3)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        g = s2;
        h = s1;
        F = s3;
        U = flag;
    }

    public PLPFragment(String s1, String s2, boolean flag, String s3, String s4)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        g = s2;
        h = s1;
        F = s3;
        U = flag;
        af = s4;
    }

    public PLPFragment(String s1, boolean flag)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        u = s1;
        t = flag;
    }

    public PLPFragment(boolean flag, String s1, String s2, int i1)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        X = flag;
        aa = s1;
        F = s2;
        ac = i1;
    }

    public PLPFragment(boolean flag, String s1, String s2, String s3, String s4, int i1)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        Y = flag;
        A = s1;
        h = s2;
        F = s4;
        Z = s3;
        ac = i1;
    }

    public PLPFragment(boolean flag, String s1, String s2, String s3, String s4, String s5, int i1)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        B = flag;
        A = s1;
        g = s3;
        h = s2;
        F = s5;
        H = s4;
        ac = i1;
    }

    public PLPFragment(boolean flag, String s1, String s2, ArrayList arraylist, String s3, int i1)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        B = flag;
        A = s1;
        h = s2;
        F = s3;
        I = arraylist;
        ac = i1;
    }

    public PLPFragment(boolean flag, String s1, Map map, String s2, String s3, int i1)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        B = flag;
        ae = s1;
        P = s3;
        if (map != null)
        {
            E.putAll(map);
        }
        F = s2;
        ac = i1;
    }

    public PLPFragment(boolean flag, ArrayList arraylist, String s1, boolean flag1)
    {
        a = null;
        h = "";
        k = new ArrayList();
        l = null;
        m = null;
        n = null;
        o = null;
        p = true;
        q = 0;
        r = 1;
        x = "";
        B = false;
        D = null;
        E = new HashMap();
        J = 0;
        P = null;
        U = false;
        V = false;
        W = false;
        ad = true;
        aj = "";
        ak = null;
        Q = arraylist;
        R = flag1;
        h = s1;
        S = flag;
    }

    static int a(PLPFragment plpfragment, int i1)
    {
        plpfragment.q = i1;
        return i1;
    }

    static RelativeLayout a(PLPFragment plpfragment)
    {
        return plpfragment.ap;
    }

    static void a(PLPFragment plpfragment, String s1, String s2, String s3)
    {
        plpfragment.a(s1, s2, s3);
    }

    private void a(String s1, String s2)
    {
        LinearLayout linearlayout;
        View view;
        HashMap hashmap;
        linearlayout = new LinearLayout(d);
        linearlayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        linearlayout.setOrientation(1);
        linearlayout.setPadding(10, 0, 0, 10);
        view = M.inflate(0x7f0300b8, null);
        hashmap = G.P();
        view.findViewById(0x7f0c02f2).setOnClickListener(new android.view.View.OnClickListener(s2, hashmap, s1) {

            final String a;
            final HashMap b;
            final String c;
            final PLPFragment d;

            public void onClick(View view1)
            {
                String s3 = a;
                view1 = s3;
                if (b != null)
                {
                    view1 = s3;
                    if (!b.isEmpty())
                    {
                        view1 = s3;
                        if (b.containsKey(a))
                        {
                            view1 = (String)b.get(a);
                        }
                    }
                }
                PLPFragment.a(d, c, a, view1);
            }

            
            {
                d = PLPFragment.this;
                a = s1;
                b = hashmap;
                c = s2;
                super();
            }
        });
        linearlayout.addView(view);
        if (!s1.equals("category_facet") || hashmap == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = hashmap.keySet().iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        s1 = (String)iterator.next();
        if (!((String)hashmap.get(s1)).equals(s2)) goto _L5; else goto _L4
_L4:
        ((BBYTextView)view.findViewById(0x7f0c02f3)).setText(s1);
        linearlayout.setTag(s2);
        L.addView(linearlayout, 0);
        return;
_L2:
        s1 = s2;
        if (true) goto _L4; else goto _L6
_L6:
    }

    private void a(String s1, String s2, String s3)
    {
        L.removeView(L.findViewWithTag(s3));
        s3 = (String)E.get(s1);
        String s4 = URLDecoder.decode(s3, "UTF-8");
        s3 = s4;
_L5:
        if (s3 == null || !s3.contains("|")) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        arraylist = new ArrayList(Arrays.asList(TextUtils.split(s3.replace("|", "&&"), "&&")));
        arraylist.remove(s2);
        if (arraylist != null && !arraylist.isEmpty()) goto _L4; else goto _L3
_L3:
        E.remove(s1);
_L8:
        b.setVisibility(0);
        K.setVisibility(8);
        e(true);
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L5
_L4:
        Iterator iterator;
        iterator = arraylist.iterator();
        s2 = "";
_L7:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s3 = (String)iterator.next();
        s3 = (new StringBuilder()).append(s2).append(s3).toString();
        s2 = s3;
        if (arraylist.size() > 1)
        {
            s2 = (new StringBuilder()).append(s3).append("|").toString();
        }
        continue; /* Loop/switch isn't completed */
        exception;
        s2 = s3;
_L9:
        exception.printStackTrace();
        if (true) goto _L7; else goto _L6
_L6:
        try
        {
            E.put(s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
        }
          goto _L8
_L2:
        E.remove(s1);
          goto _L8
        exception;
          goto _L9
    }

    private void a(ArrayList arraylist)
    {
        HashMap hashmap;
        hashmap = G.P();
        E.clear();
        if (!U && g != null && !g.isEmpty())
        {
            E.put("category_facet", g);
        }
        if (arraylist == null || arraylist.isEmpty()) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L21:
        if (i1 >= arraylist.size()) goto _L2; else goto _L3
_L3:
        Object obj;
        String as1[];
        obj = (String)arraylist.get(i1);
        as1 = TextUtils.split(((String) (obj)), "=");
        if (!E.containsKey(as1[0])) goto _L5; else goto _L4
_L4:
        String s1 = (String)E.get(as1[0]);
        if (!((String) (obj)).contains("category_facet")) goto _L7; else goto _L6
_L6:
        if (!as1[1].contains("pcmcat") && !as1[1].contains("abcat") && !as1[1].contains("cat")) goto _L9; else goto _L8
_L8:
        E.put(as1[0], as1[1]);
          goto _L10
_L9:
        try
        {
            E.put(as1[0], hashmap.get(as1[1]));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
          goto _L10
_L7:
        if (t) goto _L12; else goto _L11
_L11:
        obj = (new StringBuilder()).append(s1).append("|").append(as1[1]).toString();
_L13:
        E.put(as1[0], obj);
          goto _L10
_L12:
        obj = (new StringBuilder()).append(s1).append("|").append(as1[1]).toString();
          goto _L13
_L5:
        if (!((String) (obj)).contains("category_facet")) goto _L15; else goto _L14
_L14:
        if (!as1[1].contains("pcmcat") && !as1[1].contains("abcat") && !as1[1].contains("cat")) goto _L17; else goto _L16
_L16:
        E.put(as1[0], as1[1]);
          goto _L10
_L17:
        E.put(as1[0], hashmap.get(as1[1]));
          goto _L10
_L15:
        if (t) goto _L19; else goto _L18
_L18:
        E.put(as1[0], as1[1]);
          goto _L10
_L19:
        E.put(as1[0], as1[1]);
          goto _L10
_L2:
        return;
_L10:
        i1++;
        if (true) goto _L21; else goto _L20
_L20:
    }

    static boolean a(PLPFragment plpfragment, boolean flag)
    {
        plpfragment.p = flag;
        return flag;
    }

    static int b(PLPFragment plpfragment, int i1)
    {
        plpfragment.r = i1;
        return i1;
    }

    static void b(PLPFragment plpfragment, boolean flag)
    {
        plpfragment.e(flag);
    }

    static boolean b(PLPFragment plpfragment)
    {
        return plpfragment.am;
    }

    static ArrayList c(PLPFragment plpfragment)
    {
        return plpfragment.k;
    }

    private void d()
    {
        if (h())
        {
            al = (new qn(d)).a(ahy.a).a(this).a(this).b();
            al.b();
            return;
        }
        if (am)
        {
            e();
            return;
        } else
        {
            g();
            return;
        }
    }

    static boolean d(PLPFragment plpfragment)
    {
        return plpfragment.B;
    }

    static String e(PLPFragment plpfragment)
    {
        return plpfragment.F;
    }

    private void e()
    {
        if (ap != null)
        {
            ap.setVisibility(8);
        }
        as.setVisibility(0);
        as.bringToFront();
        at.setOnClickListener(new android.view.View.OnClickListener() {

            final PLPFragment a;

            public void onClick(View view)
            {
                view = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                a.d.startActivityForResult(view, 5000);
            }

            
            {
                a = PLPFragment.this;
                super();
            }
        });
    }

    private void e(boolean flag)
    {
        View view = null;
        if (flag)
        {
            view = i;
        }
        if (am)
        {
            if (aq != null)
            {
                (new hz(d, this, view, u, E, ae, aq, r, 20, W, t, am)).executeOnExecutor(nb.h, new Void[0]);
                return;
            }
            String s1 = nb.a().b().getString("availability_zip", "");
            String s2 = nb.a().b().getString("availability_storeid", "");
            if (s1 != null && !s1.isEmpty() && s2 != null && !s2.isEmpty())
            {
                (new hz(d, this, view, u, E, ae, r, 20, W, t, am, s1, s2)).executeOnExecutor(nb.h, new Void[0]);
                return;
            } else
            {
                (new hz(d, this, view, u, E, ae, null, r, 20, W, t, am)).executeOnExecutor(nb.h, new Void[0]);
                return;
            }
        } else
        {
            (new hz(d, this, view, u, E, ae, "", r, 20, W, t)).executeOnExecutor(nb.h, new Void[0]);
            return;
        }
    }

    private void f()
    {
        as.setVisibility(8);
    }

    static boolean f(PLPFragment plpfragment)
    {
        return plpfragment.S;
    }

    private void g()
    {
        if (B)
        {
            if (A != null)
            {
                (new id(d, this, i, A, I, g, H, null, r, ac, true)).executeOnExecutor(nb.h, new Void[0]);
            }
            return;
        }
        if (R)
        {
            if (S || ag)
            {
                c.setVisibility(8);
                y.setVisibility(8);
            }
            try
            {
                (new hj(d, this, i, Q)).executeOnExecutor(nb.h, new Void[0]);
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            return;
        }
        if (Y)
        {
            if (aq != null)
            {
                (new hf(d, this, Z, "Best-Match", 20, 1, false, null, am, aq)).execute(new Void[0]);
                return;
            } else
            {
                (new hf(d, this, Z, "Best-Match", 20, 1, false, null, am)).execute(new Void[0]);
                return;
            }
        }
        if (X)
        {
            (new jh(d, this, null, aa, r)).executeOnExecutor(nb.h, new Void[0]);
            return;
        }
        if (t)
        {
            if (!am)
            {
                a(w, true);
                return;
            } else
            {
                e(true);
                return;
            }
        }
        if (g != null && !g.isEmpty() && (g.contains("categoryid$") || g.contains("si/products/search/www")))
        {
            u = g;
        }
        e(true);
    }

    static boolean g(PLPFragment plpfragment)
    {
        return plpfragment.X;
    }

    private boolean h()
    {
        return ((LocationManager)d.getSystemService("location")).isProviderEnabled("gps");
    }

    static boolean h(PLPFragment plpfragment)
    {
        return plpfragment.p;
    }

    static int i(PLPFragment plpfragment)
    {
        return plpfragment.q;
    }

    static int j(PLPFragment plpfragment)
    {
        return plpfragment.J;
    }

    static long k(PLPFragment plpfragment)
    {
        return plpfragment.s;
    }

    static int l(PLPFragment plpfragment)
    {
        return plpfragment.r;
    }

    static String m(PLPFragment plpfragment)
    {
        return plpfragment.A;
    }

    static ArrayList n(PLPFragment plpfragment)
    {
        return plpfragment.I;
    }

    static String o(PLPFragment plpfragment)
    {
        return plpfragment.g;
    }

    static String p(PLPFragment plpfragment)
    {
        return plpfragment.H;
    }

    static int q(PLPFragment plpfragment)
    {
        return plpfragment.ac;
    }

    static String r(PLPFragment plpfragment)
    {
        return plpfragment.aa;
    }

    static boolean s(PLPFragment plpfragment)
    {
        return plpfragment.Y;
    }

    static BBYStore t(PLPFragment plpfragment)
    {
        return plpfragment.aq;
    }

    static String u(PLPFragment plpfragment)
    {
        return plpfragment.Z;
    }

    static CustomSwipeToRefresh v(PLPFragment plpfragment)
    {
        return plpfragment.ah;
    }

    static boolean w(PLPFragment plpfragment)
    {
        return plpfragment.C;
    }

    static boolean x(PLPFragment plpfragment)
    {
        return plpfragment.U;
    }

    static String y(PLPFragment plpfragment)
    {
        return plpfragment.af;
    }

    public void a(int i1)
    {
        HashMap hashmap1;
        if (ax)
        {
            ax = false;
            b(i1);
            return;
        }
        if (ak == null)
        {
            break MISSING_BLOCK_LABEL_696;
        }
        hashmap1 = new HashMap();
        hashmap1.put("bb.numResults", Integer.valueOf(i1));
        if (ak.size() <= 0) goto _L2; else goto _L1
_L1:
        String s1;
        StringBuilder stringbuilder3;
        s1 = "";
        stringbuilder3 = new StringBuilder();
        i1 = 0;
        while (i1 < ak.size()) 
        {
            if (((String)ak.get(i1)).contains("Category"))
            {
                s1 = ((String)ak.get(i1)).replace("Category", "");
            } else
            if (ak != null && ak.size() > 0)
            {
                stringbuilder3.append((new StringBuilder()).append((String)ak.get(i1)).append(" | ").toString());
            }
            i1++;
        }
        if (am)
        {
            hashmap1.put(lu.br, "1");
        }
        if (U) goto _L4; else goto _L3
_L3:
        af = lu.e;
        hashmap1.put("bb.searchTerm", u);
        hashmap1.put(lu.bp, "SRCLF");
        hashmap1.put(lu.bo, "browse,list,search,results");
        if (an)
        {
            StringBuilder stringbuilder4 = new StringBuilder();
            stringbuilder4.append(lu.e);
            if (C)
            {
                stringbuilder4.append(lu.bn);
            }
            stringbuilder4.append(lu.bl);
            stringbuilder4.append(lu.bm);
            hashmap1.put(lu.bq, stringbuilder4);
        }
        if (s1.isEmpty() && !stringbuilder3.toString().isEmpty())
        {
            hashmap1.put("bb.fullFacetList ", stringbuilder3.toString().substring(0, stringbuilder3.toString().length() - 2));
        } else
        if (stringbuilder3 != null && !stringbuilder3.toString().isEmpty())
        {
            hashmap1.put("bb.fullFacetList ", (new StringBuilder()).append("Category").append(s1).append(" | ").append(stringbuilder3.toString().substring(0, stringbuilder3.toString().length() - 2)).toString());
        } else
        {
            hashmap1.put("bb.fullFacetList ", (new StringBuilder()).append("Category").append(s1).toString());
        }
_L5:
        if (!aj.contains("Category"))
        {
            hashmap1.put("bb.currentFacetValue", aj);
        }
        lu.b((new StringBuilder()).append(af).append(lu.bn).toString(), hashmap1);
        return;
_L4:
        if (stringbuilder3 != null && !stringbuilder3.toString().isEmpty())
        {
            hashmap1.put(lu.bp, "BRCLF");
            hashmap1.put(lu.bo, "browse,list,category");
            hashmap1.put("bb.fullFacetList ", (new StringBuilder()).append("Category: ").append(af).append(s1).append(" | ").append(stringbuilder3.toString().substring(0, stringbuilder3.toString().length() - 2)).toString());
        }
        if (an)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(af);
            if (C)
            {
                stringbuilder.append(lu.bn);
            }
            stringbuilder.append(lu.bl);
            stringbuilder.append(lu.bm);
            hashmap1.put(lu.bq, stringbuilder);
        }
        if (true) goto _L5; else goto _L2
_L2:
        b(i1);
        return;
        if (C)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("bb.numResults", Integer.valueOf(i1));
            if (am)
            {
                hashmap.put(lu.br, "1");
            }
            if (!U)
            {
                hashmap.put("bb.searchTerm", u);
                hashmap.put(lu.bo, "browse,list,search,results");
                hashmap.put(lu.bp, "SRCLF");
                if (an)
                {
                    StringBuilder stringbuilder1 = new StringBuilder();
                    stringbuilder1.append(lu.e);
                    stringbuilder1.append(lu.bn);
                    stringbuilder1.append(lu.bl);
                    stringbuilder1.append(lu.bm);
                    hashmap.put(lu.bq, stringbuilder1);
                }
                lu.b(lu.f, hashmap);
                return;
            }
            hashmap.put(lu.bo, "browse,list,category");
            hashmap.put(lu.bp, "BRCLF");
            if (an)
            {
                StringBuilder stringbuilder2 = new StringBuilder();
                stringbuilder2.append(af);
                stringbuilder2.append(lu.bn);
                stringbuilder2.append(lu.bl);
                stringbuilder2.append(lu.bm);
                hashmap.put(lu.bq, stringbuilder2);
            }
            lu.b((new StringBuilder()).append(af).append(lu.bn).toString(), hashmap);
            return;
        } else
        {
            b(i1);
            return;
        }
    }

    public void a(Store store)
    {
        (new lh(d, aq, store)).show();
    }

    public void a(SearchApi searchapi, boolean flag)
    {
        if (searchapi.getStoreDetails() != null)
        {
            aq = searchapi.getStoreDetails();
        }
        i.setVisibility(8);
        as.setVisibility(8);
        if (P != null)
        {
            N.setVisibility(0);
            Iterator iterator;
            if (P.equals(getString(0x7f080077)))
            {
                O.setImageResource(0x7f020168);
            } else
            if (P.equals(getString(0x7f080075)))
            {
                O.setImageResource(0x7f020158);
            } else
            if (P.equals(getString(0x7f08012a)))
            {
                O.setImageResource(0x7f02007a);
            } else
            if (P.equals(getString(0x7f08006c)))
            {
                O.setImageResource(0x7f020133);
            }
        } else
        {
            N.setVisibility(8);
        }
        w = searchapi;
        G.a(searchapi.getCategoryMap());
        if (X)
        {
            s = ab;
        } else
        {
            s = searchapi.getTotal();
        }
        if (s != 0L) goto _L2; else goto _L1
_L1:
        b.setVisibility(8);
        K.setVisibility(0);
        L.removeAllViews();
        Object obj;
        String s1;
        List list;
        int i1;
        if (searchapi != null)
        {
            searchapi = searchapi.getRequestedFacets();
        } else
        {
            searchapi = null;
        }
        if (searchapi == null) goto _L4; else goto _L3
_L3:
        iterator = searchapi.keySet().iterator();
_L9:
        if (iterator.hasNext())
        {
            s1 = (String)iterator.next();
            list = (List)searchapi.get(s1);
            i1 = 0;
            do
            {
                if (i1 >= list.size())
                {
                    continue; /* Loop/switch isn't completed */
                }
                while (false) 
                {
                    if ((!s1.equals(getString(0x7f08012c)) && !s1.equals(getString(0x7f080157)) || P == null || !P.equals(getString(0x7f080077)) && !P.equals(getString(0x7f080075)) && !P.equals(getString(0x7f08012a))) && (!s1.equals(getString(0x7f08012c)) || P == null || !P.equals(getString(0x7f08006c))) && h != null && !h.equals(list.get(i1)))
                    {
                        a(s1, (String)list.get(i1));
                    }
                    i1++;
                }
            } while (true);
        }
          goto _L4
_L2:
        b.setVisibility(0);
        if (!B)
        {
            c.setVisibility(0);
        }
        if (X || Y)
        {
            c.setVisibility(8);
        }
        K.setVisibility(8);
        if (l == null)
        {
            l = searchapi.getFacets();
        }
        if (m == null)
        {
            m = searchapi.getSortOptions();
        }
        if (searchapi.getSkuDetails() != null && !searchapi.getSkuDetails().isEmpty() || Y) goto _L6; else goto _L5
_L5:
        if (t)
        {
            a(u);
        }
_L4:
        return;
_L6:
        if (r <= 1)
        {
            ao = nb.a().c();
            if (ao.getBoolean("FIRST_PLP_LAUNCH", true))
            {
                ao.edit().putBoolean("FIRST_PLP_LAUNCH", false).commit();
                ap.setVisibility(0);
            } else
            {
                ap.setVisibility(8);
            }
            y.findViewById(0x7f0c0303).setVisibility(0);
            p = true;
            q = 0;
            k.clear();
            if (b.getFooterViewsCount() == 0)
            {
                b.addFooterView(y, null, false);
            }
            J = 1;
            if (B)
            {
                y.findViewById(0x7f0c0304).setVisibility(8);
            } else
            {
                y.findViewById(0x7f0c0304).setVisibility(0);
            }
            if (s <= (long)k.size())
            {
                y.findViewById(0x7f0c0303).setVisibility(8);
                y.findViewById(0x7f0c0304).setVisibility(0);
            }
            if (Y)
            {
                for (i1 = 0; i1 < searchapi.getDocuments().size(); i1++)
                {
                    obj = new BBYProduct();
                    ((BBYProduct) (obj)).setSummary(((Documents)searchapi.getDocuments().get(i1)).getSummary());
                    ((BBYProduct) (obj)).setPriceBlock(((Documents)searchapi.getDocuments().get(i1)).getPriceBlock());
                    ((BBYProduct) (obj)).setSkuId(((Documents)searchapi.getDocuments().get(i1)).getSkuid());
                    if (am)
                    {
                        ((BBYProduct) (obj)).setStoreAvailability(((Documents)searchapi.getDocuments().get(i1)).getStoreAvailability());
                    }
                    k.add(obj);
                }

            } else
            if (searchapi.isPlpAvailabilityEnabled())
            {
                for (i1 = 0; i1 < searchapi.getSkuDetails().size(); i1++)
                {
                    obj = (BBYProduct)searchapi.getSkuDetails().get(i1);
                    if (am)
                    {
                        ((BBYProduct) (obj)).setStoreAvailability(((Documents)searchapi.getDocuments().get(i1)).getStoreAvailability());
                    }
                    k.add(obj);
                }

            } else
            {
                k.addAll(searchapi.getSkuDetails());
            }
            a(k.size());
            j = new es(d, this, 0x7f0300bb, k);
            if (aq != null && aq.getStoreDetails() != null)
            {
                j.a(aq.getStoreDetails().getName());
            }
            j.a(am);
            b.setAdapter(j);
            b.removeHeaderView(z);
            ((HomeActivity)d).setStoreAvailabilityVisible(searchapi.isPlpAvailabilityEnabled());
            ((HomeActivity)d).setCheckedStatus();
            if (am && searchapi.getStoreDetails() != null && searchapi.isPlpAvailabilityEnabled())
            {
                nb.a().b().edit().putString("availability_zip", searchapi.getStoreDetails().getStoreDetails().getZipCode()).commit();
                nb.a().b().edit().putString("availability_storeid", searchapi.getStoreDetails().getStoreId()).commit();
                searchapi = nr.a(aq);
                obj = aq.getDistance();
                s1 = aq.getStoreDetails().getName();
                b.addHeaderView(z);
                ar.setText(s1);
                av.setText((new StringBuilder()).append(((String) (obj))).append(" mi - ").append(searchapi).toString());
                au.setOnClickListener(this);
                ar.setOnClickListener(this);
                av.setOnClickListener(this);
                aw.setOnClickListener(this);
            } else
            {
                b.removeHeaderView(z);
            }
        } else
        {
            if (Y)
            {
                for (i1 = 0; i1 < searchapi.getDocuments().size(); i1++)
                {
                    obj = new BBYProduct();
                    ((BBYProduct) (obj)).setSummary(((Documents)searchapi.getDocuments().get(i1)).getSummary());
                    ((BBYProduct) (obj)).setPriceBlock(((Documents)searchapi.getDocuments().get(i1)).getPriceBlock());
                    ((BBYProduct) (obj)).setSkuId(((Documents)searchapi.getDocuments().get(i1)).getSkuid());
                    if (am)
                    {
                        ((BBYProduct) (obj)).setStoreAvailability(((Documents)searchapi.getDocuments().get(i1)).getStoreAvailability());
                    }
                    k.add(obj);
                }

            } else
            if (searchapi.isPlpAvailabilityEnabled())
            {
                for (i1 = 0; i1 < searchapi.getSkuDetails().size(); i1++)
                {
                    obj = (BBYProduct)searchapi.getSkuDetails().get(i1);
                    if (am)
                    {
                        ((BBYProduct) (obj)).setStoreAvailability(((Documents)searchapi.getDocuments().get(i1)).getStoreAvailability());
                    }
                    k.add(obj);
                }

            } else
            {
                k.addAll(searchapi.getSkuDetails());
            }
            j.notifyDataSetChanged();
        }
        if (s != (long)k.size()) goto _L4; else goto _L7
_L7:
        if (B)
        {
            J = 0;
            b.removeFooterView(y);
        }
        y.findViewById(0x7f0c0303).setVisibility(8);
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void a(SolrResponse solrresponse, boolean flag)
    {
        if (P != null)
        {
            N.setVisibility(0);
            Iterator iterator;
            if (P.equals(getString(0x7f080077)))
            {
                O.setImageResource(0x7f020168);
            } else
            if (P.equals(getString(0x7f080075)))
            {
                O.setImageResource(0x7f020158);
            } else
            if (P.equals(getString(0x7f08012a)))
            {
                O.setImageResource(0x7f02007a);
            } else
            if (P.equals(getString(0x7f08006c)))
            {
                O.setImageResource(0x7f020133);
            }
        } else
        {
            N.setVisibility(8);
        }
        v = solrresponse;
        G.a(solrresponse.getCategoryMap());
        if (X)
        {
            s = ab;
        } else
        {
            s = solrresponse.getTotalCount();
        }
        if (s != 0L) goto _L2; else goto _L1
_L1:
        b.setVisibility(8);
        K.setVisibility(0);
        L.removeAllViews();
        String s1;
        List list;
        int i1;
        if (solrresponse.getFacets() != null && solrresponse.getRequestInfo() != null)
        {
            solrresponse = solrresponse.getRequestInfo().getRequestedFacets();
        } else
        {
            solrresponse = null;
        }
        if (U && solrresponse != null)
        {
            solrresponse.remove("category_facet");
        }
        if (solrresponse == null) goto _L4; else goto _L3
_L3:
        iterator = solrresponse.keySet().iterator();
_L9:
        if (iterator.hasNext())
        {
            s1 = (String)iterator.next();
            list = (List)solrresponse.get(s1);
            i1 = 0;
            do
            {
                if (i1 >= list.size())
                {
                    continue; /* Loop/switch isn't completed */
                }
                while (false) 
                {
                    if ((!s1.equals(getString(0x7f08012c)) && !s1.equals(getString(0x7f080157)) || P == null || !P.equals(getString(0x7f080077)) && !P.equals(getString(0x7f080075)) && !P.equals(getString(0x7f08012a))) && (!s1.equals(getString(0x7f08012c)) || P == null || !P.equals(getString(0x7f08006c))) && h != null && !h.equals(list.get(i1)))
                    {
                        a(s1, (String)list.get(i1));
                    }
                    i1++;
                }
            } while (true);
        }
          goto _L4
_L2:
        b.setVisibility(0);
        if (!B)
        {
            c.setVisibility(0);
        }
        if (X)
        {
            c.setVisibility(8);
        }
        K.setVisibility(8);
        if (n == null)
        {
            n = solrresponse.getFacets();
        }
        if (o == null)
        {
            o = solrresponse.getSortOptions();
        }
        if (solrresponse.getBbyProducts() != null && !solrresponse.getBbyProducts().isEmpty()) goto _L6; else goto _L5
_L5:
        if (t)
        {
            a(u);
        }
_L4:
        return;
_L6:
        if (r <= 1)
        {
            y.findViewById(0x7f0c0303).setVisibility(0);
            p = true;
            q = 0;
            k.clear();
            if (b.getFooterViewsCount() == 0)
            {
                b.addFooterView(y, null, false);
            }
            J = 1;
            if (B)
            {
                y.findViewById(0x7f0c0304).setVisibility(8);
            } else
            {
                y.findViewById(0x7f0c0304).setVisibility(0);
            }
            if (s <= (long)k.size())
            {
                y.findViewById(0x7f0c0303).setVisibility(8);
                y.findViewById(0x7f0c0304).setVisibility(0);
            }
            k.addAll(solrresponse.getBbyProducts());
            j = new es(d, this, 0x7f0300bb, k);
            b.setAdapter(j);
        } else
        {
            k.addAll(solrresponse.getBbyProducts());
            j.notifyDataSetChanged();
        }
        if (s != (long)k.size()) goto _L4; else goto _L7
_L7:
        if (B)
        {
            J = 0;
            b.removeFooterView(y);
        }
        y.findViewById(0x7f0c0303).setVisibility(8);
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void a(String s1)
    {
        BBYBaseFragment bbybasefragment;
        Bundle bundle;
        if (!s1.contains("categoryid"))
        {
            HashMap hashmap = new HashMap();
            hashmap.put("bb.failedSearchTerm", s1);
            hashmap.put("bb.numResults", "zero");
            hashmap.put(lu.bo, "browse,list,search,failed");
            hashmap.put(lu.bp, "SRCL");
            lu.b(lu.d, hashmap);
        } else
        {
            s1 = "The selected category";
        }
        bbybasefragment = kb.a("NoSearchResultFragment");
        bundle = new Bundle();
        bundle.putString("Query", s1);
        bbybasefragment.setArguments(bundle);
        ((BaseFragmentContainer)getParentFragment()).a(bbybasefragment, false);
    }

    public void a(ArrayList arraylist, int i1)
    {
        ab = i1;
        if (ad)
        {
            ad = false;
            (new id(d, this, i, "Best-Match", arraylist, g, H, null, r, 20, true)).executeOnExecutor(nb.h, new Void[0]);
            return;
        } else
        {
            (new id(d, this, null, "Best-Match", arraylist, g, H, null, r, 20, true)).executeOnExecutor(nb.h, new Void[0]);
            return;
        }
    }

    public void a(ArrayList arraylist, boolean flag)
    {
        c.setVisibility(0);
        if (S || ag)
        {
            c.setVisibility(8);
            y.setVisibility(8);
        }
        if (flag && r <= 1)
        {
            b.addFooterView(y, null, false);
        }
        k.addAll(arraylist);
        if (j == null)
        {
            j = new es(d, this, 0x7f0300bb, k);
            b.setAdapter(j);
            return;
        } else
        {
            j.notifyDataSetChanged();
            return;
        }
    }

    public void a(boolean flag)
    {
        an = flag;
        if (ap != null)
        {
            ap.setVisibility(8);
        }
        am = flag;
        r = 1;
        if (h() && al.d())
        {
            as.setVisibility(8);
            i.setVisibility(0);
            ahy.b.a(al, BBYBaseFragmentActivity.REQUEST, this);
            return;
        }
        if (am)
        {
            e();
            return;
        } else
        {
            f();
            return;
        }
    }

    public void b()
    {
        ah.setEnabled(true);
    }

    public void b(int i1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("bb.numResults", Integer.valueOf(i1));
        if (am)
        {
            hashmap.put(lu.br, "1");
        }
        if (U)
        {
            hashmap.put(lu.bo, "browse,list,category");
            hashmap.put(lu.bp, "BRCL");
            if (an)
            {
                hashmap.put(lu.bq, (new StringBuilder()).append(af).append(lu.bl).append(lu.bm).toString());
            }
            lu.b(af, hashmap);
            return;
        }
        hashmap.put("bb.searchTerm", u);
        hashmap.put(lu.bo, "browse,list,search,results");
        hashmap.put(lu.bp, "SRCL");
        if (an)
        {
            hashmap.put(lu.bq, (new StringBuilder()).append(lu.e).append(lu.bl).append(lu.bm).toString());
        }
        lu.b(lu.e, hashmap);
    }

    public void b(boolean flag)
    {
        S = flag;
    }

    public void c()
    {
        ah.setEnabled(false);
    }

    public void c(boolean flag)
    {
        T = flag;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).hideActionBarHome();
        if (S || t)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarSearchAndQueryVisibility(d, true, u);
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (intent == null) goto _L2; else goto _L1
_L1:
        C = true;
        p = true;
        r = 1;
        if (!intent.hasExtra("SELECTED_FACETS")) goto _L4; else goto _L3
_L3:
        D = intent.getStringArrayListExtra("SELECTED_FACETS");
        a(D);
        ae = intent.getStringExtra("SORT_ORDER");
        e(true);
_L6:
        if (intent.hasExtra("Selected_Facets_For_Analytics") && intent.hasExtra("Latest_Facet_Selected"))
        {
            aj = intent.getStringExtra("Latest_Facet_Selected");
            ak = intent.getStringArrayListExtra("Selected_Facets_For_Analytics");
        }
        if (intent.hasExtra("SelectedStore"))
        {
            aq = (BBYStore)intent.getExtras().getSerializable("SelectedStore");
            g();
        }
_L2:
        if (i1 == 5000)
        {
            d();
        }
        return;
_L4:
        if (intent.hasExtra("CLEAR_ALL"))
        {
            ax = intent.getBooleanExtra("CLEAR_ALL", false);
            E.clear();
            ae = null;
            if (!U && g != null && !g.isEmpty())
            {
                E.put("category_facet", g);
            }
            e(true);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        ((BBYBaseFragmentActivity)activity).changeActionBarAddToVisibility(activity, false);
        am = nb.a().b().getBoolean("show_availability", false);
        if (!h())
        {
            am = false;
        }
        G = nb.a();
        C = false;
    }

    public void onClick(View view)
    {
        int i1 = 0;
        if (view != c) goto _L2; else goto _L1
_L1:
        if (v == null || t) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = new Intent(d, com/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity);
        if (C)
        {
            ((Intent) (obj)).putExtra("BASE_FACETS", n);
            ((Intent) (obj)).putExtra("BASE_SORT_OPTIONS", o);
        }
        if (U && !V)
        {
            V = true;
        }
        if (!V) goto _L6; else goto _L5
_L5:
        view = v.getFacets();
_L9:
        if (i1 >= view.size())
        {
            break MISSING_BLOCK_LABEL_1173;
        }
        if (((Facet)view.get(i1)).getCategoryMap().isEmpty()) goto _L8; else goto _L7
_L7:
        view = ((Facet)view.get(i1)).getCategoryMap();
_L18:
        if (!h.isEmpty() && view != null && !view.containsKey(h))
        {
            v.getRequestInfo().getRequestedFacets().remove("category_facet");
        }
_L6:
        ((Intent) (obj)).putExtra(getString(0x7f080082), v);
        if (P != null && !P.isEmpty())
        {
            ((Intent) (obj)).putExtra(getString(0x7f08005a), P);
        }
        ((Intent) (obj)).putExtra(getString(0x7f08007c), h);
        ((Intent) (obj)).putExtra("isSearch", t);
        d.startActivityForResult(((Intent) (obj)), 9999);
        d.overridePendingTransition(0x7f04000e, 0x7f040005);
_L11:
        return;
_L8:
        i1++;
          goto _L9
_L4:
        if (w == null) goto _L11; else goto _L10
_L10:
        view = new Intent(d, com/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity);
        view.putExtra("BreadCrumb", af);
        view.putExtra("isFacetsSearch", C);
        view.putExtra("isBrowseProduct", U);
        if (C)
        {
            view.putExtra("SEARCH_BASE_FACETS", l);
            view.putExtra("SEARCH_BASE_SORT_OPTIONS", m);
        }
        if (U && !V)
        {
            V = true;
            w.setRequestedFacets(w.getRequestedFacets());
        }
        if (V && !h.isEmpty() && w.getCategoryMap() != null && !w.getCategoryMap().containsKey(h))
        {
            obj = w.getRequestedFacets();
            if (w.getRequestInfo() != null)
            {
                String s1 = w.getRequestInfo().getQuery();
                List list = (List)((HashMap) (obj)).get("category_facet");
                if (list != null)
                {
                    for (int j1 = 0; j1 < list.size(); j1++)
                    {
                        if (s1 != null && s1.contains((CharSequence)list.get(j1)))
                        {
                            ((HashMap) (obj)).remove("category_facet");
                        }
                    }

                }
            }
        }
        view.putExtra(getString(0x7f08007b), w);
        if (P != null && !P.isEmpty())
        {
            view.putExtra(getString(0x7f08005a), P);
        }
        view.putExtra(getString(0x7f08007c), h);
        view.putExtra("isSearch", t);
        d.startActivityForResult(view, 9999);
        d.overridePendingTransition(0x7f04000e, 0x7f040005);
        return;
_L2:
        if (view != N) goto _L13; else goto _L12
_L12:
        obj = new Intent(d, com/bestbuy/android/activities/dnm/DNMDetailsModel);
        view = "";
        if (!P.equals(getString(0x7f080077))) goto _L15; else goto _L14
_L14:
        view = getString(0x7f08029f);
_L16:
        ((Intent) (obj)).putExtra(getString(0x7f080379), (new StringBuilder()).append("file:///android_asset/").append(view).toString());
        ((Intent) (obj)).putExtra(getString(0x7f08003b), P);
        d.startActivity(((Intent) (obj)));
        d.overridePendingTransition(0x7f04000e, 0x7f040005);
        return;
_L15:
        if (P.equals(getString(0x7f080075)))
        {
            view = getString(0x7f08029e);
        } else
        if (P.equals(getString(0x7f08012a)))
        {
            view = getString(0x7f08029c);
        } else
        if (P.equals(getString(0x7f08006c)))
        {
            view = getString(0x7f08029d);
        }
        if (true) goto _L16; else goto _L13
_L13:
        if (view == au)
        {
            HashMap hashmap = new HashMap();
            StringBuilder stringbuilder = new StringBuilder();
            if (U)
            {
                view = af;
            } else
            {
                view = lu.e;
            }
            stringbuilder.append(view);
            if (C)
            {
                stringbuilder.append(lu.bn);
            }
            hashmap.put(lu.bq, (new StringBuilder()).append(stringbuilder).append(lu.bl).append(lu.bk).toString());
            lu.a(lu.bk, hashmap);
            view = new Intent(d.getApplicationContext(), com/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity);
            d.startActivityForResult(view, 9999);
            d.overridePendingTransition(0x7f04000e, 0x7f040005);
            return;
        }
        if (view != ar && view != av && view != aw) goto _L11; else goto _L17
_L17:
        HashMap hashmap1 = new HashMap();
        StringBuilder stringbuilder1 = new StringBuilder();
        if (U)
        {
            view = af;
        } else
        {
            view = lu.e;
        }
        stringbuilder1.append(view);
        if (C)
        {
            stringbuilder1.append(lu.bn);
        }
        hashmap1.put(lu.bq, (new StringBuilder()).append(stringbuilder1).append(lu.bl).append(lu.bj).toString());
        lu.a(lu.bj, hashmap1);
        (new jx(d, this, null, aq.getStoreId())).executeOnExecutor(nb.h, new Void[0]);
        return;
        view = null;
          goto _L18
    }

    public void onConnected(Bundle bundle)
    {
        as.setVisibility(8);
        i.setVisibility(0);
        ahy.b.a(al, BBYBaseFragmentActivity.REQUEST, this);
    }

    public void onConnectionFailed(pp pp1)
    {
        if (pp1.a())
        {
            try
            {
                pp1.a(d, 9000);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (pp pp1)
            {
                pp1.printStackTrace();
            }
            return;
        } else
        {
            kf.b("PLPFragment", (new StringBuilder()).append("Location services connection failed with code ").append(pp1.c()).toString());
            return;
        }
    }

    public void onConnectionSuspended(int i1)
    {
        kf.b("PLPFragment", (new StringBuilder()).append("Location services suspended cause:  ").append(i1).toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((HomeActivity)d).setOnStoreAvailabiltyClickListener(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        M = layoutinflater;
        if (a == null)
        {
            a = layoutinflater.inflate(0x7f0300ba, viewgroup, false);
            ah = (CustomSwipeToRefresh)a.findViewById(0x7f0c02f9);
            ah.setColorScheme(0x7f0b0000, 0x7f0b0063, 0x7f0b0000, 0x7f0b0063);
            ah.setOnRefreshListener(this);
            ai = ChatRunningStatus.getChatRunning();
            if (!ai)
            {
                b();
            } else
            {
                c();
            }
            i = a.findViewById(0x7f0c0064);
            as = (RelativeLayout)a.findViewById(0x7f0c0036);
            at = (BBYButton)a.findViewById(0x7f0c0037);
            L = (LinearLayout)a.findViewById(0x7f0c00bd);
            b = (ListView)a.findViewById(0x7f0c0075);
            K = (RelativeLayout)a.findViewById(0x7f0c00b9);
            c = (RelativeLayout)a.findViewById(0x7f0c00be);
            c.setOnClickListener(this);
            if (B)
            {
                c.setVisibility(8);
            }
            O = (ImageView)a.findViewById(0x7f0c00c2);
            N = (LinearLayout)a.findViewById(0x7f0c00c1);
            N.setOnClickListener(this);
            b.setSelection(0x80000000);
            b.setOnScrollListener(ay);
            y = layoutinflater.inflate(0x7f0300bc, null);
            z = layoutinflater.inflate(0x7f0300b5, null);
            ar = (BBYTextView)z.findViewById(0x7f0c0024);
            au = (BBYTextView)z.findViewById(0x7f0c02ee);
            av = (BBYTextView)z.findViewById(0x7f0c02ed);
            aw = (LinearLayout)z.findViewById(0x7f0c02ec);
            if (u != null && !u.isEmpty())
            {
                x = u;
            } else
            if (h != null && !h.isEmpty())
            {
                x = h;
                u = h;
            }
            ap = ((HomeActivity)d).getActivateLayout();
            if (ap != null)
            {
                ap.setOnClickListener(new android.view.View.OnClickListener() {

                    final PLPFragment a;

                    public void onClick(View view)
                    {
                        PLPFragment.a(a).setVisibility(8);
                    }

            
            {
                a = PLPFragment.this;
                super();
            }
                });
            }
            d();
        } else
        {
            ((ViewGroup)a.getParent()).removeView(a);
        }
        b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PLPFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                boolean flag1 = true;
                if (PLPFragment.a(a) != null)
                {
                    PLPFragment.a(a).setVisibility(8);
                }
                int j1 = i1;
                String s1;
                Object obj;
                boolean flag;
                if (PLPFragment.b(a))
                {
                    if (i1 >= 1)
                    {
                        j1 = i1 - 1;
                    } else
                    {
                        j1 = i1;
                        if (i1 == 0)
                        {
                            return;
                        }
                    }
                }
                obj = (BBYProduct)PLPFragment.c(a).get(j1);
                if (PLPFragment.d(a))
                {
                    if (PLPFragment.e(a).equals("Products"))
                    {
                        ((HomeActivity)a.d).sendRecommendations("productsclickmostpopular", "product", ((BBYProduct) (obj)));
                    } else
                    if (PLPFragment.e(a).equals("Cart"))
                    {
                        ((HomeActivity)a.d).sendRecommendations("cartclickmostpopular", "cart", ((BBYProduct) (obj)));
                    }
                }
                ((HomeActivity)a.d).setStoreAvailabilityVisible(false);
                adapterview = nb.a().b().getString("availability_storeid", "");
                view = (HomeActivity)a.d;
                s1 = ((BBYProduct) (obj)).getSkuId();
                obj = (new StringBuilder()).append("").append(((BBYProduct) (obj)).getSummary().getProductId()).toString();
                flag = flag1;
                if (!PLPFragment.f(a))
                {
                    if (PLPFragment.g(a))
                    {
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                }
                view.openPDP(s1, adapterview, ((String) (obj)), false, flag);
            }

            
            {
                a = PLPFragment.this;
                super();
            }
        });
        return a;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (!S || !(getActivity() instanceof HomeActivity)) goto _L2; else goto _L1
_L1:
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(G.T());
        Object obj = ((HomeActivity)d).getSupportFragmentManager();
        Object obj1 = (EmptyWeddingRegistryContainer)((FragmentManager) (obj)).findFragmentByTag("EmptyWeddingRegistryContainer");
        if (obj1 != null)
        {
            obj = ((EmptyWeddingRegistryContainer) (obj1)).b();
            break MISSING_BLOCK_LABEL_69;
        }
        if (G.C())
        {
            obj = (WishListFragmentContainer)((FragmentManager) (obj)).findFragmentByTag("WishListFragmentContainer");
            if (obj != null)
            {
                obj = ((WishListFragmentContainer) (obj)).b();
                if (obj instanceof MyEmptyWishListFragment)
                {
                    ((MyEmptyWishListFragment)obj).b();
                }
            }
        }
          goto _L3
_L2:
        if (U)
        {
            obj = getArguments();
            obj1 = new HashMap();
            ((HashMap) (obj1)).put(lu.bo, "browse,deptCat");
            ((HashMap) (obj1)).put(lu.bp, "PRD");
            if (obj != null && !((Bundle) (obj)).getString("Category", "").isEmpty())
            {
                lu.b(((Bundle) (obj)).getString("Category", ""), ((HashMap) (obj1)));
            }
        }
        if (S || t || U)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarSearchAndQueryVisibility(d, true, "");
        }
        if (ap != null)
        {
            ap.setVisibility(8);
        }
        if (al != null && al.d())
        {
            al.c();
        }
        return;
        if ((obj instanceof MyEmptyWeddingRegistryList) || !(obj instanceof WishListWithProductsFragment));
          goto _L2
_L3:
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        ((HomeActivity)d).setStoreAvailabilityVisible(false);
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            G.a(location.getLatitude());
            G.b(location.getLongitude());
            if (al.d())
            {
                ahy.b.a(al, this);
            }
        }
        g();
    }

    public void onRefresh()
    {
        c();
        (new Handler()).postDelayed(new Runnable() {

            final PLPFragment a;

            public void run()
            {
                PLPFragment.v(a).setRefreshing(false);
                if (a.getActivity() != null)
                {
                    Intent intent = new Intent(a.getActivity(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
                    HashMap hashmap = new HashMap();
                    if (PLPFragment.w(a))
                    {
                        if (PLPFragment.x(a))
                        {
                            hashmap.put("bb.prevPageLink", (new StringBuilder()).append(PLPFragment.y(a)).append(": Faceted : Blue Assist").toString());
                        } else
                        {
                            hashmap.put("bb.prevPageLink", (new StringBuilder()).append(lu.f).append(": Blue Assist").toString());
                        }
                    } else
                    if (PLPFragment.x(a))
                    {
                        hashmap.put("bb.prevPageLink", (new StringBuilder()).append(PLPFragment.y(a)).append(": Blue Assist").toString());
                    } else
                    {
                        hashmap.put("bb.prevPageLink", (new StringBuilder()).append(lu.e).append(": Blue Assist").toString());
                    }
                    lu.b(lu.aT, hashmap);
                    a.startActivityForResult(intent, 8998);
                }
            }

            
            {
                a = PLPFragment.this;
                super();
            }
        }, 1500L);
    }

    public void onResume()
    {
        super.onResume();
        ai = ChatRunningStatus.getChatRunning();
        String s1;
        if (!ai)
        {
            b();
        } else
        {
            c();
        }
        s1 = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
        G.i(s1);
        if (W)
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
        } else
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(x);
        }
        if (l())
        {
            if (B)
            {
                if (A != null)
                {
                    (new id(d, this, i, A, I, g, H, null, r, ac, true)).executeOnExecutor(nb.h, new Void[0]);
                }
            } else
            if (t)
            {
                a(w, true);
            } else
            {
                e(true);
            }
        }
        if (X)
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(F);
            ((HomeActivity)d).changeActionBarSearchVisibility(d, false);
            (new jh(d, this, null, aa, r)).executeOnExecutor(nb.h, new Void[0]);
        }
        if (w != null && w.isPlpAvailabilityEnabled())
        {
            ((HomeActivity)d).setStoreAvailabilityVisible(w.isPlpAvailabilityEnabled());
            if (!h())
            {
                as.setVisibility(0);
            }
        }
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
        ((BBYBaseFragmentActivity)d).changeActionBarSearchAndQueryVisibility(d, true, "");
    }
}
