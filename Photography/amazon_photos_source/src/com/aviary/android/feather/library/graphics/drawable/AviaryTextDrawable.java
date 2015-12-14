// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.library.graphics.drawable:
//            EditableDrawable, FeatherDrawable

public class AviaryTextDrawable extends Drawable
    implements EditableDrawable, FeatherDrawable
{

    public static final float DEFAULT_MIN_TEXT_SIZE = 14F;
    static final boolean LOG_ENABLED = true;
    static final String LOG_TAG = "text-drawable";
    public static final float STROKE_WIDTH_RATIO = 10F;
    final RectF drawRect;
    final Rect lastRect;
    protected final List linesBreak;
    protected final RectF mBoundsF;
    protected float mCursorDistance;
    protected final Paint mCursorPaint;
    protected float mCursorWidth;
    protected final Paint mDebugPaint;
    protected float mDefaultTextSize;
    protected boolean mEditing;
    protected String mHintString;
    protected float mIntrinsicHeight;
    protected float mIntrinsicWidth;
    protected float mMinHeight;
    protected float mMinTextSize;
    protected float mMinWidth;
    protected long mNow;
    protected final Paint mPaint;
    protected int mPaintAlpha;
    protected boolean mShowCursor;
    private EditableDrawable.OnSizeChange mSizeChangeListener;
    protected int mStrokeAlpha;
    protected boolean mStrokeEnabled;
    protected final Paint mStrokePaint;
    protected String mText;
    protected boolean mTextHint;
    android.graphics.Paint.FontMetrics metrics;

    public AviaryTextDrawable(String s, float f)
    {
        this(s, f, null);
    }

    public AviaryTextDrawable(String s, float f, Typeface typeface)
    {
        mText = "";
        mBoundsF = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        mEditing = false;
        mNow = 0L;
        mShowCursor = false;
        linesBreak = new ArrayList();
        mTextHint = false;
        mCursorWidth = 2.0F;
        mCursorDistance = 1.0F;
        mStrokeEnabled = true;
        mMinTextSize = 14F;
        metrics = new android.graphics.Paint.FontMetrics();
        lastRect = new Rect();
        drawRect = new RectF();
        mPaint = new Paint(451);
        mDefaultTextSize = f;
        if (mMinTextSize > mDefaultTextSize)
        {
            mMinTextSize = mDefaultTextSize - 1.0F;
        }
        mPaint.setDither(true);
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
        mPaint.setTextSize(f);
        if (typeface != null)
        {
            Log.i("text-drawable", (new StringBuilder()).append("typeface: ").append(typeface).toString());
            mPaint.setTypeface(typeface);
        }
        mCursorPaint = new Paint(mPaint);
        mStrokePaint = new Paint(mPaint);
        mStrokePaint.setStyle(android.graphics.Paint.Style.STROKE);
        mStrokePaint.setStrokeWidth(f / 10F);
        mDebugPaint = null;
        setTextColor(-1);
        setStrokeColor(0xff000000);
        setText(s);
        computeMinSize();
    }

    public void beginEdit()
    {
        mEditing = true;
    }

    protected void computeMinSize()
    {
        mMinWidth = getMinTextWidth();
        mMinHeight = getMinTextSize() * (float)getNumLines();
        Log.i("text-drawable", (new StringBuilder()).append("computeMinSize, minHeight: ").append(mMinHeight).toString());
    }

    protected float computeTextHeight()
    {
        float f = getTextSize();
        Log.i("text-drawable", (new StringBuilder()).append("computeTextHeight. single line height: ").append(f).toString());
        if (mText.length() < 1)
        {
            return (float)(int)f;
        } else
        {
            return Math.max(f, (float)getNumLines() * f);
        }
    }

    protected float computeTextWidth()
    {
        float f;
        float f1;
        f1 = 0.0F;
        f = 0.0F;
        if (mText.length() <= 0) goto _L2; else goto _L1
_L1:
        if (getNumLines() != 1) goto _L4; else goto _L3
_L3:
        f = getTextWidth(0, mText.length()) + mCursorWidth + mCursorDistance;
_L2:
        return Math.max(f, mMinWidth);
_L4:
        int j = 0;
        int i = 0;
        do
        {
            f = f1;
            if (i >= linesBreak.size())
            {
                continue;
            }
            int k = ((Integer)linesBreak.get(i)).intValue();
            f1 = Math.max(f1, getTextWidth(j, k) + mCursorWidth + mCursorDistance);
            j = k + 1;
            i++;
        } while (true);
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void copyBounds(RectF rectf)
    {
        rectf.set(mBoundsF);
    }

    public void draw(Canvas canvas)
    {
        copyBounds(drawRect);
        if (mDebugPaint != null)
        {
            canvas.drawRect(drawRect, mDebugPaint);
        }
        int k = getNumLines();
        getFontMetrics(metrics);
        float f2 = metrics.descent;
        float f3 = metrics.leading;
        float f4 = metrics.bottom;
        float f5 = metrics.descent;
        float f6 = metrics.ascent - (metrics.top - metrics.ascent);
        float f = drawRect.top;
        float f7 = drawRect.left;
        int j = 0;
        int i = 0;
        while (i < k) 
        {
            float f8 = f - f6;
            int l = ((Integer)linesBreak.get(i)).intValue();
            String s = mText.substring(j, l);
            if (!isTextHint() && mStrokeEnabled)
            {
                canvas.drawText(s, f7, f8, mStrokePaint);
            }
            canvas.drawText(s, f7, f8, mPaint);
            if (mEditing && i == k - 1)
            {
                long l1 = System.currentTimeMillis();
                if (l1 - mNow > 400L)
                {
                    float f9;
                    float f10;
                    float f11;
                    float f12;
                    float f13;
                    float f14;
                    float f15;
                    boolean flag;
                    if (!mShowCursor)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    mShowCursor = flag;
                    mNow = l1;
                }
                if (mShowCursor)
                {
                    getLineBounds(k - 1, lastRect);
                    f9 = drawRect.left;
                    f10 = lastRect.right;
                    f11 = mCursorDistance;
                    float f1;
                    if (isTextHint() || !mStrokeEnabled)
                    {
                        f = 0.0F;
                    } else
                    {
                        f = mStrokePaint.getStrokeWidth() / 2.0F;
                    }
                    f12 = drawRect.left;
                    f13 = lastRect.right;
                    f14 = mCursorWidth;
                    f15 = mCursorDistance;
                    if (isTextHint() || !mStrokeEnabled)
                    {
                        f1 = 0.0F;
                    } else
                    {
                        f1 = mStrokePaint.getStrokeWidth() / 2.0F;
                    }
                    canvas.drawRect(f11 + (f9 + f10) + f, f8 + f6, f15 + (f12 + f13 + f14) + f1, f8 + metrics.descent, mCursorPaint);
                }
            }
            j = l + 1;
            f = f8 + ((f2 + f3) - (f4 - f5));
            i++;
        }
    }

    public void endEdit()
    {
        mEditing = false;
        if ((getText() == null || getText().length() < 1) && mHintString != null)
        {
            setTextHint(mHintString);
        }
    }

    public float getCurrentHeight()
    {
        if (mIntrinsicHeight < 0.0F)
        {
            mIntrinsicHeight = computeTextHeight();
        }
        Log.i("text-drawable", (new StringBuilder()).append("getIntrinsicHeight: ").append(mIntrinsicHeight).toString());
        return mIntrinsicHeight;
    }

    public float getCurrentWidth()
    {
        if (mIntrinsicWidth < 0.0F)
        {
            mIntrinsicWidth = Math.max(mMinWidth, computeTextWidth());
        }
        Log.i("text-drawable", (new StringBuilder()).append("getIntrinsicWidth: ").append(mIntrinsicWidth).toString());
        return mIntrinsicWidth;
    }

    public float getDefaultTextSize()
    {
        return mDefaultTextSize;
    }

    public float getFontMetrics(android.graphics.Paint.FontMetrics fontmetrics)
    {
        return mPaint.getFontMetrics(fontmetrics);
    }

    public boolean getHorizontalFlip()
    {
        return false;
    }

    public boolean getHorizontalFlipEnabled()
    {
        return false;
    }

    public int getIntrinsicHeight()
    {
        return (int)getCurrentHeight();
    }

    public int getIntrinsicWidth()
    {
        return (int)getCurrentWidth();
    }

    protected void getLineBounds(int i, Rect rect)
    {
        if (mText.length() > 0)
        {
            if (getNumLines() == 1)
            {
                mPaint.getTextBounds(mText, 0, mText.length(), rect);
                rect.left = 0;
                return;
            } else
            {
                mPaint.getTextBounds(mText, ((Integer)linesBreak.get(i - 1)).intValue() + 1, ((Integer)linesBreak.get(i)).intValue(), rect);
                rect.left = 0;
                rect.right = (int)getTextWidth(((Integer)linesBreak.get(i - 1)).intValue() + 1, ((Integer)linesBreak.get(i)).intValue());
                return;
            }
        } else
        {
            mPaint.getTextBounds(mText, 0, mText.length(), rect);
            rect.left = 0;
            rect.right = 0;
            return;
        }
    }

    public float getMinHeight()
    {
        Log.i("text-drawable", "getMinHeight");
        return mMinHeight;
    }

    public float getMinTextSize()
    {
        return mMinTextSize;
    }

    protected float getMinTextWidth()
    {
        float af[] = new float[1];
        mPaint.getTextWidths(" ", af);
        return af[0] / 2.0F;
    }

    public float getMinWidth()
    {
        return 3.402823E+38F;
    }

    public int getNumLines()
    {
        return Math.max(linesBreak.size(), 1);
    }

    public int getOpacity()
    {
        return mPaint.getAlpha();
    }

    public float getScaleX()
    {
        return 1.0F;
    }

    public boolean getStrokeEnabled()
    {
        return mStrokeEnabled;
    }

    public CharSequence getText()
    {
        return mText;
    }

    public int getTextColor()
    {
        return mPaint.getColor();
    }

    public float getTextSize()
    {
        return mPaint.getTextSize();
    }

    public int getTextStrokeColor()
    {
        return mStrokePaint.getColor();
    }

    protected float getTextWidth(int i, int j)
    {
        float af[] = new float[j - i];
        Log.d("text-drawable", (new StringBuilder()).append("getTextWidth: ").append(mText.substring(i, j)).toString());
        mPaint.getTextWidths(mText, i, j, af);
        return getTotal(af);
    }

    protected float getTotal(float af[])
    {
        float f = 0.0F;
        int j = af.length;
        for (int i = 0; i < j; i++)
        {
            f += af[i];
        }

        return f;
    }

    protected void invalidateSize()
    {
        mIntrinsicHeight = -1F;
        mIntrinsicWidth = -1F;
    }

    public boolean isEditing()
    {
        return mEditing;
    }

    public boolean isTextHint()
    {
        return mTextHint;
    }

    protected void onTextInvalidate()
    {
        Log.i("text-drawable", "onTextInvalidate");
        int i;
        if (isTextHint())
        {
            mPaint.setAlpha(mPaintAlpha / 2);
            mStrokePaint.setAlpha(mStrokeAlpha / 2);
        } else
        {
            mPaint.setAlpha(mPaintAlpha);
            mStrokePaint.setAlpha(mStrokeAlpha);
        }
        linesBreak.clear();
        i = 0;
        do
        {
            int j = mText.indexOf('\n', i);
            if (j <= -1)
            {
                break;
            }
            i = j + 1;
            linesBreak.add(Integer.valueOf(j));
        } while (true);
        linesBreak.add(Integer.valueOf(mText.length()));
        invalidateSize();
        if (mSizeChangeListener != null)
        {
            EditableDrawable.OnSizeChange onsizechange = mSizeChangeListener;
            float f = mBoundsF.left;
            float f1 = mBoundsF.top;
            float f2 = mBoundsF.left;
            float f3 = getIntrinsicWidth();
            float f4 = mBoundsF.top;
            onsizechange.onSizeChanged(this, f, f1, f3 + f2, (float)getIntrinsicHeight() + f4);
        }
    }

    public void setAlpha(int i)
    {
        mPaint.setAlpha(i);
    }

    public void setBounds(float f, float f1, float f2, float f3)
    {
        if (f != mBoundsF.left || f1 != mBoundsF.top || f2 != mBoundsF.right || f3 != mBoundsF.bottom)
        {
            Log.i("text-drawable", (new StringBuilder()).append("setBounds: ").append(f).append(", ").append(f1).append(", ").append(f2).append(", ").append(f3).toString());
            mBoundsF.set(f, f1, f2, f3);
            setTextSize(f3 - f1);
        }
    }

    public void setBounds(int i, int j, int k, int l)
    {
        super.setBounds(i, j, k, l);
        setBounds(i, j, k, l);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mPaint.setColorFilter(colorfilter);
        mStrokePaint.setColorFilter(colorfilter);
        mCursorPaint.setColorFilter(colorfilter);
    }

    public void setCursorWidth(int i)
    {
        mCursorWidth = i;
    }

    public void setHorizontalFlip(boolean flag)
    {
    }

    public void setMinSize(float f, float f1)
    {
    }

    public void setMinTextSize(float f)
    {
        Log.i("text-drawable", (new StringBuilder()).append("setMinTextSize: ").append(f).toString());
        mMinTextSize = f;
    }

    public void setOnSizeChangeListener(EditableDrawable.OnSizeChange onsizechange)
    {
        mSizeChangeListener = onsizechange;
    }

    public void setScaleX(float f)
    {
    }

    public void setStrokeColor(int i)
    {
        mStrokePaint.setColor(i);
        mStrokeAlpha = mStrokePaint.getAlpha();
    }

    public void setStrokeEnabled(boolean flag)
    {
        mStrokeEnabled = flag;
    }

    public void setText(CharSequence charsequence)
    {
        setText((String)charsequence);
    }

    public void setText(String s)
    {
        Log.i("text-drawable", (new StringBuilder()).append("setText: ").append(s).toString());
        mText = s;
        mTextHint = false;
        onTextInvalidate();
    }

    public void setTextColor(int i)
    {
        mPaint.setColor(i);
        mCursorPaint.setColor(i);
        mPaintAlpha = mPaint.getAlpha();
    }

    public void setTextHint(CharSequence charsequence)
    {
        setTextHint((String)charsequence);
    }

    public void setTextHint(String s)
    {
        String s1;
        boolean flag;
        if (s == null)
        {
            s1 = "";
        } else
        {
            s1 = s;
        }
        mText = s1;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mTextHint = flag;
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        mHintString = s1;
        onTextInvalidate();
    }

    public void setTextSize(float f)
    {
        if (!Float.valueOf(f / (float)getNumLines()).equals(Float.valueOf(mPaint.getTextSize())))
        {
            Log.i("text-drawable", (new StringBuilder()).append("setTextSize: ").append(f).toString());
            int i = getNumLines();
            mPaint.setTextSize(f / (float)i);
            mCursorPaint.setTextSize(f / (float)i);
            mStrokePaint.setTextSize(f / (float)i);
            mStrokePaint.setStrokeWidth(f / (float)i / 10F);
            invalidateSize();
            computeMinSize();
        }
    }

    public void setTextStrokeColor(int i)
    {
        mStrokePaint.setColor(i);
    }

    public boolean validateSize(RectF rectf)
    {
        Log.i("text-drawable", (new StringBuilder()).append("validateSize: ").append(rectf.width()).append("x").append(rectf.height()).append(" == ").append(mMinHeight).toString());
        return rectf.height() >= mMinHeight;
    }
}
