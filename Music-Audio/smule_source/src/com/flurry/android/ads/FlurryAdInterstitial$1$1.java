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
//            FlurryAdInterstitialListener, FlurryAdErrorType, FlurryAdInterstitial

class b extends hq
{

    final d a;
    final FlurryAdInterstitialListener b;
    final ner c;

    public void safeRun()
    {
        switch (b[a.b.a()])
        {
        default:
            return;

        case 1: // '\001'
            b.onFetched(c.c);
            return;

        case 2: // '\002'
            b.onError(c.c, FlurryAdErrorType.FETCH, a.c.a());
            return;

        case 3: // '\003'
            b.onRendered(c.c);
            return;

        case 4: // '\004'
            b.onError(c.c, FlurryAdErrorType.RENDER, a.c.a());
            return;

        case 5: // '\005'
            b.onDisplay(c.c);
            return;

        case 6: // '\006'
            b.onClose(c.c);
            return;

        case 7: // '\007'
            b.onAppExit(c.c);
            return;

        case 8: // '\b'
            b.onClicked(c.c);
            return;

        case 9: // '\t'
            b.onVideoCompleted(c.c);
            return;

        case 10: // '\n'
            b.onError(c.c, FlurryAdErrorType.CLICK, a.c.a());
            break;
        }
    }

    ner(ner ner, d d1, FlurryAdInterstitialListener flurryadinterstitiallistener)
    {
        c = ner;
        a = d1;
        b = flurryadinterstitiallistener;
        super();
    }

    // Unreferenced inner class com/flurry/android/ads/FlurryAdInterstitial$1

/* anonymous class */
    class FlurryAdInterstitial._cls1
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
                    fp.a().a(new FlurryAdInterstitial._cls1._cls1(this, d1, flurryadinterstitiallistener));
                    return;
                }
            }
        }

        public void notify(fx fx)
        {
            a((d)fx);
        }

            
            {
                a = flurryadinterstitial;
                super();
            }
    }

}
