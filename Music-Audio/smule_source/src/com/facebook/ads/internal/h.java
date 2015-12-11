// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.BannerAdapter;
import com.facebook.ads.internal.adapters.BannerAdapterListener;
import com.facebook.ads.internal.adapters.InterstitialAdapter;
import com.facebook.ads.internal.adapters.InterstitialAdapterListener;
import com.facebook.ads.internal.adapters.f;
import com.facebook.ads.internal.adapters.p;
import com.facebook.ads.internal.adapters.q;
import com.facebook.ads.internal.controllers.a;
import com.facebook.ads.internal.dev.Debug;
import com.facebook.ads.internal.dto.b;
import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.dto.d;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.s;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.ads.internal:
//            AdErrorType, a, b, e, 
//            c

public class h extends a
    implements com.facebook.ads.internal.server.a.a
{

    private static final String b = com/facebook/ads/internal/h.getSimpleName();
    private final Context c;
    private final String d;
    private final com.facebook.ads.internal.server.a e = new com.facebook.ads.internal.server.a();
    private final Handler f = new Handler();
    private final Runnable g = new Runnable() {

        final h a;

        public void run()
        {
            com.facebook.ads.internal.h.a(a, false);
            com.facebook.ads.internal.h.a(a);
        }

            
            {
                a = h.this;
                super();
            }
    };
    private final Runnable h = new Runnable() {

        final h a;

        public void run()
        {
            com.facebook.ads.internal.h.b(a);
        }

            
            {
                a = h.this;
                super();
            }
    };
    private volatile boolean i;
    private boolean j;
    private volatile boolean k;
    private AdAdapter l;
    private View m;
    private b n;
    private d o;
    private e p;
    private com.facebook.ads.internal.c q;
    private AdSize r;
    private int s;

    public h(Context context, String s1, e e1, AdSize adsize, com.facebook.ads.internal.c c1, int i1)
    {
        c = context;
        d = s1;
        p = e1;
        r = adsize;
        q = c1;
        s = i1;
        e.a(this);
    }

    static View a(h h1, View view)
    {
        h1.m = view;
        return view;
    }

    private void a(AdAdapter adadapter)
    {
        if (adadapter != null)
        {
            adadapter.onDestroy();
        }
    }

    static void a(h h1)
    {
        h1.k();
    }

    static void a(h h1, AdAdapter adadapter)
    {
        h1.a(adadapter);
    }

    static boolean a(h h1, boolean flag)
    {
        h1.i = flag;
        return flag;
    }

    static AdAdapter b(h h1, AdAdapter adadapter)
    {
        h1.l = adadapter;
        return adadapter;
    }

    static void b(h h1)
    {
        h1.m();
    }

    static void c(h h1)
    {
        h1.l();
    }

    static void d(h h1)
    {
        h1.i();
    }

    static Handler e(h h1)
    {
        return h1.f;
    }

    static AdAdapter f(h h1)
    {
        return h1.l;
    }

    static boolean g(h h1)
    {
        return h1.k;
    }

    static com.facebook.ads.internal.a h(h h1)
    {
        return h1.a;
    }

    static com.facebook.ads.internal.a i(h h1)
    {
        return h1.a;
    }

    private void i()
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException("Adapter listener must be called on the main thread.");
        } else
        {
            return;
        }
    }

    static com.facebook.ads.internal.a j(h h1)
    {
        return h1.a;
    }

    private AdPlacementType j()
    {
        if (r == null)
        {
            return AdPlacementType.NATIVE;
        }
        if (r == AdSize.INTERSTITIAL)
        {
            return AdPlacementType.INTERSTITIAL;
        } else
        {
            return AdPlacementType.BANNER;
        }
    }

    static com.facebook.ads.internal.a k(h h1)
    {
        return h1.a;
    }

    private void k()
    {
        o = new d(c, d, r, p, q, s, AdSettings.isTestMode(c));
        e.a(c, o);
    }

    private void l()
    {
        Object obj3 = n;
        Object obj1 = ((b) (obj3)).c();
        if (obj1 == null)
        {
            a.a(AdErrorType.NO_FILL.getAdErrorWrapper(""));
            m();
            return;
        }
        Object obj = ((com.facebook.ads.internal.dto.a) (obj1)).b;
        Object obj2 = com.facebook.ads.internal.adapters.f.a(((String) (obj)), ((b) (obj3)).a().a());
        if (obj2 == null)
        {
            Log.e(b, (new StringBuilder()).append("Adapter does not exist: ").append(((String) (obj))).toString());
            l();
            return;
        }
        if (j() != ((AdAdapter) (obj2)).getPlacementType())
        {
            a.a(AdErrorType.INTERNAL_ERROR.getAdErrorWrapper(""));
            return;
        }
        obj = new HashMap();
        obj3 = ((b) (obj3)).a();
        ((Map) (obj)).put("data", ((com.facebook.ads.internal.dto.a) (obj1)).c);
        ((Map) (obj)).put("definition", obj3);
        if (o == null)
        {
            a.a(AdErrorType.UNKNOWN_ERROR.getAdErrorWrapper("environment is empty"));
        }
        class _cls9
        {

            static final int a[];

            static 
            {
                a = new int[AdPlacementType.values().length];
                try
                {
                    a[AdPlacementType.INTERSTITIAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AdPlacementType.BANNER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AdPlacementType.NATIVE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.facebook.ads.internal._cls9.a[((AdAdapter) (obj2)).getPlacementType().ordinal()])
        {
        default:
            Log.e(b, "attempt unexpected adapter type");
            return;

        case 2: // '\002'
            obj1 = (BannerAdapter)obj2;
            obj2 = new Runnable(((BannerAdapter) (obj1))) {

                final BannerAdapter a;
                final h b;

                public void run()
                {
                    com.facebook.ads.internal.h.a(b, a);
                    com.facebook.ads.internal.h.c(b);
                }

            
            {
                b = h.this;
                a = banneradapter;
                super();
            }
            };
            f.postDelayed(((Runnable) (obj2)), 10000L);
            ((BannerAdapter) (obj1)).loadBannerAd(c, r, new BannerAdapterListener(((Runnable) (obj2))) {

                final Runnable a;
                final h b;

                public void onBannerAdClicked(BannerAdapter banneradapter)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.k(b).b();
                }

                public void onBannerAdExpanded(BannerAdapter banneradapter)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.l(b);
                }

                public void onBannerAdLoaded(BannerAdapter banneradapter, View view)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.e(b).removeCallbacks(a);
                    AdAdapter adadapter = com.facebook.ads.internal.h.f(b);
                    com.facebook.ads.internal.h.b(b, banneradapter);
                    com.facebook.ads.internal.h.a(b, view);
                    if (!com.facebook.ads.internal.h.g(b))
                    {
                        h.h(b).a();
                        return;
                    } else
                    {
                        h.i(b).a(view);
                        com.facebook.ads.internal.h.a(b, adadapter);
                        com.facebook.ads.internal.h.b(b);
                        return;
                    }
                }

                public void onBannerAdMinimized(BannerAdapter banneradapter)
                {
                    com.facebook.ads.internal.h.d(b);
                    com.facebook.ads.internal.h.b(b);
                }

                public void onBannerError(BannerAdapter banneradapter, AdError aderror)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.e(b).removeCallbacks(a);
                    com.facebook.ads.internal.h.a(b, banneradapter);
                    com.facebook.ads.internal.h.c(b);
                }

                public void onBannerLoggingImpression(BannerAdapter banneradapter)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.j(b).c();
                }

            
            {
                b = h.this;
                a = runnable;
                super();
            }
            }, ((Map) (obj)));
            return;

        case 1: // '\001'
            obj1 = (InterstitialAdapter)obj2;
            obj2 = new Runnable(((InterstitialAdapter) (obj1))) {

                final InterstitialAdapter a;
                final h b;

                public void run()
                {
                    com.facebook.ads.internal.h.a(b, a);
                    com.facebook.ads.internal.h.c(b);
                }

            
            {
                b = h.this;
                a = interstitialadapter;
                super();
            }
            };
            f.postDelayed(((Runnable) (obj2)), 10000L);
            ((InterstitialAdapter) (obj1)).loadInterstitialAd(c, new InterstitialAdapterListener(((Runnable) (obj2))) {

                final Runnable a;
                final h b;

                public void onInterstitialAdClicked(InterstitialAdapter interstitialadapter, String s1, boolean flag)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.o(b).b();
                    StringBuilder stringbuilder;
                    boolean flag1;
                    if (!com.facebook.ads.internal.util.s.a(s1))
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    stringbuilder = (new StringBuilder()).append("Clickthrough event with playerHandles=").append(flag).append(" and url ");
                    if (flag1)
                    {
                        interstitialadapter = "defined";
                    } else
                    {
                        interstitialadapter = "not defined";
                    }
                    Debug.d(stringbuilder.append(interstitialadapter).toString());
                    if (!flag)
                    {
                        Debug.v("Adapter handles click, ignoring click url.");
                    } else
                    if (flag1)
                    {
                        Debug.d((new StringBuilder()).append("Intent url=").append(s1).toString());
                        interstitialadapter = new Intent("android.intent.action.VIEW");
                        if (!(com.facebook.ads.internal.h.p(b).d instanceof Activity))
                        {
                            Debug.d("Context is not instance of Activity");
                            interstitialadapter.addFlags(0x10000000);
                        }
                        interstitialadapter.setData(Uri.parse(s1));
                        com.facebook.ads.internal.h.p(b).d.startActivity(interstitialadapter);
                        return;
                    }
                }

                public void onInterstitialAdDismissed(InterstitialAdapter interstitialadapter)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.r(b).e();
                }

                public void onInterstitialAdDisplayed(InterstitialAdapter interstitialadapter)
                {
                    com.facebook.ads.internal.h.d(b);
                    com.facebook.ads.internal.h.q(b).d();
                }

                public void onInterstitialAdLoaded(InterstitialAdapter interstitialadapter)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.e(b).removeCallbacks(a);
                    com.facebook.ads.internal.h.b(b, interstitialadapter);
                    h.m(b).a();
                    com.facebook.ads.internal.h.b(b);
                }

                public void onInterstitialError(InterstitialAdapter interstitialadapter, AdError aderror)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.e(b).removeCallbacks(a);
                    com.facebook.ads.internal.h.a(b, interstitialadapter);
                    com.facebook.ads.internal.h.c(b);
                }

                public void onInterstitialLoggingImpression(InterstitialAdapter interstitialadapter)
                {
                    com.facebook.ads.internal.h.d(b);
                    h.n(b).c();
                }

            
            {
                b = h.this;
                a = runnable;
                super();
            }
            }, ((Map) (obj)));
            return;

        case 3: // '\003'
            obj1 = (p)obj2;
            break;
        }
        obj2 = new Runnable(((p) (obj1))) {

            final p a;
            final h b;

            public void run()
            {
                com.facebook.ads.internal.h.a(b, a);
                com.facebook.ads.internal.h.c(b);
            }

            
            {
                b = h.this;
                a = p1;
                super();
            }
        };
        f.postDelayed(((Runnable) (obj2)), 10000L);
        ((p) (obj1)).a(c, new q(((Runnable) (obj2))) {

            final Runnable a;
            final h b;

            public void a(p p1)
            {
                com.facebook.ads.internal.h.d(b);
                h.e(b).removeCallbacks(a);
                com.facebook.ads.internal.h.b(b, p1);
                com.facebook.ads.internal.h.s(b).a();
            }

            public void a(p p1, AdError aderror)
            {
                com.facebook.ads.internal.h.d(b);
                h.e(b).removeCallbacks(a);
                com.facebook.ads.internal.h.a(b, p1);
                com.facebook.ads.internal.h.c(b);
            }

            
            {
                b = h.this;
                a = runnable;
                super();
            }
        }, ((Map) (obj)));
    }

    static void l(h h1)
    {
        h1.n();
    }

    static com.facebook.ads.internal.a m(h h1)
    {
        return h1.a;
    }

    private void m()
    {
        if (!j && !i) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        long l1;
        if ((obj = n) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((b) (obj)).a();
        l1 = ((c) (obj)).b();
        com.facebook.ads.internal._cls9.a[j().ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 69
    //                   2 119;
           goto _L3 _L4 _L5
_L3:
        return;
_L4:
        if (!com.facebook.ads.internal.util.g.a(c))
        {
            f.postDelayed(h, 1000L);
        }
_L7:
        if (l1 > 0L)
        {
            f.postDelayed(g, l1);
            i = true;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (m == null || com.facebook.ads.internal.util.g.a(c, m, ((c) (obj)).e())) goto _L7; else goto _L6
_L6:
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L8
_L8:
        f.postDelayed(h, 1000L);
        return;
    }

    static com.facebook.ads.internal.a n(h h1)
    {
        return h1.a;
    }

    private void n()
    {
        if (!i)
        {
            return;
        } else
        {
            f.removeCallbacks(g);
            i = false;
            return;
        }
    }

    static com.facebook.ads.internal.a o(h h1)
    {
        return h1.a;
    }

    static d p(h h1)
    {
        return h1.o;
    }

    static com.facebook.ads.internal.a q(h h1)
    {
        return h1.a;
    }

    static com.facebook.ads.internal.a r(h h1)
    {
        return h1.a;
    }

    static com.facebook.ads.internal.a s(h h1)
    {
        return h1.a;
    }

    public c a()
    {
        if (n == null)
        {
            return null;
        } else
        {
            return n.a();
        }
    }

    public void a(com.facebook.ads.internal.b b1)
    {
        a.a(b1);
        int i1 = b1.a().getErrorCode();
        if (!i && (i1 == 1002 || i1 == 1000))
        {
            f.postDelayed(g, 30000L);
            i = true;
        }
    }

    public void a(com.facebook.ads.internal.server.d d1)
    {
        d1 = d1.b();
        if (d1 == null || d1.a() == null)
        {
            throw new IllegalStateException("invalid placement in response");
        } else
        {
            n = d1;
            l();
            return;
        }
    }

    public void b()
    {
        k();
    }

    public void c()
    {
        if (l == null)
        {
            throw new IllegalStateException("no adapter ready to start");
        }
        if (k)
        {
            throw new IllegalStateException("ad already started");
        }
        k = true;
        Object obj = l.getPlacementType();
        switch (com.facebook.ads.internal._cls9.a[((AdPlacementType) (obj)).ordinal()])
        {
        default:
            Log.e(b, "start unexpected adapter type");
            return;

        case 1: // '\001'
            ((InterstitialAdapter)l).show();
            return;

        case 2: // '\002'
            if (m == null)
            {
                throw new IllegalStateException("ad is not ready");
            } else
            {
                a.a(m);
                m();
                return;
            }

        case 3: // '\003'
            obj = (p)l;
            break;
        }
        if (!((p) (obj)).r())
        {
            throw new IllegalStateException("ad is not ready or already displayed");
        } else
        {
            a.a(((p) (obj)));
            return;
        }
    }

    public void d()
    {
        if (!k)
        {
            return;
        } else
        {
            n();
            a(l);
            m = null;
            k = false;
            return;
        }
    }

    public void e()
    {
        if (!k)
        {
            return;
        } else
        {
            n();
            return;
        }
    }

    public void f()
    {
        if (!k)
        {
            return;
        } else
        {
            m();
            return;
        }
    }

    public void g()
    {
        n();
        k();
    }

    public void h()
    {
        j = true;
        n();
    }

}
