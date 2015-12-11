// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.poshmark.utils.ViewUtils;

public class PMAutoScaleTextView extends TextView
{

    public static final float MIN_TEXT_SIZE = 5F;
    private static final String mEllipsis = "...";
    private int fontColor;
    private String fontName;
    private boolean mAddEllipsis;
    private float mMaxTextSize;
    private float mMinTextSize;
    private boolean mNeedsResize;
    private float mSpacingAdd;
    private float mSpacingMult;
    private float mTextSize;

    public PMAutoScaleTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mNeedsResize = false;
        mAddEllipsis = true;
        mMaxTextSize = 0.0F;
        mMinTextSize = 5F;
        mSpacingMult = 1.0F;
        mSpacingAdd = 0.0F;
        fontColor = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMTextView).getColor(0, 0);
        fontName = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMCommon).getString(0);
        if (fontName != null)
        {
            ViewUtils.setTypefaceForView(context, fontName, this);
        }
        mTextSize = getTextSize();
    }

    private int getTextHeight(CharSequence charsequence, TextPaint textpaint, int i, float f)
    {
        textpaint = new TextPaint(textpaint);
        textpaint.setTextSize(f);
        return (new StaticLayout(charsequence, textpaint, i, android.text.Layout.Alignment.ALIGN_NORMAL, mSpacingMult, mSpacingAdd, true)).getHeight();
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
        TextPaint textpaint = new TextPaint(getPaint());
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
        for (k = getTextHeight(charsequence, textpaint, i, f); k > j && f > mMinTextSize; k = getTextHeight(charsequence, textpaint, i, f))
        {
            f = Math.max(f - 2.0F, mMinTextSize);
        }

        if (mAddEllipsis && f == mMinTextSize && k > j)
        {
            StaticLayout staticlayout = new StaticLayout(charsequence, new TextPaint(textpaint), i, android.text.Layout.Alignment.ALIGN_CENTER, mSpacingMult, mSpacingAdd, false);
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
        setTextSize(0, f);
        setLineSpacing(mSpacingAdd, mSpacingMult);
        mNeedsResize = false;
    }
}
