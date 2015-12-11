// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public abstract class AutoResizeTextView extends TextView
{
    public static interface OnTextResizeListener
    {

        public abstract void onTextResize(TextView textview, float f, float f1);
    }


    public static final float MIN_TEXT_SIZE = 10F;
    private static final String mEllipsis = "...";
    private float mMaxTextSize;
    private float mMinTextSize;
    private boolean mNeedsResize;
    private float mSpacingAdd;
    private float mSpacingMult;
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
        mMinTextSize = 10F;
        mNeedsResize = false;
        mMaxTextSize = 0.0F;
        mSpacingMult = 1.0F;
        mSpacingAdd = 0.0F;
        mTextSize = getTextSize();
        context = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.AutoResizeTextView);
        mMinTextSize = context.getDimension(0, mMinTextSize);
        context.recycle();
    }

    protected abstract int getLayoutSize(StaticLayout staticlayout);

    protected abstract int getSize(int i, int j);

    protected int getTextSize(CharSequence charsequence, TextPaint textpaint, int i, float f)
    {
        textpaint.setTextSize(f);
        return getLayoutSize(new StaticLayout(charsequence, textpaint, i, android.text.Layout.Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, true));
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

    public void resizeText(int i, int j)
    {
        CharSequence charsequence = getText();
        if (charsequence == null || charsequence.length() == 0 || j <= 0 || i <= 0 || mTextSize == 0.0F)
        {
            return;
        }
        TextPaint textpaint = getPaint();
        textpaint.getTextSize();
        float f;
        int k;
        if (mMaxTextSize > 0.0F)
        {
            f = Math.min(mTextSize, mMaxTextSize);
        } else
        {
            f = mTextSize;
        }
        for (k = getTextSize(charsequence, textpaint, i, f); k > getSize(j, i) && f > mMinTextSize; k = getTextSize(charsequence, textpaint, i, f))
        {
            f = Math.max(f - 2.0F, mMinTextSize);
        }

        if (f == mMinTextSize && k > getSize(j, i))
        {
            StaticLayout staticlayout = new StaticLayout(charsequence, textpaint, i, android.text.Layout.Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, false);
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
                    for (float f2 = textpaint.measureText("..."); (float)i < f1 + f2; f1 = textpaint.measureText(charsequence.subSequence(l, j + 1).toString()))
                    {
                        j--;
                    }

                    setText((new StringBuilder()).append(charsequence.subSequence(0, j)).append("...").toString());
                }
            }
        }
        textpaint.setTextSize(f);
        setLineSpacing(mSpacingAdd, mSpacingMult);
        mNeedsResize = false;
    }

    public void setLineSpacing(float f, float f1)
    {
        super.setLineSpacing(f, f1);
        mSpacingMult = f1;
        mSpacingAdd = f;
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
