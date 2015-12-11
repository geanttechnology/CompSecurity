// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.asset.Asset;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            PlayerPlatformAPI, Player

class val.adManager
    implements Runnable
{

    final PlayerPlatformAPI this$0;
    final BaseAdManager val$adManager;
    final Asset val$asset;
    final long val$startPosition;

    public void run()
    {
        PlayerPlatformAPI.access$000(PlayerPlatformAPI.this);
        applyPlayerSettings();
        PlayerPlatformAPI.access$100(PlayerPlatformAPI.this).setAsset(val$asset, val$startPosition, val$adManager);
    }

    ()
    {
        this$0 = final_playerplatformapi;
        val$asset = asset1;
        val$startPosition = l;
        val$adManager = BaseAdManager.this;
        super();
    }
}
