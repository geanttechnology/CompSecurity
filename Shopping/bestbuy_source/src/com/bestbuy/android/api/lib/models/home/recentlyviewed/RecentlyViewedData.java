// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.recentlyviewed;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.recentlyviewed:
//            RecentlyViewedAlsoViewed

public class RecentlyViewedData
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xe7989f7b713fb617L;
    private RecentlyViewedAlsoViewed response;
    private String type;
    private String version;

    public RecentlyViewedData()
    {
    }

    public RecentlyViewedAlsoViewed getResponse()
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

    public void setResponse(RecentlyViewedAlsoViewed recentlyviewedalsoviewed)
    {
        response = recentlyviewedalsoviewed;
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
