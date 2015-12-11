// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import com.groupon.Channel;
import com.groupon.provider.FragmentProvider;

public class CarouselPage
{

    private final Channel channel;
    private final FragmentProvider fragmentProvider;
    private String title;

    public CarouselPage(Channel channel1, FragmentProvider fragmentprovider, String s)
    {
        channel = channel1;
        fragmentProvider = fragmentprovider;
        title = s;
    }

    public Channel getChannel()
    {
        return channel;
    }

    public FragmentProvider getFragmentProvider()
    {
        return fragmentProvider;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
