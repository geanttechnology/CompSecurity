// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.ui.util.al;
import com.target.ui.view.StarRatingView;
import com.target.ui.view.a;
import java.math.BigDecimal;

// Referenced classes of package com.target.ui.view.product:
//            PlpCardViewDealsOnly

public class PlpCardViewDealsAndRating extends PlpCardViewDealsOnly
{
    static class Views extends a
    {

        View noRatingsView;
        StarRatingView starRatingView;

        public Views(View view)
        {
            super(view);
        }
    }


    private Point mMeasureSpec;
    private Views mViews;

    public PlpCardViewDealsAndRating(Context context)
    {
        super(context);
        mMeasureSpec = new Point();
        a();
    }

    public PlpCardViewDealsAndRating(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMeasureSpec = new Point();
        a();
    }

    public PlpCardViewDealsAndRating(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMeasureSpec = new Point();
        a();
    }

    private void a()
    {
        mViews = new Views(this);
    }

    protected Point a(int i, int j)
    {
        mMeasureSpec.set(i, j);
        return mMeasureSpec;
    }

    protected int getLayoutResource()
    {
        return 0x7f0301a2;
    }

    public void setItemData(ProductDetails productdetails)
    {
        super.setItemData(productdetails);
        boolean flag = productdetails.j().b();
        float f;
        if (flag)
        {
            f = ((ProductGuestReview)productdetails.j().c()).a().floatValue();
        } else
        {
            f = 0.0F;
        }
        mViews.starRatingView.setRating(f);
        al.a(mViews.starRatingView, flag);
        productdetails = mViews.noRatingsView;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        al.a(productdetails, flag);
    }
}
