// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            l, g, m, j, 
//            h, k

public final class p extends l
{

    private int g;

    public p(g g1, int i)
    {
        super(g1);
        g = i;
    }

    protected final g g()
    {
        boolean flag;
        if (super.a.c().equals("HEAD") || g >= 100 && g <= 199 || g == 204 || g == 304)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            super.a.b(a());
            return super.a.b();
        }
        if (super.f)
        {
            return new j(this);
        }
        if (super.d)
        {
            if (super.e > 0)
            {
                return new h(this, super.e);
            } else
            {
                super.a.b(a());
                return super.a.b();
            }
        }
        if (super.a.c().equals("CONNECT"))
        {
            super.a.b(a());
            return super.a.b();
        } else
        {
            return new k(this);
        }
    }
}
