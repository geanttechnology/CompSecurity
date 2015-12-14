// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;


public class f
{

    private float a;
    private float b;
    private float c;
    private float d;
    private float e;

    public f(float f1, float f2, float f3, float f4)
    {
        e = 0.0F;
        a = f1;
        b = f2;
        c = f3;
        d = f4;
    }

    public f(float f1, float f2, float f3, float f4, float f5)
    {
        e = 0.0F;
        a = f1;
        b = f2;
        c = f3;
        d = f4;
        e = f5;
    }

    public f(f f1)
    {
        this(f1.a, f1.b, f1.c, f1.d, f1.e);
    }

    public float a()
    {
        return c;
    }

    public void a(float f1)
    {
        a = f1;
    }

    public float b()
    {
        return d;
    }

    public void b(float f1)
    {
        b = f1;
    }

    public void c(float f1)
    {
        c = f1;
    }

    public void d(float f1)
    {
        d = f1;
    }
}
