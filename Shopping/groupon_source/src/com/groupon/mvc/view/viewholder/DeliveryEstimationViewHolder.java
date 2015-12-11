// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.groupon.mvc.model.DeliveryEstimation;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class DeliveryEstimationViewHolder extends RecyclerItemViewHolder
{

    TextView freeShipping;
    TextView shippingInformation;
    FrameLayout topSeparator;

    public DeliveryEstimationViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        topSeparator.setVisibility(0);
        if (!((DeliveryEstimation)model).isShippingFree)
        {
            freeShipping.setVisibility(8);
            shippingInformation.setText(((DeliveryEstimation)model).deliveryEstimation);
            shippingInformation.setVisibility(0);
            return;
        }
        if (Strings.isEmpty(((DeliveryEstimation)model).deliveryEstimation))
        {
            shippingInformation.setVisibility(8);
            freeShipping.setVisibility(0);
            return;
        } else
        {
            freeShipping.setVisibility(0);
            shippingInformation.setText(((DeliveryEstimation)model).deliveryEstimation);
            shippingInformation.setVisibility(0);
            return;
        }
    }
}
