// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.flurry.android:
//            ae, FlurryFullscreenTakeoverActivity, AdUnit, FlurryAds, 
//            cy, cw

final class ag extends ae
{

    public ag(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        super(context, flurryads, cw, adunit);
    }

    public final void M()
    {
        Intent intent = new Intent(getContext(), com/flurry/android/FlurryFullscreenTakeoverActivity);
        if (!J().a(getContext(), intent, L().getAdSpace().toString()))
        {
            cy.d(p, "Unable to launch FlurryFullscreenTakeoverActivity. Fix by declaring this Activity in your AndroidManifest.xml");
        }
    }
}
