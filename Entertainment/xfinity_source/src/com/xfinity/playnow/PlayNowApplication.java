// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playnow;

import com.xfinity.playerlib.PlayerApplication;

// Referenced classes of package com.xfinity.playnow:
//            PlayNowContainer

public class PlayNowApplication extends PlayerApplication
{

    public PlayNowApplication()
    {
    }

    public void initializeContainer(PlayerApplication playerapplication)
    {
        PlayNowContainer.initialize(this);
    }
}
