// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;

import com.flurry.sdk.av;
import com.flurry.sdk.d;
import com.flurry.sdk.fp;
import com.flurry.sdk.fx;
import com.flurry.sdk.fy;
import com.flurry.sdk.hq;

// Referenced classes of package com.flurry.android.ads:
//            FlurryAdBanner, FlurryAdBannerListener, FlurryAdErrorType

class a
    implements fy
{

    final FlurryAdBanner a;

    public void a(d d1)
    {
        if (d1.a == FlurryAdBanner.a(a) && d1.b != null)
        {
            FlurryAdBannerListener flurryadbannerlistener = FlurryAdBanner.b(a);
            if (flurryadbannerlistener != null)
            {
                fp.a().a(new hq(d1, flurryadbannerlistener) {

                    final d a;
                    final FlurryAdBannerListener b;
                    final FlurryAdBanner._cls1 c;

                    public void safeRun()
                    {
                        switch (FlurryAdBanner._cls2.a[a.b.ordinal()])
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
                c = FlurryAdBanner._cls1.this;
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

    _cls1.b(FlurryAdBanner flurryadbanner)
    {
        a = flurryadbanner;
        super();
    }
}
