// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippinglabel;

import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippinglabel:
//            GetDraftShippingLabelRequest

public static final class OrderParams
{
    private static class OrderParams
    {

        private final String itemId;
        private final String transactionId;

        OrderParams(String s, String s1)
        {
            itemId = s;
            transactionId = s1;
        }
    }


    private final Set orderIds = new HashSet();

    public OrderParams.transactionId(String s, String s1)
    {
        orderIds.add(new OrderParams(s, s1));
    }
}
