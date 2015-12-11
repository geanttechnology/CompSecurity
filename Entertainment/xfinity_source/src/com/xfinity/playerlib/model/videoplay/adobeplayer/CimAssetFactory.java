// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.asset.CimLinearAsset;
import com.comcast.playerplatform.primetime.android.asset.CimVodAsset;
import com.comcast.playerplatform.primetime.android.asset.DisneyAsset;
import com.comcast.playerplatform.primetime.android.asset.ESPNAsset;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;
import com.xfinity.playerlib.downloads.TitaniumTicket;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CimAssetFactory
{

    private final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory);

    public CimAssetFactory()
    {
    }

    public Asset create(HalLiveStream hallivestream, String s, String s1, String s2, DisneyEspnTokenDelegate disneyespntokendelegate)
    {
        if (hallivestream.isEspn())
        {
            return new ESPNAsset(s, s1, s2, disneyespntokendelegate);
        } else
        {
            LOG.debug("Error creating ESPN live event asset. Everything we know is wrong.");
            return null;
        }
    }

    public Asset create(String s, TitaniumTicket titaniumticket, VideoFacade videofacade, DrmWorkflow drmworkflow)
    {
        return new CimVodAsset(s, titaniumticket.getKey(), true, drmworkflow, videofacade.getPid(), Long.toString(videofacade.getVideoId()));
    }

    public Asset create(String s, String s1, DrmWorkflow drmworkflow, String s2)
    {
        return new CimLinearAsset(s, s1, true, drmworkflow, s2);
    }

    public Asset create(String s, String s1, DisneyEspnTokenDelegate disneyespntokendelegate)
    {
        return new ESPNAsset(s, s1, disneyespntokendelegate);
    }

    public Asset create(String s, String s1, VideoFacade videofacade, DrmWorkflow drmworkflow)
    {
        return new CimVodAsset(s, s1, true, drmworkflow, videofacade.getPid(), Long.toString(videofacade.getVideoId()));
    }

    public Asset create(String s, String s1, String s2, DisneyEspnTokenDelegate disneyespntokendelegate, Activity activity)
    {
        return new DisneyAsset(s, s1, s2, disneyespntokendelegate, activity);
    }
}
