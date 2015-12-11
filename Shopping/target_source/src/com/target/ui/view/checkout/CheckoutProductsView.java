// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.util.al;
import com.target.ui.util.e;
import com.target.ui.util.q;
import java.util.List;

// Referenced classes of package com.target.ui.view.checkout:
//            CheckoutProductDetailsView

public class CheckoutProductsView extends LinearLayout
{

    private static final String TAG = com/target/ui/view/checkout/CheckoutProductsView.getSimpleName();

    public CheckoutProductsView(Context context)
    {
        super(context);
        a();
    }

    public CheckoutProductsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public CheckoutProductsView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private CheckoutProductDetailsView a(LayoutInflater layoutinflater)
    {
        return (CheckoutProductDetailsView)layoutinflater.inflate(0x7f030139, this, false);
    }

    public void a()
    {
        setOrientation(1);
    }

    public void a(DeliveryDetailsModel deliverydetailsmodel)
    {
        deliverydetailsmodel = e.a(deliverydetailsmodel);
        if (deliverydetailsmodel.isEmpty())
        {
            q.a(TAG, "Product list is empty");
            al.c(this);
            return;
        }
        removeAllViews();
        LayoutInflater layoutinflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
        for (int i = 0; i < deliverydetailsmodel.size(); i++)
        {
            CheckoutProductDetailsView checkoutproductdetailsview = a(layoutinflater);
            checkoutproductdetailsview.a((CartProduct)deliverydetailsmodel.get(i));
            addView(checkoutproductdetailsview);
        }

        al.b(this);
    }

}
