// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay;

import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.comcast.playerplatform.util.android.IConfigurationEventListener;

public class PlayerConfigurationListener
    implements IConfigurationEventListener
{

    public PlayerConfigurationListener()
    {
    }

    public void configurationFailed(String s)
    {
        ConfigurationManager.getInstance().removeListener(this);
    }

    public void configurationLoaded()
    {
        ConfigurationManager.getInstance().removeListener(this);
    }
}
