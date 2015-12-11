// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;

import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.cart.interfaces.OrderReview;

// Referenced classes of package com.target.ui.analytics.b:
//            a

public class i extends a
{

    private static final long LOAD_TIME_INSTANTANEOUS = 0L;
    public final int checkoutContext;
    public final long loadTimeMS = 0L;
    public final OrderCompletionDetails orderCompletionDetails;
    public final OrderReview orderReview;

    private i(OrderCompletionDetails ordercompletiondetails, OrderReview orderreview, int j)
    {
        orderCompletionDetails = ordercompletiondetails;
        orderReview = orderreview;
        checkoutContext = j;
    }

    public static i a(OrderCompletionDetails ordercompletiondetails, OrderReview orderreview, int j)
    {
        return new i(ordercompletiondetails, orderreview, j);
    }
}
