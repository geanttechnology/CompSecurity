// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;


public class AssetInfo
{
    public static class Builder
    {

        private String assetId;
        private String channel;
        private String episode;
        private String mediaGuid;
        private String mediaId;
        private String moneyTraceId;
        private String namespace;
        private String program;
        private String providerId;
        private String recordingId;
        private String streamId;
        private String tId;

        public AssetInfo build()
        {
            return new AssetInfo(this);
        }

        public Builder withMediaId(String s)
        {
            mediaId = s;
            return this;
        }

        public Builder withStreamId(String s)
        {
            streamId = s;
            return this;
        }

        public Builder withTid(String s)
        {
            tId = s;
            return this;
        }













        public Builder()
        {
        }
    }


    private String assetId;
    private String channel;
    private String episode;
    private String mediaGuid;
    private String mediaId;
    private String moneyTraceId;
    private String namespace;
    private String program;
    private String providerId;
    private String recordingId;
    private String streamId;
    private String tId;

    private AssetInfo(Builder builder)
    {
        assetId = builder.assetId;
        providerId = builder.providerId;
        recordingId = builder.recordingId;
        streamId = builder.streamId;
        moneyTraceId = builder.moneyTraceId;
        namespace = builder.namespace;
        program = builder.program;
        episode = builder.episode;
        channel = builder.channel;
        mediaId = builder.mediaId;
        moneyTraceId = builder.moneyTraceId;
        tId = builder.tId;
        mediaGuid = builder.mediaGuid;
    }


    public String getAssetId()
    {
        return assetId;
    }

    public String getChannel()
    {
        return channel;
    }

    public String getEpisode()
    {
        return episode;
    }

    public String getMediaGuid()
    {
        return mediaGuid;
    }

    public String getMediaId()
    {
        return mediaId;
    }

    public String getMoneyTraceId()
    {
        return moneyTraceId;
    }

    public String getNamespace()
    {
        return namespace;
    }

    public String getProgram()
    {
        return program;
    }

    public String getProviderId()
    {
        return providerId;
    }

    public String getRecordingId()
    {
        return recordingId;
    }

    public String getStreamId()
    {
        return streamId;
    }

    public String gettId()
    {
        return tId;
    }
}
