// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            AdCollection, Channel, ResponseMessage, Video

public class PlayManifest
{

    private AdCollection adlist;
    private Channel channel;
    private ResponseMessage entitlmentResponse;
    private Video video;

    public PlayManifest()
    {
        entitlmentResponse = null;
        adlist = null;
        video = null;
        channel = null;
    }

    public AdCollection getAdCollection()
    {
        return adlist;
    }

    public Channel getChannel()
    {
        return channel;
    }

    public ResponseMessage getEntitlmentResponse()
    {
        return entitlmentResponse;
    }

    public Video getVideo()
    {
        return video;
    }
}
