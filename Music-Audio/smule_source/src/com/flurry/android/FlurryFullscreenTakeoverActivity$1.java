// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.sdk.ea;
import com.flurry.sdk.ek;
import com.flurry.sdk.fp;
import com.flurry.sdk.fx;
import com.flurry.sdk.fy;
import com.flurry.sdk.gd;
import com.flurry.sdk.hq;
import com.flurry.sdk.r;

// Referenced classes of package com.flurry.android:
//            FlurryFullscreenTakeoverActivity

class a
    implements fy
{

    final FlurryFullscreenTakeoverActivity a;

    public void a(ea ea1)
    {
        fp.a().a(new hq(ea1) {

            final ea a;
            final FlurryFullscreenTakeoverActivity._cls1 b;

            public void safeRun()
            {
                com.flurry.sdk.ea.a a1 = a.e;
                switch (FlurryFullscreenTakeoverActivity._cls3.a[a1.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    gd.a(3, FlurryFullscreenTakeoverActivity.a(), (new StringBuilder()).append("RELOAD_ACTIVITY Event was fired for adObject:").append(a.a.d()).append(" for url:").append(a.b).append(" and should Close Ad:").append(a.c).toString());
                    FlurryFullscreenTakeoverActivity.a(b.a, new ek(a.a, a.b, a.c, a.d));
                    FlurryFullscreenTakeoverActivity.a(b.a, FlurryFullscreenTakeoverActivity.a(b.a).c());
                    if (FlurryFullscreenTakeoverActivity.b(b.a) == null)
                    {
                        gd.b(FlurryFullscreenTakeoverActivity.a(), "Cannot launch Activity. No Ad Controller");
                        b.a.finish();
                        return;
                    } else
                    {
                        FlurryFullscreenTakeoverActivity.c(b.a);
                        FlurryFullscreenTakeoverActivity.d(b.a);
                        FlurryFullscreenTakeoverActivity.a(b.a, true);
                        FlurryFullscreenTakeoverActivity.e(b.a);
                        return;
                    }

                case 2: // '\002'
                    gd.a(FlurryFullscreenTakeoverActivity.a(), "CLOSE_ACTIVITY Event was fired :");
                    b.a.finish();
                    return;
                }
            }

            
            {
                b = FlurryFullscreenTakeoverActivity._cls1.this;
                a = ea1;
                super();
            }
        });
    }

    public void notify(fx fx)
    {
        a((ea)fx);
    }

    _cls1.a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        a = flurryfullscreentakeoveractivity;
        super();
    }
}
