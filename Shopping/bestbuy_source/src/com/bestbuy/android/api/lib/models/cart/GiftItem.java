// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.cart;

import gu;
import java.io.Serializable;

public class GiftItem
    implements gu, Serializable
{

    private String eventDate;
    private String eventDescription;
    private String firstName;
    private String giftListId;
    private String giftListItemId;
    private String giftListType;
    private String lastName;

    public GiftItem()
    {
    }

    public String getEventDate()
    {
        return eventDate;
    }

    public String getEventDescription()
    {
        return eventDescription;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getGiftListId()
    {
        return giftListId;
    }

    public String getGiftListItemId()
    {
        return giftListItemId;
    }

    public String getGiftListType()
    {
        return giftListType;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setEventDate(String s)
    {
        eventDate = s;
    }

    public void setEventDescription(String s)
    {
        eventDescription = s;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setGiftListId(String s)
    {
        giftListId = s;
    }

    public void setGiftListItemId(String s)
    {
        giftListItemId = s;
    }

    public void setGiftListType(String s)
    {
        giftListType = s;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }
}
