// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements Provider
{

    final PlayerContainer this$0;

    public PlayerUserSettings get()
    {
        return new PlayerUserSettings();
    }

    public volatile Object get()
    {
        return get();
    }

    ettings()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
