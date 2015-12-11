// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.xfinity.playerlib.model.videoplay.PlayerConfigurationListener;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            SetupMediaPlayerState, VideoStateController

class this._cls0 extends PlayerConfigurationListener
{

    final SetupMediaPlayerState this$0;

    public void configurationFailed(String s)
    {
        super.configurationFailed(s);
        throw new CimException(s);
    }

    public void configurationLoaded()
    {
        super.configurationLoaded();
        stateController.onConfigurationLoaded();
    }

    ()
    {
        this$0 = SetupMediaPlayerState.this;
        super();
    }
}
