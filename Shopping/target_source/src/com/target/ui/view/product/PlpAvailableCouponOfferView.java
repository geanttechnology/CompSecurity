// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.mcoupons.CouponsOverflowView;

public class PlpAvailableCouponOfferView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        TextView eyebrow;
        BitmapImageView imageView;
        CouponsOverflowView mCouponsOverflowView;
        TextView title;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(AvailableCouponOffer availablecouponoffer);
    }


    public static final String TAG = com/target/ui/view/product/PlpAvailableCouponOfferView.getSimpleName();
    private AvailableCouponOffer mAvailableCouponOffer;
    private a mListener;
    private Views mViews;

    public PlpAvailableCouponOfferView(Context context)
    {
        super(context);
        a();
    }

    public PlpAvailableCouponOfferView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public PlpAvailableCouponOfferView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(PlpAvailableCouponOfferView plpavailablecouponofferview)
    {
        return plpavailablecouponofferview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f030198, this);
        mViews = new Views(this);
        mViews.eyebrow.setText(getContext().getString(0x7f09041f));
        u.a(getContext()).a(0x7f0201b0).a(mViews.imageView);
        mViews.mCouponsOverflowView.setListener(new com.target.ui.view.mcoupons.CouponsOverflowView.a() {

            final PlpAvailableCouponOfferView this$0;

            public void a()
            {
                if (PlpAvailableCouponOfferView.a(PlpAvailableCouponOfferView.this) == null)
                {
                    return;
                }
                if (PlpAvailableCouponOfferView.b(PlpAvailableCouponOfferView.this) == null)
                {
                    q.a(PlpAvailableCouponOfferView.TAG, "Add to my coupons clicked for null offer");
                    return;
                } else
                {
                    PlpAvailableCouponOfferView.a(PlpAvailableCouponOfferView.this).a(PlpAvailableCouponOfferView.b(PlpAvailableCouponOfferView.this));
                    return;
                }
            }

            
            {
                this$0 = PlpAvailableCouponOfferView.this;
                super();
            }
        });
    }

    static AvailableCouponOffer b(PlpAvailableCouponOfferView plpavailablecouponofferview)
    {
        return plpavailablecouponofferview.mAvailableCouponOffer;
    }

    public void setData(AvailableCouponOffer availablecouponoffer)
    {
        mAvailableCouponOffer = availablecouponoffer;
        mViews.title.setText(availablecouponoffer.d());
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }

}
