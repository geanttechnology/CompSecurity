// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class nt
{

    private int a;
    private int b;
    private int c;
    private int d;

    public nt(String s)
    {
        s = s.split("\\.");
        if (s.length >= 1)
        {
            a = Integer.parseInt(s[0]);
        } else
        {
            a = 0;
        }
        if (s.length >= 2)
        {
            b = Integer.parseInt(s[1]);
        } else
        {
            b = 0;
        }
        if (s.length >= 3)
        {
            c = Integer.parseInt(s[2]);
        } else
        {
            c = 0;
        }
        if (s.length >= 4)
        {
            d = Integer.parseInt(s[3]);
            return;
        } else
        {
            d = 0;
            return;
        }
    }

    public int a()
    {
        return a;
    }

    public boolean a(nt nt1)
    {
        if (a <= nt1.a())
        {
            if (a < nt1.a())
            {
                return false;
            }
            if (b <= nt1.b())
            {
                if (b < nt1.b())
                {
                    return false;
                }
                if (c <= nt1.c())
                {
                    if (c < nt1.c())
                    {
                        return false;
                    }
                    if (d <= nt1.d())
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int b()
    {
        return b;
    }

    public int c()
    {
        return c;
    }

    public int d()
    {
        return d;
    }
}
