// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.media.MediaPlayer;
import com.applovin.impl.adview.AppLovinVideoView;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity, c

class b
    implements android.media.MediaPlayer.OnPreparedListener
{

    final AppLovinInterstitialActivity a;

    b(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        int i = mediaplayer.getVideoWidth();
        int j = mediaplayer.getVideoHeight();
        AppLovinInterstitialActivity.a(a, (int)TimeUnit.MILLISECONDS.toSeconds(mediaplayer.getDuration()));
        AppLovinInterstitialActivity.a(a).setVideoSize(i, j);
        mediaplayer.setDisplay(AppLovinInterstitialActivity.a(a).getHolder());
        mediaplayer.setOnErrorListener(new c(this));
        AppLovinInterstitialActivity.e(a);
        AppLovinInterstitialActivity.f(a);
        AppLovinInterstitialActivity.g(a);
    }
}
