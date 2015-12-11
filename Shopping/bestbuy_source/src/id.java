// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.cart.CartTabContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.solr.SolrResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class id extends ka
{

    private static int l = 0;
    private SolrResponse a;
    private String j;
    private String k;
    private int m;
    private int n;
    private boolean o;
    private String p;
    private String q;
    private ArrayList r;

    public id(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, ArrayList arraylist, String s1, String s2, 
            String s3, int i, int i1, boolean flag)
    {
        super(activity, bbybasefragment);
        j = s1;
        g = view;
        k = s3;
        m = i;
        n = i1;
        o = flag;
        p = s;
        q = s2;
        r = arraylist;
    }

    static int a(int i)
    {
        l = i;
        return i;
    }

    static BBYBaseFragment a(id id1)
    {
        return id1.i;
    }

    static Activity b(id id1)
    {
        return id1.f;
    }

    public void a()
    {
        if (r == null || r.isEmpty())
        {
            if (p.equals("MostPopular") || p.equals("RecenltyViewed") || p.equals("CustomerAlsoBought") || p.equals("CustomerAlsoViewed") || p.equals("Trending"))
            {
                a = fs.b(p, f, j, q, k, m, n, o);
                return;
            } else
            {
                a = fs.a(p, f, j, q, k, m, n, o);
                return;
            }
        }
        if (p.equals("MostPopular") || p.equals("RecenltyViewed") || p.equals("CustomerAlsoBought") || p.equals("CustomerAlsoViewed") || p.equals("Trending"))
        {
            a = fs.b(p, f, r, j, q, k, m, n, o);
            return;
        } else
        {
            a = fs.a(p, f, r, j, q, k, m, n, o);
            return;
        }
    }

    public void b()
    {
        boolean flag = false;
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a != null)
        {
            l = 0;
            if ((i instanceof PLPFragment) && i.isAdded())
            {
                if (m > 1)
                {
                    flag = true;
                }
                ((PLPFragment)i).a(a, flag);
            }
            return;
        } else
        {
            c();
            return;
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final id a;

            public void a()
            {
                a.d();
            }

            
            {
                a = id.this;
                super();
            }
        }, new nn() {

            final id a;

            public void a()
            {
                Object obj;
                id.a(0);
                obj = id.a(a).getParentFragment();
                if (!(obj instanceof BaseTabContainer)) goto _L2; else goto _L1
_L1:
                String s;
                s = "";
                obj = (BaseTabContainer)((Fragment) (obj)).getParentFragment();
                if (!(obj instanceof HomeTabContainer)) goto _L4; else goto _L3
_L3:
                s = "HOME";
_L5:
                ((BaseTabContainer) (obj)).a(s);
                return;
_L4:
                if (obj instanceof ProductTabContainer)
                {
                    s = "PRODUCTS";
                } else
                if (obj instanceof CartTabContainer)
                {
                    s = "CART";
                }
                if (true) goto _L5; else goto _L2
_L2:
                ((HomeActivity)id.b(a)).onBackPressed();
                return;
            }

            
            {
                a = id.this;
                super();
            }
        }, e, l);
    }

    public void d()
    {
        l++;
        (new id(f, i, g, p, r, j, q, k, m, n, o)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void e()
    {
    }

    public void onPreExecute()
    {
        super.onPreExecute();
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
