// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playnow.config;

import com.google.common.collect.Lists;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.view.flyinmenu.FlyinMenuOptions;
import java.util.ArrayList;
import java.util.List;

public class PlayNowConfiguration extends PlayerConfiguration
{

    public PlayNowConfiguration()
    {
    }

    public List getFlyinMenuOptions()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(Lists.newArrayList(new FlyinMenuOptions[] {
            FlyinMenuOptions.FEATURED, FlyinMenuOptions.TV_SERIES, FlyinMenuOptions.MOVIES, FlyinMenuOptions.LIVE, FlyinMenuOptions.KIDS, FlyinMenuOptions.NETWORKS
        }));
        arraylist.add(Lists.newArrayList(new FlyinMenuOptions[] {
            FlyinMenuOptions.DOWNLOADS, FlyinMenuOptions.HISTORY, FlyinMenuOptions.FAVORITE
        }));
        arraylist.add(Lists.newArrayList(new FlyinMenuOptions[] {
            FlyinMenuOptions.SETTINGS
        }));
        return arraylist;
    }

    public boolean shouldSuppressNetworkLogos()
    {
        return false;
    }
}
