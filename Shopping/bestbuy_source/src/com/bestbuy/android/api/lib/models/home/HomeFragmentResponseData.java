// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            HomeScreenData

public class HomeFragmentResponseData
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x5d24e6ed434028f2L;
    private HomeScreenData response;
    private String type;
    private String version;

    public HomeFragmentResponseData()
    {
    }

    public HomeScreenData getResponse()
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

    public void setResponse(HomeScreenData homescreendata)
    {
        response = homescreendata;
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
