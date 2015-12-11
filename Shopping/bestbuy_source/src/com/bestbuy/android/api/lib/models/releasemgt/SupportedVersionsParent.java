// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.releasemgt;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.releasemgt:
//            SupportedVserionsData

public class SupportedVersionsParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xf9436b2b9ab4f09L;
    private SupportedVserionsData response;
    private String type;
    private String version;

    public SupportedVersionsParent()
    {
    }

    public SupportedVserionsData getResponse()
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

    public void setResponse(SupportedVserionsData supportedvserionsdata)
    {
        response = supportedvserionsdata;
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
