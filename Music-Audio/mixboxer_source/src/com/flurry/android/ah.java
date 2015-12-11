// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.millennialmedia.android.MMInterstitial;

// Referenced classes of package com.flurry.android:
//            do, gh, FlurryAds, cw, 
//            AdUnit

final class ah extends do
{

    private static final String p = com/flurry/android/ah.getSimpleName();
    private boolean bZ;
    MMInterstitial ca;
    private final String q;

    public ah(Context context, FlurryAds flurryads, cw cw, AdUnit adunit, Bundle bundle)
    {
        super(context, flurryads, cw, adunit);
        q = bundle.getString("com.flurry.millennial.MYAPIDINTERSTITIAL");
    }

    static boolean a(ah ah1)
    {
        return ah1.bZ;
    }

    static String d()
    {
        return p;
    }

    public final void M()
    {
        ca = new MMInterstitial((Activity)getContext());
        ca.setApid(q);
        gh gh1 = new gh(this);
        ca.setListener(gh1);
        ca.fetch();
        bZ = ca.display();
        if (bZ)
        {
            Log.d(p, (new StringBuilder()).append("Millennial MMAdView Interstitial ad displayed immediately:").append(System.currentTimeMillis()).append(" ").append(bZ).toString());
            return;
        } else
        {
            Log.d(p, (new StringBuilder()).append("Millennial MMAdView Interstitial ad did not display immediately:").append(System.currentTimeMillis()).append(" ").append(bZ).toString());
            return;
        }
    }

}
