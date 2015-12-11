// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            HyperText

public class PushNotificationSubscription
{

    private HyperText details;
    private String groupId;
    private Boolean requiresUserRecognized;
    private boolean subscribed;
    private String subscriptionId;
    private String title;

    public PushNotificationSubscription()
    {
    }

    public HyperText getDetails()
    {
        return details;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public Boolean getRequiresUserRecognized()
    {
        return requiresUserRecognized;
    }

    public boolean getSubscribed()
    {
        return subscribed;
    }

    public String getSubscriptionId()
    {
        return subscriptionId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDetails(HyperText hypertext)
    {
        details = hypertext;
    }

    public void setGroupId(String s)
    {
        groupId = s;
    }

    public void setRequiresUserRecognized(Boolean boolean1)
    {
        requiresUserRecognized = boolean1;
    }

    public void setSubscribed(boolean flag)
    {
        subscribed = flag;
    }

    public void setSubscriptionId(String s)
    {
        subscriptionId = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
