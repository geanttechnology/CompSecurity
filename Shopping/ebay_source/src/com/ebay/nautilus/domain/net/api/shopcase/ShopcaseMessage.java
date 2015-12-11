// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Map;

public final class ShopcaseMessage
    implements com.ebay.nautilus.kernel.content.ResultStatus.Message
{

    private final String ebayItemId;
    private final Long itemReferenceId;
    private final com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Notification notification;

    public ShopcaseMessage(com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Notification notification1, String s, Long long1)
    {
        notification = notification1;
        ebayItemId = s;
        itemReferenceId = long1;
    }

    public boolean displayToUser()
    {
        return getSeverity().equals(com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error);
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
        return notification.notificationId.intValue();
    }

    public String getLongMessage(EbayContext ebaycontext)
    {
        return notification.message;
    }

    public String getRemediationUrl()
    {
        return "";
    }

    public com.ebay.nautilus.kernel.content.ResultStatus.Severity getSeverity()
    {
        if (notification.attributes == null) goto _L2; else goto _L1
_L1:
        String s1 = (String)notification.attributes.get("itemIdentifier");
        if (s1 == null) goto _L2; else goto _L3
_L3:
        String s = ebayItemId;
        if (s == null) goto _L5; else goto _L4
_L4:
        String as[] = ebayItemId.split(":");
        if (as.length > 1)
        {
            s = as[0];
        }
_L6:
        if (s1.equals(s))
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
        }
        break; /* Loop/switch isn't completed */
_L5:
        if (itemReferenceId != null)
        {
            s = itemReferenceId.toString();
        }
        if (true) goto _L6; else goto _L2
_L2:
        if (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.NotificationLevel.ERROR.equals(notification.notificationLevel))
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error;
        } else
        {
            return com.ebay.nautilus.kernel.content.ResultStatus.Severity.Warning;
        }
    }

    public String getShortMessage(EbayContext ebaycontext)
    {
        return notification.message;
    }

    public boolean isLongMessageHtml(EbayContext ebaycontext)
    {
        return false;
    }
}
