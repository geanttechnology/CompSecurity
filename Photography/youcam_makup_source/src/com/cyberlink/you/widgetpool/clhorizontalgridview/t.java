// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.cyberlink.you.n;

public class t
{

    private final int A;
    private final int B;
    private final int C;
    private final Drawable a;
    private final Drawable b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final int g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private long t;
    private float u;
    private final Interpolator v = new DecelerateInterpolator();
    private int w;
    private float x;
    private final Rect y = new Rect();
    private final int z;

    public t(Context context)
    {
        w = 0;
        context = context.getResources();
        a = context.getDrawable(n.u_overscroll_edge_h);
        b = context.getDrawable(n.u_overscroll_glow_h);
        z = a.getIntrinsicWidth();
        A = b.getIntrinsicHeight();
        B = b.getIntrinsicWidth();
        C = (int)(Math.min((((float)B * 4F * (float)B) / (float)A) * 0.6F, (float)B * 4F) + 0.5F);
        g = (int)(context.getDisplayMetrics().density * 300F + 0.5F);
    }

    private void d()
    {
        float f1;
        float f3;
        f1 = Math.min((float)(AnimationUtils.currentAnimationTimeMillis() - t) / u, 1.0F);
        f3 = v.getInterpolation(f1);
        h = l + (m - l) * f3;
        i = n + (o - n) * f3;
        j = p + (q - p) * f3;
        k = r + (s - r) * f3;
        if (f1 < 0.999F) goto _L2; else goto _L1
_L1:
        w;
        JVM INSTR tableswitch 1 4: default 152
    //                   1 224
    //                   2 153
    //                   3 352
    //                   4 295;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        return;
_L4:
        w = 3;
        t = AnimationUtils.currentAnimationTimeMillis();
        u = 1000F;
        l = h;
        n = i;
        p = j;
        r = k;
        m = 0.0F;
        o = 0.0F;
        q = 0.0F;
        s = 0.0F;
        return;
_L3:
        w = 4;
        t = AnimationUtils.currentAnimationTimeMillis();
        u = 1000F;
        l = h;
        n = i;
        p = j;
        r = k;
        m = 0.0F;
        o = 0.0F;
        q = 0.0F;
        s = 0.0F;
        return;
_L6:
        float f2;
        float f4;
        if (s != 0.0F)
        {
            f2 = 1.0F / (s * s);
        } else
        {
            f2 = 3.402823E+38F;
        }
        f4 = n;
        i = f2 * (f3 * (o - n)) + f4;
        w = 3;
        return;
_L5:
        w = 0;
        return;
    }

    public Rect a(boolean flag)
    {
        int i1 = 0;
        y.set(0, 0, C, d);
        Rect rect = y;
        int j1 = e;
        if (flag)
        {
            i1 = C;
        }
        rect.offset(j1 - i1, f);
        return y;
    }

    public void a(float f1)
    {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        if (w == 4 && (float)(l1 - t) < u)
        {
            return;
        }
        if (w != 1)
        {
            k = 1.0F;
        }
        w = 1;
        t = l1;
        u = 167F;
        x = x + f1;
        float f2 = Math.abs(x);
        float f3 = Math.max(0.6F, Math.min(f2, 1.0F));
        l = f3;
        h = f3;
        f2 = Math.max(0.5F, Math.min(f2 * 7F, 1.0F));
        n = f2;
        i = f2;
        f2 = Math.min(1.0F, j + Math.abs(f1) * 1.1F);
        p = f2;
        j = f2;
        f3 = Math.abs(f1);
        f2 = f3;
        if (f1 > 0.0F)
        {
            f2 = f3;
            if (x < 0.0F)
            {
                f2 = -f3;
            }
        }
        if (x == 0.0F)
        {
            k = 0.0F;
        }
        f1 = Math.min(4F, Math.max(0.0F, f2 * 7F + k));
        r = f1;
        k = f1;
        m = h;
        o = i;
        q = j;
        s = k;
    }

    public void a(int i1)
    {
        w = 2;
        i1 = Math.max(100, Math.abs(i1));
        t = AnimationUtils.currentAnimationTimeMillis();
        u = 0.1F + (float)i1 * 0.03F;
        l = 0.0F;
        n = 0.0F;
        i = 0.0F;
        p = 0.5F;
        r = 0.0F;
        m = Math.max(0, Math.min(i1 * 8, 1));
        o = Math.max(0.5F, Math.min(i1 * 8, 1.0F));
        s = Math.min(0.025F + (float)((i1 / 100) * i1) * 0.00015F, 1.75F);
        q = Math.max(p, Math.min((float)(i1 * 16) * 1E-05F, 1.0F));
    }

    public void a(int i1, int j1)
    {
        c = i1;
        d = j1;
    }

    public boolean a()
    {
        return w == 0;
    }

    public boolean a(Canvas canvas)
    {
        boolean flag = false;
        d();
        b.setAlpha((int)(Math.max(0.0F, Math.min(j, 1.0F)) * 255F));
        int i1 = (int)Math.min((((float)B * k * (float)B) / (float)A) * 0.6F, (float)B * 4F);
        int k1;
        if (d < g)
        {
            int j1 = (d - g) / 2;
            b.setBounds(0, j1, i1, d - j1);
        } else
        {
            b.setBounds(0, 0, i1, d);
        }
        b.draw(canvas);
        a.setAlpha((int)(Math.max(0.0F, Math.min(h, 1.0F)) * 255F));
        k1 = (int)((float)z * i);
        if (d < g)
        {
            int l1 = (d - g) / 2;
            a.setBounds(0, l1, k1, d - l1);
        } else
        {
            a.setBounds(0, 0, k1, d);
        }
        a.draw(canvas);
        if (w == 3 && i1 == 0 && k1 == 0)
        {
            w = 0;
        }
        if (w != 0)
        {
            flag = true;
        }
        return flag;
    }

    public void b()
    {
        w = 0;
    }

    void b(int i1, int j1)
    {
        e = i1;
        f = j1;
    }

    public void c()
    {
        x = 0.0F;
        if (w != 1 && w != 4)
        {
            return;
        } else
        {
            w = 3;
            l = h;
            n = i;
            p = j;
            r = k;
            m = 0.0F;
            o = 0.0F;
            q = 0.0F;
            s = 0.0F;
            t = AnimationUtils.currentAnimationTimeMillis();
            u = 1000F;
            return;
        }
    }
}
