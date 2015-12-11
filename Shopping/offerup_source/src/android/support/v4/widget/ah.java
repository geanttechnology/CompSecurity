// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.b.a;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.widget:
//            ak, al, ai, aj

final class ah extends Drawable
    implements Animatable
{

    private static final Interpolator b = new LinearInterpolator();
    private static final Interpolator c = new a();
    boolean a;
    private final int d[] = {
        0xff000000
    };
    private final ArrayList e = new ArrayList();
    private final al f;
    private float g;
    private Resources h;
    private View i;
    private Animation j;
    private float k;
    private double l;
    private double m;
    private final android.graphics.drawable.Drawable.Callback n = new ak(this);

    public ah(Context context, View view)
    {
        i = view;
        h = context.getResources();
        f = new al(n);
        f.a(d);
        a(1);
        context = f;
        view = new ai(this, context);
        view.setRepeatCount(-1);
        view.setRepeatMode(1);
        view.setInterpolator(b);
        view.setAnimationListener(new aj(this, context));
        j = view;
    }

    static float a(ah ah1)
    {
        return ah1.k;
    }

    static float a(ah ah1, float f1)
    {
        ah1.k = f1;
        return f1;
    }

    static float a(ah ah1, al al1)
    {
        return a(al1);
    }

    private static float a(al al1)
    {
        return (float)Math.toRadians((double)al1.d() / (6.2831853071795862D * al1.j()));
    }

    static Interpolator a()
    {
        return c;
    }

    private void a(double d1, double d2, double d3, double d4, float f1, float f2)
    {
        al al1 = f;
        float f3 = h.getDisplayMetrics().density;
        l = (double)f3 * d1;
        m = (double)f3 * d2;
        al1.a((float)d4 * f3);
        al1.a((double)f3 * d3);
        al1.c(0);
        al1.a(f1 * f3, f3 * f2);
        al1.a((int)l, (int)m);
    }

    private void a(float f1, al al1)
    {
        if (f1 > 0.75F)
        {
            f1 = (f1 - 0.75F) / 0.25F;
            int i1 = al1.h();
            int i2 = al1.a();
            int l1 = Integer.valueOf(i1).intValue();
            i1 = l1 >>> 24;
            int j1 = l1 >> 16 & 0xff;
            int k1 = l1 >> 8 & 0xff;
            l1 &= 0xff;
            i2 = Integer.valueOf(i2).intValue();
            int j2 = (int)((float)((i2 >>> 24) - i1) * f1);
            int k2 = (int)((float)((i2 >> 16 & 0xff) - j1) * f1);
            int l2 = (int)((float)((i2 >> 8 & 0xff) - k1) * f1);
            al1.b((int)(f1 * (float)((i2 & 0xff) - l1)) + l1 | (i1 + j2 << 24 | j1 + k2 << 16 | l2 + k1 << 8));
        }
    }

    static void a(ah ah1, float f1, al al1)
    {
        ah1.a(f1, al1);
        float f2 = (float)(Math.floor(al1.k() / 0.8F) + 1.0D);
        float f3 = a(al1);
        float f4 = al1.f();
        al1.b((al1.g() - f3 - al1.f()) * f1 + f4);
        al1.c(al1.g());
        f3 = al1.k();
        al1.d((f2 - al1.k()) * f1 + f3);
    }

    static void b(ah ah1, float f1, al al1)
    {
        ah1.a(f1, al1);
    }

    public final void a(float f1)
    {
        f.e(f1);
    }

    public final void a(float f1, float f2)
    {
        f.b(0.0F);
        f.c(f2);
    }

    public final void a(int i1)
    {
        if (i1 == 0)
        {
            a(56D, 56D, 12.5D, 3D, 12F, 6F);
            return;
        } else
        {
            a(40D, 40D, 8.75D, 2.5D, 10F, 5F);
            return;
        }
    }

    public final void a(boolean flag)
    {
        f.a(flag);
    }

    public final transient void a(int ai1[])
    {
        f.a(ai1);
        f.c(0);
    }

    public final void b(float f1)
    {
        f.d(f1);
    }

    public final void b(int i1)
    {
        f.a(i1);
    }

    final void c(float f1)
    {
        g = f1;
        invalidateSelf();
    }

    public final void draw(Canvas canvas)
    {
        Rect rect = getBounds();
        int i1 = canvas.save();
        canvas.rotate(g, rect.exactCenterX(), rect.exactCenterY());
        f.a(canvas, rect);
        canvas.restoreToCount(i1);
    }

    public final int getAlpha()
    {
        return f.c();
    }

    public final int getIntrinsicHeight()
    {
        return (int)m;
    }

    public final int getIntrinsicWidth()
    {
        return (int)l;
    }

    public final int getOpacity()
    {
        return -3;
    }

    public final boolean isRunning()
    {
        ArrayList arraylist = e;
        int j1 = arraylist.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            Animation animation = (Animation)arraylist.get(i1);
            if (animation.hasStarted() && !animation.hasEnded())
            {
                return true;
            }
        }

        return false;
    }

    public final void setAlpha(int i1)
    {
        f.d(i1);
    }

    public final void setColorFilter(ColorFilter colorfilter)
    {
        f.a(colorfilter);
    }

    public final void start()
    {
        j.reset();
        f.l();
        if (f.i() != f.e())
        {
            a = true;
            j.setDuration(666L);
            i.startAnimation(j);
            return;
        } else
        {
            f.c(0);
            f.m();
            j.setDuration(1332L);
            i.startAnimation(j);
            return;
        }
    }

    public final void stop()
    {
        i.clearAnimation();
        c(0.0F);
        f.a(false);
        f.c(0);
        f.m();
    }

}
