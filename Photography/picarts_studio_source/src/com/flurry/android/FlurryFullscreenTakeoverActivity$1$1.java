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

class a extends lr
{

    final go a;
    final sh b;

    public void a()
    {
        com.flurry.sdk._cls1._cls1 _lcls1 = a.e;
        switch (a[_lcls1.a()])
        {
        default:
            return;

        case 1: // '\001'
            kc.a(3, FlurryFullscreenTakeoverActivity.a(), (new StringBuilder("RELOAD_ACTIVITY Event was fired for adObject:")).append(a.a.e()).append(" for url:").append(a.b).append(" and should Close Ad:").append(a.c).toString());
            FlurryFullscreenTakeoverActivity.a(b.b, new gy(a.a, a.b, a.c, a.d));
            FlurryFullscreenTakeoverActivity.a(b.b, FlurryFullscreenTakeoverActivity.a(b.b).c());
            if (FlurryFullscreenTakeoverActivity.b(b.b) == null)
            {
                kc.b(FlurryFullscreenTakeoverActivity.a(), "Cannot launch Activity. No Ad Controller");
                b.b.finish();
                return;
            } else
            {
                FlurryFullscreenTakeoverActivity.c(b.b);
                FlurryFullscreenTakeoverActivity.d(b.b);
                FlurryFullscreenTakeoverActivity.a(b.b, true);
                FlurryFullscreenTakeoverActivity.e(b.b);
                return;
            }

        case 2: // '\002'
            kc.a(FlurryFullscreenTakeoverActivity.a(), "CLOSE_ACTIVITY Event was fired :");
            b.b.finish();
            return;
        }
    }

    ( , go go1)
    {
        b = ;
        a = go1;
        super();
    }

    // Unreferenced inner class com/flurry/android/FlurryFullscreenTakeoverActivity$1

/* anonymous class */
    class FlurryFullscreenTakeoverActivity._cls1
        implements jx
    {

        final FlurryFullscreenTakeoverActivity a;

        public void a(go go1)
        {
            jo.a().a(new FlurryFullscreenTakeoverActivity._cls1._cls1(this, go1));
        }

        public volatile void a(jw jw)
        {
            a((go)jw);
        }

            
            {
                a = flurryfullscreentakeoveractivity;
                super();
            }
    }

}
