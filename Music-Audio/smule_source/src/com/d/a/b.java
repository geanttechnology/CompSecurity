// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.List;

public class b
{

    protected Bitmap a;
    public float b;
    public float c;
    public float d;
    public int e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    protected long l;
    private Matrix m;
    private Paint n;
    private float o;
    private float p;
    private float q;
    private long r;
    private int s;
    private int t;
    private List u;

    protected b()
    {
        d = 1.0F;
        e = 255;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0.0F;
        m = new Matrix();
        n = new Paint();
    }

    public b(Bitmap bitmap)
    {
        this();
        a = bitmap;
    }

    public b a(long l1, List list)
    {
        l = l1;
        u = list;
        return this;
    }

    public void a()
    {
        d = 1.0F;
        e = 255;
    }

    public void a(long l1, float f1, float f2)
    {
        s = a.getWidth() / 2;
        t = a.getHeight() / 2;
        o = f1 - (float)s;
        p = f2 - (float)t;
        b = o;
        c = p;
        r = l1;
    }

    public void a(Canvas canvas)
    {
        m.reset();
        m.postRotate(q, s, t);
        m.postScale(d, d, s, t);
        m.postTranslate(b, c);
        n.setAlpha(e);
        canvas.drawBitmap(a, m, n);
    }

    public boolean a(long l1)
    {
        l1 -= l;
        if (l1 > r)
        {
            return false;
        }
        b = o + h * (float)l1 + j * (float)l1 * (float)l1;
        c = p + i * (float)l1 + k * (float)l1 * (float)l1;
        q = f + (g * (float)l1) / 1000F;
        int i1 = 0;
        do
        {
            if (i1 >= u.size())
            {
                return true;
            }
            ((com.d.a.b.b)u.get(i1)).a(this, l1);
            i1++;
        } while (true);
    }
}
