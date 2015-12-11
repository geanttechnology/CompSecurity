// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            HyperText

public class PushNotificationSubscriptionGroup
{

    private HyperText details;
    private String groupId;
    private String title;

    public PushNotificationSubscriptionGroup()
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

    public void setTitle(String s)
    {
        title = s;
    }
}
