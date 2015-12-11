// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.dnm.DNMSubListFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.dnm.DNMResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.ArrayList;

public class ir extends ka
{

    private static int a = 0;
    private DNMResponse j;
    private String k;
    private double l;
    private double m;
    private int n;
    private String o;
    private String p;
    private int q;
    private int r;
    private ArrayList s;
    private String t;
    private String u;

    public ir(Activity activity, BBYBaseFragment bbybasefragment, View view, String s1, double d1, double d2, int i1, String s2, String s3, int j1, int k1, ArrayList arraylist, 
            String s4, String s5)
    {
        super(activity, bbybasefragment);
        g = view;
        k = s1;
        l = d1;
        m = d2;
        n = i1;
        o = s2;
        p = s3;
        q = j1;
        r = k1;
        s = arraylist;
        t = s4;
        u = s5;
    }

    static int a(int i1)
    {
        a = i1;
        return i1;
    }

    static Activity a(ir ir1)
    {
        return ir1.f;
    }

    static BBYBaseFragment b(ir ir1)
    {
        return ir1.i;
    }

    static View c(ir ir1)
    {
        return ir1.g;
    }

    static String d(ir ir1)
    {
        return ir1.k;
    }

    static double e(ir ir1)
    {
        return ir1.l;
    }

    static double f(ir ir1)
    {
        return ir1.m;
    }

    static int f()
    {
        int i1 = a;
        a = i1 + 1;
        return i1;
    }

    static int g(ir ir1)
    {
        return ir1.n;
    }

    static String h(ir ir1)
    {
        return ir1.o;
    }

    static String i(ir ir1)
    {
        return ir1.p;
    }

    static int j(ir ir1)
    {
        return ir1.q;
    }

    static int k(ir ir1)
    {
        return ir1.r;
    }

    static ArrayList l(ir ir1)
    {
        return ir1.s;
    }

    static String m(ir ir1)
    {
        return ir1.t;
    }

    static String n(ir ir1)
    {
        return ir1.u;
    }

    static Activity o(ir ir1)
    {
        return ir1.f;
    }

    public void a()
    {
        j = fs.a(l, m, n, q, r, o, p, k, s, t, u);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (j != null)
        {
            ((DNMSubListFragment)i).a(j);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(f, new no() {

            final ir a;

            public void a()
            {
                ir.f();
                (new ir(ir.a(a), ir.b(a), ir.c(a), ir.d(a), ir.e(a), ir.f(a), ir.g(a), ir.h(a), ir.i(a), ir.j(a), ir.k(a), ir.l(a), ir.m(a), ir.n(a))).executeOnExecutor(nb.h, new Void[0]);
            }

            
            {
                a = ir.this;
                super();
            }
        }, new nn() {

            final ir a;

            public void a()
            {
                ir.a(0);
                ((HomeActivity)ir.o(a)).onBackPressed();
            }

            
            {
                a = ir.this;
                super();
            }
        }, e, a);
    }

}
