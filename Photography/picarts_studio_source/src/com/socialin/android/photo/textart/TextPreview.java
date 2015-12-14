// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class TextPreview extends AutoCompleteTextView
{

    int a;
    private final Rect b = new Rect();
    private final Paint c = new Paint(1);
    private final Paint d = new Paint(1);
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;

    public TextPreview(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c.setStyle(android.graphics.Paint.Style.FILL);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeWidth(1.0F);
    }

    protected void onDraw(Canvas canvas)
    {
        if (getWidth() == 0) goto _L2; else goto _L1
_L1:
        float f1;
        int j1;
        f1 = c.getTextSize();
        j1 = getWidth();
        if (j1 == 0) goto _L2; else goto _L3
_L3:
        TextPaint textpaint;
        String as[];
        int j;
        int l;
        int k1;
        textpaint = new TextPaint();
        textpaint.setTextSize(f1);
        as = getText().toString().split("\n");
        k1 = as.length;
        l = 0;
        j = 0;
_L5:
        String s;
        if (l >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[l];
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        j++;
_L7:
        l++;
        if (true) goto _L5; else goto _L4
_L8:
        int k;
        j = k;
        int i1;
        if (i1 >= s.length()) goto _L7; else goto _L6
_L6:
        if (i1 != s.length())
        {
            j = textpaint.breakText(s, i1, s.length(), true, j1, null);
            k++;
            i1 = j + i1;
        }
          goto _L8
_L4:
        if (j == 1)
        {
            a = getHeight() / 2;
        } else
        {
            a = getHeight() / 2 + b.height() * j;
        }
_L2:
        c.getTextBounds(getText().toString(), 0, getText().toString().length(), b);
        if (f)
        {
            c.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, a, g, h, android.graphics.Shader.TileMode.CLAMP));
        } else
        {
            c.setColor(g);
            c.setShader(new LinearGradient(0.0F, 0.0F, 0.0F, a, g, g, android.graphics.Shader.TileMode.CLAMP));
            setTextColor(g);
        }
        textpaint = new TextPaint(c);
        super.getPaint().set(textpaint);
        super.onDraw(canvas);
        if (e)
        {
            super.getPaint().set(d);
            setTextColor(i);
            if (TextUtils.isEmpty(getText().toString()))
            {
                setHintTextColor(i);
            }
            super.onDraw(canvas);
        }
        return;
        i1 = 0;
        k = j;
          goto _L8
    }

    public void setFillColor(int j)
    {
        g = j;
    }

    public void setGradientEnabled(boolean flag, int j)
    {
        f = flag;
        if (flag)
        {
            h = j;
        }
    }

    public void setStrokeEnabled(boolean flag, int j)
    {
        e = flag;
        i = j;
        if (flag)
        {
            d.setColor(j);
        }
    }

    public void setTextHeight(int j)
    {
        a = j;
    }

    public void setTextSize(int j)
    {
        c.setTextSize(j);
        d.setTextSize(j);
    }

    public final void setTypeFace(Typeface typeface)
    {
        c.setTypeface(typeface);
        d.setTypeface(typeface);
        super.setTypeface(typeface);
    }
}
