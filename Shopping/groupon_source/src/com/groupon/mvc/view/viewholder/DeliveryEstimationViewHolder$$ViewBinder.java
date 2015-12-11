// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            DeliveryEstimationViewHolder

public class 
    implements butterknife.wHolder..ViewBinder
{

    public void bind(butterknife.wHolder..ViewBinder viewbinder, DeliveryEstimationViewHolder deliveryestimationviewholder, Object obj)
    {
        deliveryestimationviewholder.topSeparator = (FrameLayout)viewbinder.topSeparator((View)viewbinder.topSeparator(obj, 0x7f1004bb, "field 'topSeparator'"), 0x7f1004bb, "field 'topSeparator'");
        deliveryestimationviewholder.freeShipping = (TextView)viewbinder.freeShipping((View)viewbinder.freeShipping(obj, 0x7f1004bd, "field 'freeShipping'"), 0x7f1004bd, "field 'freeShipping'");
        deliveryestimationviewholder.shippingInformation = (TextView)viewbinder.shippingInformation((View)viewbinder.shippingInformation(obj, 0x7f1004be, "field 'shippingInformation'"), 0x7f1004be, "field 'shippingInformation'");
    }

    public volatile void bind(butterknife.wHolder..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (DeliveryEstimationViewHolder)obj, obj1);
    }

    public void unbind(DeliveryEstimationViewHolder deliveryestimationviewholder)
    {
        deliveryestimationviewholder.topSeparator = null;
        deliveryestimationviewholder.freeShipping = null;
        deliveryestimationviewholder.shippingInformation = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((DeliveryEstimationViewHolder)obj);
    }

    public ()
    {
    }
}
