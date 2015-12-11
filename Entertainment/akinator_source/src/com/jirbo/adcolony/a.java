// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.jirbo.adcolony:
//            d, l, AdColonyException, g, 
//            AdColony, AdColonyNativeAdView, AdColonyAdAvailabilityListener, h, 
//            AdColonyAd, ADCVideo, j

class a
{

    static boolean A = false;
    static boolean B = false;
    static boolean C = false;
    static boolean D = false;
    static boolean E = false;
    static boolean F = false;
    static Activity G;
    static boolean H = false;
    static boolean I = false;
    static h J;
    static AdColonyAd K;
    static ADCVideo L;
    static ADCVideo M;
    static a N;
    static b O;
    static boolean P = false;
    static boolean Q = false;
    static boolean R = false;
    static boolean S = false;
    static int T = 0;
    static String U;
    static String V;
    static String W;
    static String X;
    static String Y;
    static ArrayList Z = new ArrayList();
    public static final boolean a = false;
    static ADCData.c aa = new ADCData.c();
    static boolean ab = false;
    static long ac = 0L;
    static int ad = 0;
    static ArrayList ae = new ArrayList();
    static ArrayList af = new ArrayList();
    static ArrayList ag = new ArrayList();
    static ArrayList ah = new ArrayList();
    static HashMap ai;
    public static final boolean b = false;
    public static final boolean c = false;
    public static final boolean d = false;
    public static String e = null;
    public static final String f = null;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    static final String k = "AdColony";
    static d l = new d();
    static boolean m;
    static int n = 2;
    static boolean o;
    static boolean p;
    static boolean q;
    static boolean r;
    static boolean s;
    static boolean t;
    static boolean u = false;
    static boolean v = true;
    static int w = 0;
    static double x = 1.0D;
    static boolean y = false;
    static boolean z = false;

    a()
    {
    }

    static void a(int i1)
    {
        boolean flag1 = false;
        n = i1;
        l l1 = l.a;
        boolean flag;
        if (i1 <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l1.f = flag;
        l1 = l.b;
        if (i1 <= 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l1.f = flag;
        l1 = l.c;
        if (i1 <= 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l1.f = flag;
        l1 = l.d;
        flag = flag1;
        if (i1 <= 3)
        {
            flag = true;
        }
        l1.f = flag;
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
        if (n > i1) goto _L2; else goto _L1
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
        if (activity == G || activity == null)
        {
            return;
        } else
        {
            G = activity;
    /* block-local class not found */
    class a {}

            N = new a();
    /* block-local class not found */
    class b {}

            O = new b();
            new p.a();
            return;
        }
    }

    static void a(AdColonyNativeAdView adcolonynativeadview)
    {
        ah.add(adcolonynativeadview);
    }

    static void a(j j1)
    {
        l.a(j1);
    }

    static void a(RuntimeException runtimeexception)
    {
        H = true;
        e(runtimeexception.toString());
        runtimeexception.printStackTrace();
    }

    static void a(String s1)
    {
        H = true;
        e(s1);
    }

    static void a(String s1, AdColonyAd adcolonyad)
    {
        l.a(s1, null, adcolonyad);
    }

    static void a(String s1, String s2)
    {
        l.a(s1, s2);
    }

    static void a(String s1, String s2, AdColonyAd adcolonyad)
    {
        l.a(s1, s2, adcolonyad);
    }

    static boolean a()
    {
        return G == null;
    }

    static Activity b()
    {
        if (G == null)
        {
            throw new AdColonyException("AdColony.configure() must be called before any other AdColony methods. If you have called AdColony.configure(), the Activity reference you passed in via AdColony.configure()/AdColony.resume() is null OR you have not called AdColony.resume() as appropriate.");
        } else
        {
            return G;
        }
    }

    static void b(Activity activity)
    {
        p = false;
        a(activity);
        J = null;
        m = com.jirbo.adcolony.g.i();
        if (H)
        {
            H = false;
            o = false;
            l = new d();
        }
    }

    static void b(String s1)
    {
        a(0, s1);
    }

    static boolean b(int i1)
    {
        return n <= i1;
    }

    static void c(String s1)
    {
        a(1, s1);
    }

    static boolean c()
    {
        return H || q || !o;
    }

    static void d(String s1)
    {
        a(2, s1);
    }

    static boolean d()
    {
        return o && !H && !q;
    }

    static void e()
    {
        b();
    }

    static void e(String s1)
    {
        a(3, s1);
    }

    static void f(String s1)
    {
        Toast.makeText(b(), s1, 0).show();
    }

    static boolean f()
    {
        return n <= 0;
    }

    static double g(String s1)
    {
        return l.a(s1);
    }

    static boolean g()
    {
        return n <= 1;
    }

    static int h(String s1)
    {
        return l.b(s1);
    }

    static void h()
    {
        if (l != null && ag.size() != 0 && ai != null)
        {
            Iterator iterator = ai.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                boolean flag1 = ((Boolean)entry.getValue()).booleanValue();
                boolean flag;
                if (AdColony.isZoneV4VC((String)entry.getKey()))
                {
                    flag = l.b((String)entry.getKey(), true, false);
                } else
                {
                    flag = l.a((String)entry.getKey(), true, false);
                }
                if (AdColony.isZoneNative((String)entry.getKey()) && G != null)
                {
                    flag = (new AdColonyNativeAdView(b(), (String)entry.getKey(), 300, true)).b(true);
                }
                if (flag1 != flag)
                {
                    ai.put(entry.getKey(), Boolean.valueOf(flag));
                    int i1 = 0;
                    while (i1 < ag.size()) 
                    {
                        ((AdColonyAdAvailabilityListener)ag.get(i1)).onAdColonyAdAvailabilityChange(flag, (String)entry.getKey());
                        i1++;
                    }
                }
            }
        }
    }

    static boolean i(String s1)
    {
        return l.c(s1);
    }

    static String j(String s1)
    {
        return l.d(s1);
    }

    static void k(String s1)
    {
        l.a(s1, null);
    }

    static 
    {
        A = false;
        B = false;
        C = true;
        F = false;
        ad = 0;
    }
}
