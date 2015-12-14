// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads.lib;

import android.util.Log;
import com.google.android.gms.ads.InterstitialAd;
import com.picsart.studio.ads.h;

// Referenced classes of package com.picsart.studio.ads.lib:
//            AdsFactoryImpl

final class a
    implements h
{

    private InterstitialAd a;

    public final boolean a()
    {
        Log.i("ads-AdMob", " AdMob ad initialized");
        return a.isLoaded();
    }

    public final void b()
    {
        a.show();
    }

    public final void c()
    {
    }

    (InterstitialAd interstitialad)
    {
        a = interstitialad;
        super();
    }
}
