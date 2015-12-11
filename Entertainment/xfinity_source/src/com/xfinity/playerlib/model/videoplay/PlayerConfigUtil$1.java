// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.model.videoplay:
//            PlayerConfigurationListener, PlayerConfigUtil

class Listener extends PlayerConfigurationListener
{

    final PlayerConfigUtil this$0;
    final CountDownLatch val$waitForConfig;

    public void configurationFailed(String s)
    {
        super.configurationFailed(s);
        PlayerConfigUtil.access$000().error("configurationFailed: {}", s);
        val$waitForConfig.countDown();
    }

    public void configurationLoaded()
    {
        super.configurationLoaded();
        val$waitForConfig.countDown();
    }

    Listener()
    {
        this$0 = final_playerconfigutil;
        val$waitForConfig = CountDownLatch.this;
        super();
    }
}
