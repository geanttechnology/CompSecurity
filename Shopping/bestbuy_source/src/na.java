// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class na
{

    public static boolean a = false;
    public static boolean b = false;
    private static na c;
    private static ft f;
    private static ft g;
    private static LinkedHashMap h = new LinkedHashMap();
    private static LinkedHashMap i = new LinkedHashMap();
    private static LinkedHashMap j = new LinkedHashMap();
    private static LinkedHashMap k = new LinkedHashMap();
    private static LinkedHashMap l = new LinkedHashMap();
    private Context d;
    private nb e;

    protected na(Context context)
    {
        d = context;
        e = new nb(context);
        c = this;
        context = new ln(context);
        gm.a(context.e());
        gq.a(context.a());
        gd.a(context.c());
        gg.a(context.d());
        ga.a(context.b());
        i();
    }

    public static ft a()
    {
        return g;
    }

    public static void a(Context context)
    {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        int j1 = astacktraceelement.length;
        int i1 = 0;
        do
        {
label0:
            {
                if (i1 < j1)
                {
                    if (astacktraceelement[i1].getClassName().compareTo("com.bestbuy.android.base.BBYApplication") != 0)
                    {
                        break label0;
                    }
                    kf.c("BBYAppConfig", "Found correct class!  Setting Instance.");
                    c = new na(context);
                }
                return;
            }
            i1++;
        } while (true);
    }

    public static void a(ft ft1)
    {
        g = ft1;
    }

    public static ft b()
    {
        return f;
    }

    public static void b(ft ft1)
    {
        f = ft1;
    }

    public static HashMap c()
    {
        return h;
    }

    public static HashMap d()
    {
        return i;
    }

    public static HashMap e()
    {
        return k;
    }

    public static HashMap f()
    {
        return l;
    }

    public static HashMap g()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (fr.d() != null)
        {
            linkedhashmap.put("ut", fr.d());
            linkedhashmap.put("Domain", ".bestbuy.com");
            linkedhashmap.put("Path", "/");
            linkedhashmap.put("Version", "0");
        }
        return linkedhashmap;
    }

    public static HashMap h()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (fr.b() != null)
        {
            linkedhashmap.put("at", fr.b());
            linkedhashmap.put("Domain", ".bestbuy.com");
            linkedhashmap.put("Path", "/");
            linkedhashmap.put("Version", "0");
            linkedhashmap.put("Secure", "true");
        }
        return linkedhashmap;
    }

    private void i()
    {
        String s = e.p();
        String s1 = e.r();
        h.put("s_app", s);
        h.put("Domain", ".bestbuy.com");
        h.put("Path", "/");
        h.put("Version", "0");
        j.put("s_vi", s1);
        j.put("Domain", ".bestbuy.com");
        j.put("Path", "/");
        j.put("Version", "0");
        i.put("s_channel", "mapp-android");
        i.put("Domain", ".bestbuy.com");
        i.put("Path", "/");
        i.put("Version", "0");
        k.put("bby_rdp", "s");
        k.put("Domain", ".bestbuy.com");
        k.put("Path", "/");
        k.put("Version", "0");
        l.put("com_ress", "true");
        l.put("Domain", ".bestbuy.com");
        l.put("Path", "/");
        l.put("Version", "0");
    }

    static 
    {
        f = ft.a;
        g = ft.a;
    }
}
