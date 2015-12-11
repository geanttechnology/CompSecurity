// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.view.widgetcards.CouponTopItem;
import java.util.Date;

public class CouponCategory extends CouponTopItem
{

    public String channel;
    public int instoreCouponsCount;
    public Date modificationDate;
    public int onlineCouponsCount;
    public String parentSlug;
    public Long primaryKey;
    public String remoteId;
    public String slug;
    public String thumbnailImageUrl;
    public String title;

    public CouponCategory()
    {
        title = "";
        slug = "";
        parentSlug = "";
        thumbnailImageUrl = "";
        instoreCouponsCount = 0;
        onlineCouponsCount = 0;
    }

    public String getImageUrl()
    {
        return thumbnailImageUrl;
    }

    public String getRemoteId()
    {
        return remoteId;
    }

    public String getSlug()
    {
        return slug;
    }

    public String getTitle()
    {
        return title;
    }
}
