// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.asset;


// Referenced classes of package com.comcast.playerplatform.primetime.android.asset:
//            AssetInfo

public static class 
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
        return new AssetInfo(this, null);
    }

    public  withMediaId(String s)
    {
        mediaId = s;
        return this;
    }

    public mediaId withStreamId(String s)
    {
        streamId = s;
        return this;
    }

    public streamId withTid(String s)
    {
        tId = s;
        return this;
    }













    public ()
    {
    }
}
