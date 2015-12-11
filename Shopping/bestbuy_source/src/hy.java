// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.bestbuy.android.activities.blueassist.BlueAssistUserContactInfoActivity;

public class hy extends ka
{

    private Activity a;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private int o;

    public hy(Activity activity, String s, String s1, String s2, String s3, String s4)
    {
        o = 0;
        a = activity;
        j = s;
        k = s1;
        l = s2;
        m = s3;
        n = s4;
    }

    static int a(hy hy1)
    {
        int i = hy1.o;
        hy1.o = i + 1;
        return i;
    }

    static int a(hy hy1, int i)
    {
        hy1.o = i;
        return i;
    }

    static Activity b(hy hy1)
    {
        return hy1.a;
    }

    static String c(hy hy1)
    {
        return hy1.j;
    }

    static String d(hy hy1)
    {
        return hy1.k;
    }

    static String e(hy hy1)
    {
        return hy1.l;
    }

    static String f(hy hy1)
    {
        return hy1.m;
    }

    static String g(hy hy1)
    {
        return hy1.n;
    }

    public void a()
    {
        fs.b(j, k, l, m, n);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        fq.a(n, ne.a(k, l));
        if (a instanceof BlueAssistUserContactInfoActivity)
        {
            ((BlueAssistUserContactInfoActivity)a).a(n);
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(a, new no() {

            final hy a;

            public void a()
            {
                hy.a(a);
                new hy(hy.b(a), hy.c(a), hy.d(a), hy.e(a), hy.f(a), hy.g(a));
            }

            
            {
                a = hy.this;
                super();
            }
        }, new nn() {

            final hy a;

            public void a()
            {
                hy.a(a, 0);
                hy.b(a).finish();
            }

            
            {
                a = hy.this;
                super();
            }
        }, e, o);
    }
}
