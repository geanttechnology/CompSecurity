// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.drawable.DrawableWrapper;

final class an extends DrawableWrapper
{

    private static double c = Math.cos(Math.toRadians(45D));
    float a;
    float b;
    private Paint d;
    private Paint e;
    private RectF f;
    private float g;
    private Path h;
    private float i;
    private boolean j;
    private final int k;
    private final int l;
    private final int m;
    private boolean n;
    private boolean o;

    public an(Resources resources, Drawable drawable, float f1, float f2, float f3)
    {
        super(drawable);
        j = true;
        n = true;
        o = false;
        k = resources.getColor(0x7f0e009b);
        l = resources.getColor(0x7f0e009a);
        m = resources.getColor(0x7f0e0099);
        d = new Paint(5);
        d.setStyle(android.graphics.Paint.Style.FILL);
        g = Math.round(f1);
        f = new RectF();
        e = new Paint(d);
        e.setAntiAlias(false);
        a(f2, f3);
    }

    private static int a(float f1)
    {
        int j1 = Math.round(f1);
        int i1 = j1;
        if (j1 % 2 == 1)
        {
            i1 = j1 - 1;
        }
        return i1;
    }

    final void a(float f1, float f2)
    {
        if (f1 < 0.0F || f2 < 0.0F)
        {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float f3 = a(f1);
        f2 = a(f2);
        f1 = f3;
        if (f3 > f2)
        {
            if (!o)
            {
                o = true;
            }
            f1 = f2;
        }
        if (b == f1 && a == f2)
        {
            return;
        } else
        {
            b = f1;
            a = f2;
            i = Math.round(f1 * 1.5F);
            j = true;
            invalidateSelf();
            return;
        }
    }

    public final void a(boolean flag)
    {
        n = false;
        invalidateSelf();
    }

    public final void draw(Canvas canvas)
    {
        int j1;
        boolean flag;
        if (j)
        {
            Object obj = getBounds();
            float f1 = a * 1.5F;
            f.set((float)((Rect) (obj)).left + a, (float)((Rect) (obj)).top + f1, (float)((Rect) (obj)).right - a, (float)((Rect) (obj)).bottom - f1);
            getWrappedDrawable().setBounds((int)f.left, (int)f.top, (int)f.right, (int)f.bottom);
            obj = new RectF(-g, -g, g, g);
            RectF rectf = new RectF(((RectF) (obj)));
            rectf.inset(-i, -i);
            float f3;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            Paint paint1;
            int l1;
            int j2;
            if (h == null)
            {
                h = new Path();
            } else
            {
                h.reset();
            }
            h.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            h.moveTo(-g, 0.0F);
            h.rLineTo(-i, 0.0F);
            h.arcTo(rectf, 180F, 90F, false);
            h.arcTo(((RectF) (obj)), 270F, -90F, false);
            h.close();
            f1 = -rectf.top;
            if (f1 > 0.0F)
            {
                float f2 = g / f1;
                float f4 = (1.0F - f2) / 2.0F;
                Paint paint = d;
                int i1 = k;
                int k1 = l;
                int i2 = m;
                android.graphics.Shader.TileMode tilemode = android.graphics.Shader.TileMode.CLAMP;
                paint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] {
                    0, i1, k1, i2
                }, new float[] {
                    0.0F, f2, f2 + f4, 1.0F
                }, tilemode));
            }
            paint1 = e;
            f1 = ((RectF) (obj)).top;
            f3 = rectf.top;
            j1 = k;
            l1 = l;
            j2 = m;
            obj = android.graphics.Shader.TileMode.CLAMP;
            paint1.setShader(new LinearGradient(0.0F, f1, 0.0F, f3, new int[] {
                j1, l1, j2
            }, new float[] {
                0.0F, 0.5F, 1.0F
            }, ((android.graphics.Shader.TileMode) (obj))));
            e.setAntiAlias(false);
            j = false;
        }
        f1 = -g - i;
        f3 = g;
        if (f.width() - 2.0F * f3 > 0.0F)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (f.height() - 2.0F * f3 > 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f8 = b;
        f9 = b;
        f5 = b;
        f10 = b;
        f6 = b;
        f7 = b;
        f5 = f3 / ((f5 - f10 * 0.5F) + f3);
        f8 = f3 / ((f8 - f9 * 0.25F) + f3);
        f6 = f3 / (f3 + (f6 - f7));
        j2 = canvas.save();
        canvas.translate(f.left + f3, f.top + f3);
        canvas.scale(f5, f8);
        canvas.drawPath(h, d);
        if (j1 != 0)
        {
            canvas.scale(1.0F / f5, 1.0F);
            canvas.drawRect(0.0F, f1, f.width() - 2.0F * f3, -g, e);
        }
        canvas.restoreToCount(j2);
        j2 = canvas.save();
        canvas.translate(f.right - f3, f.bottom - f3);
        canvas.scale(f5, f6);
        canvas.rotate(180F);
        canvas.drawPath(h, d);
        if (j1 != 0)
        {
            canvas.scale(1.0F / f5, 1.0F);
            f7 = f.width();
            f9 = -g;
            canvas.drawRect(0.0F, f1, f7 - 2.0F * f3, i + f9, e);
        }
        canvas.restoreToCount(j2);
        j1 = canvas.save();
        canvas.translate(f.left + f3, f.bottom - f3);
        canvas.scale(f5, f6);
        canvas.rotate(270F);
        canvas.drawPath(h, d);
        if (flag)
        {
            canvas.scale(1.0F / f6, 1.0F);
            canvas.drawRect(0.0F, f1, f.height() - 2.0F * f3, -g, e);
        }
        canvas.restoreToCount(j1);
        j1 = canvas.save();
        canvas.translate(f.right - f3, f.top + f3);
        canvas.scale(f5, f8);
        canvas.rotate(90F);
        canvas.drawPath(h, d);
        if (flag)
        {
            canvas.scale(1.0F / f8, 1.0F);
            canvas.drawRect(0.0F, f1, f.height() - 2.0F * f3, -g, e);
        }
        canvas.restoreToCount(j1);
        super.draw(canvas);
    }

    public final int getOpacity()
    {
        return -3;
    }

    public final boolean getPadding(Rect rect)
    {
        float f1 = a;
        float f2 = g;
        float f3;
        int i1;
        int j1;
        if (n)
        {
            double d1 = f1 * 1.5F;
            double d3 = c;
            f1 = (float)((double)f2 * (1.0D - d3) + d1);
        } else
        {
            f1 *= 1.5F;
        }
        i1 = (int)Math.ceil(f1);
        f2 = a;
        f3 = g;
        f1 = f2;
        if (n)
        {
            double d2 = f2;
            double d4 = c;
            f1 = (float)((double)f3 * (1.0D - d4) + d2);
        }
        j1 = (int)Math.ceil(f1);
        rect.set(j1, i1, j1, i1);
        return true;
    }

    protected final void onBoundsChange(Rect rect)
    {
        j = true;
    }

    public final void setAlpha(int i1)
    {
        super.setAlpha(i1);
        d.setAlpha(i1);
        e.setAlpha(i1);
    }

}
