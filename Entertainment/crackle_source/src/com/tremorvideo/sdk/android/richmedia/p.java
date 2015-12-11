// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Canvas;
import com.tremorvideo.sdk.android.videoad.ad;

public class p
{

    Canvas a;
    m.a b;
    float c;
    float d;
    float e;
    public float f;
    public boolean g;
    public boolean h;
    public float i;
    public float j;
    public boolean k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;

    public p()
    {
        f = 1.0F;
        g = true;
        h = true;
        i = 1.0F;
        j = 1.0F;
        k = false;
    }

    public float a()
    {
        return f;
    }

    public float a(q.b b1)
    {
        if (b1 == q.b.b)
        {
            return Math.min(i, j);
        }
        if (b1 == q.b.c)
        {
            return Math.max(i, j);
        } else
        {
            return c;
        }
    }

    public void a(float f1, float f2, float f3, float f4, q.b b1, b.b b2)
    {
        if (b2 != b.b.b && b2 != b.b.e && b2 != b.b.h) goto _L2; else goto _L1
_L1:
        float f5 = f1 + f3 / 2.0F;
_L7:
        if (b2 != b.b.d && b2 != b.b.e && b2 != b.b.f) goto _L4; else goto _L3
_L3:
        f1 = f2 + f4 / 2.0F;
_L10:
        f2 = f();
        float f6 = g();
        f3 = a(b1) * f3;
        f4 = a(b1) * f4;
        n = f2 * f5;
        o = f6 * f1;
        if (b2 == b.b.b || b2 == b.b.e || b2 == b.b.h)
        {
            n = n - f3 / 2.0F;
        } else
        if (b2 == b.b.c || b2 == b.b.f || b2 == b.b.i)
        {
            n = n - f3;
        }
        if (b2 == b.b.d || b2 == b.b.e || b2 == b.b.f)
        {
            o = o - f4 / 2.0F;
        } else
        if (b2 == b.b.g || b2 == b.b.h || b2 == b.b.i)
        {
            o = o - f4;
        }
        p = f3;
        q = f4;
        return;
_L2:
        if (b2 == b.b.c || b2 == b.b.f) goto _L6; else goto _L5
_L5:
        f5 = f1;
        if (b2 != b.b.i) goto _L7; else goto _L6
_L6:
        f5 = f1 + f3;
          goto _L7
_L4:
        if (b2 == b.b.g || b2 == b.b.h) goto _L9; else goto _L8
_L8:
        f1 = f2;
        if (b2 != b.b.i) goto _L10; else goto _L9
_L9:
        f1 = f2 + f4;
          goto _L10
    }

    public void a(Canvas canvas)
    {
        k = true;
        try
        {
            a = canvas;
            l = canvas.getWidth();
            m = canvas.getHeight();
            d = 1.0F;
            e = 1.0F;
            c = 1.0F;
            i = 1.0F;
            j = 1.0F;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Canvas canvas)
        {
            ad.a(canvas);
        }
    }

    public void a(m.a a1, Canvas canvas, int i1, int j1)
    {
        k = true;
        b = a1;
        a = canvas;
        l = canvas.getWidth();
        m = canvas.getHeight();
        d = (float)canvas.getWidth() / (float)i1;
        e = (float)canvas.getHeight() / (float)j1;
        int k1 = Math.max(canvas.getWidth(), canvas.getHeight());
        int l1 = Math.min(canvas.getWidth(), canvas.getHeight());
        i = (float)k1 / (float)i1;
        j = (float)l1 / (float)j1;
        c = Math.min(d, e);
    }

    public m.a b()
    {
        return b;
    }

    public Canvas c()
    {
        return a;
    }

    public float d()
    {
        return l;
    }

    public float e()
    {
        return m;
    }

    public float f()
    {
        return d;
    }

    public float g()
    {
        return e;
    }

    public float h()
    {
        return n;
    }

    public float i()
    {
        return o;
    }

    public float j()
    {
        return Math.max(1.0F, p);
    }

    public float k()
    {
        return Math.max(1.0F, q);
    }
}
