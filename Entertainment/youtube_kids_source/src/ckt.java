// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class ckt
{

    final bkn a;
    final boolean b;
    final boolean c;
    final boolean d;
    final boolean e = false;
    int f;
    int g;

    public ckt(bkn bkn1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        f = -1;
        g = -1;
        a = bkn1;
        b = flag;
        c = flag1;
        d = flag2;
    }

    int a()
    {
        if (a.e())
        {
            return 144;
        }
        if (c)
        {
            return 240;
        }
        if (d || !a.f())
        {
            return 360;
        }
        return b ? 720 : 480;
    }

    public ckr a(boolean flag)
    {
        int i;
        int j;
        if (g > 0)
        {
            i = g;
        } else
        if (flag)
        {
            i = 0x7fffffff;
        } else
        {
            i = a();
        }
        if (f > 0)
        {
            j = f;
        } else
        if (flag)
        {
            j = 0;
        } else
        {
            j = b();
        }
        return new ckr(new cks(i, Math.min(j, i)), true, e, null);
    }

    int b()
    {
        return !a.f() || d ? 144 : 360;
    }
}
