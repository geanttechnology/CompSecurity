// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.sdk.go;
import com.flurry.sdk.gy;
import com.flurry.sdk.jo;
import com.flurry.sdk.jw;
import com.flurry.sdk.jx;
import com.flurry.sdk.kc;
import com.flurry.sdk.lr;
import com.flurry.sdk.s;

// Referenced classes of package com.flurry.android:
//            FlurryFullscreenTakeoverActivity

class a
    implements jx
{

    final FlurryFullscreenTakeoverActivity a;

    public void a(go go1)
    {
        jo.a().a(new lr(go1) {

            final go a;
            final FlurryFullscreenTakeoverActivity._cls1 b;

            public void a()
            {
                com.flurry.sdk.go.a a1 = a.e;
                switch (FlurryFullscreenTakeoverActivity._cls3.a[a1.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    kc.a(3, FlurryFullscreenTakeoverActivity.a(), (new StringBuilder("RELOAD_ACTIVITY Event was fired for adObject:")).append(a.a.e()).append(" for url:").append(a.b).append(" and should Close Ad:").append(a.c).toString());
                    FlurryFullscreenTakeoverActivity.a(b.a, new gy(a.a, a.b, a.c, a.d));
                    FlurryFullscreenTakeoverActivity.a(b.a, FlurryFullscreenTakeoverActivity.a(b.a).c());
                    if (FlurryFullscreenTakeoverActivity.b(b.a) == null)
                    {
                        kc.b(FlurryFullscreenTakeoverActivity.a(), "Cannot launch Activity. No Ad Controller");
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
                    kc.a(FlurryFullscreenTakeoverActivity.a(), "CLOSE_ACTIVITY Event was fired :");
                    b.a.finish();
                    return;
                }
            }

            
            {
                b = FlurryFullscreenTakeoverActivity._cls1.this;
                a = go1;
                super();
            }
        });
    }

    public volatile void a(jw jw)
    {
        a((go)jw);
    }

    _cls1.a(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        a = flurryfullscreentakeoveractivity;
        super();
    }
}
