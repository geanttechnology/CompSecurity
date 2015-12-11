// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import com.ebay.nautilus.kernel.content.EbayContext;

public class HttpError
    implements com.ebay.nautilus.kernel.content.ResultStatus.Message
{

    public static final String HTTP_ERROR_CATEGORY = "network";
    public static final String HTTP_ERROR_DOMAIN = "http";
    public volatile String message;
    private final int responseCode;

    public HttpError(int i, String s)
    {
        responseCode = i;
        message = s;
    }

    public boolean displayToUser()
    {
        return true;
    }

    public String getCategory()
    {
        return "network";
    }

    public String getDomain()
    {
        return "http";
    }

    public int getId()
    {
        return responseCode;
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        return null;
    }

    public String getRemediationUrl()
    {
        return null;
    }

    public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
    {
        return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        return message;
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        return false;
    }

    public String toString()
    {
        return (new StringBuilder()).append("HTTP ").append(responseCode).append(": ").append(message).toString();
    }
}
