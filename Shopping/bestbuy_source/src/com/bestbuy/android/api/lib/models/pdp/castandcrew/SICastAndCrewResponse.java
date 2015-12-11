// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.castandcrew;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.castandcrew:
//            CastAndCrewResponse

public class SICastAndCrewResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private CastAndCrewResponse response;
    private String type;
    private String version;

    public SICastAndCrewResponse()
    {
    }

    public CastAndCrewResponse getCastAndCrewResponse()
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

    public void setCastAndCrewResponse(CastAndCrewResponse castandcrewresponse)
    {
        response = castandcrewresponse;
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
