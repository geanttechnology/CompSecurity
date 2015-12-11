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
//            FlurryAdNativeListener, FlurryAdErrorType, FlurryAdNative

class b extends hq
{

    final d a;
    final FlurryAdNativeListener b;
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
            b.onShowFullscreen(c.c);
            return;

        case 4: // '\004'
            b.onCloseFullscreen(c.c);
            return;

        case 5: // '\005'
            b.onAppExit(c.c);
            return;

        case 6: // '\006'
            b.onClicked(c.c);
            return;

        case 7: // '\007'
            b.onError(c.c, FlurryAdErrorType.CLICK, a.c.a());
            return;

        case 8: // '\b'
            b.onImpressionLogged(c.c);
            break;
        }
    }

    ner(ner ner, d d1, FlurryAdNativeListener flurryadnativelistener)
    {
        c = ner;
        a = d1;
        b = flurryadnativelistener;
        super();
    }

    // Unreferenced inner class com/flurry/android/ads/FlurryAdNative$1

/* anonymous class */
    class FlurryAdNative._cls1
        implements fy
    {

        final FlurryAdNative a;

        public void a(d d1)
        {
            if (d1.a == FlurryAdNative.a(a) && d1.b != null)
            {
                if (com.flurry.sdk.d.a.a.equals(d1.b))
                {
                    FlurryAdNative.b(a);
                }
                FlurryAdNativeListener flurryadnativelistener = FlurryAdNative.c(a);
                if (flurryadnativelistener != null)
                {
                    fp.a().a(new FlurryAdNative._cls1._cls1(this, d1, flurryadnativelistener));
                    return;
                }
            }
        }

        public void notify(fx fx)
        {
            a((d)fx);
        }

            
            {
                a = flurryadnative;
                super();
            }
    }

}
