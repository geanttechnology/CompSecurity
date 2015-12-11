// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            Thumbnails, TrackCode

public class Show
    implements Serializable
{

    private Thumbnails thumbnails;
    private TrackCode trackcode;

    public Show()
    {
    }

    public Thumbnails getThumbnails()
    {
        return thumbnails;
    }

    public TrackCode getTrackcode()
    {
        return trackcode;
    }
}
