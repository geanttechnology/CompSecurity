// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.blueassist.BlueAssistUserContactInfoActivity;

public class hu extends ka
{

    private Activity a;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private int r;

    public hu(Activity activity, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
    {
        r = 0;
        a = activity;
        j = s;
        k = s1;
        l = s2;
        o = s3;
        p = s4;
        m = s5;
        n = s6;
    }

    static int a(hu hu1)
    {
        int i1 = hu1.r;
        hu1.r = i1 + 1;
        return i1;
    }

    static int a(hu hu1, int i1)
    {
        hu1.r = i1;
        return i1;
    }

    static Activity b(hu hu1)
    {
        return hu1.a;
    }

    static String c(hu hu1)
    {
        return hu1.j;
    }

    static String d(hu hu1)
    {
        return hu1.k;
    }

    static String e(hu hu1)
    {
        return hu1.l;
    }

    static String f(hu hu1)
    {
        return hu1.o;
    }

    static String g(hu hu1)
    {
        return hu1.p;
    }

    static String h(hu hu1)
    {
        return hu1.m;
    }

    static String i(hu hu1)
    {
        return hu1.n;
    }

    public void a()
    {
        q = fs.a(j, k, l, o, p, m, n);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (a instanceof BlueAssistUserContactInfoActivity)
        {
            ((BlueAssistUserContactInfoActivity)a).a(q);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(a, new no() {

            final hu a;

            public void a()
            {
                hu.a(a);
                new hu(hu.b(a), hu.c(a), hu.d(a), hu.e(a), hu.f(a), hu.g(a), hu.h(a), hu.i(a));
            }

            
            {
                a = hu.this;
                super();
            }
        }, new nn() {

            final hu a;

            public void a()
            {
                hu.a(a, 0);
                hu.b(a).finish();
            }

            
            {
                a = hu.this;
                super();
            }
        }, e, r);
    }
}
