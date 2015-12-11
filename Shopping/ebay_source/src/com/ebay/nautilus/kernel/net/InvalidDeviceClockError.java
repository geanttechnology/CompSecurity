// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.content.EbayContext;

public class InvalidDeviceClockError
    implements com.ebay.nautilus.kernel.content.ResultStatus.Message
{

    public volatile String message;

    public InvalidDeviceClockError()
    {
    }

    public boolean displayToUser()
    {
        return !TextUtils.isEmpty(message);
    }

    public String getCategory()
    {
        return "app";
    }

    public String getDomain()
    {
        return "nautilus kernel";
    }

    public int getId()
    {
        return 0;
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
}
