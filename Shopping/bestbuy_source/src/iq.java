// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.cart.CartTabContainer;
import com.bestbuy.android.activities.dnm.DNMListFragment;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.dnm.DNMResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class iq extends ka
{

    private static int a = 0;
    private DNMResponse j;
    private String k;
    private double l;
    private double m;
    private int n;
    private String o;
    private ArrayList p;
    private String q;
    private int r;
    private int s;
    private String t;

    public iq(Activity activity, BBYBaseFragment bbybasefragment, View view, String s1, double d1, double d2, int i1, int j1, int k1, String s2, ArrayList arraylist, String s3, 
            String s4)
    {
        super(activity, bbybasefragment);
        g = view;
        q = s3;
        k = s1;
        l = d1;
        m = d2;
        n = i1;
        o = s2;
        p = arraylist;
        r = j1;
        s = k1;
        t = s4;
    }

    static int a(int i1)
    {
        a = i1;
        return i1;
    }

    static Activity a(iq iq1)
    {
        return iq1.f;
    }

    static BBYBaseFragment b(iq iq1)
    {
        return iq1.i;
    }

    static View c(iq iq1)
    {
        return iq1.g;
    }

    static String d(iq iq1)
    {
        return iq1.k;
    }

    static double e(iq iq1)
    {
        return iq1.l;
    }

    static double f(iq iq1)
    {
        return iq1.m;
    }

    static int f()
    {
        int i1 = a;
        a = i1 + 1;
        return i1;
    }

    static int g(iq iq1)
    {
        return iq1.n;
    }

    static int h(iq iq1)
    {
        return iq1.r;
    }

    static int i(iq iq1)
    {
        return iq1.s;
    }

    static String j(iq iq1)
    {
        return iq1.o;
    }

    static ArrayList k(iq iq1)
    {
        return iq1.p;
    }

    static String l(iq iq1)
    {
        return iq1.q;
    }

    static String m(iq iq1)
    {
        return iq1.t;
    }

    static BBYBaseFragment n(iq iq1)
    {
        return iq1.i;
    }

    public void a()
    {
        j = fs.a(k, l, m, n, r, s, o, p, q, t);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j == null)
        {
            c();
        } else
        {
            a = 0;
            if (i instanceof DNMListFragment)
            {
                ((DNMListFragment)i).a(j);
                return;
            }
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (r > 1)
        {
            return;
        } else
        {
            nm.a(f, new no() {

                final iq a;

                public void a()
                {
                    iq.f();
                    (new iq(iq.a(a), iq.b(a), iq.c(a), iq.d(a), iq.e(a), iq.f(a), iq.g(a), iq.h(a), iq.i(a), iq.j(a), iq.k(a), iq.l(a), iq.m(a))).executeOnExecutor(nb.h, new Void[0]);
                }

            
            {
                a = iq.this;
                super();
            }
            }, new nn() {

                final iq a;

                public void a()
                {
                    String s1;
                    Object obj;
                    iq.a(0);
                    obj = iq.n(a).getParentFragment();
                    s1 = "";
                    obj = (BaseTabContainer)((Fragment) (obj)).getParentFragment();
                    if (!(obj instanceof HomeTabContainer)) goto _L2; else goto _L1
_L1:
                    s1 = "HOME";
_L4:
                    ((BaseTabContainer) (obj)).a(s1);
                    return;
_L2:
                    if (obj instanceof ProductTabContainer)
                    {
                        s1 = "PRODUCTS";
                    } else
                    if (obj instanceof CartTabContainer)
                    {
                        s1 = "CART";
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = iq.this;
                super();
            }
            }, e, a);
            return;
        }
    }

}
