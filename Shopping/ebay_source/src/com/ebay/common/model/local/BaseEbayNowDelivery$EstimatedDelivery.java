// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.local;

import java.util.Date;

// Referenced classes of package com.ebay.common.model.local:
//            BaseEbayNowDelivery

public static class max
{

    public final Date max;
    public final Date min;

    public String toString()
    {
        return (new StringBuilder()).append("EstimatedDelivery [min=").append(min).append(", max=").append(max).append("]").toString();
    }

    public (Date date, Date date1)
    {
        min = date;
        max = date1;
    }
}
