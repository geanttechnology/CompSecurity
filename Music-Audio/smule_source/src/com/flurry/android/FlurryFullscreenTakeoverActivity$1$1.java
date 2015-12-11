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

class a extends hq
{

    final ea a;
    final sh b;

    public void safeRun()
    {
        com.flurry.sdk._cls1._cls1 _lcls1 = a.e;
        switch (a[_lcls1.a()])
        {
        default:
            return;

        case 1: // '\001'
            gd.a(3, FlurryFullscreenTakeoverActivity.a(), (new StringBuilder()).append("RELOAD_ACTIVITY Event was fired for adObject:").append(a.a.d()).append(" for url:").append(a.b).append(" and should Close Ad:").append(a.c).toString());
            FlurryFullscreenTakeoverActivity.a(b.b, new ek(a.a, a.b, a.c, a.d));
            FlurryFullscreenTakeoverActivity.a(b.b, FlurryFullscreenTakeoverActivity.a(b.b).c());
            if (FlurryFullscreenTakeoverActivity.b(b.b) == null)
            {
                gd.b(FlurryFullscreenTakeoverActivity.a(), "Cannot launch Activity. No Ad Controller");
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
            gd.a(FlurryFullscreenTakeoverActivity.a(), "CLOSE_ACTIVITY Event was fired :");
            b.b.finish();
            return;
        }
    }

    ( , ea ea1)
    {
        b = ;
        a = ea1;
        super();
    }

    // Unreferenced inner class com/flurry/android/FlurryFullscreenTakeoverActivity$1

/* anonymous class */
    class FlurryFullscreenTakeoverActivity._cls1
        implements fy
    {

        final FlurryFullscreenTakeoverActivity a;

        public void a(ea ea1)
        {
            fp.a().a(new FlurryFullscreenTakeoverActivity._cls1._cls1(this, ea1));
        }

        public void notify(fx fx)
        {
            a((ea)fx);
        }

            
            {
                a = flurryfullscreentakeoveractivity;
                super();
            }
    }

}
