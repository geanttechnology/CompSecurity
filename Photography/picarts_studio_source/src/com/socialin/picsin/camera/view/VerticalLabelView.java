// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import myobfuscated.be.a;

public class VerticalLabelView extends View
{

    private TextPaint a;
    private String b;
    private float c;
    private Rect d;

    public VerticalLabelView(Context context)
    {
        super(context);
        d = new Rect();
        a();
    }

    public VerticalLabelView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = new Rect();
        a();
        context = context.obtainStyledAttributes(attributeset, a.VerticalLabelView);
        attributeset = context.getString(a.VerticalLabelView_text);
        if (attributeset != null)
        {
            setText(attributeset.toString());
        }
        setTextColor(context.getColor(a.VerticalLabelView_textColor, 0xff000000));
        int i = context.getDimensionPixelOffset(a.VerticalLabelView_textSize, 0);
        if (i > 0)
        {
            setTextSize(i);
        }
        context.recycle();
    }

    private final void a()
    {
        a = new TextPaint();
        a.setAntiAlias(true);
        a.setTextSize(15F);
        a.setColor(0xff000000);
        a.setTextAlign(android.graphics.Paint.Align.LEFT);
        setPadding(3, 3, 3, 3);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.save();
        canvas.rotate(-90F);
        canvas.translate(-d.width() - getPaddingRight(), 0.0F);
        canvas.drawText(b, 0.0F, -c, a);
        canvas.restore();
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        a.getTextBounds(b, 0, b.length(), d);
        int l = android.view.View.MeasureSpec.getMode(i);
        i = android.view.View.MeasureSpec.getSize(i);
        if (l != 0x40000000)
        {
            int k = d.height() + getPaddingLeft() + getPaddingRight();
            if (l == 0x80000000)
            {
                i = Math.min(k, i);
            } else
            {
                i = k;
            }
        }
        l = android.view.View.MeasureSpec.getMode(j);
        j = android.view.View.MeasureSpec.getSize(j);
        c = a.ascent();
        if (l != 0x40000000)
        {
            k = d.width() + getPaddingTop() + getPaddingBottom();
            if (l == 0x80000000)
            {
                j = Math.min(k, j);
            } else
            {
                j = k;
            }
        }
        setMeasuredDimension(i, j);
    }

    public void setText(String s)
    {
        b = s;
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i)
    {
        a.setColor(i);
        invalidate();
    }

    public void setTextSize(int i)
    {
        a.setTextSize(i);
        requestLayout();
        invalidate();
    }
}
