// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;


public abstract class CouponTopItem
{

    int horizontalPosition;
    com.groupon.v3.view.list_view.CouponTopItemType.ItemType itemType;
    int verticalPosition;

    public CouponTopItem()
    {
        horizontalPosition = 0;
        verticalPosition = 0;
    }

    public int getHorizontalPosition()
    {
        return horizontalPosition;
    }

    public abstract String getImageUrl();

    public com.groupon.v3.view.list_view.CouponTopItemType.ItemType getItemType()
    {
        return itemType;
    }

    public abstract String getRemoteId();

    public abstract String getSlug();

    public abstract String getTitle();

    public int getVerticalPosition()
    {
        return verticalPosition;
    }

    public void setHorizontalPosition(int i)
    {
        horizontalPosition = i;
    }

    public void setItemType(com.groupon.v3.view.list_view.CouponTopItemType.ItemType itemtype)
    {
        itemType = itemtype;
    }

    public void setVerticalPosition(int i)
    {
        verticalPosition = i;
    }
}
