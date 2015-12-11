// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.pageconfiguration:
//            PageConfiguation

public class PageConfigurationInnerResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private PageConfiguation pageConfiguration;

    public PageConfigurationInnerResponse()
    {
    }

    public PageConfiguation getPageConfiguration()
    {
        return pageConfiguration;
    }

    public void setPageConfiguration(PageConfiguation pageconfiguation)
    {
        pageConfiguration = pageconfiguation;
    }
}
