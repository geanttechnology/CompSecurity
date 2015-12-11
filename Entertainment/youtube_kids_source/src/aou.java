// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class aou
    implements anm
{

    public int g;

    public aou()
    {
    }

    public void a(int i, Object obj)
    {
    }

    public abstract void a(long l1);

    public abstract void a(long l1, long l2);

    public void a(long l1, boolean flag)
    {
    }

    public boolean a()
    {
        return false;
    }

    public void b()
    {
    }

    final void b(long l1, boolean flag)
    {
        boolean flag1 = true;
        if (g != 1)
        {
            flag1 = false;
        }
        a.b(flag1);
        g = 2;
        a(l1, flag);
    }

    public void c()
    {
    }

    public abstract boolean d();

    public abstract boolean e();

    public abstract long f();

    public void g()
    {
    }

    public abstract int h();

    public void l()
    {
    }

    public abstract long m();

    public abstract long n();

    final int o()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (g == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a.b(flag);
            g = h();
            if (g != 0 && g != 1)
            {
                flag = flag1;
                if (g != -1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        a.b(flag);
        return g;
    }

    final void p()
    {
        boolean flag;
        if (g == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        g = 3;
        b();
    }

    final void q()
    {
        boolean flag;
        if (g == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        g = 2;
        c();
    }

    final void r()
    {
        boolean flag;
        if (g == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        g = 1;
        g();
    }

    final void s()
    {
        boolean flag;
        if (g != 2 && g != 3 && g != -2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        g = -2;
        l();
    }
}
