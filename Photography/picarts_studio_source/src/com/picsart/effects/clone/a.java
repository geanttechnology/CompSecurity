// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.TypedValue;

public final class a
{

    Point a;
    int b;
    Rect c;
    PointF d;
    boolean e;
    int f;
    private Paint g;
    private float h;
    private float i;

    public a(Context context, Point point, int j)
    {
        c = new Rect();
        new Point();
        d = null;
        e = true;
        f = -1;
        a = point;
        b = j;
        g = new Paint();
        g.setAntiAlias(true);
        g.setDither(true);
        g.setStyle(android.graphics.Paint.Style.STROKE);
        g.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        g.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        g.setStrokeWidth(4F);
        g.setFilterBitmap(true);
        g.setColor(0xff000000);
        h = TypedValue.applyDimension(1, 2.0F, context.getResources().getDisplayMetrics());
        i = h / 3F;
    }

    public final void a(int j, int k)
    {
        int l = a.x;
        int i1 = a.y;
        a.x = j;
        a.y = k;
        a(l, i1, b);
    }

    final void a(int j, int k, int l)
    {
        int i1 = Math.min(j - l - 4, a.x - b - 4);
        int j1 = Math.min(k - l - 4, a.y - b - 4);
        j = Math.max(j + l + 4, a.x + b + 4);
        k = Math.max(k + l + 4, a.y + b + 4);
        c.set(i1, j1, j, k);
    }

    public final void a(Canvas canvas)
    {
        if (!e)
        {
            return;
        } else
        {
            g.setColor(f);
            g.setStrokeWidth(h);
            canvas.drawCircle(a.x, a.y, (float)b - h / 2.0F, g);
            g.setColor(Color.argb(204, 0, 0, 0));
            g.setStrokeWidth((h * 2.0F) / 3F);
            canvas.drawCircle(a.x, a.y, (float)b - h / 3F - h, g);
            g.setColor(0xff000000);
            g.setStrokeWidth(i);
            canvas.drawLine(a.x - b / 6, (float)a.y - i / 2.0F, a.x + b / 6, (float)a.y - i / 2.0F, g);
            canvas.drawLine((float)a.x - i / 2.0F, a.y - b / 6, (float)a.x - i / 2.0F, a.y + b / 6, g);
            g.setColor(f);
            float f1 = a.x - b / 6;
            float f2 = a.y;
            float f3 = i / 2.0F;
            float f4 = a.x + b / 6;
            float f5 = a.y;
            canvas.drawLine(f1, f3 + f2, f4, i / 2.0F + f5, g);
            f1 = a.x;
            f2 = i / 2.0F;
            f3 = a.y - b / 6;
            f4 = a.x;
            canvas.drawLine(f2 + f1, f3, i / 2.0F + f4, a.y + b / 6, g);
            return;
        }
    }
}
