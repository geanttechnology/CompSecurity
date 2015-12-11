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
//            FlurryAdInterstitial, FlurryAdInterstitialListener, FlurryAdErrorType

class a
    implements fy
{

    final FlurryAdInterstitial a;

    public void a(d d1)
    {
        if (d1.a == FlurryAdInterstitial.a(a) && d1.b != null)
        {
            FlurryAdInterstitialListener flurryadinterstitiallistener = FlurryAdInterstitial.b(a);
            if (flurryadinterstitiallistener != null)
            {
                fp.a().a(new hq(d1, flurryadinterstitiallistener) {

                    final d a;
                    final FlurryAdInterstitialListener b;
                    final FlurryAdInterstitial._cls1 c;

                    public void safeRun()
                    {
                        switch (FlurryAdInterstitial._cls2.a[a.b.ordinal()])
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
                            b.onDisplay(c.a);
                            return;

                        case 6: // '\006'
                            b.onClose(c.a);
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
                c = FlurryAdInterstitial._cls1.this;
                a = d1;
                b = flurryadinterstitiallistener;
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

    _cls1.b(FlurryAdInterstitial flurryadinterstitial)
    {
        a = flurryadinterstitial;
        super();
    }
}
