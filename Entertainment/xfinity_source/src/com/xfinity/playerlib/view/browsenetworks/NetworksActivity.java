// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworksActivity extends PlayNowFlyinMenuActivity
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browsenetworks/NetworksActivity);

    public NetworksActivity()
    {
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.flyin_networks_browse;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_back_networks;
    }

}
