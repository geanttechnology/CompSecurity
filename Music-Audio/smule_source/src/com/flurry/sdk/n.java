// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.net.HttpCookie;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            fz, fp, fe, hp, 
//            gj, fn, gk, fy, 
//            hq, ff, fx, fi, 
//            gd

public class n
{

    private static final String a = com/flurry/sdk/n.getSimpleName();
    private long b;
    private String c;
    private final Runnable d = new hq() {

        final n a;

        public void safeRun()
        {
            n.a(a);
        }

            
            {
                a = n.this;
                super();
            }
    };
    private final fy e = new fy() {

        final n a;

        public void a(ff ff1)
        {
            n.a(a);
        }

        public void notify(fx fx)
        {
            a((ff)fx);
        }

            
            {
                a = n.this;
                super();
            }
    };
    private final fy f = new fy() {

        final n a;

        public void a(fi fi1)
        {
            if (fi1.a)
            {
                n.a(a);
            }
        }

        public void notify(fx fx)
        {
            a((fi)fx);
        }

            
            {
                a = n.this;
                super();
            }
    };

    public n()
    {
        b = 10000L;
        fz.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", e);
        fz.a().a("com.flurry.android.sdk.NetworkStateEvent", f);
        g();
    }

    static long a(n n1, int i)
    {
        long l = n1.b << i;
        n1.b = l;
        return l;
    }

    static String a(n n1, String s)
    {
        n1.c = s;
        return s;
    }

    static void a(n n1)
    {
        n1.g();
    }

    static String b(n n1)
    {
        return n1.c;
    }

    static long c(n n1)
    {
        return n1.b;
    }

    static Runnable d(n n1)
    {
        return n1.d;
    }

    public static String e()
    {
        String s1 = Build.SERIAL;
        String s = s1;
        try
        {
            if (TextUtils.isEmpty(s1))
            {
                s = android.provider.Settings.Secure.getString(fp.a().c().getContentResolver(), "android_id");
            }
        }
        catch (Exception exception)
        {
            exception = s1;
        }
        s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = fe.a().f();
        }
        return s1;
    }

    static void e(n n1)
    {
        n1.h();
    }

    static String f()
    {
        return a;
    }

    private void g()
    {
        while (!TextUtils.isEmpty(c) || !fe.a().c()) 
        {
            return;
        }
        Object obj1 = fe.a().d();
        String s = e();
        Object obj = new StringBuilder("select bid from data.utilities where _di='");
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            s = hp.a(hp.f(((String) (obj1))));
            ((StringBuilder) (obj)).append(s).append("' and _diaid='").append(s).append("' and _diaidu='").append(((String) (obj1))).append("'");
        } else
        {
            ((StringBuilder) (obj)).append(hp.a(hp.f(s))).append("'");
        }
        obj1 = new gj();
        ((gj) (obj1)).a("q", ((StringBuilder) (obj)).toString());
        fn.a().a(this);
        obj = new gk();
        ((gk) (obj)).a((new StringBuilder()).append("https://analytics.query.yahoo.com/v1/public/yql?").append(((gj) (obj1)).b()).toString());
        ((gk) (obj)).a(0);
        ((gk) (obj)).a(gl.a.b);
        ((gk) (obj)).a(new gk.a() {

            final n a;

            public volatile void a(gk gk1, Object obj2)
            {
                a(gk1, (Void)obj2);
            }

            public void a(gk gk1, Void void1)
            {
                gd.a(3, n.f(), (new StringBuilder()).append("BCookie request: HTTP status code is:").append(gk1.e()).toString());
                if (gk1.c())
                {
                    gk1 = gk1.b("Set-Cookie");
                    if (gk1 != null)
                    {
                        for (gk1 = gk1.iterator(); gk1.hasNext();)
                        {
                            void1 = HttpCookie.parse((String)gk1.next());
                            if (void1 != null)
                            {
                                void1 = void1.iterator();
                                while (void1.hasNext()) 
                                {
                                    HttpCookie httpcookie = (HttpCookie)void1.next();
                                    if (HttpCookie.domainMatches(".yahoo.com", httpcookie.getDomain()) && "B".equalsIgnoreCase(httpcookie.getName()))
                                    {
                                        gd.a(3, n.f(), "Found BCookie");
                                        n.a(a, httpcookie.getValue());
                                    }
                                }
                            }
                        }

                    }
                }
                if (TextUtils.isEmpty(n.b(a)))
                {
                    n.a(a, 1);
                    gd.a(3, n.f(), (new StringBuilder()).append("BCookie request failed, backing off: ").append(n.c(a)).append("ms").toString());
                    fp.a().b(n.d(a), n.c(a));
                    return;
                } else
                {
                    n.e(a);
                    return;
                }
            }

            
            {
                a = n.this;
                super();
            }
        });
        fn.a().a(this, ((hr) (obj)));
    }

    private void h()
    {
        fz.a().b("com.flurry.android.sdk.NetworkStateEvent", f);
        fz.a().b("com.flurry.android.sdk.IdProviderFinishedEvent", e);
    }

    public void a()
    {
        fp.a().c(d);
        h();
    }

    public String b()
    {
        return c;
    }

    public String c()
    {
        if (fe.a().e())
        {
            return "0";
        } else
        {
            return "1";
        }
    }

    public String d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        HttpCookie httpcookie = new HttpCookie("B", b());
        httpcookie.setDomain(".yahoo.com");
        stringbuilder.append(httpcookie.toString());
        if (!fe.a().e())
        {
            stringbuilder.append(";");
            HttpCookie httpcookie1 = new HttpCookie("AO", c());
            httpcookie.setDomain(".yahoo.com");
            stringbuilder.append(httpcookie1.toString());
        }
        return stringbuilder.toString();
    }

}
