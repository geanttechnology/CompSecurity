// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            Analytics, Info

public class AdAsset
    implements Serializable
{

    private boolean affiliate;
    private Analytics analytics;
    private String asset;
    private String duration;
    private float end;
    private String format;
    private Info info;
    private String playthrough;
    private float start;
    private String type;

    public AdAsset()
    {
        asset = "";
        format = "";
        duration = null;
        type = null;
        playthrough = "true";
        analytics = null;
        info = null;
        affiliate = false;
    }

    public String getDuration()
    {
        return duration;
    }

    public float getEnd()
    {
        return end;
    }

    public float getStart()
    {
        return start;
    }
}
