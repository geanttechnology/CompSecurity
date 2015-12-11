// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay;

import android.content.Context;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.model.videoplay:
//            PlayerConfigurationListener, PlayerConfigUtil

class Listener extends PlayerConfigurationListener
{

    final PlayerConfigUtil this$0;
    final Context val$context;

    public void configurationFailed(String s)
    {
        super.configurationFailed(s);
        PlayerConfigUtil.access$000().error("configurationFailed: {}", s);
    }

    public void configurationLoaded()
    {
        super.configurationLoaded();
        if (!ConfigurationManager.getInstance().isEspnReady())
        {
            ConfigurationManager.getInstance().initializeESPN(val$context, false);
        }
    }

    ger()
    {
        this$0 = final_playerconfigutil;
        val$context = Context.this;
        super();
    }
}
