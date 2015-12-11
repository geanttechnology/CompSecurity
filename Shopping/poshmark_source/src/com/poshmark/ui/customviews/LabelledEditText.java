// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.poshmark.utils.ViewUtils;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMEditText

public class LabelledEditText extends PMEditText
{

    private String labelText;
    private float labelTextWidth;
    private int paddingLeft;

    public LabelledEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        attributeset = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.LabelledEditText);
        labelText = attributeset.getString(0);
        labelTextWidth = attributeset.getDimension(1, 0.0F);
        if (labelText == null)
        {
            labelText = "";
        }
        paddingLeft = getPaddingLeft();
        if (labelTextWidth == 0.0F && labelText.length() > 0)
        {
            labelTextWidth = ViewUtils.dipToPixels(context, 100F);
        }
        attributeset.recycle();
    }

    protected void onDraw(Canvas canvas)
    {
        TextPaint textpaint = getPaint();
        Rect rect = new Rect();
        textpaint.getTextBounds(labelText, 0, labelText.length(), rect);
        if ((float)rect.width() > labelTextWidth)
        {
            labelTextWidth = rect.width();
        }
        setPadding(paddingLeft + (int)labelTextWidth, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        super.onDraw(canvas);
        textpaint.setTextSize(ViewUtils.dipToPixels(getContext(), 14F));
        textpaint.setColor(getResources().getColor(0x7f090039));
        canvas.drawText(labelText, paddingLeft, rect.height() + getPaddingTop(), textpaint);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
    }
}
