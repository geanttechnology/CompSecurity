// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

abstract class m extends Drawable
{

    private static final float b = (float)Math.toRadians(45D);
    private final Paint a = new Paint();
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final boolean h;
    private final Path i = new Path();
    private final int j;
    private boolean k;
    private float l;
    private float m;
    private float n;

    m(Context context)
    {
        k = false;
        context = context.getTheme().obtainStyledAttributes(null, android.support.v7.br.k.DrawerArrowToggle, android.support.v7.br.a.drawerArrowStyle, android.support.v7.br.j.Base_Widget_AppCompat_DrawerArrowToggle);
        a.setAntiAlias(true);
        a.setColor(context.getColor(android.support.v7.br.k.DrawerArrowToggle_color, 0));
        j = context.getDimensionPixelSize(android.support.v7.br.k.DrawerArrowToggle_drawableSize, 0);
        e = Math.round(context.getDimension(android.support.v7.br.k.DrawerArrowToggle_barSize, 0.0F));
        d = Math.round(context.getDimension(android.support.v7.br.k.DrawerArrowToggle_topBottomBarArrowSize, 0.0F));
        c = context.getDimension(android.support.v7.br.k.DrawerArrowToggle_thickness, 0.0F);
        g = Math.round(context.getDimension(android.support.v7.br.k.DrawerArrowToggle_gapBetweenBars, 0.0F));
        h = context.getBoolean(android.support.v7.br.k.DrawerArrowToggle_spinBars, true);
        f = context.getDimension(android.support.v7.br.k.DrawerArrowToggle_middleBarArrowSize, 0.0F);
        n = ((int)((float)j - c * 3F - g * 2.0F) / 4) * 2;
        n = (float)((double)n + ((double)c * 1.5D + (double)g));
        context.recycle();
        a.setStyle(android.graphics.Paint.Style.STROKE);
        a.setStrokeJoin(android.graphics.Paint.Join.MITER);
        a.setStrokeCap(android.graphics.Paint.Cap.BUTT);
        a.setStrokeWidth(c);
        m = (float)((double)(c / 2.0F) * Math.cos(b));
    }

    private static float a(float f1, float f2, float f3)
    {
        return (f2 - f1) * f3 + f1;
    }

    protected void a(boolean flag)
    {
        k = flag;
    }

    abstract boolean a();

    public void b(float f1)
    {
        l = f1;
        invalidateSelf();
    }

    public void draw(Canvas canvas)
    {
        boolean flag;
        Rect rect = getBounds();
        flag = a();
        float f5 = a(e, d, l);
        float f3 = a(e, f, l);
        float f4 = Math.round(a(0.0F, m, l));
        float f6 = a(0.0F, b, l);
        float f1;
        float f2;
        float f7;
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = -180F;
        }
        if (flag)
        {
            f2 = 180F;
        } else
        {
            f2 = 0.0F;
        }
        f1 = a(f1, f2, l);
        f2 = Math.round((double)f5 * Math.cos(f6));
        f5 = Math.round((double)f5 * Math.sin(f6));
        i.rewind();
        f6 = a(g + c, -m, l);
        f7 = -f3 / 2.0F;
        i.moveTo(f7 + f4, 0.0F);
        i.rLineTo(f3 - f4 * 2.0F, 0.0F);
        i.moveTo(f7, f6);
        i.rLineTo(f2, f5);
        i.moveTo(f7, -f6);
        i.rLineTo(f2, -f5);
        i.close();
        canvas.save();
        canvas.translate(rect.centerX(), n);
        if (!h) goto _L2; else goto _L1
_L1:
        int i1;
        if (k ^ flag)
        {
            i1 = -1;
        } else
        {
            i1 = 1;
        }
        canvas.rotate((float)i1 * f1);
_L4:
        canvas.drawPath(i, a);
        canvas.restore();
        return;
_L2:
        if (flag)
        {
            canvas.rotate(180F);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getIntrinsicHeight()
    {
        return j;
    }

    public int getIntrinsicWidth()
    {
        return j;
    }

    public int getOpacity()
    {
        return -3;
    }

    public boolean isAutoMirrored()
    {
        return true;
    }

    public void setAlpha(int i1)
    {
        a.setAlpha(i1);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        a.setColorFilter(colorfilter);
    }

}
