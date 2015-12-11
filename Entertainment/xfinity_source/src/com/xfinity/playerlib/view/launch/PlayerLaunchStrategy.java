// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.launch;

import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.xfinity.playerlib.view.featured.FeaturedActivity;

public class PlayerLaunchStrategy extends LaunchStrategy
{

    public PlayerLaunchStrategy()
    {
    }

    public Class getDefaultActivityClass()
    {
        return com/xfinity/playerlib/view/featured/FeaturedActivity;
    }
}
