// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.ui.common.b;
import com.target.ui.util.al;
import com.target.ui.view.StarRatingView;
import java.math.BigDecimal;

// Referenced classes of package com.target.ui.view.product:
//            ProductEyebrowView, ProductPriceView

public class PdpPriceInfoView extends RelativeLayout
{
    static class Views extends com.target.ui.view.a
    {

        ProductEyebrowView eyebrow;
        StarRatingView guestRating;
        TextView guestRatingCount;
        View guestRatingViewContainer;
        ProductPriceView priceBlock;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final PdpPriceInfoView this$0;

        public void onClick(View view)
        {
            if (PdpPriceInfoView.a(PdpPriceInfoView.this) == null)
            {
                return;
            } else
            {
                PdpPriceInfoView.a(PdpPriceInfoView.this).a();
                return;
            }
        }

        private b()
        {
            this$0 = PdpPriceInfoView.this;
            super();
        }

    }


    private a mListener;
    private Views mViews;

    public PdpPriceInfoView(Context context)
    {
        super(context);
        b();
    }

    public PdpPriceInfoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public PdpPriceInfoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    static a a(PdpPriceInfoView pdppriceinfoview)
    {
        return pdppriceinfoview.mListener;
    }

    private void b()
    {
        inflate(getContext(), 0x7f0301bd, this);
        mViews = new Views(this);
    }

    public void a()
    {
        al.c(mViews.guestRatingViewContainer);
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setEyebrowData(com.target.ui.common.b b1)
    {
        if (b1 == null || mViews == null)
        {
            return;
        }
        if (!b1.c())
        {
            al.c(mViews.eyebrow);
            return;
        } else
        {
            mViews.eyebrow.setEyebrowData(b1);
            return;
        }
    }

    public void setGuestRating(ProductGuestReview productguestreview)
    {
        BigDecimal bigdecimal;
        if (productguestreview != null && mViews != null)
        {
            if ((bigdecimal = productguestreview.a()) != null)
            {
                productguestreview = String.format(getContext().getString(0x7f090474), new Object[] {
                    Integer.valueOf(productguestreview.b())
                });
                mViews.guestRatingCount.setText(productguestreview);
                mViews.guestRating.setRating(bigdecimal.floatValue());
                mViews.guestRatingViewContainer.setOnClickListener(new b());
                al.b(mViews.guestRatingViewContainer);
                return;
            }
        }
    }

    public void setPriceData(com.target.ui.common.b b1)
    {
        if (b1 == null || mViews == null)
        {
            return;
        } else
        {
            mViews.priceBlock.setPriceData(b1);
            return;
        }
    }
}
