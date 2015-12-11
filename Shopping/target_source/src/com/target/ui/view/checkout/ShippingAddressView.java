// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.ShippingAddressDetailsModel;
import com.target.ui.util.al;
import com.target.ui.view.a;
import java.util.List;

public class ShippingAddressView extends RelativeLayout
    implements android.view.View.OnClickListener
{
    static class Views extends a
    {

        TextView selectShippingText;
        LinearLayout shippingAddressDetailsView;
        View shippingCompactView;
        TextView shippingText;

        Views(View view)
        {
            super(view);
        }
    }


    private DeliveryView.a mActionListener;
    private List mProductList;
    private ShippingAddressDetailsModel mShippingAddressDetails;
    private Views mViews;

    public ShippingAddressView(Context context)
    {
        super(context);
        mViews = null;
        a(context);
    }

    public ShippingAddressView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        a(context);
    }

    public ShippingAddressView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        a(context);
    }

    private void b()
    {
        al.a(mViews.selectShippingText, new View[] {
            mViews.shippingAddressDetailsView
        });
    }

    private void b(ShippingAddressDetailsModel shippingaddressdetailsmodel)
    {
        StringBuilder stringbuilder;
        al.a(mViews.shippingAddressDetailsView, new View[] {
            mViews.selectShippingText
        });
        stringbuilder = new StringBuilder();
        if (!shippingaddressdetailsmodel.b()) goto _L2; else goto _L1
_L1:
        stringbuilder.append(getContext().getString(0x7f09024e, new Object[] {
            shippingaddressdetailsmodel.f()
        }));
_L4:
        al.a(mViews.shippingText, stringbuilder);
        return;
_L2:
        stringbuilder.append(shippingaddressdetailsmodel.d());
        if (o.g(shippingaddressdetailsmodel.e()))
        {
            stringbuilder.append(", ");
            stringbuilder.append(shippingaddressdetailsmodel.e());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a()
    {
        if (mShippingAddressDetails.a())
        {
            return;
        } else
        {
            mViews.selectShippingText.setCompoundDrawablesWithIntrinsicBounds(0x7f020178, 0, 0, 0);
            mViews.selectShippingText.setCompoundDrawablePadding(getResources().getDimensionPixelSize(0x7f0a0115));
            mViews.selectShippingText.setTextColor(getResources().getColor(0x7f0f00e9));
            return;
        }
    }

    public void a(Context context)
    {
        inflate(context, 0x7f030140, this);
        mViews = new Views(this);
    }

    public void a(ShippingAddressDetailsModel shippingaddressdetailsmodel)
    {
        mShippingAddressDetails = shippingaddressdetailsmodel;
        if (shippingaddressdetailsmodel.a())
        {
            b(shippingaddressdetailsmodel);
            return;
        } else
        {
            b();
            return;
        }
    }

    public void a(ShippingAddressDetailsModel shippingaddressdetailsmodel, List list, DeliveryView.a a1)
    {
        mProductList = list;
        mActionListener = a1;
        a(shippingaddressdetailsmodel);
        mViews.shippingCompactView.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if (view == null || mActionListener == null)
        {
            return;
        }
        if (mShippingAddressDetails.a())
        {
            mActionListener.b(mProductList);
            return;
        } else
        {
            mActionListener.a(mProductList);
            return;
        }
    }
}
