// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.mvc.model.DeliveryEstimation;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class DeliveryEstimationController extends RecyclerItemViewController
{

    private Deal deal;
    private String deliveryEstimation;

    public DeliveryEstimationController(Context context)
    {
        super(context);
    }

    public void processData()
    {
        model = new DeliveryEstimation();
        ((DeliveryEstimation)model).isShippingFree = deal.allOptionsAreFreeShipping();
        ((DeliveryEstimation)model).deliveryEstimation = deliveryEstimation;
        if (((DeliveryEstimation)model).isShippingFree || !Strings.isEmpty(deliveryEstimation))
        {
            setState(2);
            return;
        } else
        {
            setState(0);
            return;
        }
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setEstimation(String s)
    {
        setState(1);
        deliveryEstimation = s;
    }
}
