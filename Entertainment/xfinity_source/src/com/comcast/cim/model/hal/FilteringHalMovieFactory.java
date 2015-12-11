// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.hal;

import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;

// Referenced classes of package com.comcast.cim.model.hal:
//            HalMovieFactory, HalVideoFilter

public class FilteringHalMovieFactory extends HalMovieFactory
{

    private final HalVideoFilter videoFilter;

    public volatile HalParseable createWithUrl(String s, HalHttpClient halhttpclient)
    {
        return createWithUrl(s, halhttpclient);
    }

    public HalMovieConsumable createWithUrl(String s, HalHttpClient halhttpclient)
    {
        s = (HalMovieConsumable)super.createWithUrl(s, halhttpclient);
        s.setVideos(videoFilter.filter(s.getVideos()));
        return s;
    }
}
