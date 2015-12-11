// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.playbackclient;

import com.amazon.avod.clickstream.PageInfo;
import com.amazon.avod.clickstream.PageInfoSource;
import com.amazon.avod.clickstream.page.ComponentPageInfoHolder;
import com.amazon.avod.playbackclient.activity.ForegroundAwareActivity;
import com.amazon.avod.playbackclient.presenters.SurfaceSwitcher;
import com.amazon.avod.playbackclient.presenters.SurfaceSwitcherProvider;
import com.amazon.mShop.android.platform.app.ProxyActivity;

public class MShopPlaybackActivityProxy extends ProxyActivity
    implements ComponentPageInfoHolder, ForegroundAwareActivity, SurfaceSwitcherProvider
{

    public MShopPlaybackActivityProxy()
    {
    }

    public PageInfo getPageInfo()
    {
        return ((PageInfoSource)getActivityDelegate()).getPageInfo();
    }

    public SurfaceSwitcher getSurfaceSwitcher()
    {
        return ((SurfaceSwitcherProvider)getActivityDelegate()).getSurfaceSwitcher();
    }

    public boolean isActivityInForeground()
    {
        return ((ForegroundAwareActivity)getActivityDelegate()).isActivityInForeground();
    }

    public void resetToMainPage(String s)
    {
        ((ComponentPageInfoHolder)getActivityDelegate()).resetToMainPage(s);
    }

    public void transitionToPage(String s, PageInfo pageinfo)
    {
        ((ComponentPageInfoHolder)getActivityDelegate()).transitionToPage(s, pageinfo);
    }
}
