// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.sdk.gy;
import com.flurry.sdk.kc;

// Referenced classes of package com.flurry.android:
//            FlurryFullscreenTakeoverActivity

class a
    implements com.flurry.sdk.y._cls2
{

    final FlurryFullscreenTakeoverActivity a;

    public void a()
    {
        kc.a(FlurryFullscreenTakeoverActivity.a(), "onViewBack");
        if (FlurryFullscreenTakeoverActivity.a(a) != null && FlurryFullscreenTakeoverActivity.a(a).b())
        {
            FlurryFullscreenTakeoverActivity.d(a);
            a.finish();
            return;
        } else
        {
            a.removeViewState();
            a.loadViewState();
            FlurryFullscreenTakeoverActivity.a(a, true);
            FlurryFullscreenTakeoverActivity.e(a);
            return;
        }
    }

    public void b()
    {
        kc.a(FlurryFullscreenTakeoverActivity.a(), "onViewClose");
        FlurryFullscreenTakeoverActivity.d(a);
        a.finish();
    }

    public void c()
    {
        kc.a(FlurryFullscreenTakeoverActivity.a(), "onViewError");
        FlurryFullscreenTakeoverActivity.d(a);
        a.finish();
    }

    (FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        a = flurryfullscreentakeoveractivity;
        super();
    }
}
