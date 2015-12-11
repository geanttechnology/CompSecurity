// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.jirbo.adcolony:
//            ac, aj, j, af, 
//            f, n, l, h, 
//            g, e, ag, ah, 
//            v, ar, aa, p

public final class q
{
    static final class a extends Handler
    {

        g a;

        public final void a(g g1)
        {
            if (g1 == null)
            {
                a = q.A;
            } else
            {
                a = g1;
            }
            sendMessage(obtainMessage(1));
        }

        public final void b(g g1)
        {
            if (g1 == null)
            {
                a = q.A;
            } else
            {
                a = g1;
            }
            sendMessage(obtainMessage(0));
        }

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 0 1: default 28
        //                       0 29
        //                       1 58;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            q.a("skip", a);
            if (q.A != null)
            {
                q.A.a = 1;
                q.A.c();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            message = new a.g();
            if (q.C.C.P)
            {
                message.b("html5_endcard_loading_started", q.C.j);
            }
            if (q.C.C.P)
            {
                message.b("html5_endcard_loading_finished", q.C.k);
            }
            if (q.C.C.P)
            {
                message.a("html5_endcard_loading_time", q.C.o);
            }
            if (q.C.C.P)
            {
                message.b("html5_endcard_loading_timeout", q.C.l);
            }
            if (q.C.p < 60000D)
            {
                message.a("endcard_time_spent", q.C.p);
            }
            message.b("endcard_dissolved", q.C.m);
            e e1 = q.C;
            message.b("replay", e.e);
            message.b("reward", q.C.n);
            q.c.d.a("continue", message, a);
            q.c.b.a();
            if (q.A != null)
            {
                q.A.a = 4;
                q.A.c();
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        a()
        {
        }
    }

    static final class b extends Handler
    {

        public final void handleMessage(Message message)
        {
            String s1 = (String)message.obj;
            int i1 = message.what;
            boolean flag;
            if (s1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            message = s1;
            if (!flag)
            {
                message = "";
            }
            new p(flag, message, i1);
            for (int j1 = 0; j1 < q.V.size(); j1++)
            {
                q.V.get(j1);
            }

        }

        b()
        {
        }
    }


    static g A;
    public static e B;
    static e C;
    static a D;
    static b E;
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
    static a.c Q = new a.c();
    static boolean R;
    static long S;
    static int T = 0;
    static ArrayList U = new ArrayList();
    public static ArrayList V = new ArrayList();
    public static ArrayList W = new ArrayList();
    public static ArrayList X = new ArrayList();
    public static HashMap Y;
    public static String a = null;
    public static final String b = null;
    public static ac c = new ac();
    static boolean d;
    static int e = 2;
    public static boolean f;
    public static boolean g;
    public static boolean h;
    static boolean i;
    static boolean j;
    static boolean k;
    static boolean l = false;
    public static boolean m = true;
    static int n = 0;
    static double o = 1.0D;
    public static boolean p = false;
    public static boolean q = false;
    static boolean r = false;
    static boolean s = false;
    static boolean t = true;
    static boolean u;
    static boolean v;
    static boolean w = false;
    static Activity x;
    static boolean y;
    static ag z;

    static void a(int i1)
    {
        e = i1;
        aj aj1 = aj.a;
        boolean flag;
        if (i1 <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aj1.f = flag;
        aj1 = aj.b;
        if (i1 <= 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aj1.f = flag;
        aj1 = aj.c;
        if (i1 <= 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aj1.f = flag;
        aj1 = aj.d;
        if (i1 <= 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aj1.f = flag;
        if (i1 <= 0)
        {
            a(0, "DEVELOPER LOGGING ENABLED");
        }
        if (i1 <= 1)
        {
            a(1, "DEBUG LOGGING ENABLED");
        }
    }

    static void a(int i1, String s1)
    {
        if (e > i1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 0 3: default 40
    //                   0 40
    //                   1 40
    //                   2 40
    //                   3 41;
           goto _L2 _L2 _L2 _L2 _L3
_L2:
        return;
_L3:
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
            D = new a();
            E = new b();
            new an.a();
            return;
        }
    }

    static void a(ah ah)
    {
        c.a(ah);
    }

    static void a(RuntimeException runtimeexception)
    {
        y = true;
        a(3, runtimeexception.toString());
        runtimeexception.printStackTrace();
    }

    public static void a(String s1)
    {
        y = true;
        a(3, s1);
    }

    static void a(String s1, g g1)
    {
        c.a(s1, null, g1);
    }

    static void a(String s1, String s2, g g1)
    {
        c.a(s1, s2, g1);
    }

    static boolean a()
    {
        return x == null;
    }

    static Activity b()
    {
        if (x == null)
        {
            throw new j("AdColony.configure() must be called before any other AdColony methods. If you have called AdColony.configure(), the Activity reference you passed in via AdColony.configure()/AdColony.resume() is null OR you have not called AdColony.resume() as appropriate.");
        } else
        {
            return x;
        }
    }

    public static void b(Activity activity)
    {
        g = false;
        a(activity);
        z = null;
        d = af.b();
        if (y)
        {
            y = false;
            f = false;
            c = new ac();
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
                if (com.jirbo.adcolony.f.a((String)entry.getKey()))
                {
                    flag = c.b((String)entry.getKey(), true, false);
                } else
                {
                    flag = c.a((String)entry.getKey(), true, false);
                }
                if (com.jirbo.adcolony.f.b((String)entry.getKey()) && x != null)
                {
                    n n1 = new n(b(), (String)entry.getKey());
                    int i1;
                    if (n1.D.b() && com.jirbo.adcolony.f.b(n1.b))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
                if (flag1 != flag)
                {
                    Y.put(entry.getKey(), Boolean.valueOf(flag));
                    i1 = 0;
                    while (i1 < W.size()) 
                    {
                        ((h)W.get(i1)).a(flag, (String)entry.getKey());
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
