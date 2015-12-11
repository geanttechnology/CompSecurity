// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasErrorHandler

public static class supressErrors
    implements com.ebay.nautilus.kernel.content.sage
{

    private final int errorCode;
    private final String longMessage;
    private final com.ebay.nautilus.kernel.content.sage severity;
    private final String shortMessage;
    private final boolean supressErrors;

    public boolean displayToUser()
    {
        return !supressErrors;
    }

    public String getCategory()
    {
        return "";
    }

    public String getDomain()
    {
        return "";
    }

    public int getId()
    {
        return errorCode;
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        return longMessage;
    }

    public String getRemediationUrl()
    {
        return "";
    }

    public com.ebay.nautilus.kernel.content.sage getSeverity()
    {
        if (!supressErrors)
        {
            return severity;
        } else
        {
            return com.ebay.nautilus.kernel.content.;
        }
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        return shortMessage;
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        return false;
    }

    public (com.ebay.nautilus.kernel.content.sage sage, int i, String s, String s1, boolean flag)
    {
        severity = sage;
        errorCode = i;
        longMessage = s1;
        shortMessage = s;
        supressErrors = flag;
    }
}
