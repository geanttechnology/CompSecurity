// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.episodes;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.episodes:
//            PDPEpisodesResponseChild

public class PDPEpisodesResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private PDPEpisodesResponseChild response;
    private String type;
    private String version;

    public PDPEpisodesResponse()
    {
    }

    public PDPEpisodesResponseChild getResponse()
    {
        return response;
    }

    public String getType()
    {
        return type;
    }

    public String getVersion()
    {
        return version;
    }

    public void setResponse(PDPEpisodesResponseChild pdpepisodesresponsechild)
    {
        response = pdpepisodesresponsechild;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setVersion(String s)
    {
        version = s;
    }
}
