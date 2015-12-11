// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public class VPChannel extends VPMedia
{

    private static VPMedia.MediaType MEDIA_TYPE;

    public VPChannel()
    {
    }

    public VPMedia.MediaType getMediaType()
    {
        return MEDIA_TYPE;
    }

    static 
    {
        MEDIA_TYPE = VPMedia.MediaType.LIVE;
    }
}
