// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.view.View;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.remix.StoreList;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.api.lib.models.solr.SolrResponse;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hz extends ka
{

    private static int a = 0;
    private String j;
    private int k;
    private int l;
    private String m;
    private boolean n;
    private Map o;
    private boolean p;
    private SearchApi q;
    private SolrResponse r;
    private boolean s;
    private String t;
    private boolean u;
    private nb v;
    private BBYStore w;
    private String x;

    public hz(Activity activity, BBYBaseFragment bbybasefragment, View view, String s1, Map map, String s2, int i1, 
            int j1)
    {
        super(activity, bbybasefragment);
        n = false;
        o = new HashMap();
        s = false;
        g = view;
        j = s1;
        l = i1;
        k = j1;
        o = map;
        m = s2;
        i = bbybasefragment;
    }

    public hz(Activity activity, BBYBaseFragment bbybasefragment, View view, String s1, Map map, String s2, int i1, 
            int j1, boolean flag, boolean flag1, boolean flag2, String s3, String s4)
    {
        super(activity, bbybasefragment);
        n = false;
        o = new HashMap();
        s = false;
        g = view;
        j = s1;
        k = i1;
        l = j1;
        i = bbybasefragment;
        o = map;
        m = s2;
        p = flag;
        s = flag1;
        x = s3;
        t = s4;
        u = flag2;
    }

    public hz(Activity activity, BBYBaseFragment bbybasefragment, View view, String s1, Map map, String s2, BBYStore bbystore, 
            int i1, int j1, boolean flag, boolean flag1, boolean flag2)
    {
        super(activity, bbybasefragment);
        n = false;
        o = new HashMap();
        s = false;
        g = view;
        j = s1;
        k = i1;
        l = j1;
        i = bbybasefragment;
        o = map;
        m = s2;
        p = flag;
        s = flag1;
        w = bbystore;
        u = flag2;
    }

    public hz(Activity activity, BBYBaseFragment bbybasefragment, View view, String s1, Map map, String s2, String s3, 
            int i1, int j1, boolean flag, boolean flag1)
    {
        super(activity, bbybasefragment);
        n = false;
        o = new HashMap();
        s = false;
        g = view;
        j = s1;
        k = i1;
        l = j1;
        i = bbybasefragment;
        o = map;
        m = s2;
        p = flag;
        s = flag1;
        t = s3;
    }

    static int a(int i1)
    {
        a = i1;
        return i1;
    }

    static View a(hz hz1)
    {
        return hz1.g;
    }

    private BBYStore a(String s1, String s2)
    {
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (s1.isEmpty()) goto _L2; else goto _L3
_L3:
        s1 = fs.a(s1, null, 0, 200).getStores();
        if (s1 == null) goto _L5; else goto _L4
_L4:
        if (s1.isEmpty()) goto _L5; else goto _L6
_L6:
        int i1 = 0;
_L11:
        if (i1 >= s1.size()) goto _L5; else goto _L7
_L7:
        BBYStore bbystore = (BBYStore)s1.get(i1);
        if (bbystore.getStoreId().equalsIgnoreCase(s2))
        {
            return bbystore;
        }
        i1++;
        continue; /* Loop/switch isn't completed */
_L2:
        s1 = fs.a(i.getActivity(), v.y(), v.z(), null, 1, 1).getStores();
        if (s1 == null) goto _L5; else goto _L8
_L8:
        if (s1.isEmpty()) goto _L5; else goto _L9
_L9:
        s1 = (BBYStore)s1.get(0);
        return s1;
        s1;
        s1.printStackTrace();
_L5:
        return null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    static Activity b(hz hz1)
    {
        return hz1.f;
    }

    static BBYBaseFragment c(hz hz1)
    {
        return hz1.i;
    }

    static View d(hz hz1)
    {
        return hz1.g;
    }

    static String e(hz hz1)
    {
        return hz1.j;
    }

    static int f()
    {
        int i1 = a;
        a = i1 + 1;
        return i1;
    }

    static Map f(hz hz1)
    {
        return hz1.o;
    }

    static String g(hz hz1)
    {
        return hz1.m;
    }

    private boolean g()
    {
        return ((LocationManager)f.getSystemService("location")).isProviderEnabled("gps");
    }

    static int h(hz hz1)
    {
        return hz1.l;
    }

    private void h()
    {
        nm.a(f, new no() {

            final hz a;

            public void a()
            {
                hz.f();
                (new hz(hz.b(a), hz.c(a), hz.d(a), hz.e(a), hz.f(a), hz.g(a), hz.h(a), hz.i(a))).executeOnExecutor(nb.h, new Void[0]);
            }

            
            {
                a = hz.this;
                super();
            }
        }, new nn() {

            final hz a;

            public void a()
            {
                hz.a(0);
                ((HomeActivity)hz.j(a)).onBackPressed();
            }

            
            {
                a = hz.this;
                super();
            }
        }, e, a);
    }

    static int i(hz hz1)
    {
        return hz1.k;
    }

    static Activity j(hz hz1)
    {
        return hz1.f;
    }

    public void a()
    {
        v = nb.a();
        u = nb.a().b().getBoolean("show_availability", false);
        if (u && g())
        {
            BBYStore bbystore;
            if (!String.valueOf(v.y()).equalsIgnoreCase("0.0") && !String.valueOf(v.z()).equalsIgnoreCase("0.0"))
            {
                if (w != null)
                {
                    bbystore = w;
                } else
                {
                    bbystore = a(x, t);
                }
            } else
            {
                bbystore = null;
            }
            q = fs.a(j, "search", bbystore.getStoreId(), o, m, false, false, l, k);
            q.setStoreDetails(bbystore);
            return;
        } else
        {
            q = fs.a(j, "search", "", o, m, false, false, l, k);
            return;
        }
    }

    public void b()
    {
        a = 0;
        if (!(i instanceof PLPFragment)) goto _L2; else goto _L1
_L1:
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (!(i instanceof PLPFragment) || !i.isAdded()) goto _L4; else goto _L3
_L3:
        if (q == null) goto _L6; else goto _L5
_L5:
        ((PLPFragment)i).a(q, true);
_L4:
        return;
_L6:
        if (r != null)
        {
            ((PLPFragment)i).a(r, true);
            return;
        } else
        {
            ((PLPFragment)i).a(j);
            return;
        }
_L2:
        if ((i instanceof BBYBaseFragment) && i.isAdded())
        {
            if (q != null && q.getSkuDetails().size() > 0)
            {
                i.a(q, j);
            } else
            {
                ((HomeActivity)f).showErrorBanner(j);
            }
            if (g != null)
            {
                g.postDelayed(new Runnable() {

                    final hz a;

                    public void run()
                    {
                        hz.a(a).setVisibility(8);
                    }

            
            {
                a = hz.this;
                super();
            }
                }, 1000L);
                return;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (e)
        {
            h();
            return;
        }
        if (!n)
        {
            h();
            return;
        }
        if (j.contains("http://"))
        {
            h();
            return;
        }
        if (i instanceof PLPFragment)
        {
            ((PLPFragment)i).a(j);
            return;
        } else
        {
            ((HomeActivity)f).showErrorBanner(j);
            return;
        }
    }

    public void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
        }
        if (j != null && !j.isEmpty() && Pattern.compile("[^A-Za-z0-9]").matcher(j).find())
        {
            n = true;
        }
    }

}
