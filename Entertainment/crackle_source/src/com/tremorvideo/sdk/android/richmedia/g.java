// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Canvas;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            k, q, p, x, 
//            o

public class g
{

    public boolean a;
    private q b;
    private int c;
    private int d;
    private long e;
    private boolean f;
    private float g;
    private float h;
    private float i;
    private float j;

    public g(q q1)
    {
        a = false;
        b = q1;
        f = false;
        e = 0L;
    }

    private int a(p p1, k k1, int l)
    {
        int i1 = Math.round((((k1.a - b.a) + (float)l) - g) + i);
        int j1 = Math.round((float)i1 + k1.f);
        if ((float)i1 < p1.d() / -2F)
        {
            i1 = l + ((int)(p1.d() / -2F) - i1);
        } else
        {
            i1 = l;
            if ((float)j1 > p1.d() / 2.0F)
            {
                return l + ((int)(p1.d() / 2.0F) - j1);
            }
        }
        return i1;
    }

    private int b(p p1, k k1, int l)
    {
        int i1 = Math.round((((k1.b - b.b) + (float)l) - h) + j);
        int j1 = Math.round((float)i1 + k1.g);
        if ((float)i1 < p1.e() / -2F)
        {
            i1 = l + ((int)(p1.e() / -2F) - i1);
        } else
        {
            i1 = l;
            if ((float)j1 > p1.e() / 2.0F)
            {
                return l + ((int)(p1.e() / 2.0F) - j1);
            }
        }
        return i1;
    }

    private void d(p p1, int l, int i1)
    {
        c = l;
        d = i1;
        b.a = ((float)c - g) + i;
        b.b = ((float)d - h) + j;
    }

    public void a()
    {
        f = false;
        e = 0L;
        i = 0.0F;
        j = 0.0F;
        g = 0.0F;
        h = 0.0F;
        c = 0;
        d = 0;
        a = false;
        b.a = 0.0F;
        b.b = 0.0F;
    }

    public void a(long l)
    {
        if (b instanceof x)
        {
            o o1 = ((x)b).j();
            e = (e + l) % o1.c();
        }
    }

    public void a(p p1)
    {
        p1.c().save();
        if (f)
        {
            p1.c().translate(-g, -h);
            p1.c().translate(i, j);
            p1.c().translate(c, d);
        }
        b.a(p1, e);
        p1.c().restore();
    }

    public void a(p p1, int l, int i1)
    {
        k k1 = b.c(p1, e);
        d(p1, a(p1, k1, l), b(p1, k1, i1));
    }

    public void a(p p1, int l, int i1, long l1)
    {
        k k1 = b.c(p1, l1);
        if (!f)
        {
            f = true;
            e = l1;
            g = k1.a;
            h = k1.b;
            i = k1.a - (float)l;
            j = k1.b - (float)i1;
        } else
        {
            i = k1.a - (float)l;
            j = k1.b - (float)i1;
        }
        d(p1, l, i1);
    }

    public q b()
    {
        return b;
    }

    public void b(p p1, int l, int i1)
    {
        k k1 = b.c(p1, e);
        d(p1, a(p1, k1, l), b(p1, k1, i1));
    }

    public boolean c(p p1, int l, int i1)
    {
        p1 = b.c(p1, e);
        if ((float)l >= ((k) (p1)).a && (float)i1 >= ((k) (p1)).b && (float)l < ((k) (p1)).a + ((k) (p1)).f)
        {
            float f1 = i1;
            float f2 = ((k) (p1)).b;
            if (f1 < ((k) (p1)).g + f2)
            {
                return true;
            }
        }
        return false;
    }
}
