// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.c;

import android.graphics.Matrix;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class a extends Animation
{

    private int a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private float w;
    private float x;
    private float y;
    private float z;

    public a(float f1, float f2, float f3, float f4, float f5, float f6, float f7, 
            float f8, int i1, float f9, int j1, float f10)
    {
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0.0F;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        q = 0;
        r = 0;
        s = 0;
        t = 0;
        u = 0;
        v = 0;
        w = 0.0F;
        x = 0.0F;
        e = f1;
        f = f2;
        g = f3;
        h = f4;
        a = 2;
        b = 2;
        c = 2;
        d = 2;
        m = f5;
        n = f6;
        o = f7;
        p = f8;
        w = f9;
        u = i1;
        x = f10;
        v = j1;
        a();
    }

    private void a()
    {
        if (u == 0)
        {
            y = w;
        }
        if (v == 0)
        {
            z = x;
        }
    }

    float a(float f1, int i1, int j1, int k1, int l1)
    {
label0:
        {
            if (i1 == 6)
            {
                f1 = TypedValue.complexToFraction(j1, k1, l1);
                if (k1 != 0)
                {
                    break label0;
                }
                f1 = 1.0F;
            }
            return f1;
        }
        return f1 / (float)k1;
    }

    protected void applyTransformation(float f1, Transformation transformation)
    {
label0:
        {
            float f4 = 1.0F;
            float f2 = i;
            float f3 = k;
            if (i != j)
            {
                f2 = i + (j - i) * f1;
            }
            if (k != l)
            {
                f3 = k + (l - k) * f1;
            }
            transformation.getMatrix().setTranslate(f2, f3);
            float f5 = y + f2;
            float f6 = f3 + z;
            float f7 = getScaleFactor();
            if (m != 1.0F || n != 1.0F)
            {
                f2 = m + (n - m) * f1;
            } else
            {
                f2 = 1.0F;
            }
            if (o == 1.0F)
            {
                f3 = f4;
                if (p == 1.0F)
                {
                    break label0;
                }
            }
            f3 = o + (p - o) * f1;
        }
        if (f5 == 0.0F && f6 == 0.0F)
        {
            transformation.getMatrix().postScale(f2, f3);
            return;
        } else
        {
            transformation.getMatrix().postScale(f2, f3, f5 * f7, f6 * f7);
            return;
        }
    }

    public void initialize(int i1, int j1, int k1, int l1)
    {
        super.initialize(i1, j1, k1, l1);
        i = resolveSize(a, e, i1, k1);
        j = resolveSize(b, f, i1, k1);
        k = resolveSize(c, g, j1, l1);
        l = resolveSize(d, h, j1, l1);
        m = a(m, a, q, i1, k1);
        n = a(n, b, r, i1, k1);
        o = a(o, c, s, j1, l1);
        p = a(p, d, t, j1, l1);
        y = resolveSize(u, w, i1, k1);
        z = resolveSize(v, x, j1, l1);
    }
}
