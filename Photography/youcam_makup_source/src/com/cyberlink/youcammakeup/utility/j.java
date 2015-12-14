// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            k

public class j
{

    private static String a = "DFPAdUtilityGeneral";
    private String b;
    private List c;
    private int d;
    private k e;
    private android.view.View.OnLayoutChangeListener f;
    private PublisherAdView g;
    private View h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;

    public j(String s, List list, int i1, int j1)
    {
        d = 0;
        f = new android.view.View.OnLayoutChangeListener() {

            final j a;

            public void onLayoutChange(View view, int k1, int l1, int i2, int j2, int k2, int l2, 
                    int i3, int j3)
            {
                j.a(a);
            }

            
            {
                a = j.this;
                super();
            }
        };
        g = null;
        h = null;
        k = false;
        l = false;
        m = 0;
        n = false;
        b = s;
        c = list;
        i = i1;
        j = j1;
        do
        {
label0:
            {
                if (d < c.size())
                {
                    if (!h())
                    {
                        break label0;
                    }
                    f();
                }
                if (!k)
                {
                    com.pf.common.utility.m.e(a, "DFPAdUtilityGeneral DFP not initialized");
                }
                return;
            }
            d = d + 1;
        } while (true);
    }

    static String a(int i1)
    {
        return b(i1);
    }

    private void a(View view, boolean flag)
    {
        if (g != null)
        {
            ViewGroup viewgroup = (ViewGroup)g.getParent();
            if (viewgroup != null && (flag || viewgroup == view))
            {
                viewgroup.removeView(g);
                viewgroup.removeOnLayoutChangeListener(f);
            }
        }
    }

    static void a(j j1)
    {
        j1.j();
    }

    static boolean a(j j1, boolean flag)
    {
        j1.l = flag;
        return flag;
    }

    static int b(j j1)
    {
        return j1.d;
    }

    private static String b(int i1)
    {
        switch (i1)
        {
        default:
            return "";

        case 0: // '\0'
            return "Internal error";

        case 1: // '\001'
            return "Invalid request";

        case 2: // '\002'
            return "Network Error";

        case 3: // '\003'
            return "No fill";
        }
    }

    static boolean b(j j1, boolean flag)
    {
        j1.n = flag;
        return flag;
    }

    static int c(j j1)
    {
        return j1.m;
    }

    static int d(j j1)
    {
        int i1 = j1.m;
        j1.m = i1 + 1;
        return i1;
    }

    static String e()
    {
        return a;
    }

    static void e(j j1)
    {
        j1.i();
    }

    static k f(j j1)
    {
        return j1.e;
    }

    private void f()
    {
        com.pf.common.utility.m.c(a, "init enter");
        k = true;
        g = new PublisherAdView(Globals.d().getApplicationContext());
        g.setAdUnitId(b);
        g.setAdSizes(new AdSize[] {
            (AdSize)c.get(d)
        });
        g.setAdListener(new AdListener() {

            final j a;

            public void onAdClosed()
            {
                com.pf.common.utility.m.c(j.e(), "PublisherAdView onAdClosed");
                j.a(a, false);
            }

            public void onAdFailedToLoad(int i1)
            {
                com.pf.common.utility.m.c(j.e(), (new StringBuilder()).append("PublisherAdView mCurrentAdSizeCount=").append(j.b(a)).append(" onAdFailedToLoad : ").append(j.a(i1)).toString());
                j.a(a, false);
                if (j.c(a) < 3)
                {
                    j.d(a);
                    j.e(a);
                } else
                if (j.f(a) != null)
                {
                    j.b(a, false);
                    j.f(a).b();
                    return;
                }
            }

            public void onAdLeftApplication()
            {
                com.pf.common.utility.m.c(j.e(), " PublisherAdViewonAdLeftApplication");
            }

            public void onAdLoaded()
            {
                com.pf.common.utility.m.c(j.e(), (new StringBuilder()).append("PublisherAdView onAdLoaded size:").append(j.g(a).getAdSize()).toString());
                if (j.h(a)) goto _L2; else goto _L1
_L1:
                if (!j.i(a)) goto _L4; else goto _L3
_L3:
                j.e(a);
_L6:
                return;
_L4:
                com.pf.common.utility.m.e(j.e(), "onAdLoaded, no any proper size!");
                return;
_L2:
                j.a(a, true);
                j.a(a);
                if (j.f(a) != null)
                {
                    j.f(a).a();
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void onAdOpened()
            {
                com.pf.common.utility.m.c(j.e(), "PublisherAdView onAdOpened");
            }

            
            {
                a = j.this;
                super();
            }
        });
    }

    static PublisherAdView g(j j1)
    {
        return j1.g;
    }

    private boolean g()
    {
label0:
        {
            do
            {
                int i1 = d;
                d = i1 + 1;
                if (i1 >= c.size())
                {
                    break label0;
                }
                if (c.size() <= d)
                {
                    break;
                }
                if (h())
                {
                    g.setAdSizes(new AdSize[] {
                        (AdSize)c.get(d)
                    });
                    com.pf.common.utility.m.b(a, (new StringBuilder()).append("setNextProperSize(), info. adSize=").append(((AdSize)c.get(d)).toString()).toString());
                    return true;
                }
            } while (true);
            d = d - 1;
            n = false;
            m = 0;
        }
        com.pf.common.utility.m.b(a, "setNextProperSize(), info. failed");
        return false;
    }

    private boolean h()
    {
        AdSize adsize = (AdSize)c.get(d);
        int i1 = adsize.getHeightInPixels(Globals.d().getApplicationContext());
        return adsize.getWidthInPixels(Globals.d().getApplicationContext()) <= i && i1 <= j;
    }

    static boolean h(j j1)
    {
        return j1.h();
    }

    private void i()
    {
        if (NetworkManager.L())
        {
            if (!l)
            {
                Object obj = new Bundle();
                String s = AccountManager.a();
                String s1 = com.cyberlink.beautycircle.Globals.t();
                ((Bundle) (obj)).putString("banner_country", s);
                ((Bundle) (obj)).putString("version", s1);
                obj = (new com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder()).addNetworkExtras(new AdMobExtras(((Bundle) (obj)))).build();
                g.loadAd(((com.google.android.gms.ads.doubleclick.PublisherAdRequest) (obj)));
            }
            return;
        } else
        {
            n = false;
            e.b();
            return;
        }
    }

    static boolean i(j j1)
    {
        return j1.g();
    }

    private void j()
    {
        if (h == null)
        {
            return;
        } else
        {
            AdSize adsize = g.getAdSize();
            com.pf.common.utility.m.b(a, (new StringBuilder()).append("scaleAdView, size=").append(adsize).toString());
            int i1 = adsize.getHeightInPixels(Globals.d().getApplicationContext());
            int j1 = adsize.getWidthInPixels(Globals.d().getApplicationContext());
            int k1 = h.getHeight();
            int l1 = h.getWidth();
            com.pf.common.utility.m.b(a, (new StringBuilder()).append("scaleAdView, size, pixel h:").append(i1).toString());
            com.pf.common.utility.m.b(a, (new StringBuilder()).append("scaleAdView, size, pixel w:").append(j1).toString());
            com.pf.common.utility.m.b(a, (new StringBuilder()).append("scaleAdView, size, pixel ph:").append(k1).toString());
            com.pf.common.utility.m.b(a, (new StringBuilder()).append("scaleAdView, size, pixel pw:").append(l1).toString());
            g.setScaleY((float)k1 / (float)i1);
            g.setScaleX((float)l1 / (float)j1);
            return;
        }
    }

    public void a()
    {
        if (!k)
        {
            com.pf.common.utility.m.e(a, "startAdFlow DFP not initialized");
        } else
        if (!n)
        {
            n = true;
            i();
            return;
        }
    }

    public void a(View view)
    {
        a(view, false);
    }

    public void a(ViewGroup viewgroup, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (!k)
        {
            com.pf.common.utility.m.e(a, "setAdContainer DFP not initialized");
            return;
        } else
        {
            a(((View) (null)), true);
            h = viewgroup;
            g.setLayoutParams(layoutparams);
            viewgroup.addView(g);
            viewgroup.addOnLayoutChangeListener(f);
            j();
            return;
        }
    }

    public void a(k k1)
    {
        e = k1;
    }

    public void b()
    {
        if (g != null)
        {
            g.resume();
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.pause();
        }
    }

    public void d()
    {
        if (g != null)
        {
            g.destroy();
        }
    }

}
