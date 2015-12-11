// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.a;
import com.target.ui.view.cart.CartItemOverflowView;
import com.target.ui.view.cart.CartProductFulfillmentView;

// Referenced classes of package com.target.ui.adapter.cart:
//            CartProductAdapter

static class position extends a
{

    LinearLayout freeItemContainer;
    CartProductFulfillmentView fulfillmentContainer;
    BitmapImageView imageView;
    CartItemOverflowView overflowMenu;
    int position;
    TextView price;
    Spinner quantitySpinner;
    TextView registryName;
    LinearLayout rewardsContainer;
    TextView title;

    (View view)
    {
        super(view);
        position = -1;
    }
}
