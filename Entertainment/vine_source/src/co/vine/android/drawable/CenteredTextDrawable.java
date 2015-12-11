// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class CenteredTextDrawable extends Drawable
{

    private final Rect mDrawableBounds;
    private Drawable mDrawables[];
    private int mDrawablesMinHeight;
    private int mDrawablesMinWidth;
    private final Paint mPaint;
    private String mText;
    private final Rect mTextBounds;
    private int mTextMinHeight;
    private int mTextMinWidth;
    private final Rect mTextPadding;

    public transient CenteredTextDrawable(Resources resources, int ai[])
    {
        this(getDrawablesFromIds(resources, ai));
    }

    public transient CenteredTextDrawable(Drawable adrawable[])
    {
        setDrawables(adrawable);
        mPaint = init();
        mTextBounds = new Rect();
        mTextPadding = new Rect();
        mDrawableBounds = new Rect();
    }

    private static transient Drawable[] getDrawablesFromIds(Resources resources, int ai[])
    {
        Drawable adrawable[] = new Drawable[ai.length];
        int k = ai.length;
        int j = 0;
        for (int i = 0; j < k; i++)
        {
            adrawable[i] = resources.getDrawable(ai[j]);
            j++;
        }

        return adrawable;
    }

    private Paint init()
    {
        Paint paint = new Paint(65);
        paint.setTextSize(32F);
        paint.setColor(0xff000000);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setTextAlign(android.graphics.Paint.Align.CENTER);
        return paint;
    }

    private void updateTextBounds()
    {
        String s;
        if (mText == null)
        {
            s = "";
        } else
        {
            s = mText;
        }
        mPaint.getTextBounds(s, 0, s.length(), mTextBounds);
        mTextMinHeight = Math.max(mTextBounds.height() + mTextPadding.top + mTextPadding.bottom, mDrawablesMinHeight);
        mTextMinWidth = Math.max(mTextBounds.width() + mTextPadding.left + mTextPadding.right, mDrawablesMinWidth);
    }

    public void draw(Canvas canvas)
    {
        mDrawableBounds.set(getBounds());
        Drawable adrawable[] = mDrawables;
        int j = adrawable.length;
        for (int i = 0; i < j; i++)
        {
            Drawable drawable = adrawable[i];
            drawable.setBounds(mDrawableBounds);
            drawable.draw(canvas);
        }

        Rect rect = mDrawableBounds;
        rect.left = rect.left + mTextPadding.left;
        rect = mDrawableBounds;
        rect.top = rect.top + mTextPadding.top;
        rect = mDrawableBounds;
        rect.bottom = rect.bottom - mTextPadding.bottom;
        rect = mDrawableBounds;
        rect.right = rect.right - mTextPadding.right;
        canvas.drawText(mText, mDrawableBounds.exactCenterX(), mDrawableBounds.exactCenterY() + (float)mTextBounds.height() * 0.5F, mPaint);
    }

    public int getIntrinsicHeight()
    {
        return mTextMinHeight;
    }

    public int getIntrinsicWidth()
    {
        return mTextMinWidth;
    }

    public int getOpacity()
    {
        return mPaint.getAlpha() >= 255 ? -1 : -3;
    }

    public void setAlpha(int i)
    {
        mPaint.setAlpha(i);
    }

    public void setColorFilter(int i, ColorFilter colorfilter)
    {
        mDrawables[i].setColorFilter(colorfilter);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mPaint.setColorFilter(colorfilter);
    }

    public transient void setDrawables(Drawable adrawable[])
    {
        mDrawables = adrawable;
        int k = 0;
        int j = 0;
        adrawable = mDrawables;
        int l = adrawable.length;
        for (int i = 0; i < l; i++)
        {
            Drawable drawable = adrawable[i];
            k = Math.max(k, drawable.getMinimumHeight());
            j = Math.max(j, drawable.getMinimumWidth());
        }

        mDrawablesMinHeight = k;
        mDrawablesMinWidth = j;
    }

    public void setText(String s)
    {
        mText = s;
        updateTextBounds();
        invalidateSelf();
    }

    public void setTextColor(int i)
    {
        mPaint.setColor(i);
        invalidateSelf();
    }

    public void setTextPadding(Rect rect)
    {
        mTextPadding.left = rect.left;
        mTextPadding.right = rect.right;
        mTextPadding.top = rect.top;
        mTextPadding.bottom = rect.bottom;
    }

    public void setTextSize(float f)
    {
        mPaint.setTextSize(f);
        updateTextBounds();
        invalidateSelf();
    }

    public void setTypeFace(Typeface typeface)
    {
        mPaint.setTypeface(typeface);
        updateTextBounds();
        invalidateSelf();
    }
}
