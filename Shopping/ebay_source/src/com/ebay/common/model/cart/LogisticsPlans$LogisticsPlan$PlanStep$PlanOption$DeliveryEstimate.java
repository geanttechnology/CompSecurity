// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import java.io.Serializable;
import java.util.Date;

// Referenced classes of package com.ebay.common.model.cart:
//            LogisticsPlans

public static class 
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public Date deliveryDateMax;
    public Date deliveryDateMin;
    public int deliveryDaysMax;
    public int deliveryDaysMin;
    public Date estimatedPickupTime;

    public void setDeliveryDaysMax(String s)
    {
        deliveryDaysMin = Integer.parseInt(s);
    }

    public void setDeliveryDaysMin(String s)
    {
        deliveryDaysMin = Integer.parseInt(s);
    }

    public ()
    {
    }
}
