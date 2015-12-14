// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

public class FontFitTextView extends TextView
{

    protected static final float MAX_FONT_SIZE_DEFAULT_VALUE = 254F;
    protected Paint mTestPaint;
    protected float maxFontSize;

    public FontFitTextView(Context context)
    {
        super(context);
        initialise(context, null);
    }

    public FontFitTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initialise(context, attributeset);
    }

    public FontFitTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset);
        initialise(context, attributeset);
    }

    private void initialise(Context context, AttributeSet attributeset)
    {
        if (attributeset != null)
        {
            context = context.obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.FontFitTextView);
            maxFontSize = context.getDimension(0, 254F);
            context.recycle();
        } else
        {
            maxFontSize = 254F;
        }
        mTestPaint = new Paint();
        mTestPaint.set(getPaint());
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        i = android.view.View.MeasureSpec.getSize(i);
        j = getMeasuredHeight();
        refitText(getText().toString(), i, j);
        setMeasuredDimension(i, j);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        if (i != k)
        {
            refitText(getText().toString(), i, j);
        }
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        refitText(charsequence.toString(), getWidth(), getHeight());
    }

    protected void refitText(String s, int i, int j)
    {
        if (i <= 0)
        {
            return;
        }
        int k = getPaddingLeft();
        int l = getPaddingRight();
        int i1 = getPaddingTop();
        int j1 = getPaddingBottom();
        float f1 = maxFontSize;
        mTestPaint.set(getPaint());
        Rect rect = new Rect();
        float f;
        for (f = 2.0F; f1 - f > 1.0F;)
        {
            float f2 = (f1 + f) / 2.0F;
            mTestPaint.setTextSize(f2);
            mTestPaint.getTextBounds(s, 0, s.length(), rect);
            if (rect.width() >= i - k - l || rect.height() >= j - i1 - j1)
            {
                f1 = f2;
            } else
            {
                f = f2;
            }
        }

        setTextSize(0, f - 1.0F);
    }
}
