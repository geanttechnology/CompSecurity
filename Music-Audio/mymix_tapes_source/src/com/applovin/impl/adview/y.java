// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.app.Activity;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

// Referenced classes of package com.applovin.impl.adview:
//            x, af

class y
    implements AppLovinAdDisplayListener
{

    final af a;
    final x b;

    y(x x1, af af1)
    {
        b = x1;
        a = af1;
        super();
    }

    public void adDisplayed(AppLovinAd applovinad)
    {
        x.d(b);
        if (!x.e(b))
        {
            AppLovinAdDisplayListener applovinaddisplaylistener = a.d();
            if (applovinaddisplaylistener != null)
            {
                applovinaddisplaylistener.adDisplayed(applovinad);
            }
            x.b(b, true);
        }
    }

    public void adHidden(AppLovinAd applovinad)
    {
        x.b(b).runOnUiThread(x.a(b));
        AppLovinAdDisplayListener applovinaddisplaylistener = a.d();
        if (!x.c(b) && applovinaddisplaylistener != null)
        {
            applovinaddisplaylistener.adHidden(applovinad);
            x.a(b, true);
        }
        a.a(false);
    }
}
