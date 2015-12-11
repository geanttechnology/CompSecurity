// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.comcast.cim.cmasl.utils.initializer.Initializer;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements Initializer
{

    final PlayerContainer this$0;

    public void initialize(PlayerUserSettings playerusersettings)
    {
        playerusersettings.setFilterFactory(getDibicProgramFilterFactory());
    }

    public volatile void initialize(Object obj)
    {
        initialize((PlayerUserSettings)obj);
    }

    ettings()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
