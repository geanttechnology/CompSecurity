// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.media.MediaPlayer;
import android.os.Handler;

// Referenced classes of package com.applovin.adview:
//            b, AppLovinInterstitialActivity, d

class c
    implements android.media.MediaPlayer.OnErrorListener
{

    final b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        AppLovinInterstitialActivity.e(a.a).post(new d(this, i, j));
        return true;
    }
}
