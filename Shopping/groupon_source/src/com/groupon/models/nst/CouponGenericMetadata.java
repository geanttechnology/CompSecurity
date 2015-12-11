// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class CouponGenericMetadata extends JsonEncodedNSTField
{

    public String categoryId;
    public String channelId;
    public String couponId;
    public String eventId;
    public String merchantId;
    public String pageId;
    public String pageSection;
    public String position;

    public CouponGenericMetadata()
    {
        couponId = null;
        pageId = null;
        merchantId = null;
        pageSection = null;
        channelId = null;
        categoryId = null;
        position = null;
        eventId = null;
    }
}
