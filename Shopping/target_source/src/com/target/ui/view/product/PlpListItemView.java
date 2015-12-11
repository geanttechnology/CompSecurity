// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.mothership.util.o;
import com.target.ui.adapter.product.c;
import com.target.ui.util.al;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.StarRatingView;
import java.math.BigDecimal;

// Referenced classes of package com.target.ui.view.product:
//            PlpFulfillmentOverflowView, PlpFulfillmentView, ProductEyebrowView, ProductPriceView

public class PlpListItemView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
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

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements PlpFulfillmentView.a
    {

        final ProductDetails mProductDetailsData;
        final PlpListItemView this$0;

        public void a()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).b(mProductDetailsData);
                return;
            }
        }

        public void b()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).c(mProductDetailsData);
                return;
            }
        }

        public void c()
        {
        }

        public void d()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).a(mProductDetailsData);
                return;
            }
        }

        a(ProductDetails productdetails)
        {
            this$0 = PlpListItemView.this;
            super();
            mProductDetailsData = productdetails;
        }
    }

    private class b
        implements PlpFulfillmentOverflowView.a
    {

        final ProductDetails mProductDetailsData;
        final PlpListItemView this$0;

        public void a()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).d(mProductDetailsData);
                return;
            }
        }

        public void b()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).e(mProductDetailsData);
                return;
            }
        }

        public void c()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).f(mProductDetailsData);
                return;
            }
        }

        public void d()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).b(mProductDetailsData);
                return;
            }
        }

        public void e()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).c(mProductDetailsData);
                return;
            }
        }

        public void f()
        {
            if (PlpListItemView.a(PlpListItemView.this) == null)
            {
                return;
            } else
            {
                PlpListItemView.a(PlpListItemView.this).g(mProductDetailsData);
                return;
            }
        }

        b(ProductDetails productdetails)
        {
            this$0 = PlpListItemView.this;
            super();
            mProductDetailsData = productdetails;
        }
    }

    public static interface c
    {

        public abstract void a(ProductDetails productdetails);

        public abstract void b(ProductDetails productdetails);

        public abstract void c(ProductDetails productdetails);

        public abstract void d(ProductDetails productdetails);

        public abstract void e(ProductDetails productdetails);

        public abstract void f(ProductDetails productdetails);

        public abstract void g(ProductDetails productdetails);
    }

    public static class d
        implements c
    {

        public void a(ProductDetails productdetails)
        {
        }

        public void b(ProductDetails productdetails)
        {
        }

        public void c(ProductDetails productdetails)
        {
        }

        public void d(ProductDetails productdetails)
        {
        }

        public void e(ProductDetails productdetails)
        {
        }

        public void f(ProductDetails productdetails)
        {
        }

        public void g(ProductDetails productdetails)
        {
        }

        public d()
        {
        }
    }


    public static final int ICONS = 1;
    public static final int OVERFLOW = 2;
    private int mApproximateCardHeight;
    private int mFulfillmentStyle;
    private c mListener;
    private boolean mShowFulfillment;
    private Views mViews;

    public PlpListItemView(Context context)
    {
        super(context);
        mFulfillmentStyle = 1;
        a(((AttributeSet) (null)));
    }

    public PlpListItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFulfillmentStyle = 1;
        a(attributeset);
    }

    public PlpListItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFulfillmentStyle = 1;
        a(attributeset);
    }

    static c a(PlpListItemView plplistitemview)
    {
        return plplistitemview.mListener;
    }

    private void a(AttributeSet attributeset)
    {
        b(attributeset);
        mFulfillmentStyle;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 66
    //                   2 80;
           goto _L1 _L2 _L3
_L1:
        mViews = new Views(this);
        mApproximateCardHeight = getContext().getResources().getDimensionPixelSize(0x7f0a026e);
        mShowFulfillment = true;
        return;
_L2:
        inflate(getContext(), 0x7f0301ad, this);
        continue; /* Loop/switch isn't completed */
_L3:
        inflate(getContext(), 0x7f0301ae, this);
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(TextView textview, ProductDetails productdetails)
    {
        textview.setText(Html.fromHtml(productdetails.g()));
        al.b(textview);
    }

    private void a(StarRatingView starratingview, ProductDetails productdetails)
    {
        if (productdetails.j().b())
        {
            starratingview.setHalfStars(((ProductGuestReview)productdetails.j().c()).a().multiply(new BigDecimal(2)).intValue());
            al.b(starratingview);
            return;
        } else
        {
            al.c(starratingview);
            return;
        }
    }

    private void a(PlpFulfillmentOverflowView plpfulfillmentoverflowview, AisleBadgeView aislebadgeview, ProductDetails productdetails)
    {
        if (!mShowFulfillment)
        {
            al.a(new View[] {
                plpfulfillmentoverflowview, aislebadgeview
            });
            return;
        } else
        {
            b(plpfulfillmentoverflowview, aislebadgeview, productdetails);
            return;
        }
    }

    private void a(PlpFulfillmentView plpfulfillmentview, ProductDetails productdetails)
    {
        if (!mShowFulfillment)
        {
            al.a(new View[] {
                plpfulfillmentview
            });
            return;
        } else
        {
            b(plpfulfillmentview, productdetails);
            return;
        }
    }

    private void b(AttributeSet attributeset)
    {
        if (attributeset != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((attributeset = getContext().obtainStyledAttributes(attributeset, com.target.ui.a.a.PlpListItemView)) == null) goto _L1; else goto _L3
_L3:
        attributeset.getInteger(0, 0);
        JVM INSTR tableswitch 0 1: default 48
    //                   0 53
    //                   1 61;
           goto _L4 _L5 _L6
_L4:
        attributeset.recycle();
        return;
_L5:
        mFulfillmentStyle = 1;
        continue; /* Loop/switch isn't completed */
_L6:
        mFulfillmentStyle = 2;
        if (true) goto _L4; else goto _L7
_L7:
    }

    private void b(PlpFulfillmentOverflowView plpfulfillmentoverflowview, AisleBadgeView aislebadgeview, final ProductDetails productDetails)
    {
        com.target.ui.adapter.product.c.a(plpfulfillmentoverflowview, aislebadgeview, productDetails);
        plpfulfillmentoverflowview.setListener(new b(productDetails));
        aislebadgeview.setOnClickListener(new android.view.View.OnClickListener() {

            final PlpListItemView this$0;
            final ProductDetails val$productDetails;

            public void onClick(View view)
            {
                if (PlpListItemView.a(PlpListItemView.this) == null)
                {
                    return;
                } else
                {
                    PlpListItemView.a(PlpListItemView.this).a(productDetails);
                    return;
                }
            }

            
            {
                this$0 = PlpListItemView.this;
                productDetails = productdetails;
                super();
            }
        });
    }

    private void b(PlpFulfillmentView plpfulfillmentview, ProductDetails productdetails)
    {
        com.target.ui.adapter.product.c.a(plpfulfillmentview, productdetails);
        plpfulfillmentview.setClickListener(new a(productdetails));
    }

    public void a(String s, int i)
    {
        if (!o.g(s))
        {
            al.c(mViews.subTitle);
            return;
        } else
        {
            mViews.subTitle.setText(s);
            mViews.subTitle.setTextColor(getResources().getColor(i));
            al.b(mViews.subTitle);
            return;
        }
    }

    public void a(boolean flag)
    {
        mShowFulfillment = flag;
    }

    public BitmapImageView getBitmapImageView()
    {
        return mViews.imageView;
    }

    public void setClickListener(c c1)
    {
        mListener = c1;
    }

    public void setItemData(ProductDetails productdetails)
    {
        if (productdetails == null)
        {
            return;
        }
        com.target.ui.adapter.product.c.a(mViews.imageView, mApproximateCardHeight, productdetails);
        com.target.ui.adapter.product.c.a(mViews.priceLayout, mViews.eyebrowLayout, productdetails);
        a(mViews.title, productdetails);
        a(mViews.guestRating, productdetails);
        switch (mFulfillmentStyle)
        {
        default:
            return;

        case 1: // '\001'
            a(mViews.fulfillmentLayout, productdetails);
            return;

        case 2: // '\002'
            a(mViews.fulfillmentOverflowView, mViews.overflowAisleBadge, productdetails);
            break;
        }
    }
}
