// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.recentlyviewed;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.recentlyviewed:
//            RecentlyViewedData

public class RecentlyViewedAlsoViewedResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x258866ef9d27ad3bL;
    private RecentlyViewedData si;

    public RecentlyViewedAlsoViewedResponse()
    {
    }

    public RecentlyViewedData getSi()
    {
        return si;
    }

    public void setSi(RecentlyViewedData recentlyvieweddata)
    {
        si = recentlyvieweddata;
    }
}
