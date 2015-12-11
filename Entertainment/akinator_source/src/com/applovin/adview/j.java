// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.media.MediaPlayer;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class j
    implements android.media.MediaPlayer.OnCompletionListener
{

    final AppLovinInterstitialActivity a;

    j(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        AppLovinInterstitialActivity.a(a, true);
        AppLovinInterstitialActivity.h(a);
    }
}
