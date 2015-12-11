// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.analytics;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.assets.GenericAsset;
import com.comcast.playerplatform.analytics.java.xua.assets.PAIDAsset;
import com.comcast.playerplatform.analytics.java.xua.assets.RecordingAsset;
import com.comcast.playerplatform.analytics.java.xua.assets.StreamingAsset;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.asset.AssetInfo;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.util.android.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsAssetUtil
{

    public AnalyticsAssetUtil()
    {
    }

    public static AbstractXuaAsset convertPlayerAssetToXuaAsset(Asset asset)
    {
        AssetInfo assetinfo;
label0:
        {
            PAIDAsset paidasset = null;
            assetinfo = asset.getAssetInfo();
            if (assetinfo != null)
            {
                if (assetinfo.getProviderId() == null || assetinfo.getAssetId() == null)
                {
                    break label0;
                }
                paidasset = new PAIDAsset(asset.getStreamType().name(), assetinfo.getProviderId(), assetinfo.getAssetId(), assetinfo.getMediaGuid());
            }
            return paidasset;
        }
        if (assetinfo.getRecordingId() != null)
        {
            return new RecordingAsset(assetinfo.getRecordingId());
        }
        if (assetinfo.getStreamId() != null)
        {
            return new StreamingAsset(assetinfo.getStreamId());
        }
        if (assetinfo.getMediaId() != null && assetinfo.gettId() != null)
        {
            asset = new HashMap();
            asset.put("TP_ID", assetinfo.gettId());
            asset.put("MEDIA_ID", assetinfo.getMediaId());
            return new GenericAsset("VOD", "CIM", asset);
        }
        if (assetinfo.getNamespace() != null && assetinfo.getChannel() != null && assetinfo.getEpisode() != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("PROGRAM", assetinfo.getProgram());
            hashmap.put("EPISODE", assetinfo.getEpisode());
            hashmap.put("CHANNEL", assetinfo.getChannel());
            return new GenericAsset(asset.getStreamType().name(), assetinfo.getNamespace(), hashmap);
        }
        String s1 = assetinfo.getNamespace();
        String s = s1;
        if (!StringUtil.isNotNullOrEmpty(s1))
        {
            s = "Unknown";
        }
        return new GenericAsset(asset.getStreamType().name(), s, getIdMap(assetinfo));
    }

    private static Map getIdMap(AssetInfo assetinfo)
    {
        HashMap hashmap = new HashMap();
        if (assetinfo.getAssetId() != null)
        {
            hashmap.put("assetId", assetinfo.getAssetId());
        }
        if (assetinfo.getProviderId() != null)
        {
            hashmap.put("providerId", assetinfo.getProviderId());
        }
        if (assetinfo.getMediaId() != null)
        {
            hashmap.put("mediaId", assetinfo.getMediaId());
        }
        if (assetinfo.gettId() != null)
        {
            hashmap.put("tPID", assetinfo.gettId());
        }
        if (assetinfo.getRecordingId() != null)
        {
            hashmap.put("recordingId", assetinfo.getRecordingId());
        }
        if (assetinfo.getStreamId() != null)
        {
            hashmap.put("streamId", assetinfo.getStreamId());
        }
        return hashmap;
    }
}
