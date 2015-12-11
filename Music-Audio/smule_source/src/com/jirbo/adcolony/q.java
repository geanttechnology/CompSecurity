// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            ak, bl, r, be, 
//            bd, bc, bh, ad, 
//            af, bx, bt, bq, 
//            bw, bo, ci, ah

public class q
{

    static boolean a;

    public static void a()
    {
        ak.h = true;
    }

    public static void a(Activity activity)
    {
        bl.c.b("[ADC] AdColony resume called.");
        ak.k = false;
        ak.a(activity);
        ak.j = false;
        if (activity == null)
        {
            bl.d.b("Activity reference is null. Disabling AdColony.");
            a();
            return;
        } else
        {
            (new Thread(new Runnable(activity) {

                final Activity a;

                public void run()
                {
                    a.runOnUiThread(new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            for (int i = 0; i < ak.X.size(); i++)
                            {
                                ad ad1 = (ad)ak.X.get(i);
                                if (ad1 == null || ak.b() != ad1.a || ad1.p)
                                {
                                    continue;
                                }
                                ad1.u = false;
                                ad1.invalidate();
                                if (ad1.J != null)
                                {
                                    ad1.J.a = false;
                                    ad1.J.invalidate();
                                }
                            }

                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                }

            
            {
                a = activity;
                super();
            }
            })).start();
            ak.u = false;
            return;
        }
    }

    public static transient void a(Activity activity, String s, String s1, String as[])
    {
        Handler handler;
        Runnable runnable;
        a = false;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new r(activity)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            (new r(activity)).execute(new Void[0]);
        }
        ak.X.clear();
        handler = new Handler();
        runnable = new Runnable() {

            public void run()
            {
                ak.p = false;
            }

        };
        if (ak.p && !ak.q) goto _L2; else goto _L1
_L1:
        if (!ak.h) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if (s1 == null)
        {
            ak.a("Null App ID - disabling AdColony.");
            return;
        }
        if (as == null)
        {
            ak.a("Null Zone IDs array - disabling AdColony.");
            return;
        }
        if (as.length == 0)
        {
            ak.a("No Zone IDs provided - disabling AdColony.");
            return;
        }
        ak.b(activity);
        ak.c.a(s, s1, as);
        ak.f = true;
        ak.p = true;
        handler.postDelayed(runnable, 0x1d4c0L);
_L2:
        if (ak.B == null)
        {
            ak.m = true;
        }
        ak.V.clear();
        ak.W.clear();
        ak.Y = new HashMap();
        int i = 0;
        while (i < as.length) 
        {
            ak.Y.put(as[i], Boolean.valueOf(false));
            i++;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static void a(ah ah)
    {
        if (ak.V.contains(ah))
        {
            return;
        } else
        {
            ak.V.add(ah);
            return;
        }
    }

    public static void a(String s)
    {
        if (!s.equals(ak.c.a.x))
        {
            ak.c.a.x = s;
            ak.p = false;
            ak.c.b.d = true;
            ak.c.b.b = false;
            ak.c.b.c = true;
        }
    }

    public static void b(String s)
    {
        if (!s.equals(ak.c.a.y))
        {
            ak.c.a.y = s;
            ak.p = false;
            ak.c.b.d = true;
            ak.c.b.b = false;
            ak.c.b.c = true;
        }
    }

    public static boolean b()
    {
        return bh.i();
    }

    public static void c()
    {
        bl.c.b("[ADC] AdColony pause called.");
        ak.k = true;
        for (int i = 0; i < ak.X.size(); i++)
        {
            if (ak.X.get(i) == null)
            {
                continue;
            }
            ad ad1 = (ad)ak.X.get(i);
            ad1.u = true;
            if (ad1.T == null || ad1.p || !ad1.T.isPlaying())
            {
                continue;
            }
            if (ak.m)
            {
                ad1.J.setVisibility(0);
            }
            ad1.c();
        }

    }

    public static boolean c(String s)
    {
        while (ak.c == null || ak.c.b == null || ak.c.b.j == null || ak.c.b.j.n == null) 
        {
            return false;
        }
        return ak.c.b.a(s, false);
    }

    public static Activity d()
    {
        return ak.b();
    }

    public static boolean d(String s)
    {
        if (ak.c != null && ak.c.b != null && ak.c.b.j != null && ak.c.b.j.n != null && ak.c.b.j.n.a(s) != null && ak.c.b.j.n.a(s).i != null && ak.c.b.j.n.a(s).i.a != null)
        {
            int i = 0;
            while (i < ak.c.b.j.n.a(s).i.a.size()) 
            {
                if (ak.c.b.j.n.a(s).i.a(i).v.a)
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
