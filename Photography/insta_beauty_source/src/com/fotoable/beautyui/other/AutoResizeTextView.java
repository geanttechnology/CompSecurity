// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;

import android.content.Context;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import xk;

public class AutoResizeTextView extends TextView
{

    public static final float MIN_TEXT_SIZE = 15F;
    private static final String mEllipsis = "...";
    private boolean mAddEllipsis;
    private float mMaxTextSize;
    private float mMinTextSize;
    private boolean mNeedsResize;
    private float mSpacingAdd;
    private float mSpacingMult;
    private xk mTextResizeListener;
    private float mTextSize;

    public AutoResizeTextView(Context context)
    {
        this(context, null);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mNeedsResize = false;
        mMaxTextSize = 0.0F;
        mMinTextSize = 15F;
        mSpacingMult = 1.0F;
        mSpacingAdd = 0.0F;
        mAddEllipsis = true;
        mTextSize = getTextSize();
    }

    private int getTextHeight(CharSequence charsequence, TextPaint textpaint, int i, float f)
    {
        textpaint = new TextPaint(textpaint);
        textpaint.setTextSize(f);
        return (new StaticLayout(charsequence, textpaint, i, android.text.Layout.Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, true)).getHeight();
    }

    public boolean getAddEllipsis()
    {
        return mAddEllipsis;
    }

    public float getMaxTextSize()
    {
        return mMaxTextSize;
    }

    public float getMinTextSize()
    {
        return mMinTextSize;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (flag || mNeedsResize)
        {
            resizeText(k - i - getCompoundPaddingLeft() - getCompoundPaddingRight(), l - j - getCompoundPaddingBottom() - getCompoundPaddingTop());
        }
        super.onLayout(flag, i, j, k, l);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        if (i != k || j != l)
        {
            mNeedsResize = true;
        }
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        mNeedsResize = true;
        resetTextSize();
    }

    public void resetTextSize()
    {
        if (mTextSize > 0.0F)
        {
            super.setTextSize(0, mTextSize);
            mMaxTextSize = mTextSize;
        }
    }

    public void resizeText()
    {
        int i = getHeight();
        int j = getPaddingBottom();
        int k = getPaddingTop();
        resizeText(getWidth() - getPaddingLeft() - getPaddingRight(), i - j - k);
    }

    public void resizeText(int i, int j)
    {
        CharSequence charsequence = getText();
        if (charsequence == null || charsequence.length() == 0 || j <= 0 || i <= 0 || mTextSize == 0.0F)
        {
            return;
        }
        TextPaint textpaint = getPaint();
        float f2 = textpaint.getTextSize();
        float f;
        int k;
        if (mMaxTextSize > 0.0F)
        {
            f = Math.min(mTextSize, mMaxTextSize);
        } else
        {
            f = mTextSize;
        }
        for (k = getTextHeight(charsequence, textpaint, i, f); k > j && f > mMinTextSize; k = getTextHeight(charsequence, textpaint, i, f))
        {
            f = Math.max(f - 2.0F, mMinTextSize);
        }

        if (mAddEllipsis && f == mMinTextSize && k > j)
        {
            StaticLayout staticlayout = new StaticLayout(charsequence, new TextPaint(textpaint), i, android.text.Layout.Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, false);
            if (staticlayout.getLineCount() > 0)
            {
                int i1 = staticlayout.getLineForVertical(j) - 1;
                if (i1 < 0)
                {
                    setText("");
                } else
                {
                    int l = staticlayout.getLineStart(i1);
                    j = staticlayout.getLineEnd(i1);
                    float f1 = staticlayout.getLineWidth(i1);
                    for (float f3 = textpaint.measureText("..."); (float)i < f1 + f3; f1 = textpaint.measureText(charsequence.subSequence(l, j + 1).toString()))
                    {
                        j--;
                    }

                    setText((new StringBuilder()).append(charsequence.subSequence(0, j)).append("...").toString());
                }
            }
        }
        f = 0.7F * f;
        setTextSize(0, f);
        setLineSpacing(mSpacingAdd, mSpacingMult);
        if (mTextResizeListener != null)
        {
            mTextResizeListener.a(this, f2, f);
        }
        mNeedsResize = false;
    }

    public void setAddEllipsis(boolean flag)
    {
        mAddEllipsis = flag;
    }

    public void setLineSpacing(float f, float f1)
    {
        super.setLineSpacing(f, f1);
        mSpacingMult = f1;
        mSpacingAdd = f;
    }

    public void setMaxTextSize(float f)
    {
        mMaxTextSize = f;
        requestLayout();
        invalidate();
    }

    public void setMinTextSize(float f)
    {
        mMinTextSize = f;
        requestLayout();
        invalidate();
    }

    public void setOnResizeListener(xk xk1)
    {
        mTextResizeListener = xk1;
    }

    public void setTextSize(float f)
    {
        super.setTextSize(f);
        mTextSize = getTextSize();
    }

    public void setTextSize(int i, float f)
    {
        super.setTextSize(i, f);
        mTextSize = getTextSize();
    }
}
