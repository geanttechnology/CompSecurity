// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads.lib;

import com.mopub.mobileads.MoPubInterstitial;
import com.picsart.studio.ads.h;

// Referenced classes of package com.picsart.studio.ads.lib:
//            AdsFactoryImpl

final class a
    implements h
{

    private MoPubInterstitial a;

    public final boolean a()
    {
        return a.isReady();
    }

    public final void b()
    {
        a.show();
    }

    public final void c()
    {
        a.destroy();
    }

    (MoPubInterstitial mopubinterstitial)
    {
        a = mopubinterstitial;
        super();
    }
}
