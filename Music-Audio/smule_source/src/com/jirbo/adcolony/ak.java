// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.jirbo.adcolony:
//            be, d, bl, al, 
//            am, cw, y, bh, 
//            q, ad, t, s, 
//            o, bi, bj

class ak
{

    static s A;
    static o B;
    static o C;
    static al D;
    static am E;
    static boolean F;
    static boolean G;
    static boolean H;
    static boolean I;
    static int J;
    static String K;
    static String L;
    static String M;
    static String N;
    static String O;
    static ArrayList P = new ArrayList();
    static d Q = new d();
    static boolean R;
    static long S;
    static int T = 0;
    static ArrayList U = new ArrayList();
    static ArrayList V = new ArrayList();
    static ArrayList W = new ArrayList();
    static ArrayList X = new ArrayList();
    static HashMap Y;
    public static String a = null;
    public static final String b = null;
    static be c = new be();
    static boolean d;
    static int e = 2;
    static boolean f;
    static boolean g;
    static boolean h;
    static boolean i;
    static boolean j;
    static boolean k;
    static boolean l = false;
    static boolean m = true;
    static int n = 0;
    static double o = 1.0D;
    static boolean p = false;
    static boolean q = false;
    static boolean r = false;
    static boolean s = false;
    static boolean t = true;
    static boolean u;
    static boolean v;
    static boolean w = false;
    static Activity x;
    static boolean y;
    static bi z;

    static void a(int i1)
    {
        boolean flag1 = false;
        e = i1;
        bl bl1 = bl.a;
        boolean flag;
        if (i1 <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bl1.f = flag;
        bl1 = bl.b;
        if (i1 <= 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bl1.f = flag;
        bl1 = bl.c;
        if (i1 <= 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bl1.f = flag;
        bl1 = bl.d;
        flag = flag1;
        if (i1 <= 3)
        {
            flag = true;
        }
        bl1.f = flag;
        if (i1 <= 0)
        {
            b("DEVELOPER LOGGING ENABLED");
        }
        if (i1 <= 1)
        {
            c("DEBUG LOGGING ENABLED");
        }
    }

    static void a(int i1, String s1)
    {
        if (e > i1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 0 3: default 40
    //                   0 41
    //                   1 41
    //                   2 49
    //                   3 57;
           goto _L2 _L3 _L3 _L4 _L5
_L2:
        return;
_L3:
        Log.d("AdColony", s1);
        return;
_L4:
        Log.i("AdColony", s1);
        return;
_L5:
        Log.e("AdColony", s1);
        return;
    }

    static void a(Activity activity)
    {
        if (activity == x || activity == null)
        {
            return;
        } else
        {
            x = activity;
            D = new al();
            E = new am();
            new cw();
            return;
        }
    }

    static void a(bj bj)
    {
        c.a(bj);
    }

    static void a(RuntimeException runtimeexception)
    {
        y = true;
        d(runtimeexception.toString());
        runtimeexception.printStackTrace();
    }

    static void a(String s1)
    {
        y = true;
        d(s1);
    }

    static void a(String s1, s s2)
    {
        c.a(s1, null, s2);
    }

    static void a(String s1, String s2, s s3)
    {
        c.a(s1, s2, s3);
    }

    static boolean a()
    {
        return x == null;
    }

    static Activity b()
    {
        if (x == null)
        {
            throw new y("AdColony.configure() must be called before any other AdColony methods. If you have called AdColony.configure(), the Activity reference you passed in via AdColony.configure()/AdColony.resume() is null OR you have not called AdColony.resume() as appropriate.");
        } else
        {
            return x;
        }
    }

    static void b(Activity activity)
    {
        g = false;
        a(activity);
        z = null;
        d = bh.i();
        if (y)
        {
            y = false;
            f = false;
            c = new be();
        }
    }

    static void b(String s1)
    {
        a(0, s1);
    }

    static void c(String s1)
    {
        a(1, s1);
    }

    static boolean c()
    {
        return y || h || !f;
    }

    static void d(String s1)
    {
        a(3, s1);
    }

    static boolean d()
    {
        return f && !y && !h;
    }

    static int e(String s1)
    {
        return c.a(s1);
    }

    static void e()
    {
        b();
    }

    static void f()
    {
        if (c != null && W.size() != 0 && Y != null)
        {
            Iterator iterator = Y.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                boolean flag1 = ((Boolean)entry.getValue()).booleanValue();
                boolean flag;
                if (com.jirbo.adcolony.q.c((String)entry.getKey()))
                {
                    flag = c.b((String)entry.getKey(), true, false);
                } else
                {
                    flag = c.a((String)entry.getKey(), true, false);
                }
                if (com.jirbo.adcolony.q.d((String)entry.getKey()) && x != null)
                {
                    flag = (new ad(b(), (String)entry.getKey(), 300, true)).b(true);
                }
                if (flag1 != flag)
                {
                    Y.put(entry.getKey(), Boolean.valueOf(flag));
                    int i1 = 0;
                    while (i1 < W.size()) 
                    {
                        ((t)W.get(i1)).a(flag, (String)entry.getKey());
                        i1++;
                    }
                }
            }
        }
    }

    static boolean f(String s1)
    {
        return c.b(s1);
    }

    static String g(String s1)
    {
        return c.c(s1);
    }

}
