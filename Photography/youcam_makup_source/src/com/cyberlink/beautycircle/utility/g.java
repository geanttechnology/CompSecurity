// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.c;
import com.cyberlink.beautycircle.view.widgetpool.common.SlideShowView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager, h

public class g
{

    private String a;
    private List b;
    private int c;
    private h d;
    private android.view.View.OnLayoutChangeListener e;
    private PublisherAdView f;
    private ImageView g;
    private ViewGroup h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private int m;
    private boolean n;

    public g(String s, List list, int i1, int j1)
    {
        c = 0;
        e = new android.view.View.OnLayoutChangeListener() {

            final g a;

            public void onLayoutChange(View view, int k1, int l1, int i2, int j2, int k2, int l2, 
                    int i3, int j3)
            {
                a.a();
            }

            
            {
                a = g.this;
                super();
            }
        };
        f = null;
        g = null;
        h = null;
        k = false;
        l = false;
        m = 0;
        n = false;
        a = s;
        b = list;
        i = i1;
        j = j1;
        do
        {
label0:
            {
                if (c < b.size())
                {
                    if (!h())
                    {
                        break label0;
                    }
                    f();
                }
                if (!k)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "DFPAdUtilityGeneral DFP not initialized"
                    });
                }
                return;
            }
            c = c + 1;
        } while (true);
    }

    static int a(g g1)
    {
        return g1.c;
    }

    static int a(g g1, int i1)
    {
        g1.m = i1;
        return i1;
    }

    static String a(int i1)
    {
        return b(i1);
    }

    private void a(View view, boolean flag)
    {
        if (f != null)
        {
            ViewGroup viewgroup = (ViewGroup)f.getParent();
            if (viewgroup != null && (flag || viewgroup == view))
            {
                viewgroup.removeView(f);
                viewgroup.removeOnLayoutChangeListener(e);
            }
        }
        if (g != null)
        {
            ViewGroup viewgroup1 = (ViewGroup)g.getParent();
            if (viewgroup1 != null && (flag || viewgroup1 == view))
            {
                viewgroup1.removeView(g);
            }
        }
    }

    static boolean a(g g1, boolean flag)
    {
        g1.l = flag;
        return flag;
    }

    static int b(g g1)
    {
        return g1.m;
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

    static boolean b(g g1, boolean flag)
    {
        g1.n = flag;
        return flag;
    }

    static int c(g g1)
    {
        int i1 = g1.m;
        g1.m = i1 + 1;
        return i1;
    }

    static void d(g g1)
    {
        g1.i();
    }

    static h e(g g1)
    {
        return g1.d;
    }

    static PublisherAdView f(g g1)
    {
        return g1.f;
    }

    private void f()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "init enter"
        });
        k = true;
        f = new PublisherAdView(Globals.n().getApplicationContext());
        f.setAdUnitId(a);
        f.setAdSizes(new AdSize[] {
            (AdSize)b.get(c)
        });
        f.setAdListener(new AdListener() {

            final g a;

            public void onAdClosed()
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    "PublisherAdView onAdClosed"
                });
                g.a(a, false);
            }

            public void onAdFailedToLoad(int i1)
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    (new StringBuilder()).append("PublisherAdView mCurrentAdSizeCount=").append(g.a(a)).append(" onAdFailedToLoad : ").append(g.a(i1)).toString()
                });
                g.a(a, false);
                if (g.b(a) < 3)
                {
                    com.cyberlink.beautycircle.utility.g.c(a);
                    g.d(a);
                } else
                if (com.cyberlink.beautycircle.utility.g.e(a) != null)
                {
                    g.b(a, false);
                    com.cyberlink.beautycircle.utility.g.e(a).b();
                    return;
                }
            }

            public void onAdLeftApplication()
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    " PublisherAdViewonAdLeftApplication"
                });
            }

            public void onAdLoaded()
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    (new StringBuilder()).append("PublisherAdView onAdLoaded size:").append(g.f(a).getAdSize()).toString()
                });
                if (g.g(a)) goto _L2; else goto _L1
_L1:
                if (!g.h(a)) goto _L4; else goto _L3
_L3:
                g.d(a);
_L6:
                return;
_L4:
                g.b(a, false);
                g.a(a, 0);
                com.perfectcorp.utility.e.e(new Object[] {
                    "onAdLoaded, no any proper size!"
                });
                return;
_L2:
                g.a(a, true);
                a.a();
                if (g.i(a) != null)
                {
                    g.f(a).postDelayed(new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            if (g.i(a.a) != null)
                            {
                                g.i(a.a).setVisibility(8);
                                g.i(a.a).setImageDrawable(null);
                            }
                            com.cyberlink.beautycircle.utility.g.j(a.a);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    }, 1000L);
                } else
                {
                    com.cyberlink.beautycircle.utility.g.j(a);
                }
                if (com.cyberlink.beautycircle.utility.g.e(a) != null)
                {
                    com.cyberlink.beautycircle.utility.g.e(a).a();
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void onAdOpened()
            {
                com.perfectcorp.utility.e.c(new Object[] {
                    "PublisherAdView onAdOpened"
                });
            }

            
            {
                a = g.this;
                super();
            }
        });
        g = new ImageView(Globals.n().getApplicationContext());
    }

    private boolean g()
    {
label0:
        {
            do
            {
                int i1 = c;
                c = i1 + 1;
                if (i1 >= b.size())
                {
                    break label0;
                }
                if (b.size() <= c)
                {
                    break;
                }
                if (h())
                {
                    f.setAdSizes(new AdSize[] {
                        (AdSize)b.get(c)
                    });
                    com.perfectcorp.utility.e.b(new Object[] {
                        (new StringBuilder()).append("setNextProperSize(), info. adSize=").append(((AdSize)b.get(c)).toString()).toString()
                    });
                    return true;
                }
            } while (true);
            c = c - 1;
        }
        com.perfectcorp.utility.e.b(new Object[] {
            "setNextProperSize(), info. failed"
        });
        return false;
    }

    static boolean g(g g1)
    {
        return g1.h();
    }

    private boolean h()
    {
        AdSize adsize = (AdSize)b.get(c);
        int i1 = adsize.getHeightInPixels(Globals.n().getApplicationContext());
        return adsize.getWidthInPixels(Globals.n().getApplicationContext()) <= i && i1 <= j;
    }

    static boolean h(g g1)
    {
        return g1.g();
    }

    static ImageView i(g g1)
    {
        return g1.g;
    }

    private void i()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            (new StringBuilder()).append("sendReqeust enter request count = ").append(m).toString()
        });
        boolean flag = com.cyberlink.beautycircle.model.network.c.a();
        com.perfectcorp.utility.e.c(new Object[] {
            (new StringBuilder()).append("sendReqeust bIsNetworkConnected:").append(flag).toString()
        });
        if (flag)
        {
            if (!l)
            {
                Object obj = new Bundle();
                String s = AccountManager.a();
                String s1 = Globals.t();
                ((Bundle) (obj)).putString("banner_country", s);
                ((Bundle) (obj)).putString("version", s1);
                com.perfectcorp.utility.e.c(new Object[] {
                    "banner_country=", s, ", version=", s1
                });
                obj = (new com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder()).addNetworkExtras(new AdMobExtras(((Bundle) (obj)))).build();
                f.loadAd(((com.google.android.gms.ads.doubleclick.PublisherAdRequest) (obj)));
            }
            return;
        } else
        {
            n = false;
            d.b();
            return;
        }
    }

    private void j()
    {
        if (h != null)
        {
            int j1 = h.getChildCount();
            for (int i1 = 0; i1 < j1; i1++)
            {
                View view = h.getChildAt(i1);
                if (view instanceof SlideShowView)
                {
                    ((SlideShowView)view).c();
                    view.setVisibility(8);
                }
            }

        }
    }

    static void j(g g1)
    {
        g1.j();
    }

    static boolean k(g g1)
    {
        return g1.l;
    }

    public void a()
    {
        if (h == null)
        {
            return;
        } else
        {
            AdSize adsize = f.getAdSize();
            com.perfectcorp.utility.e.b(new Object[] {
                (new StringBuilder()).append("scaleAdView, size=").append(adsize).toString()
            });
            int i1 = adsize.getHeightInPixels(Globals.n().getApplicationContext());
            int j1 = adsize.getWidthInPixels(Globals.n().getApplicationContext());
            int k1 = h.getHeight();
            int l1 = h.getWidth();
            com.perfectcorp.utility.e.b(new Object[] {
                (new StringBuilder()).append("scaleAdView, size, pixel h:").append(i1).toString()
            });
            com.perfectcorp.utility.e.b(new Object[] {
                (new StringBuilder()).append("scaleAdView, size, pixel w:").append(j1).toString()
            });
            com.perfectcorp.utility.e.b(new Object[] {
                (new StringBuilder()).append("scaleAdView, size, pixel ph:").append(k1).toString()
            });
            com.perfectcorp.utility.e.b(new Object[] {
                (new StringBuilder()).append("scaleAdView, size, pixel pw:").append(l1).toString()
            });
            f.setScaleY((float)k1 / (float)i1);
            f.setScaleX((float)l1 / (float)j1);
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
            com.perfectcorp.utility.e.e(new Object[] {
                "setAdContainer DFP not initialized"
            });
        } else
        {
            com.perfectcorp.utility.e.c(new Object[] {
                "setAdContainer enter"
            });
            if (f.getParent() != null)
            {
                ((ViewGroup)f.getParent()).removeView(f);
            }
            if (g != null && g.getParent() != null)
            {
                ((ViewGroup)g.getParent()).removeView(g);
            }
            h = viewgroup;
            f.setLayoutParams(layoutparams);
            viewgroup.addView(f);
            viewgroup.addOnLayoutChangeListener(e);
            a();
            if (g != null)
            {
                g.setLayoutParams(layoutparams);
                viewgroup.addView(g);
                return;
            }
        }
    }

    public void a(h h1)
    {
        d = h1;
    }

    public void a(boolean flag)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "startAdFlow enter"
        });
        if (!k)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "startAdFlow DFP not initialized"
            });
        } else
        if (!n || flag)
        {
            if (h != null && g != null)
            {
                if (h.getWidth() + h.getHeight() != 0)
                {
                    ImageUtils.a(h).a(new m(flag) {

                        final boolean a;
                        final g b;

                        protected void a(Bitmap bitmap)
                        {
                            if (bitmap != null)
                            {
                                g.i(b).setImageBitmap(bitmap);
                                g.i(b).setVisibility(0);
                                g.b(b, true);
                                if (g.k(b) && a)
                                {
                                    g.a(b, 0);
                                    g.a(b, false);
                                }
                                g.d(b);
                            }
                        }

                        protected void b(Object obj)
                        {
                            a((Bitmap)obj);
                        }

            
            {
                b = g.this;
                a = flag;
                super();
            }
                    });
                    return;
                }
            } else
            {
                n = true;
                if (l && flag)
                {
                    m = 0;
                    l = false;
                }
                i();
                return;
            }
        }
    }

    public void b()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "resumeAdView enter"
        });
        if (f != null)
        {
            f.resume();
        }
    }

    public void c()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "pauseAdView enter"
        });
        if (f != null)
        {
            f.pause();
        }
    }

    public void d()
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "destoryAdView enter"
        });
        if (f != null)
        {
            f.destroy();
        }
    }

    public boolean e()
    {
        return l;
    }
}
