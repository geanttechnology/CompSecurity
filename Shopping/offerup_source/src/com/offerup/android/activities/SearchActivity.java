// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.al;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.bi;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.apptentive.android.sdk.Apptentive;
import com.b.a.a.g;
import com.b.a.a.j;
import com.facebook.appevents.AppEventsLogger;
import com.google.gson.Gson;
import com.offerup.android.a.ah;
import com.offerup.android.a.ai;
import com.offerup.android.dto.Data;
import com.offerup.android.dto.FilterTypes;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.OfferUpResponse;
import com.offerup.android.e.d;
import com.offerup.android.network.SearchService;
import com.offerup.android.network.o;
import com.offerup.android.providers.a;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.an;
import com.offerup.android.utils.ap;
import com.offerup.android.utils.as;
import com.offerup.android.utils.n;
import com.offerup.android.utils.x;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            h, hb, gs, gt, 
//            hc, ha, gy, a, 
//            ItemDetailActivity, gz, gr, gu, 
//            gv, gw, gx

public class SearchActivity extends h
    implements bi
{

    private static OfferUpLocation y;
    private View A;
    private Toolbar B;
    private TextView C;
    private SwipeRefreshLayout D;
    private MenuItem E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private String K;
    private List L;
    private ArrayList M;
    private ArrayList N;
    private String O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private hb S;
    private int T;
    private int U;
    private List V;
    private boolean W;
    private boolean X;
    private ExecutorService Y;
    TextView a;
    private String b;
    private String c;
    private String d;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private RecyclerView u;
    private ah v;
    private StaggeredGridLayoutManager w;
    private gz x;
    private View z;

    public SearchActivity()
    {
        b = "";
        c = "";
        d = "";
        j = "";
        k = "";
        l = "";
        m = "";
        n = "";
        o = "";
        p = "";
        q = "";
        t = "SearchActivity";
        G = 1;
        Q = false;
        R = true;
        V = new ArrayList();
        Y = Executors.newSingleThreadExecutor();
    }

    static int a(SearchActivity searchactivity, int i1)
    {
        searchactivity.U = i1;
        return i1;
    }

    static hb a(SearchActivity searchactivity, hb hb1)
    {
        searchactivity.S = hb1;
        return hb1;
    }

    static String a(SearchActivity searchactivity)
    {
        return searchactivity.I;
    }

    static String a(SearchActivity searchactivity, String s1)
    {
        searchactivity.I = s1;
        return s1;
    }

    private void a(Intent intent)
    {
        X = intent.getBooleanExtra("activity_started_externally", false);
        if (X)
        {
            a(intent.getStringExtra("query"));
            G = intent.getIntExtra("lid", 0);
            H = intent.getIntExtra("cid", 0);
            if (intent.hasExtra("loc"))
            {
                y = new OfferUpLocation((Location)intent.getParcelableExtra("loc"));
            }
            c(true);
            return;
        }
        if ("android.intent.action.SEARCH".equals(intent.getAction()))
        {
            intent = intent.getExtras();
            S = hb.b;
            a(((Bundle) (intent)));
            c(true);
            return;
        }
        if ("com.google.android.gms.actions.SEARCH_ACTION".equals(intent.getAction()))
        {
            intent = intent.getExtras();
            S = hb.c;
            a(((Bundle) (intent)));
            c(true);
            return;
        }
        intent = intent.getExtras();
        if (intent != null)
        {
            a(((Bundle) (intent)));
            if (StringUtils.isEmpty(intent.getString("saveSortFilter")))
            {
                O = null;
                L = null;
                t();
            }
            if (TextUtils.isEmpty(I))
            {
                Object obj;
                String s1;
                if (intent.containsKey("listName"))
                {
                    r = intent.getString("listName");
                    J = r;
                } else
                {
                    r = b;
                }
                s = r;
                G = intent.getInt("listId", 1);
            }
            if (intent.containsKey("response"))
            {
                obj = new Gson();
                s1 = intent.getString("response");
                com.b.a.a.g.a("MICHAEL", (new StringBuilder("OfferActivity about retrieve json string ")).append(s1.length()).toString());
                obj = (OfferUpResponse)((Gson) (obj)).fromJson(s1, com/offerup/android/dto/OfferUpResponse);
                r = getString(0x7f090188);
                if (((OfferUpResponse) (obj)).isSuccess())
                {
                    U = ((OfferUpResponse) (obj)).getData().getTotal();
                    a(((OfferUpResponse) (obj)), 1);
                }
            }
            if (intent.containsKey("location"))
            {
                intent = (OfferUpLocation)intent.getParcelable("location");
                if (intent != null)
                {
                    y = intent;
                } else
                if (y == null)
                {
                    q();
                }
            }
        }
        if (y != null)
        {
            c(true);
            return;
        } else
        {
            q();
            return;
        }
    }

    private void a(Bundle bundle)
    {
        if (bundle.containsKey("query"))
        {
            a(bundle.getString("query"));
        }
    }

    static void a(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.c(flag);
    }

    private void a(String s1)
    {
        if (StringUtils.isNotEmpty(s1))
        {
            s1 = s1.trim().toLowerCase();
            (new a(this, "com.offerup.android.providers.SearchSuggestionProvider", 1)).saveRecentQuery(s1, null);
            if (!StringUtils.equals(s1, I))
            {
                I = s1;
            }
            supportInvalidateOptionsMenu();
        }
    }

    private void b(Intent intent)
    {
        String s1;
label0:
        {
            if (intent.hasExtra("location"))
            {
                y = (OfferUpLocation)intent.getParcelableExtra("location");
            }
            String s2 = r;
            if (!StringUtils.isEmpty(s2))
            {
                s1 = s2;
                if (!s2.contains(b))
                {
                    break label0;
                }
            }
            s1 = c;
        }
        if (y != null)
        {
            if (StringUtils.isNotEmpty(y.f()))
            {
                K = y.f();
                a.setText((new StringBuilder()).append(s1).append(" near ").append(y.f()).append(", ").append(y.g()).toString());
            } else
            if (StringUtils.isNotEmpty(y.a()))
            {
                a.setText((new StringBuilder()).append(s1).append(" near ").append(y.a()).toString());
            } else
            {
                a.setText((new StringBuilder()).append(s1).append(" Nearby").toString());
            }
            y.a();
            u();
            return;
        }
        intent = intent.getStringExtra("address");
        String s3 = e.E();
        String s4 = e.I();
        String s5 = e.J();
        if (StringUtils.isNotEmpty(intent))
        {
            if (StringUtils.isNotEmpty(s4))
            {
                K = s4;
                a.setText((new StringBuilder()).append(s1).append(" near ").append(s4).append(", ").append(s5).toString());
            } else
            if (StringUtils.isNotEmpty(s3))
            {
                a.setText((new StringBuilder()).append(s1).append(" near ").append(s3).toString());
            } else
            {
                a.setText((new StringBuilder()).append(s1).append(" Nearby").toString());
            }
        } else
        if (StringUtils.isNotEmpty(s3))
        {
            a.setText((new StringBuilder()).append(s1).append(" near ").append(s3).toString());
        } else
        {
            a.setText((new StringBuilder()).append(s1).append(" Nearby").toString());
        }
        u();
    }

    static void b(SearchActivity searchactivity, String s1)
    {
        searchactivity.a(s1);
    }

    private void b(boolean flag)
    {
        android.app.AlertDialog.Builder builder;
        try
        {
            builder = com.offerup.android.utils.n.c(this);
        }
        catch (Exception exception)
        {
            Log.e(t, Log.getStackTraceString(exception));
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        builder.setTitle(k);
        builder.setMessage(l);
_L2:
        builder.setPositiveButton(o, new gs(this));
        builder.setNegativeButton(p, new gt(this));
        com.offerup.android.utils.n.a(builder);
        return;
        builder.setTitle(m);
        builder.setMessage(n);
        if (true) goto _L2; else goto _L1
_L1:
    }

    static boolean b(SearchActivity searchactivity)
    {
        return searchactivity.W;
    }

    static boolean b(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.R = flag;
        return flag;
    }

    static ArrayList c(SearchActivity searchactivity)
    {
        return searchactivity.N;
    }

    private void c(Intent intent)
    {
        Object obj = intent.getStringArrayListExtra("filter");
        b(intent);
        O = intent.getStringExtra("sort");
        if (obj != null && ((List) (obj)).size() > 0)
        {
            L = new ArrayList(((List) (obj)).size());
            String s1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); L.add(new FilterTypes(s1, intent.getStringExtra(s1))))
            {
                s1 = (String)((Iterator) (obj)).next();
            }

        }
        v();
        c(true);
    }

    private void c(boolean flag)
    {
        Object obj;
        Object obj1;
        int i1;
        i1 = F;
        i();
        System.gc();
        if (!android.support.v4.e.a.b(this))
        {
            break MISSING_BLOCK_LABEL_404;
        }
        P = true;
        Object obj2;
        String s1;
        List list;
        long l1;
        long l2;
        if (flag)
        {
            try
            {
                g = ProgressDialog.show(this, "", d);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                try
                {
                    (new hc(this)).execute(new Void[0]);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            }
        }
        if (flag)
        {
            i1 = 1;
        }
        obj1 = y;
        obj2 = I;
        l1 = G;
        l2 = H;
        s1 = O;
        list = L;
        obj = new HashMap();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        if (((OfferUpLocation) (obj1)).d() == 0.0D || ((OfferUpLocation) (obj1)).c() == 0.0D || ((OfferUpLocation) (obj1)).d() == 47.609999899999998D || ((OfferUpLocation) (obj1)).c() == -122.33399999D) goto _L4; else goto _L3
_L3:
        ((Map) (obj)).put("lon", String.valueOf(((OfferUpLocation) (obj1)).c()));
        ((Map) (obj)).put("lat", String.valueOf(((OfferUpLocation) (obj1)).d()));
_L2:
        if (StringUtils.isNotEmpty(((CharSequence) (obj2))))
        {
            ((Map) (obj)).put("q", obj2);
        }
        if (l1 > 0L)
        {
            ((Map) (obj)).put("lid", String.valueOf(l1));
        }
        if (l2 > 0L)
        {
            ((Map) (obj)).put("cid", String.valueOf(l2));
        }
        if (StringUtils.isNotEmpty(s1))
        {
            ((Map) (obj)).put("sort", s1);
        }
        if (list != null && list.size() > 0)
        {
            for (obj1 = list.iterator(); ((Iterator) (obj1)).hasNext(); ((Map) (obj)).put(((FilterTypes) (obj2)).getType(), ((FilterTypes) (obj2)).getName()))
            {
                obj2 = (FilterTypes)((Iterator) (obj1)).next();
            }

        }
        break; /* Loop/switch isn't completed */
_L4:
        if (StringUtils.isNotEmpty(((OfferUpLocation) (obj1)).a()))
        {
            ((Map) (obj)).put("zipcode", ((OfferUpLocation) (obj1)).a());
        }
        if (true) goto _L2; else goto _L5
_L5:
        com.offerup.android.network.o.a(com.offerup.android.network.o.c(Y)).doSearchWithCallBack(i1, 50, ((Map) (obj)), new ha(this, i1, S, (byte)0));
        return;
        b(false);
        return;
    }

    static boolean c(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.Q = false;
        return false;
    }

    static ArrayList d(SearchActivity searchactivity)
    {
        return searchactivity.M;
    }

    static boolean d(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.P = false;
        return false;
    }

    static int e(SearchActivity searchactivity)
    {
        return searchactivity.F;
    }

    static void e(SearchActivity searchactivity, boolean flag)
    {
        searchactivity.b(true);
    }

    static String f(SearchActivity searchactivity)
    {
        return searchactivity.r;
    }

    static MenuItem g(SearchActivity searchactivity)
    {
        return searchactivity.E;
    }

    static void h(SearchActivity searchactivity)
    {
        searchactivity.v();
    }

    static boolean i(SearchActivity searchactivity)
    {
        return searchactivity.Q;
    }

    static List j(SearchActivity searchactivity)
    {
        return searchactivity.V;
    }

    static String k(SearchActivity searchactivity)
    {
        return searchactivity.J;
    }

    static String l(SearchActivity searchactivity)
    {
        return searchactivity.K;
    }

    static String m(SearchActivity searchactivity)
    {
        return searchactivity.d;
    }

    static StaggeredGridLayoutManager n(SearchActivity searchactivity)
    {
        return searchactivity.w;
    }

    static ah o(SearchActivity searchactivity)
    {
        return searchactivity.v;
    }

    static OfferUpLocation p()
    {
        return y;
    }

    private void q()
    {
        if (an.b(ap.a))
        {
            y = an.a(ap.a);
            c(true);
            return;
        } else
        {
            i();
            g = ProgressDialog.show(this, "", j);
            g.setCancelable(true);
            f();
            return;
        }
    }

    private boolean r()
    {
        return G != 1;
    }

    private void s()
    {
        try
        {
            v();
            F = 1;
            c(true);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(t, exception);
        }
    }

    private void t()
    {
        C.setBackgroundResource(0x7f02011f);
        C.setTextColor(getResources().getColor(0x7f0e00be));
        C.setCompoundDrawablesWithIntrinsicBounds(0x7f020110, 0, 0, 0);
        W = false;
    }

    private void u()
    {
        F = 1;
        U = 0x7fffffff;
        v();
    }

    private void v()
    {
        if (v != null)
        {
            v.a();
            v.notifyDataSetChanged();
            return;
        } else
        {
            new ai(this, new ArrayList());
            v.a(A);
            u.setAdapter(v);
            return;
        }
    }

    public final void a()
    {
        P = true;
        Q = true;
        T = gy.e;
        F = 1;
        P = false;
        supportInvalidateOptionsMenu();
        a.setText(q);
        c(true);
        if (D.a())
        {
            D.setRefreshing(false);
        }
    }

    protected final void a(ActionBar actionbar)
    {
label0:
        {
            super.a(actionbar);
            if (actionbar != null)
            {
                if (!r() || !StringUtils.isNotEmpty(r))
                {
                    break label0;
                }
                actionbar.setTitle(r);
                actionbar.setDisplayShowTitleEnabled(true);
                actionbar.setDisplayUseLogoEnabled(false);
            }
            return;
        }
        actionbar.setHomeAsUpIndicator(0x7f020015);
    }

    public final void a(OfferUpResponse offerupresponse, int i1)
    {
        if (offerupresponse == null || !offerupresponse.isSuccess())
        {
            break MISSING_BLOCK_LABEL_272;
        }
        ArrayList arraylist;
        try
        {
            if (v == null)
            {
                v = new ai(this, new ArrayList());
                v.a(A);
                u.setAdapter(v);
            }
            z.setVisibility(8);
            U = offerupresponse.getData().getTotal();
            v.b(U);
            if (U == 0)
            {
                as.a(com.b.a.a.j.a().U(), this);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (OfferUpResponse offerupresponse)
        {
            com.b.a.a.g.a(t, offerupresponse);
            return;
        }
        arraylist = offerupresponse.getData().getItems();
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (arraylist.size() > 0)
        {
            v.a(arraylist);
            v.notifyDataSetChanged();
        }
        N = offerupresponse.getData().getSorts();
        M = offerupresponse.getData().getFilters();
        if (i1 != 1)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        if (arraylist.size() > 0)
        {
            offerupresponse = (Item)arraylist.get(0);
            a.setText(offerupresponse.getSortLabel());
        }
        if (N != null && !N.isEmpty() || M != null && !M.isEmpty())
        {
            break MISSING_BLOCK_LABEL_261;
        }
        C.setVisibility(8);
_L1:
        F = i1 + 1;
        return;
        C.setVisibility(0);
          goto _L1
    }

    public final void a(OfferUpLocation offeruplocation)
    {
        i();
        if (offeruplocation != null)
        {
            y = offeruplocation;
            if (offeruplocation.i() != null)
            {
                an.a(ap.a, offeruplocation.i());
            }
        }
        c(true);
    }

    final String b()
    {
        if (L != null && L.size() > 0 || StringUtils.isNotEmpty(O))
        {
            return "filtered_search";
        } else
        {
            return "search";
        }
    }

    public final void b(int i1)
    {
        Object obj1;
        boolean flag;
        obj1 = (Item)v.a(i1);
        flag = StringUtils.isNotEmpty(I);
        if (!X)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        Object obj = "deeplink";
_L1:
        com.offerup.android.activities.a a1;
        int j1;
        long l1;
        if (!V.contains(Long.valueOf(((Item) (obj1)).getId())))
        {
            break MISSING_BLOCK_LABEL_191;
        }
        a1 = f;
        l1 = ((Item) (obj1)).getId();
        j1 = G;
        if (l1 > 0L)
        {
            try
            {
                obj1 = new Intent(a1.a, com/offerup/android/activities/ItemDetailActivity);
                ((Intent) (obj1)).putExtra("itemId", l1);
                ((Intent) (obj1)).putExtra("originScreenViewKey", ((String) (obj)));
                ((Intent) (obj1)).putExtra("listId", j1);
                ((Intent) (obj1)).putExtra("itemListPosition", i1);
                ((Intent) (obj1)).putExtra("hasSearchQuery", flag);
                ((Intent) (obj1)).addFlags(0x20000);
                a1.a.startActivity(((Intent) (obj1)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.b.a.a.g.a(t, ((Exception) (obj)));
            }
            break MISSING_BLOCK_LABEL_190;
        }
        break MISSING_BLOCK_LABEL_165;
        obj = b();
          goto _L1
        com.b.a.a.g.a(a1, new Exception("itemId is 0"));
        return;
        return;
        a1 = f;
        j1 = G;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        Intent intent = new Intent(a1.a, com/offerup/android/activities/ItemDetailActivity);
        intent.putExtra("item", ((android.os.Parcelable) (obj1)));
        intent.putExtra("originScreenViewKey", ((String) (obj)));
        intent.putExtra("listId", j1);
        intent.putExtra("itemListPosition", i1);
        intent.putExtra("hasSearchQuery", flag);
        intent.addFlags(0x20000);
        a1.a.startActivity(intent);
        return;
        com.b.a.a.g.a(a1, new Exception("item is null"));
        return;
    }

    public final int c()
    {
        return !r() ? 0 : 1;
    }

    public final boolean d()
    {
        return true;
    }

    public final int e()
    {
        return 0x7f11000c;
    }

    public void itemUpdatedAvailable(d d1)
    {
        V.add(Long.valueOf(d1.a()));
    }

    public final void m()
    {
        while (v.getItemCount() >= U || P) 
        {
            return;
        }
        c(false);
    }

    public final void n()
    {
        if (z != null && P && F > 1)
        {
            z.setVisibility(0);
        }
    }

    public final void o()
    {
        if (z != null)
        {
            z.setVisibility(8);
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        T = gy.b;
        if (i1 == 615 && j1 == -1)
        {
            b(intent);
            v();
            c(true);
        }
        if (i1 != 7) goto _L2; else goto _L1
_L1:
        if (j1 != 9) goto _L4; else goto _L3
_L3:
        c(intent);
        C.setBackgroundResource(0x7f020121);
        C.setTextColor(getResources().getColor(0x7f0e0137));
        C.setCompoundDrawablesWithIntrinsicBounds(0x7f020111, 0, 0, 0);
        W = true;
_L6:
        supportInvalidateOptionsMenu();
_L2:
        return;
_L4:
        if (j1 == 8)
        {
            c(intent);
            t();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onBackPressed()
    {
        if (i.g())
        {
            i.e();
            return;
        }
        if (StringUtils.isNotEmpty(I) && E != null)
        {
            al.c(E);
            return;
        }
        if (X)
        {
            f.m();
            return;
        } else
        {
            super.k();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04003a);
        C = (TextView)findViewById(0x7f10012c);
        z = findViewById(0x7f10012d);
        a = (TextView)findViewById(0x7f10012b);
        D = (SwipeRefreshLayout)findViewById(0x7f100091);
        u = (RecyclerView)findViewById(0x7f1000fd);
        com.offerup.android.b.a.getInstance().register(this);
        T = gy.c;
        b = getString(0x7f090188);
        c = getString(0x7f0901b2);
        d = getString(0x7f09013c);
        j = getString(0x7f09011a);
        k = getString(0x7f09017d);
        l = getString(0x7f09017b);
        m = getString(0x7f090178);
        n = getString(0x7f090176);
        o = getString(0x7f090177);
        p = getString(0x7f090175);
        q = getString(0x7f0901d4);
        r = b;
        a(getIntent());
        s = "Offers Nearby";
        a.setText(s);
        D.setOnRefreshListener(this);
        D.setColorSchemeResources(new int[] {
            0x7f0e0050
        });
        int i1 = (int)((double)(getApplicationContext().getResources().getDisplayMetrics().density * 35F) + 0.5D);
        D.a(true, i1, i1 * 3);
        u.setHasFixedSize(true);
        w = new StaggeredGridLayoutManager(getResources().getInteger(0x7f0d0005), 1);
        u.setLayoutManager(w);
        A = getLayoutInflater().inflate(0x7f0400a3, null);
        x = new gz(this, (byte)0);
        v = new ai(this, new ArrayList());
        A.setLayoutParams(w.generateDefaultLayoutParams());
        v.a(A);
        u.setAdapter(v);
        u.setOnScrollListener(x);
        B = (Toolbar)findViewById(0x7f100094);
        setSupportActionBar(B);
        a(getSupportActionBar());
        F = 1;
        C.setOnClickListener(new gr(this));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        boolean flag = super.onCreateOptionsMenu(menu);
        E = menu.findItem(0x7f1002e7);
        MenuItem menuitem = menu.findItem(0x7f1002d2);
        MenuItem menuitem1 = menu.findItem(0x7f1002e8);
        menu = menu.findItem(0x7f1002e9);
        SearchManager searchmanager = (SearchManager)getSystemService("search");
        SearchView searchview = (SearchView)al.a(E);
        MenuItem menuitem2 = E;
        if (menuitem2 != null && searchview != null)
        {
            if (TextUtils.isEmpty(I))
            {
                searchview.setQuery("", false);
                searchview.onActionViewCollapsed();
                al.c(menuitem2);
            } else
            {
                al.b(menuitem2);
                searchview.onActionViewExpanded();
                searchview.setQuery(I, false);
            }
            searchview.clearFocus();
        }
        searchview.setFocusable(false);
        searchview.setSearchableInfo(searchmanager.getSearchableInfo(getComponentName()));
        al.a(E, new gu(this, menuitem, menuitem1, menu, searchview));
        searchview.setOnQueryTextFocusChangeListener(new gv(this));
        searchview.setOnQueryTextListener(new gw(this));
        searchview.setOnSuggestionListener(new gx(this, searchview));
        return flag;
    }

    protected void onDestroy()
    {
        com.offerup.android.b.a.getInstance().unregister(this);
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Q = true;
        T = com.offerup.android.activities.gy.d;
        F = 1;
        H = 0;
        G = 1;
        P = false;
        v();
        a(intent);
        supportInvalidateOptionsMenu();
        a.setText(s);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            if (r())
            {
                onBackPressed();
            } else
            {
                i.h();
            }
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onPause()
    {
        P = false;
        System.gc();
        AppEventsLogger.deactivateApp(this);
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem = menu.findItem(0x7f1002e9);
        MenuItem menuitem1 = menu.findItem(0x7f1002d2);
        MenuItem menuitem2 = menu.findItem(0x7f1002e8);
        if (R)
        {
            menuitem.setVisible(true);
            menuitem1.setVisible(true);
            menuitem2.setVisible(true);
        } else
        {
            menuitem.setVisible(false);
            menuitem1.setVisible(false);
            menuitem2.setVisible(false);
        }
        if (r())
        {
            menuitem2.setVisible(false);
            return true;
        } else
        {
            return super.onPrepareOptionsMenu(menu);
        }
    }

    protected void onResume()
    {
        super.onResume();
        AppEventsLogger.activateApp(this);
        if (T != com.offerup.android.activities.gy.a) goto _L2; else goto _L1
_L1:
        if (v == null) goto _L2; else goto _L3
_L3:
        if (v.getItemCount() != 0) goto _L5; else goto _L4
_L4:
        s();
_L2:
        T = com.offerup.android.activities.gy.a;
        return;
_L5:
        try
        {
            if (v.c >= v.getItemCount() - 25 && v.c != 0 && v.getItemCount() < v.b())
            {
                m();
            }
        }
        catch (Exception exception)
        {
            s();
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
        {
            Apptentive.engage(this, "init");
        }
    }
}
