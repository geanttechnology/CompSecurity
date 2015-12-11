// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.Locale;

public class ErrorDetails extends com.ebay.nautilus.domain.net.EbayResponseError.ShortDetails
{

    private String mappedCategory;
    private String mappedSeverity;

    public ErrorDetails()
    {
    }

    public String getCategory()
    {
        category = getMappedCategory();
        return super.getCategory();
    }

    protected int getMappedCategory()
    {
        String s = mappedCategory.toLowerCase(Locale.US);
        if ("requesterror".equals(s) || "request".equals(s))
        {
            return 2;
        }
        if ("systemerror".equals(s) || "system".equals(s))
        {
            return 3;
        }
        if ("customcode".equals(s))
        {
            return -1;
        }
        if ("application".equals(s))
        {
            return 1;
        } else
        {
            return category;
        }
    }

    protected int getMappedSeverity()
    {
        String s = mappedSeverity.toLowerCase(Locale.US);
        if ("error".equals(s))
        {
            return 1;
        }
        if ("warning".equals(s))
        {
            return 2;
        }
        if ("customcode".equals(s))
        {
            return -1;
        } else
        {
            return severity;
        }
    }

    public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
    {
        severity = getMappedSeverity();
        return super.getSeverity();
    }
}
