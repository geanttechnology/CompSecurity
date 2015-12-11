// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.Interpolator;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            j

public final class i extends Drawable
    implements Animatable
{

    private Interpolator a;
    private Rect b;
    private Paint c;
    private int d[];
    private int e;
    private boolean f;
    private float g;
    private int h;
    private int i;
    private float j;
    private boolean k;
    private boolean l;
    private boolean m;
    private final Runnable n;

    private i(Interpolator interpolator, int i1, int j1, int ai[], int k1, float f1, boolean flag, 
            boolean flag1)
    {
        n = new j(this);
        f = false;
        a = interpolator;
        i = i1;
        h = j1;
        j = f1;
        k = flag;
        d = ai;
        e = 0;
        m = flag1;
        c = new Paint();
        c.setStrokeWidth(k1);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setDither(false);
        c.setAntiAlias(false);
    }

    i(Interpolator interpolator, int i1, int j1, int ai[], int k1, float f1, boolean flag, 
            boolean flag1, byte byte0)
    {
        this(interpolator, i1, j1, ai, k1, f1, flag, flag1);
    }

    static float a(i i1)
    {
        return i1.j;
    }

    static float a(i i1, float f1)
    {
        f1 = i1.g + f1;
        i1.g = f1;
        return f1;
    }

    static float b(i i1)
    {
        return i1.g;
    }

    static int c(i i1)
    {
        return i1.i;
    }

    static boolean d(i i1)
    {
        i1.l = true;
        return true;
    }

    static float e(i i1)
    {
        i1.g = 0.0F;
        return 0.0F;
    }

    static Runnable f(i i1)
    {
        return i1.n;
    }

    public final void draw(Canvas canvas)
    {
        b = getBounds();
        canvas.clipRect(b);
        int i1 = b.width();
        if (k)
        {
            canvas.translate(i1, 0.0F);
            canvas.scale(-1F, 1.0F);
        }
        int j1 = b.width();
        if (m)
        {
            j1 /= 2;
        }
        int j2 = h + j1 + i;
        int k2 = b.centerY();
        float f4 = 1.0F / (float)i;
        if (l)
        {
            int k1 = e - 1;
            i1 = k1;
            if (k1 < 0)
            {
                i1 = d.length - 1;
            }
            e = i1;
            l = false;
        }
        i1 = e;
        int l1 = 0;
        float f1 = 0.0F;
        do
        {
            while (l1 <= i) 
            {
                float f3 = (float)l1 * f4 + g;
                float f2 = Math.max(0.0F, f3 - f4);
                f3 = (int)(Math.abs(a.getInterpolation(f2) - a.getInterpolation(Math.min(f3, 1.0F))) * (float)j2);
                if (f3 + f2 < (float)j2)
                {
                    f2 = Math.min(f3, h);
                } else
                {
                    f2 = 0.0F;
                }
                if (f3 > f2)
                {
                    f3 -= f2;
                } else
                {
                    f3 = 0.0F;
                }
                f3 = f1 + f3;
                if (f3 > f1)
                {
                    f1 = Math.min(j1, f1);
                    float f5 = k2;
                    float f6 = Math.min(j1, f3);
                    float f7 = k2;
                    c.setColor(d[i1]);
                    int i2;
                    if (!m)
                    {
                        canvas.drawLine(f1, f5, f6, f7, c);
                    } else
                    if (k)
                    {
                        canvas.drawLine((float)j1 + f1, f5, (float)j1 + f6, f7, c);
                        canvas.drawLine((float)j1 - f1, f5, (float)j1 - f6, f7, c);
                    } else
                    {
                        canvas.drawLine(f1, f5, f6, f7, c);
                        canvas.drawLine((float)(j1 * 2) - f1, f5, (float)(j1 * 2) - f6, f7, c);
                    }
                    canvas.save();
                }
                i2 = i1 + 1;
                i1 = i2;
                if (i2 >= d.length)
                {
                    i1 = 0;
                }
                l1++;
                f1 = f3 + f2;
            }
            return;
        } while (true);
    }

    public final int getOpacity()
    {
        return -2;
    }

    public final boolean isRunning()
    {
        return f;
    }

    public final void scheduleSelf(Runnable runnable, long l1)
    {
        f = true;
        super.scheduleSelf(runnable, l1);
    }

    public final void setAlpha(int i1)
    {
        c.setAlpha(i1);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        c.setColorFilter(colorfilter);
    }

    public final void start()
    {
        if (isRunning())
        {
            return;
        } else
        {
            scheduleSelf(n, SystemClock.uptimeMillis() + 16L);
            invalidateSelf();
            return;
        }
    }

    public final void stop()
    {
        if (!isRunning())
        {
            return;
        } else
        {
            f = false;
            unscheduleSelf(n);
            return;
        }
    }
}
