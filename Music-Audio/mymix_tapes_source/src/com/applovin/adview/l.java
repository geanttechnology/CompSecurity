// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.media.MediaPlayer;
import android.os.Handler;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity, m

class l
    implements android.media.MediaPlayer.OnErrorListener
{

    final AppLovinInterstitialActivity a;

    l(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        AppLovinInterstitialActivity.e(a).post(new m(this, i, j));
        return true;
    }
}
