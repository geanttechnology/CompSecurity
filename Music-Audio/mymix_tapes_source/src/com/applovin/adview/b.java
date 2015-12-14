// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.media.MediaPlayer;
import com.applovin.impl.adview.AppLovinVideoView;
import java.lang.ref.WeakReference;
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
        AppLovinInterstitialActivity.a(a, new WeakReference(mediaplayer));
        int i;
        int j;
        if (AppLovinInterstitialActivity.a(a))
        {
            i = 0;
        } else
        {
            i = 1;
        }
        mediaplayer.setVolume(i, i);
        i = mediaplayer.getVideoWidth();
        j = mediaplayer.getVideoHeight();
        AppLovinInterstitialActivity.a(a, (int)TimeUnit.MILLISECONDS.toSeconds(mediaplayer.getDuration()));
        AppLovinInterstitialActivity.b(a).setVideoSize(i, j);
        mediaplayer.setDisplay(AppLovinInterstitialActivity.b(a).getHolder());
        mediaplayer.setOnErrorListener(new c(this));
        AppLovinInterstitialActivity.f(a);
        AppLovinInterstitialActivity.g(a);
        AppLovinInterstitialActivity.h(a);
        AppLovinInterstitialActivity.i(a);
    }
}
