// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clone;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.TypedValue;

public final class a
{

    public static final int a = Color.argb(255, 51, 181, 229);
    public Point b;
    public Point c;
    public Paint d;
    public int e;
    public float f;
    public float g;
    public boolean h;
    public CloneDrawController.Mode i;
    private Point j;
    private boolean k;

    public a(Context context, Point point)
    {
        b = point;
        e = 50;
        d = new Paint();
        d.setAntiAlias(true);
        d.setDither(true);
        d.setStyle(android.graphics.Paint.Style.STROKE);
        d.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        d.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        d.setStrokeWidth(4F);
        d.setFilterBitmap(true);
        d.setColor(0xff000000);
        f = TypedValue.applyDimension(1, 2.0F, context.getResources().getDisplayMetrics());
        g = f / 3F;
        i = CloneDrawController.Mode.SOURCE;
        k = false;
    }

    public final Rect a()
    {
        Rect rect = new Rect();
        rect.set((int)((float)(b.x - e) - f), (int)((float)(b.y - e) - f), (int)((float)(b.x + e) + f), (int)((float)(b.y + e) + f));
        if (j != null)
        {
            rect.union((int)((float)(j.x - e) - f), (int)((float)(j.y - e) - f), (int)((float)(j.x + e) + f), (int)((float)(j.y + e) + f));
        }
        return rect;
    }

    public final void a(int l, int i1)
    {
        if (j == null)
        {
            j = new Point();
        }
        j.x = b.x;
        j.y = b.y;
        b.x = l;
        b.y = i1;
    }

}
