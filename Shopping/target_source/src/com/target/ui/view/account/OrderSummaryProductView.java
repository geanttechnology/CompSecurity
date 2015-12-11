// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.model.guest.interfaces.OrderSummaryProduct;

public class OrderSummaryProductView extends RelativeLayout
{
    static class Views
    {

        TextView mDeliveryStatus;
        ImageView mProductImage;
        TextView mProductTitle;

        Views(View view)
        {
            ButterKnife.bind(this, view);
        }
    }


    private static final String TAG = com/target/ui/view/account/OrderSummaryProductView.getSimpleName();
    private Views mViews;

    public OrderSummaryProductView(Context context)
    {
        super(context);
        a(context);
    }

    public OrderSummaryProductView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public OrderSummaryProductView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f03017a, this);
        mViews = new Views(this);
    }

    public void a(OrderSummaryProduct ordersummaryproduct)
    {
        int i = getResources().getDimensionPixelSize(0x7f0a00a6);
        u.a(getContext()).a(ordersummaryproduct.a(i)).a(mViews.mProductImage);
        mViews.mDeliveryStatus.setText(ordersummaryproduct.c());
        mViews.mProductTitle.setText(ordersummaryproduct.g());
    }

}
