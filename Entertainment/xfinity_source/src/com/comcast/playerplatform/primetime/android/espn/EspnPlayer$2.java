// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.espn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.comcast.playerplatform.primetime.android.espn:
//            EspnPlayer

class val.waitForConfig extends BroadcastReceiver
{

    final EspnPlayer this$0;
    final CountDownLatch val$waitForConfig;

    public void onReceive(Context context, Intent intent)
    {
        val$waitForConfig.countDown();
        context.unregisterReceiver(this);
    }

    ()
    {
        this$0 = final_espnplayer;
        val$waitForConfig = CountDownLatch.this;
        super();
    }
}
