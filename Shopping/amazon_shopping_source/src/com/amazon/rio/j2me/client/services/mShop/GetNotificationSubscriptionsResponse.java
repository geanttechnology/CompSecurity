// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            HyperText

public class GetNotificationSubscriptionsResponse
{

    private HyperText helpLink;
    private HyperText message;
    private List subscriptionGroups;
    private List subscriptions;

    public GetNotificationSubscriptionsResponse()
    {
    }

    public HyperText getHelpLink()
    {
        return helpLink;
    }

    public HyperText getMessage()
    {
        return message;
    }

    public List getSubscriptionGroups()
    {
        return subscriptionGroups;
    }

    public List getSubscriptions()
    {
        return subscriptions;
    }

    public void setHelpLink(HyperText hypertext)
    {
        helpLink = hypertext;
    }

    public void setMessage(HyperText hypertext)
    {
        message = hypertext;
    }

    public void setSubscriptionGroups(List list)
    {
        subscriptionGroups = list;
    }

    public void setSubscriptions(List list)
    {
        subscriptions = list;
    }
}
