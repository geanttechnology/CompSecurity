// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.espn;

import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.util.android.StringUtil;
import com.espn.androidplayersdk.datamanager.EPPlaybackManager;

// Referenced classes of package com.comcast.playerplatform.primetime.android.espn:
//            EspnPlayer

class this._cls0
    implements Runnable
{

    final EspnPlayer this$0;

    public void run()
    {
        if (EspnPlayer.access$000(EspnPlayer.this))
        {
            EspnPlayer.access$200(EspnPlayer.this).initWithToken(EspnPlayer.access$100(EspnPlayer.this).getDrmKey());
            String s = EspnPlayer.access$100(EspnPlayer.this).getEventId();
            if (StringUtil.isNotNullOrEmpty(s))
            {
                EspnPlayer.access$200(EspnPlayer.this).initiateStartSessionRequest(s);
                return;
            }
            if (EspnPlayer.access$100(EspnPlayer.this).getChannelName().equals("espn3") || EspnPlayer.access$100(EspnPlayer.this).getChannelName().equals("secplus") || EspnPlayer.access$100(EspnPlayer.this).getChannelName().equals("goalline"))
            {
                EspnPlayer.access$300(EspnPlayer.this);
                return;
            } else
            {
                EspnPlayer.access$200(EspnPlayer.this).initiateLiveEventSessionForLinearNetwork(EspnPlayer.access$100(EspnPlayer.this).getChannelName());
                return;
            }
        } else
        {
            sendMediaFailed(String.valueOf(1), "Failed to initialize playback for ESPN.");
            return;
        }
    }

    ()
    {
        this$0 = EspnPlayer.this;
        super();
    }
}
