// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            SiteSpeedData

public class SiteSpeedDataNoOp extends SiteSpeedData
{

    public SiteSpeedDataNoOp(String s, boolean flag, EbayCountry ebaycountry)
    {
        super(s, flag, ebaycountry);
    }

    public void addExtendedData(String s, String s1)
    {
    }

    public void allLoaded()
    {
    }

    public boolean isComplete()
    {
        return false;
    }

    public boolean isReportable()
    {
        return false;
    }

    public void primaryLoaded()
    {
    }

    public void setEventName(String s)
    {
    }

    public void setSubEventName(String s)
    {
    }

    public boolean upload(EbayContext ebaycontext)
    {
        return false;
    }

    public void viewAppeared()
    {
    }
}
