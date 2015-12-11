// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.flurry.sdk.av;
import com.flurry.sdk.d;
import com.flurry.sdk.fp;
import com.flurry.sdk.fx;
import com.flurry.sdk.fy;
import com.flurry.sdk.fz;
import com.flurry.sdk.gd;
import com.flurry.sdk.hq;
import com.flurry.sdk.i;
import com.flurry.sdk.q;

// Referenced classes of package com.flurry.android.ads:
//            FlurryAdBannerListener, FlurryAdTargeting, FlurryAdErrorType

public final class FlurryAdBanner
{

    private static final String a = com/flurry/android/ads/FlurryAdBanner.getSimpleName();
    private q b;
    private final fy c;
    private FlurryAdBannerListener d;

    public FlurryAdBanner(Context context, ViewGroup viewgroup, String s)
    {
        c = new fy() {

            final FlurryAdBanner a;

            public void a(d d1)
            {
                if (d1.a == FlurryAdBanner.a(a) && d1.b != null)
                {
                    FlurryAdBannerListener flurryadbannerlistener = FlurryAdBanner.b(a);
                    if (flurryadbannerlistener != null)
                    {
                        fp.a().a(new hq(this, d1, flurryadbannerlistener) {

                            final d a;
                            final FlurryAdBannerListener b;
                            final _cls1 c;

                            public void safeRun()
                            {
                                class _cls2
                                {

                                    static final int a[];

                                    static 
                                    {
                                        a = new int[com.flurry.sdk.d.a.values().length];
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.a.ordinal()] = 1;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror9) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.b.ordinal()] = 2;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror8) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.c.ordinal()] = 3;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror7) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.d.ordinal()] = 4;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror6) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.e.ordinal()] = 5;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror5) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.f.ordinal()] = 6;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror4) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.g.ordinal()] = 7;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror3) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.h.ordinal()] = 8;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror2) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.k.ordinal()] = 9;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror1) { }
                                        try
                                        {
                                            a[com.flurry.sdk.d.a.i.ordinal()] = 10;
                                        }
                                        catch (NoSuchFieldError nosuchfielderror)
                                        {
                                            return;
                                        }
                                    }
                                }

                                switch (_cls2.a[a.b.ordinal()])
                                {
                                default:
                                    return;

                                case 1: // '\001'
                                    b.onFetched(c.a);
                                    return;

                                case 2: // '\002'
                                    b.onError(c.a, FlurryAdErrorType.FETCH, a.c.a());
                                    return;

                                case 3: // '\003'
                                    b.onRendered(c.a);
                                    return;

                                case 4: // '\004'
                                    b.onError(c.a, FlurryAdErrorType.RENDER, a.c.a());
                                    return;

                                case 5: // '\005'
                                    b.onShowFullscreen(c.a);
                                    return;

                                case 6: // '\006'
                                    b.onCloseFullscreen(c.a);
                                    return;

                                case 7: // '\007'
                                    b.onAppExit(c.a);
                                    return;

                                case 8: // '\b'
                                    b.onClicked(c.a);
                                    return;

                                case 9: // '\t'
                                    b.onVideoCompleted(c.a);
                                    return;

                                case 10: // '\n'
                                    b.onError(c.a, FlurryAdErrorType.CLICK, a.c.a());
                                    break;
                                }
                            }

            
            {
                c = _pcls1;
                a = d1;
                b = flurryadbannerlistener;
                super();
            }
                        });
                        return;
                    }
                }
            }

            public void notify(fx fx)
            {
                a((d)fx);
            }

            
            {
                a = FlurryAdBanner.this;
                super();
            }
        };
        if (fp.a() == null)
        {
            throw new IllegalStateException("Flurry SDK must be initialized before starting a session");
        }
        if (context == null)
        {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Ad space must be specified!");
        }
        try
        {
            if (i.a() == null)
            {
                throw new IllegalStateException("Could not find FlurryAds module. Please make sure the library is included.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            gd.a(a, "Exception: ", context);
            return;
        }
        b = new q(context, viewgroup, s);
        fz.a().a("com.flurry.android.impl.ads.AdStateEvent", c);
        return;
    }

    static q a(FlurryAdBanner flurryadbanner)
    {
        return flurryadbanner.b;
    }

    static FlurryAdBannerListener b(FlurryAdBanner flurryadbanner)
    {
        return flurryadbanner.d;
    }

    public void destroy()
    {
        try
        {
            fz.a().b("com.flurry.android.impl.ads.AdStateEvent", c);
            d = null;
            if (b != null)
            {
                b.a();
                b = null;
            }
            return;
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
        }
    }

    public void displayAd()
    {
        try
        {
            b.w();
            return;
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
        }
    }

    public void fetchAd()
    {
        try
        {
            b.v();
            return;
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
        }
    }

    public void fetchAndDisplayAd()
    {
        try
        {
            b.x();
            return;
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
        }
    }

    public boolean isReady()
    {
        boolean flag;
        try
        {
            flag = b.u();
        }
        catch (Throwable throwable)
        {
            gd.a(a, "Exception: ", throwable);
            return false;
        }
        return flag;
    }

    public void setListener(FlurryAdBannerListener flurryadbannerlistener)
    {
        try
        {
            d = flurryadbannerlistener;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FlurryAdBannerListener flurryadbannerlistener)
        {
            gd.a(a, "Exception: ", flurryadbannerlistener);
        }
    }

    public void setTargeting(FlurryAdTargeting flurryadtargeting)
    {
        try
        {
            b.a(flurryadtargeting);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FlurryAdTargeting flurryadtargeting)
        {
            gd.a(a, "Exception: ", flurryadtargeting);
        }
    }

}
