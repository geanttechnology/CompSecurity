// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.Toast;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.FlurryAds;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.jirbo.adcolony.aj;
import com.jirbo.adcolony.q;
import com.jirbo.adcolony.s;
import com.jirbo.adcolony.u;
import com.smule.android.c.aa;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.utils.a;
import com.smule.pianoandroid.utils.b;
import com.smule.pianoandroid.utils.n;
import java.text.MessageFormat;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.ads:
//            b, i

public abstract class g
{

    private static final String a = com/smule/pianoandroid/ads/g.getName();
    private PublisherInterstitialAd b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private Runnable i;
    private boolean j;

    public g()
    {
        f = MagicApplication.getContext().getString(0x7f0c00ce);
        j = false;
    }

    static String a(g g1)
    {
        return g1.c;
    }

    static Runnable b(g g1)
    {
        return g1.i;
    }

    private void d(Activity activity, int k, Runnable runnable, Map map)
    {
        i = runnable;
        Context context = activity.getApplicationContext();
        if (b())
        {
            aa.c(a, "Pre-loading Flurry ads.");
            FlurryAds.initializeAds(activity);
            FlurryAds.setTargetingKeywords(com.smule.pianoandroid.utils.a.c());
            (new Thread(new Runnable(context, activity, k) {

                final Context a;
                final Activity b;
                final int c;
                final g d;

                public void run()
                {
                    FlurryAds.fetchAd(a, com.smule.pianoandroid.ads.g.a(d), (ViewGroup)b.findViewById(c), FlurryAdSize.FULLSCREEN);
                }

            
            {
                d = g.this;
                a = context;
                b = activity;
                c = k;
                super();
            }
            })).start();
        } else
        {
            if (c())
            {
                com.smule.pianoandroid.utils.a.a(activity);
                return;
            }
            if (d())
            {
                b = new PublisherInterstitialAd(activity);
                b.setAdUnitId(MessageFormat.format("/{0}/{1}", new Object[] {
                    f, g
                }));
                map = (new com.google.android.gms.ads.doubleclick.PublisherAdRequest.Builder()).addNetworkExtras(new AdMobExtras(com.smule.pianoandroid.utils.a.a(map))).build();
                aa.a(a, (new StringBuilder()).append("Loading DFP ").append(g).toString());
                b.loadAd(map);
                b.setAdListener(new com.smule.pianoandroid.ads.b(b, g, runnable));
                b.setAppEventListener(new b(activity, this));
                return;
            }
        }
    }

    private void e(Activity activity, int k, Runnable runnable, Map map)
    {
        if (com.smule.android.network.managers.a.a().c())
        {
            d(activity, k, runnable, map);
        }
    }

    public void a(Activity activity)
    {
        if (c())
        {
            q.c();
        }
    }

    public void a(Fragment fragment)
    {
        if (c())
        {
            q.c();
        }
    }

    public void a(Runnable runnable)
    {
        i = runnable;
        if (b != null)
        {
            ((com.smule.pianoandroid.ads.b)b.getAdListener()).a(runnable);
        }
    }

    protected void a(String s)
    {
        h = s;
    }

    protected void a(String s, String s1)
    {
        d = s;
        e = s1;
    }

    protected abstract boolean a();

    public boolean a(Activity activity, int k)
    {
        if (a())
        {
            aa.a(a, (new StringBuilder()).append("Throttling ad on show ").append(getClass().getName()).toString());
            return false;
        }
        if (b() && e())
        {
            n.c();
            FlurryAds.setAdListener(new i(i));
            FlurryAds.displayAd(activity.getApplicationContext(), c, (ViewGroup)activity.findViewById(k));
            com.smule.android.c.a.a(c);
            return true;
        }
        if (c())
        {
            aj aj1 = new aj(e);
            aj1.a(new u(activity) {

                final Activity a;
                final g b;

                public void a(s s)
                {
                    if (com.smule.pianoandroid.ads.g.b(b) != null)
                    {
                        com.smule.pianoandroid.ads.g.b(b).run();
                    }
                }

                public void b(s s)
                {
                    Toast.makeText(a.getApplicationContext(), 0x7f0c001f, 0).show();
                }

            
            {
                b = g.this;
                a = activity;
                super();
            }
            });
            if (aj1.f())
            {
                aj1.j();
                com.smule.android.c.a.a(d);
                return true;
            }
        } else
        if (d())
        {
            if (e())
            {
                aa.a(a, (new StringBuilder()).append("Showing DFP ").append(g).toString());
                b.show();
                com.smule.android.c.a.a(g);
                return true;
            }
            if (b != null)
            {
                ((com.smule.pianoandroid.ads.b)b.getAdListener()).a();
            }
            return false;
        }
        return false;
    }

    public boolean a(Activity activity, int k, Runnable runnable, Map map)
    {
        i = runnable;
        if (a())
        {
            aa.a(a, (new StringBuilder()).append("Throttling ad on load ").append(getClass().getName()).toString());
            j = true;
            return false;
        } else
        {
            j = false;
            e(activity, k, runnable, map);
            return true;
        }
    }

    public void b(Activity activity)
    {
        if (c())
        {
            q.a(activity);
        }
    }

    public void b(Activity activity, int k, Runnable runnable, Map map)
    {
        if (d())
        {
            a(activity, k, runnable, map);
        }
    }

    public void b(Fragment fragment)
    {
        if (c())
        {
            q.a(fragment.getActivity());
        }
    }

    protected void b(String s)
    {
        c = s;
    }

    public boolean b()
    {
        return n.a(h);
    }

    public void c(Activity activity)
    {
    }

    public void c(Activity activity, int k, Runnable runnable, Map map)
    {
        if (!d())
        {
            a(activity, k, runnable, map);
        }
    }

    public void c(Fragment fragment)
    {
    }

    protected void c(String s)
    {
        g = s;
    }

    protected boolean c()
    {
        return n.c(h);
    }

    protected boolean d()
    {
        return n.b(h);
    }

    public boolean e()
    {
        boolean flag1 = false;
        if (!b()) goto _L2; else goto _L1
_L1:
        boolean flag = FlurryAds.isAdReady(c);
_L4:
        aa.c(a, (new StringBuilder()).append("Ad ").append(h).append(" ready : ").append(flag).toString());
        return flag;
_L2:
        flag = flag1;
        if (d())
        {
            flag = flag1;
            if (b != null)
            {
                flag = b.isLoaded();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void f()
    {
    }

}
