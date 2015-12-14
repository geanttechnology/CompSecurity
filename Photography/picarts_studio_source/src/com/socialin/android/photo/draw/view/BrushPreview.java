// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.stroke.Stroke;

public class BrushPreview extends View
{

    private static final float a[] = {
        0.2F, 0.8F, 0.4F, 0.2F, 0.6F, 0.8F, 0.8F, 0.2F, 0.801F, 0.201F
    };
    private static final float b[];
    private static final float c[];
    private Stroke d;
    private Brush e;
    private com.socialin.android.brushlib.brush.Brush.Params f;
    private float g;
    private boolean h;
    private float i[];

    public BrushPreview(Context context)
    {
        super(context);
        f = new com.socialin.android.brushlib.brush.Brush.Params();
        g = 1.0F;
        i = new float[10];
    }

    public BrushPreview(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = new com.socialin.android.brushlib.brush.Brush.Params();
        g = 1.0F;
        i = new float[10];
    }

    public BrushPreview(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        f = new com.socialin.android.brushlib.brush.Brush.Params();
        g = 1.0F;
        i = new float[10];
    }

    private static float a(float f1, float f2, float f3)
    {
        return (-4F * f3 * f1 * f1) / 25F + (4F * f3 * f1) / 5F;
    }

    protected void onDraw(Canvas canvas)
    {
        if (d != null && e != null)
        {
            if (h)
            {
                f.setColorRGB(-1);
            }
            e.b(f);
            int j = f.getColor();
            float f1 = (float)Color.red(j) / 255F;
            float f2 = (float)Color.green(j) / 255F;
            if (((float)Color.blue(j) / 255F + (f1 + f2)) / 3F > 0.8F)
            {
                j = 0xff252525;
            } else
            {
                j = -1;
            }
            if (j != -1)
            {
                canvas.drawColor(0xff252525);
            }
            e.b(f);
            f1 = f.getThickness();
            f.setThickness(g * f1);
            e.a(f);
            e.a(d, canvas);
            f.setThickness(f1);
            e.a(f);
        }
    }

    protected void onSizeChanged(int j, int k, int l, int i1)
    {
        boolean flag = true;
        super.onSizeChanged(j, k, l, i1);
        l = getPaddingLeft();
        i1 = getPaddingTop();
        int j1 = getPaddingRight();
        int k1 = getPaddingBottom();
        Matrix matrix = new Matrix();
        matrix.setScale(j - l - j1, k - i1 - k1);
        matrix.postTranslate(l, i1);
        d = Stroke.obtain();
        matrix.mapPoints(i, a);
        k = i.length / 2;
        d.setStartPoint(i[0], i[1], b[0], c[0]);
        for (j = ((flag) ? 1 : 0); j < k; j++)
        {
            d.addPoint(i[j * 2], i[j * 2 + 1], b[j], c[j]);
        }

    }

    public void setBrush(Brush brush)
    {
        e = brush;
    }

    public void setBrushParams(com.socialin.android.brushlib.brush.Brush.Params params)
    {
        e.a(params);
        f.set(params);
    }

    public void setEraserModeOn(boolean flag)
    {
        h = flag;
    }

    public void setScale(float f1)
    {
        g = f1;
    }

    static 
    {
        c = new float[5];
        b = new float[5];
        for (int j = 0; j < 5; j++)
        {
            c[j] = a(j, 5F, 0.3F);
            b[j] = a(j, 5F, -8F) + 8F;
        }

    }
}
