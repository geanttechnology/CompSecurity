// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.walmart.android.app.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.walmart.android.util.WalmartPrice;
import com.walmart.android.utils.ViewUtil;
import com.walmart.android.wmui.VariablePriceViewBase;
import com.walmartlabs.ui.PriceView;

public class ItemPriceView extends VariablePriceViewBase
{

    private static boolean sDrawBounds = false;
    private int mLargeDecimalTextSize;
    private int mLargeIntegerTextSize;
    private int mSmallDecimalTextSize;
    private int mSmallIntegerTextSize;

    public ItemPriceView(Context context)
    {
        super(context, true);
        init();
    }

    public ItemPriceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, true);
        init();
    }

    public ItemPriceView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i, true);
        init();
    }

    private void init()
    {
        Resources resources = getContext().getResources();
        mLargeIntegerTextSize = resources.getDimensionPixelSize(0x7f0a00a2);
        mLargeDecimalTextSize = resources.getDimensionPixelSize(0x7f0a00a1);
        mSmallIntegerTextSize = ViewUtil.dpToPixels(24, getContext());
        mSmallDecimalTextSize = mSmallIntegerTextSize / 2;
    }

    protected void initBounds()
    {
        if (isPriceRange() || shouldDrawPrefix())
        {
            mPrice1.setTextSize(mSmallDecimalTextSize, mSmallIntegerTextSize, mSmallDecimalTextSize);
            mPrice2.setTextSize(mSmallDecimalTextSize, mSmallIntegerTextSize, mSmallDecimalTextSize);
            mTextPaint.setTextSize(mSmallIntegerTextSize);
            mUnitPaint.setTextSize((float)mSmallDecimalTextSize * 0.8F);
        } else
        {
            mPrice1.setTextSize(mLargeDecimalTextSize, mLargeIntegerTextSize, mLargeDecimalTextSize);
            mPrice2.setTextSize(mLargeDecimalTextSize, mLargeIntegerTextSize, mLargeDecimalTextSize);
            mTextPaint.setTextSize(mLargeIntegerTextSize);
            mUnitPaint.setTextSize((float)mLargeDecimalTextSize * 0.8F);
        }
        mTextPaint.getFontMetricsInt(mFontMetrics);
        super.initBounds();
    }

    protected void onDraw(Canvas canvas)
    {
        if (sDrawBounds)
        {
            canvas.drawRect(1.0F, 1.0F, mWidth, mHeight, mRectPaint);
        }
        canvas.save();
        if (shouldDrawPrefix() || isPriceRange())
        {
            canvas.translate(0.0F, (mLargeIntegerTextSize - mSmallIntegerTextSize) / 3);
        }
        if (shouldDrawPrefix())
        {
            canvas.drawText(mPrice.getPrefix(), 0.0F, mPrefixBounds.height() - mPrefixBounds.bottom, mTextPaint);
            canvas.translate(mTextPaint.measureText(mPrice.getPrefix()) + mTextPaint.measureText(" "), 0.0F);
        }
        mPrice1.draw(canvas);
        canvas.translate(mPrice1.getMeasuredWidth(), 0.0F);
        if (!isPriceRange()) goto _L2; else goto _L1
_L1:
        canvas.translate(4F, 0.0F);
        canvas.drawText(mPriceRangeDelimiter, 0.0F, mTextPaint.getTextSize() - (float)mFontMetrics.bottom, mTextPaint);
        canvas.translate(mTextPaint.measureText(mPriceRangeDelimiter) + 4F, 0.0F);
        mPrice2.draw(canvas);
        if (mUnit != null)
        {
            canvas.translate(mPrice2.getMeasuredWidth(), 0.0F);
            canvas.drawText(mUnit, 0.0F, mPrice2.getDecimalsBaseline(), mUnitPaint);
        }
_L4:
        canvas.restore();
        return;
_L2:
        if (mUnit != null)
        {
            canvas.drawText(mUnit, 0.0F, mPrice1.getDecimalsBaseline(), mUnitPaint);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getSize(i);
        int l = android.view.View.MeasureSpec.getSize(j);
        int i1 = android.view.View.MeasureSpec.getMode(i);
        int j1 = android.view.View.MeasureSpec.getMode(j);
        initBounds();
        mPrice1.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x80000000), j);
        mPrice2.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x80000000), j);
        mWidth = 0;
        float f;
        float f1;
        if (shouldDrawPrefix())
        {
            mWidth = (int)((float)mWidth + mTextPaint.measureText(mPrice.getPrefix()));
            mWidth = (int)((float)mWidth + mTextPaint.measureText(" "));
        } else
        if (isPriceRange())
        {
            mWidth = (int)((float)mWidth + mTextPaint.measureText(mPriceRangeDelimiter));
            mWidth = mWidth + 8;
        }
        mWidth = mWidth + (mPrice1.getMeasuredWidth() + mPrice2.getMeasuredWidth());
        f1 = mWidth;
        if (mUnit != null)
        {
            f = mUnitPaint.measureText(mUnit);
        } else
        {
            f = 0.0F;
        }
        mWidth = (int)(f + f1);
        mHeight = Math.max(mPrice1.getMeasuredHeight(), mPrice2.getMeasuredHeight());
        if (shouldDrawPrefix())
        {
            mHeight = Math.max(mPrefixBounds.height(), mHeight);
        }
        if (i1 == 0x40000000)
        {
            mWidth = k;
        } else
        if (i1 == 0x80000000)
        {
            mWidth = Math.min(mWidth, k);
        }
        if (j1 == 0x40000000)
        {
            mHeight = l;
        } else
        if (j1 == 0x80000000)
        {
            mHeight = Math.min(mHeight, l);
        }
        setMeasuredDimension(mWidth, mHeight);
    }

}
