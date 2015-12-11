// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.primetime.android.analytics.AnalyticsAssetUtil;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;
import com.comcast.playerplatform.util.android.MoneyTrace;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            AssetInfo, AdData

public class Asset
{
    public static final class AssetType extends Enum
    {

        private static final AssetType $VALUES[];
        public static final AssetType DISNEY;
        public static final AssetType ESPN;
        public static final AssetType PRIMETIME;

        public static AssetType valueOf(String s)
        {
            return (AssetType)Enum.valueOf(com/comcast/playerplatform/primetime/android/asset/Asset$AssetType, s);
        }

        public static AssetType[] values()
        {
            return (AssetType[])$VALUES.clone();
        }

        static 
        {
            PRIMETIME = new AssetType("PRIMETIME", 0);
            ESPN = new AssetType("ESPN", 1);
            DISNEY = new AssetType("DISNEY", 2);
            $VALUES = (new AssetType[] {
                PRIMETIME, ESPN, DISNEY
            });
        }

        private AssetType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Builder
    {

        private AdData adData;
        private AssetInfo assetInfo;
        private String channelName;
        private DisneyEspnTokenDelegate disneyEspnTokenDelegate;
        private String drmKey;
        private DrmWorkflow drmWorkflow;
        private String eventId;
        private String manifestUrl;
        private MoneyTrace moneyTrace;
        private String networkId;
        private AssetType playerType;
        private long resumePoint;
        private StreamType streamType;

        public Builder asStreamType(StreamType streamtype)
        {
            streamType = streamtype;
            return this;
        }

        public Builder forDisney(String s, String s1)
        {
            channelName = s;
            networkId = s1;
            playerType = AssetType.DISNEY;
            return this;
        }

        public Builder forEspn(String s, String s1)
        {
            channelName = s;
            eventId = s1;
            playerType = AssetType.ESPN;
            return this;
        }

        public Builder withAssetInfo(AssetInfo assetinfo)
        {
            assetInfo = assetinfo;
            return this;
        }

        public Builder withCustomDRMKey(String s)
        {
            drmKey = s;
            return this;
        }

        public Builder withDisneyEspnTokenDelegate(DisneyEspnTokenDelegate disneyespntokendelegate)
        {
            disneyEspnTokenDelegate = disneyespntokendelegate;
            return this;
        }

        public Builder withDrmWorkflow(DrmWorkflow drmworkflow)
        {
            drmWorkflow = drmworkflow;
            return this;
        }

        public Builder withManifest(String s)
        {
            manifestUrl = s;
            return this;
        }














        public Builder()
        {
            resumePoint = 0L;
            streamType = StreamType.VOD;
            playerType = AssetType.PRIMETIME;
            drmWorkflow = DrmWorkflow.STREAMING;
        }
    }


    private AdData adData;
    private AssetInfo assetInfo;
    public String authCookieName;
    public String authCookieValue;
    private String channelName;
    private DisneyEspnTokenDelegate disneyEspnTokenDelegate;
    private String drmKey;
    private DrmWorkflow drmWorkflow;
    private String eventId;
    public String manifestUri;
    private MoneyTrace moneyTrace;
    private String networkId;
    private long resumePoint;
    private StreamType streamType;
    private AssetType type;

    public Asset(Builder builder)
    {
        type = AssetType.PRIMETIME;
        manifestUri = builder.manifestUrl;
        drmKey = builder.drmKey;
        drmWorkflow = builder.drmWorkflow;
        channelName = builder.channelName;
        networkId = builder.networkId;
        eventId = builder.eventId;
        disneyEspnTokenDelegate = builder.disneyEspnTokenDelegate;
        resumePoint = builder.resumePoint;
        assetInfo = builder.assetInfo;
        adData = builder.adData;
        moneyTrace = builder.moneyTrace;
        type = builder.playerType;
        streamType = builder.streamType;
    }

    public AbstractXuaAsset buildXuaAsset()
    {
        return AnalyticsAssetUtil.convertPlayerAssetToXuaAsset(this);
    }

    public AdData getAdData()
    {
        return adData;
    }

    public AssetInfo getAssetInfo()
    {
        return assetInfo;
    }

    public Map getAssetOptionsAsDictionary()
    {
        Hashtable hashtable = new Hashtable();
        AssetInfo assetinfo = getAssetInfo();
        if (assetinfo != null)
        {
            if (assetinfo.getAssetId() != null)
            {
                hashtable.put("assetId", assetinfo.getAssetId());
            }
            if (assetinfo.getProviderId() != null)
            {
                hashtable.put("providerId", assetinfo.getProviderId());
            }
            if (assetinfo.getMediaId() != null)
            {
                hashtable.put("mediaID", assetinfo.getMediaId());
            }
            if (assetinfo.gettId() != null)
            {
                hashtable.put("tPID", assetinfo.gettId());
            }
            if (assetinfo.getRecordingId() != null)
            {
                hashtable.put("recordingID", assetinfo.getRecordingId());
            }
            if (assetinfo.getStreamId() != null)
            {
                hashtable.put("streamId", assetinfo.getStreamId());
            }
            if (assetinfo.getMediaGuid() != null)
            {
                hashtable.put("MediaGUID", assetinfo.getMediaGuid());
            }
        }
        if (getDrmKey() != null)
        {
            hashtable.put("drmKey", getDrmKey());
        }
        if (getDrmWorkflow() != null)
        {
            hashtable.put("drmWorkflow", getDrmWorkflow().name());
        }
        return hashtable;
    }

    public String getChannelName()
    {
        return channelName;
    }

    public DisneyEspnTokenDelegate getDisneyEspnTokenDelegate()
    {
        return disneyEspnTokenDelegate;
    }

    public String getDrmKey()
    {
        return drmKey;
    }

    public DrmWorkflow getDrmWorkflow()
    {
        return drmWorkflow;
    }

    public String getEventId()
    {
        return eventId;
    }

    public Map getIdMap()
    {
        HashMap hashmap = new HashMap();
        AssetInfo assetinfo = getAssetInfo();
        if (assetinfo != null)
        {
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
                hashmap.put("mediaID", assetinfo.getMediaId());
            }
            if (assetinfo.gettId() != null)
            {
                hashmap.put("tPID", assetinfo.gettId());
            }
            if (assetinfo.getRecordingId() != null)
            {
                hashmap.put("recordingID", assetinfo.getRecordingId());
            }
            if (assetinfo.getStreamId() != null)
            {
                hashmap.put("streamId", assetinfo.getStreamId());
            }
            if (assetinfo.getMediaGuid() != null)
            {
                hashmap.put("MediaGUID", assetinfo.getMediaGuid());
            }
        }
        return hashmap;
    }

    public String getManifestUri()
    {
        return manifestUri;
    }

    public MoneyTrace getMoneyTrace()
    {
        return moneyTrace;
    }

    public MoneyTrace getMoneyTraceId()
    {
        return moneyTrace;
    }

    public String getNetworkId()
    {
        return networkId;
    }

    public long getResumePoint()
    {
        return resumePoint;
    }

    public StreamType getStreamType()
    {
        return streamType;
    }

    public AssetType getType()
    {
        return type;
    }

    public void setChannelName(String s)
    {
        channelName = s;
    }

    public void setDrmKey(String s)
    {
        drmKey = s;
    }

    public void setDrmWorkflow(DrmWorkflow drmworkflow)
    {
        drmWorkflow = drmworkflow;
    }

    public void setEventId(String s)
    {
        eventId = s;
    }

    public void setManifestUri(String s)
    {
        manifestUri = s;
    }

    public void setMoneytraceId(String s)
    {
        moneyTrace = new MoneyTrace(s);
    }

    public void setNetworkId(String s)
    {
        networkId = s;
    }
}
