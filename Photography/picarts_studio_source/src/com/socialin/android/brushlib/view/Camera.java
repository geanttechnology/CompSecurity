// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public final class Camera
{

    private static float f = 1.0F;
    private static float g = 1.0F;
    private static float h = 1.0F;
    private static float i = 1.0F;
    private static float j = 1.0F;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    private final transient List k = new ArrayList();

    private Camera(float f1, float f2, float f3, float f4, float f5)
    {
        a(f1, f2);
        b(f3, f4);
        a(f5);
    }

    public static Camera a()
    {
        return new Camera(f, g, h, i, j);
    }

    public final Camera a(float f1)
    {
        e = f1;
        int l = 0;
        for (int i1 = k.size(); l < i1; l++)
        {
            k.get(l);
        }

        return this;
    }

    public final Camera a(float f1, float f2)
    {
        a = f1;
        b = f2;
        int l = 0;
        for (int i1 = k.size(); l < i1; l++)
        {
            k.get(l);
        }

        return this;
    }

    public final void a(Canvas canvas)
    {
        canvas.translate(a / 2.0F, b / 2.0F);
        canvas.scale(e, e);
        canvas.translate(-c, -d);
    }

    public final void a(PointF pointf, PointF pointf1)
    {
        pointf1.x = d(pointf.x);
        pointf1.y = e(pointf.y);
    }

    public final void a(RectF rectf)
    {
        rectf.left = b(rectf.left);
        rectf.top = c(rectf.top);
        rectf.right = b(rectf.right);
        rectf.bottom = c(rectf.bottom);
    }

    public final float b(float f1)
    {
        return (f1 - c) * e + a / 2.0F;
    }

    public final int b(Canvas canvas)
    {
        int l = canvas.save();
        a(canvas);
        return l;
    }

    public final Camera b(float f1, float f2)
    {
        c = f1;
        d = f2;
        b();
        return this;
    }

    public final void b()
    {
        int l = 0;
        for (int i1 = k.size(); l < i1; l++)
        {
            k.get(l);
        }

    }

    public final float c(float f1)
    {
        return (f1 - d) * e + b / 2.0F;
    }

    public final float d(float f1)
    {
        return (f1 - a / 2.0F) / e + c;
    }

    public final float e(float f1)
    {
        return (f1 - b / 2.0F) / e + d;
    }

}
