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
//            FlurryAdNative, FlurryAdNativeListener, FlurryAdErrorType

class a
    implements fy
{

    final FlurryAdNative a;

    public void a(d d1)
    {
        if (d1.a == FlurryAdNative.a(a) && d1.b != null)
        {
            if (com.flurry.sdk.ative._cls1.a.a(d1.b))
            {
                FlurryAdNative.b(a);
            }
            FlurryAdNativeListener flurryadnativelistener = FlurryAdNative.c(a);
            if (flurryadnativelistener != null)
            {
                fp.a().a(new hq(d1, flurryadnativelistener) {

                    final d a;
                    final FlurryAdNativeListener b;
                    final FlurryAdNative._cls1 c;

                    public void safeRun()
                    {
                        switch (FlurryAdNative._cls2.a[a.b.ordinal()])
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
                            b.onShowFullscreen(c.a);
                            return;

                        case 4: // '\004'
                            b.onCloseFullscreen(c.a);
                            return;

                        case 5: // '\005'
                            b.onAppExit(c.a);
                            return;

                        case 6: // '\006'
                            b.onClicked(c.a);
                            return;

                        case 7: // '\007'
                            b.onError(c.a, FlurryAdErrorType.CLICK, a.c.a());
                            return;

                        case 8: // '\b'
                            b.onImpressionLogged(c.a);
                            break;
                        }
                    }

            
            {
                c = FlurryAdNative._cls1.this;
                a = d1;
                b = flurryadnativelistener;
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

    _cls1.b(FlurryAdNative flurryadnative)
    {
        a = flurryadnative;
        super();
    }
}
