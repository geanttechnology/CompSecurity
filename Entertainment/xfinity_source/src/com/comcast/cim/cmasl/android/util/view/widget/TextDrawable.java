// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;

public class TextDrawable extends Drawable
{

    private final android.text.TextUtils.TruncateAt ellipsizeWhere;
    private final int hPad;
    private final boolean isCenteredH;
    private final boolean isCenteredV;
    private final TextPaint paint = new TextPaint();
    private final int pixelFormat;
    private final String text;
    private final int vPad;

    public TextDrawable(Context context, String s, int i, float f, int j, int k, boolean flag, 
            int l, boolean flag1, android.text.TextUtils.TruncateAt truncateat)
    {
        text = s;
        pixelFormat = j;
        hPad = k;
        isCenteredH = flag;
        vPad = l;
        isCenteredV = flag1;
        ellipsizeWhere = truncateat;
        paint.setColor(i);
        paint.setTextSize(f);
        s = paint;
        if (flag)
        {
            context = android.graphics.Paint.Align.CENTER;
        } else
        {
            context = android.graphics.Paint.Align.LEFT;
        }
        s.setTextAlign(context);
        paint.setAntiAlias(true);
    }

    public void draw(Canvas canvas)
    {
        int i = 0;
        Rect rect = canvas.getClipBounds();
        rect.left = rect.left + hPad;
        rect.right = rect.right - hPad;
        rect.top = rect.top + vPad;
        rect.bottom = rect.bottom - vPad;
        canvas.clipRect(rect);
        Object obj = new Rect();
        paint.getTextBounds(text, 0, text.length(), ((Rect) (obj)));
        String s = text;
        if (((Rect) (obj)).width() > rect.width())
        {
            s = TextUtils.ellipsize(text, paint, rect.width(), ellipsizeWhere).toString();
        }
        if (isCenteredH)
        {
            i = rect.centerX();
        }
        obj = paint.getFontMetricsInt();
        int j;
        if (isCenteredV)
        {
            j = rect.centerY() - (((android.graphics.Paint.FontMetricsInt) (obj)).top + ((android.graphics.Paint.FontMetricsInt) (obj)).bottom) / 2;
        } else
        {
            j = -((android.graphics.Paint.FontMetricsInt) (obj)).top;
        }
        canvas.drawText(s, i, j, paint);
    }

    public int getOpacity()
    {
        return pixelFormat;
    }

    public void setAlpha(int i)
    {
        paint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        paint.setColorFilter(colorfilter);
    }
}
