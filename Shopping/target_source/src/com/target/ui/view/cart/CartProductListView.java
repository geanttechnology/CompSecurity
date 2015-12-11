// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ListView;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.ui.view.product.PdpRecommendationsView;

// Referenced classes of package com.target.ui.view.cart:
//            CartHeaderView

public class CartProductListView extends ListView
{

    private static final int GENERIC_FOOTER_INDEX = 1;
    private static final int NUM_FOOTERS = 2;
    private static final int RECOMMENDATIONS_FOOTER_INDEX = 0;
    boolean mFooterShowState[];

    public CartProductListView(Context context)
    {
        super(context);
        mFooterShowState = new boolean[2];
    }

    public CartProductListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFooterShowState = new boolean[2];
    }

    public CartProductListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFooterShowState = new boolean[2];
    }

    public void a()
    {
        if (mFooterShowState[1])
        {
            return;
        } else
        {
            addFooterView(LayoutInflater.from(getContext()).inflate(0x7f030107, null), null, false);
            mFooterShowState[1] = true;
            return;
        }
    }

    public void a(CartHeaderView cartheaderview, CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion)
        throws IllegalStateException
    {
        if (getHeaderViewsCount() > 0)
        {
            removeHeaderView(cartheaderview);
        }
        cartheaderview.a(cartdetails, freeshippingpromotion);
        addHeaderView(cartheaderview, null, false);
    }

    public void a(PdpRecommendationsView pdprecommendationsview)
    {
        if (mFooterShowState[0])
        {
            return;
        } else
        {
            addFooterView(pdprecommendationsview, null, false);
            mFooterShowState[0] = true;
            return;
        }
    }
}
