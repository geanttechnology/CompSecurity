// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk;

import com.supersonic.mediationsdk.sdk.RewardedVideoManagerListener;
import java.util.TimerTask;

// Referenced classes of package com.supersonic.mediationsdk:
//            AbstractAdapter

class anagerListener extends TimerTask
{

    final AbstractAdapter this$0;
    final RewardedVideoManagerListener val$listener;

    public void run()
    {
        val$listener.onVideoAvailabilityChanged(false, AbstractAdapter.this);
    }

    anagerListener()
    {
        this$0 = final_abstractadapter;
        val$listener = RewardedVideoManagerListener.this;
        super();
    }
}
