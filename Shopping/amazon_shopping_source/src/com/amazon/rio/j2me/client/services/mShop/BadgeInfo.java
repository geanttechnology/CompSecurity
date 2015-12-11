// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            Badge, RichMessage

public class BadgeInfo
{

    private Badge badge;
    private RichMessage detailedMessage;
    private RichMessage prominentMessage;

    public BadgeInfo()
    {
    }

    public Badge getBadge()
    {
        return badge;
    }

    public RichMessage getDetailedMessage()
    {
        return detailedMessage;
    }

    public RichMessage getProminentMessage()
    {
        return prominentMessage;
    }

    public void setBadge(Badge badge1)
    {
        badge = badge1;
    }

    public void setDetailedMessage(RichMessage richmessage)
    {
        detailedMessage = richmessage;
    }

    public void setProminentMessage(RichMessage richmessage)
    {
        prominentMessage = richmessage;
    }
}
