// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.view.View;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class t
    implements android.view.View.OnClickListener
{

    final AppLovinInterstitialActivity a;

    t(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void onClick(View view)
    {
        AppLovinInterstitialActivity.q(a);
    }
}
