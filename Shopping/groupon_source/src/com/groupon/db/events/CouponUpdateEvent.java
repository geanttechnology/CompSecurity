// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.events;


// Referenced classes of package com.groupon.db.events:
//            UniversalUpdateEvent

public class CouponUpdateEvent extends UniversalUpdateEvent
{

    protected String couponId;

    public CouponUpdateEvent(String s, String s1)
    {
        super(s);
        couponId = s1;
    }

    public String getCouponId()
    {
        return couponId;
    }
}
