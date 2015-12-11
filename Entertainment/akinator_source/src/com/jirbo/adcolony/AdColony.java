// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            a, ADCVideo, d, b, 
//            c, l, t, g, 
//            u, ac, ad, h, 
//            AdColonyV4VCAd, AdColonyNativeAdView, AdColonyAdAvailabilityListener, AdColonyV4VCListener

public class AdColony
{

    static boolean b;
    boolean a;

    public AdColony()
    {
        a = false;
    }

    public static Activity activity()
    {
        return com.jirbo.adcolony.a.b();
    }

    public static void addAdAvailabilityListener(AdColonyAdAvailabilityListener adcolonyadavailabilitylistener)
    {
        if (a.ag.contains(adcolonyadavailabilitylistener))
        {
            return;
        } else
        {
            a.ag.add(adcolonyadavailabilitylistener);
            return;
        }
    }

    public static void addV4VCListener(AdColonyV4VCListener adcolonyv4vclistener)
    {
        if (a.af.contains(adcolonyv4vclistener))
        {
            return;
        } else
        {
            a.af.add(adcolonyv4vclistener);
            return;
        }
    }

    public static void cancelVideo()
    {
        if (a.L != null)
        {
            a.L.finish();
            a.ab = true;
            a.N.b(null);
        }
    }

    public static transient void configure(Activity activity1, String s, String s1, String as[])
    {
        Handler handler;
        _cls1 _lcls1;
        b = false;
    /* block-local class not found */
    class a {}

        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new a(activity1)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            (new a(activity1)).execute(new Void[0]);
        }
        a.ah.clear();
        handler = new Handler();
        _lcls1 = new _cls1();
        if (a.y && !a.z) goto _L2; else goto _L1
_L1:
        if (!a.q) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if (s1 == null)
        {
            com.jirbo.adcolony.a.a("Null App ID - disabling AdColony.");
            return;
        }
        if (as == null)
        {
            com.jirbo.adcolony.a.a("Null Zone IDs array - disabling AdColony.");
            return;
        }
        if (as.length == 0)
        {
            com.jirbo.adcolony.a.a("No Zone IDs provided - disabling AdColony.");
            return;
        }
        com.jirbo.adcolony.a.b(activity1);
        a.l.a(s, s1, as);
        a.o = true;
        a.y = true;
        handler.postDelayed(_lcls1, 0x1d4c0L);
_L2:
        if (a.L == null)
        {
            a.v = true;
        }
        a.af.clear();
        a.ag.clear();
        a.ai = new HashMap();
        int i = 0;
        while (i < as.length) 
        {
            a.ai.put(as[i], Boolean.valueOf(false));
            i++;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static void disable()
    {
        a.q = true;
    }

    public static void disableDECOverride()
    {
        a.e = null;
    }

    public static void forceMobileCache()
    {
        if (!a.E)
        {
            a.E = true;
            a.y = false;
            a.l.b.d = true;
            a.l.b.b = false;
            a.l.b.c = true;
        }
    }

    public static String getCustomID()
    {
        return a.l.a.x;
    }

    public static String getDeviceID()
    {
        return a.l.a.y;
    }

    public static int getRemainingV4VCForZone(String s)
    {
        if (a.l == null || a.l.h == null || a.l.b == null || a.l.b.j == null || a.l.b.j.n == null)
        {
            return l.c.c("getRemainingV4VCForZone called before AdColony has finished configuring.");
        }
        n.ab ab = a.l.b.j.n.a(s);
        if (ab == null)
        {
            return l.c.c("getRemainingV4VCForZone called before AdColony has finished configuring, or the zone passed in is invalid.");
        }
        if (!ab.j.a)
        {
            return l.c.c("getRemainingV4VCForZone called with non-V4VC zone.");
        } else
        {
            return ab.j.b.a - a.l.h.b(s);
        }
    }

    public static void get_images(String s)
    {
        a.l.a.b(s);
    }

    public static boolean isTablet()
    {
        return g.i();
    }

    public static boolean isZoneNative(String s)
    {
        if (a.l != null && a.l.b != null && a.l.b.j != null && a.l.b.j.n != null && a.l.b.j.n.a(s) != null && a.l.b.j.n.a(s).i != null && a.l.b.j.n.a(s).i.a != null)
        {
            int i = 0;
            while (i < a.l.b.j.n.a(s).i.a.size()) 
            {
                if (a.l.b.j.n.a(s).i.a(i).w.a)
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static boolean isZoneV4VC(String s)
    {
        while (a.l == null || a.l.b == null || a.l.b.j == null || a.l.b.j.n == null) 
        {
            return false;
        }
        return a.l.b.a(s, false);
    }

    public static void notifyIAPComplete(String s, String s1)
    {
        notifyIAPComplete(s, s1, null, 0.0D);
    }

    public static void notifyIAPComplete(String s, String s1, String s2, double d1)
    {
        l.c.b("notifyIAPComplete() called.");
        ADCData.g g1 = new ADCData.g();
        g1.b("product_id", s);
        if (d1 != 0.0D)
        {
            g1.b("price", d1);
        }
        g1.b("trans_id", s1);
        g1.b("quantity", 1);
        if (s2 != null)
        {
            g1.b("price_currency_code", s2);
        }
        if (a.F)
        {
            a.l.d.a("in_app_purchase", g1);
            return;
        } else
        {
            a.aa.a(g1);
            return;
        }
    }

    public static void onBackPressed()
    {
        int i = 0;
        if (a.J != null && ((a.J instanceof ac) || (a.J instanceof ad)))
        {
            ((ViewGroup)a.J.getParent()).removeView(a.J);
            a.v = true;
            a.J.G.c(false);
            for (; i < a.ae.size(); i++)
            {
                ((Bitmap)a.ae.get(i)).recycle();
            }

            a.ae.clear();
            a.J = null;
        }
    }

    public static void pause()
    {
        l.c.b("[ADC] AdColony pause called.");
        a.t = true;
        for (int i = 0; i < a.ah.size(); i++)
        {
            if (a.ah.get(i) == null)
            {
                continue;
            }
            AdColonyNativeAdView adcolonynativeadview = (AdColonyNativeAdView)a.ah.get(i);
            adcolonynativeadview.A = true;
            if (adcolonynativeadview.ad == null || adcolonynativeadview.u || !adcolonynativeadview.ad.isPlaying())
            {
                continue;
            }
            if (a.v)
            {
                adcolonynativeadview.R.setVisibility(0);
            }
            adcolonynativeadview.c();
        }

    }

    public static void removeAdAvailabilityListener(AdColonyAdAvailabilityListener adcolonyadavailabilitylistener)
    {
        a.ag.remove(adcolonyadavailabilitylistener);
    }

    public static void removeV4VCListener(AdColonyV4VCListener adcolonyv4vclistener)
    {
        a.af.remove(adcolonyv4vclistener);
    }

    public static void resume(Activity activity1)
    {
        l.c.b("[ADC] AdColony resume called.");
        a.t = false;
        com.jirbo.adcolony.a.a(activity1);
        a.s = false;
        if (activity1 == null)
        {
            l.d.b("Activity reference is null. Disabling AdColony.");
            disable();
            return;
        } else
        {
            (new Thread(new _cls2(activity1))).start();
            a.D = false;
            return;
        }
    }

    public static void setCustomID(String s)
    {
        if (!s.equals(a.l.a.x))
        {
            a.l.a.x = s;
            a.y = false;
            a.l.b.d = true;
            a.l.b.b = false;
            a.l.b.c = true;
        }
    }

    public static void setDeviceID(String s)
    {
        if (!s.equals(a.l.a.y))
        {
            a.l.a.y = s;
            a.y = false;
            a.l.b.d = true;
            a.l.b.b = false;
            a.l.b.c = true;
        }
    }

    public static String statusForZone(String s)
    {
        if (a.l == null || a.l.b == null || a.l.b.j == null || a.l.b.j.n == null)
        {
            return "unknown";
        }
        if (a.q)
        {
            return "unknown";
        }
        n.ab ab = a.l.b.j.n.a(s);
        if (ab != null)
        {
            if (!ab.e)
            {
                return "off";
            }
            if (ab.f && a.l.b.c(s, true))
            {
                return "active";
            } else
            {
                return "loading";
            }
        }
        if (!a.p)
        {
            return "unknown";
        } else
        {
            return "invalid";
        }
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
