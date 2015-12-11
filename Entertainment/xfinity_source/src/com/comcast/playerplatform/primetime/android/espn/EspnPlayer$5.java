// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.espn;

import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;
import com.espn.androidplayersdk.datamanager.EPPlaybackManager;

// Referenced classes of package com.comcast.playerplatform.primetime.android.espn:
//            EspnPlayer

class this._cls0
    implements Runnable
{

    final EspnPlayer this$0;

    public void run()
    {
        String s = EspnPlayer.access$100(EspnPlayer.this).getDisneyEspnTokenDelegate().onTokenExpired(EspnPlayer.access$100(EspnPlayer.this).getChannelName(), EspnPlayer.access$100(EspnPlayer.this).getDrmKey());
        EspnPlayer.access$100(EspnPlayer.this).setDrmKey(s);
        EspnPlayer.access$200(EspnPlayer.this).updateAffiliateToken(s);
    }

    okenDelegate()
    {
        this$0 = EspnPlayer.this;
        super();
    }
}
