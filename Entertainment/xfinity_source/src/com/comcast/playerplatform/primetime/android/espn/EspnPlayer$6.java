// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.espn;

import com.comcast.playerplatform.primetime.android.player.Player;

// Referenced classes of package com.comcast.playerplatform.primetime.android.espn:
//            EspnPlayer

class this._cls0
    implements Runnable
{

    final EspnPlayer this$0;

    public void run()
    {
        EspnPlayer.access$700(EspnPlayer.this).setAsset(EspnPlayer.access$100(EspnPlayer.this), -1L, null);
    }

    ()
    {
        this$0 = EspnPlayer.this;
        super();
    }
}
