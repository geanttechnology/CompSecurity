// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.aviary.android.feather.sdk.utils.TypefaceUtils;

public class PluginDividerDrawable extends Drawable
{

    static final float DEFAULT_TEXT_DIVIDER_PERC = 0.9F;
    public static final String LOG_TAG = "Drawable";
    private Rect mBounds;
    private int mFillColor;
    private int mHeight;
    private String mLabel;
    private int mMaxHeight;
    private android.graphics.Paint.FontMetrics mMetrics;
    private int mStrokeColor;
    private int mStrokeWidth;
    private float mTextDivider;
    private Paint mTextPaint;
    private float mTextSize;
    private Paint mTextStrokePaint;
    private int mTextY;
    private int mWidth;

    public PluginDividerDrawable(Context context, int i, String s)
    {
        mTextSize = 10F;
        mTextY = 0;
        Typeface typeface = Typeface.DEFAULT;
        TypedArray typedarray = context.getTheme().obtainStyledAttributes(null, com.aviary.android.feather.sdk.R.styleable.AviaryPluginDividerDrawable, com.aviary.android.feather.sdk.R.attr.aviaryEffectThumbDividerTextStyle, -1);
        mFillColor = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPluginDividerDrawable_android_textColor, 0);
        mStrokeWidth = typedarray.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryPluginDividerDrawable_aviary_strokeWidth, 0);
        mStrokeColor = typedarray.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPluginDividerDrawable_aviary_strokeColor, 0);
        mTextDivider = typedarray.getFloat(com.aviary.android.feather.sdk.R.styleable.AviaryPluginDividerDrawable_aviary_textPerc, 0.9F);
        String s1 = typedarray.getString(com.aviary.android.feather.sdk.R.styleable.AviaryPluginDividerDrawable_aviary_typeface);
        try
        {
            context = TypefaceUtils.createFromAsset(context.getAssets(), s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = typeface;
        }
        typedarray.recycle();
        mLabel = s;
        mTextPaint = new Paint(385);
        mTextPaint.setColor(mFillColor);
        mTextPaint.setStyle(android.graphics.Paint.Style.FILL);
        if (context != null)
        {
            mTextPaint.setTypeface(context);
        }
        mTextStrokePaint = new Paint(mTextPaint);
        mTextStrokePaint.setColor(mStrokeColor);
        mTextStrokePaint.setStyle(android.graphics.Paint.Style.STROKE);
        mTextStrokePaint.setStrokeWidth(mStrokeWidth);
        mBounds = new Rect();
        mMetrics = new android.graphics.Paint.FontMetrics();
    }

    public void clearColorFilter()
    {
    }

    public void draw(Canvas canvas)
    {
        int i = canvas.save(1);
        canvas.rotate(-90F);
        canvas.translate(-mHeight + (mHeight - mBounds.width()) / 2, mTextY);
        if (mBounds.width() > mMaxHeight)
        {
            float f = (float)mMaxHeight / (float)mBounds.width();
            canvas.scale(f, f, mBounds.centerX(), mBounds.centerY());
        }
        if (mStrokeWidth > 0)
        {
            canvas.drawText(mLabel, 0.0F, 0.0F, mTextStrokePaint);
        }
        canvas.drawText(mLabel, 0.0F, 0.0F, mTextPaint);
        canvas.restoreToCount(i);
    }

    public int getIntrinsicHeight()
    {
        return super.getIntrinsicHeight();
    }

    public int getIntrinsicWidth()
    {
        return super.getIntrinsicWidth();
    }

    public int getMinimumHeight()
    {
        return super.getMinimumHeight();
    }

    public int getMinimumWidth()
    {
        return super.getMinimumWidth();
    }

    public int getOpacity()
    {
        return -3;
    }

    public final String getTitle()
    {
        return mLabel;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        mWidth = rect.width();
        mHeight = rect.height();
        onTextBoundsChanged();
    }

    protected final void onTextBoundsChanged()
    {
        mTextSize = (float)mWidth * mTextDivider;
        mTextPaint.setTextSize(mTextSize);
        mTextStrokePaint.setTextSize(mTextSize);
        mTextPaint.getTextBounds(mLabel, 0, mLabel.length(), mBounds);
        mTextPaint.getFontMetrics(mMetrics);
        mTextY = (int)(((float)mWidth / 2.0F + mTextSize / 2.0F) - mMetrics.bottom / 2.0F);
        mMaxHeight = (int)((double)mHeight * 0.90000000000000002D);
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }

    public void setTitle(String s)
    {
        mLabel = s;
        onBoundsChange(getBounds());
        invalidateSelf();
    }
}
