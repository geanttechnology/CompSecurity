// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.h.c.e;
import com.h.c.u;
import com.h.c.y;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.common.b;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.a;
import com.target.ui.view.product.PlpFulfillmentView;
import com.target.ui.view.product.ProductEyebrowView;
import com.target.ui.view.product.ProductPriceView;

public class WeeklyAdListItemView extends FrameLayout
{
    static class Views extends a
    {

        ProductEyebrowView eyebrowLayout;
        PlpFulfillmentView fulfillmentLayout;
        ProductPriceView priceLayout;
        BitmapImageView productImageView;
        TextView title;

        Views(View view)
        {
            super(view);
        }
    }


    private String mCurrentImageUrl;
    private Views mViews;

    public WeeklyAdListItemView(Context context)
    {
        super(context);
        a();
    }

    public WeeklyAdListItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public WeeklyAdListItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static String a(WeeklyAdListItemView weeklyadlistitemview, String s)
    {
        weeklyadlistitemview.mCurrentImageUrl = s;
        return s;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301ad, this);
        mViews = new Views(this);
    }

    public void setDisplayPrice(String s)
    {
        b b1 = new b();
        b1.a(true);
        b1.a(s);
        mViews.priceLayout.setPriceData(b1);
    }

    public void setEyebrowText(String s)
    {
        b b1 = new b();
        b1.c(s);
        b1.c(true);
        mViews.eyebrowLayout.setEyebrowData(b1);
    }

    public void setFulfillmentClickListener(com.target.ui.view.product.PlpFulfillmentView.a a1)
    {
        mViews.fulfillmentLayout.setClickListener(a1);
    }

    public void setFulfillmentViewOptions(ProductFulfillmentOptions productfulfillmentoptions)
    {
        mViews.fulfillmentLayout.a(productfulfillmentoptions);
    }

    public void setImageUrl(final String imageUrl)
    {
        BitmapImageView bitmapimageview = mViews.productImageView;
        if (imageUrl == null)
        {
            mCurrentImageUrl = null;
            u.a(getContext()).a(bitmapimageview);
            u.a(getContext()).a((String)null).a(bitmapimageview);
        } else
        if (!imageUrl.equals(mCurrentImageUrl))
        {
            mViews.productImageView.setCallback(new e() {

                final WeeklyAdListItemView this$0;
                final String val$imageUrl;

                public void a()
                {
                    com.target.ui.view.weekly_ad.WeeklyAdListItemView.a(WeeklyAdListItemView.this, imageUrl);
                }

                public void b()
                {
                    com.target.ui.view.weekly_ad.WeeklyAdListItemView.a(WeeklyAdListItemView.this, null);
                }

            
            {
                this$0 = WeeklyAdListItemView.this;
                imageUrl = s;
                super();
            }
            });
            u.a(getContext()).a(imageUrl).b(0x7f0201ae).a(bitmapimageview);
            return;
        }
    }

    public void setTitle(String s)
    {
        mViews.title.setText(s);
    }
}
