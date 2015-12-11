// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.StarRatingView;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.product:
//            PlpListItemView, ProductEyebrowView, PlpFulfillmentView, PlpFulfillmentOverflowView, 
//            ProductPriceView

static class View extends a
{

    ProductEyebrowView eyebrowLayout;
    PlpFulfillmentView fulfillmentLayout;
    PlpFulfillmentOverflowView fulfillmentOverflowView;
    StarRatingView guestRating;
    BitmapImageView imageView;
    AisleBadgeView overflowAisleBadge;
    ProductPriceView priceLayout;
    TextView subTitle;
    TextView title;

    public View(View view)
    {
        super(view);
    }
}
