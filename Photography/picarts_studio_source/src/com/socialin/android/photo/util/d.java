// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.socialin.android.util.Utils;

public final class d extends Drawable
{

    public String a;
    private Drawable b;
    private Paint c;
    private Paint d;
    private int e;
    private int f;
    private int g;
    private Context h;
    private float i;
    private float j;

    public d(Drawable drawable, Context context)
    {
        a = "";
        f = 11;
        g = 15;
        h = null;
        i = 2.0F;
        j = 2.0F;
        h = context;
        e = (int)Utils.a(24F, context);
        f = (int)Utils.a(f, context);
        i = Utils.a(i, context);
        j = Utils.a(j, context);
        c = new Paint();
        c.setColor(-1);
        c.setTextSize(f);
        c.setAntiAlias(true);
        c.setFakeBoldText(true);
        c.setStyle(android.graphics.Paint.Style.FILL);
        d = new Paint(1);
        d.setColor(0xffff0000);
        d.setStyle(android.graphics.Paint.Style.FILL);
        b = drawable;
        setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicWidth());
    }

    public final void draw(Canvas canvas)
    {
        if (b != null)
        {
            b.draw(canvas);
        }
        if (!TextUtils.isEmpty(a))
        {
            Rect rect = b.getBounds();
            Rect rect1 = new Rect();
            c.getTextBounds(a, 0, a.length(), rect1);
            if (a.length() <= 2)
            {
                i = Utils.a(5F, h);
            }
            float f1 = rect.right - rect1.width();
            float f2 = (float)(e / 4) + c.getTextSize() / 4F + 2.0F;
            canvas.drawRoundRect(new RectF(f1 - i, f2 - (float)rect1.height() - j, (float)rect1.width() + f1 + i + 1.0F, j + f2 + 1.0F), 4F, 4F, d);
            canvas.drawText(a, f1, f2, c);
        }
    }

    public final int getIntrinsicHeight()
    {
        return e;
    }

    public final int getIntrinsicWidth()
    {
        return e + g;
    }

    public final int getMinimumHeight()
    {
        return e;
    }

    public final int getMinimumWidth()
    {
        return e + g;
    }

    public final int getOpacity()
    {
        return -3;
    }

    public final void setAlpha(int k)
    {
    }

    public final void setBounds(int k, int l, int i1, int j1)
    {
        super.setBounds(k, l, i1, j1);
        if (b != null)
        {
            b.setBounds(k, l, e, e);
        }
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
    }
}
