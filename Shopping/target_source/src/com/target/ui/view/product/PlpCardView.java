// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.Html;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.adapter.product.c;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.b.a;

// Referenced classes of package com.target.ui.view.product:
//            PlpGridPriceView

public class PlpCardView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        BitmapImageView mImageView;
        PlpGridPriceView mPriceBlock;

        public Views(View view)
        {
            super(view);
        }
    }


    public static final float ASPECT_RATIO = 0.8F;
    private int mApproximateCardHeight;
    private Point mMeasureSpec;
    private a mMeasurer;
    private Views mViews;

    public PlpCardView(Context context)
    {
        super(context);
        mMeasureSpec = new Point();
        a();
    }

    public PlpCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMeasureSpec = new Point();
        a();
    }

    public PlpCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMeasureSpec = new Point();
        a();
    }

    private void a()
    {
        mMeasurer = new a(0.80000001192092896D);
        inflate(getContext(), getLayoutResource(), this);
        mViews = new Views(this);
        Resources resources = getContext().getResources();
        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
        int i = resources.getInteger(0x7f0b0015);
        mApproximateCardHeight = Math.round((float)(displaymetrics.widthPixels / i) / 0.8F);
    }

    protected Point a(int i, int j)
    {
        mMeasurer.a(i, j);
        j = mMeasurer.a();
        i = mMeasurer.b();
        j = android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000);
        i = android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000);
        mMeasureSpec.set(j, i);
        return mMeasureSpec;
    }

    public BitmapImageView getBitmapImageView()
    {
        return mViews.mImageView;
    }

    protected int getLayoutResource()
    {
        return 0x7f0301a1;
    }

    protected void onMeasure(int i, int j)
    {
        Point point = a(i, j);
        super.onMeasure(point.x, point.y);
    }

    public void setItemData(ProductDetails productdetails)
    {
        mViews.mImageView.setContentDescription(Html.fromHtml(productdetails.g()));
        c.a(mViews.mImageView, mApproximateCardHeight, productdetails);
        c.a(mViews.mPriceBlock, productdetails);
    }
}
