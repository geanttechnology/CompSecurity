// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class aso extends asq
{

    private boolean a;
    private boolean b;
    private boolean c;
    private int d;
    private boolean e;

    public aso()
    {
        a = false;
        b = false;
        c = false;
        d = 0;
        e = false;
    }

    public void a(int i)
    {
        c = true;
        d = i;
        a(2, Integer.valueOf(d));
    }

    public void a(boolean flag)
    {
        e = flag;
    }

    public void b(boolean flag)
    {
        b = flag;
        a(1, null);
    }

    public void c(boolean flag)
    {
        a = flag;
    }

    public boolean c()
    {
        return e;
    }

    public boolean d()
    {
        return c;
    }

    public int e()
    {
        return d;
    }

    public void f()
    {
        c = false;
        d = 0;
        a(2, Integer.valueOf(d));
    }

    public boolean g()
    {
        return b;
    }

    public boolean h()
    {
        return a;
    }
}
