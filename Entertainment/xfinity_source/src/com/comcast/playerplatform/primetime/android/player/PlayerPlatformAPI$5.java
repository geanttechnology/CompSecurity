// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            PlayerPlatformAPI, Player

class this._cls0
    implements com.comcast.playerplatform.util.android.ener
{

    final PlayerPlatformAPI this$0;

    public void onTick(String s)
    {
        if (PlayerPlatformAPI.access$100(PlayerPlatformAPI.this) != null && PlayerPlatformAPI.access$100(PlayerPlatformAPI.this).getPlayerStatus() == PlayerStatus.PLAYING)
        {
            requestMediaProgress();
            PlayerPlatformAPI.access$2000(PlayerPlatformAPI.this);
        }
    }

    ()
    {
        this$0 = PlayerPlatformAPI.this;
        super();
    }
}
