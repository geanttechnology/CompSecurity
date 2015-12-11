// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


abstract class w
{

    boolean a;
    int b;

    w()
    {
        a = true;
        b = 0;
    }

    private void b(long l)
    {
        if (l == 0L)
        {
            return;
        } else
        {
            b(l / 10L);
            a((char)(int)(48L + l % 10L));
            return;
        }
    }

    final void a()
    {
        if (a)
        {
            a = false;
            int i = b;
            do
            {
                i--;
                if (i < 0)
                {
                    break;
                }
                a(' ');
            } while (true);
        }
    }

    abstract void a(char c);

    final void a(long l)
    {
        do
        {
            if (a)
            {
                a();
            }
            if (l == 0L)
            {
                a('0');
                return;
            }
            if (l == -l)
            {
                a("-9223372036854775808");
                return;
            }
            if (l < 0L)
            {
                a('-');
                l = -l;
            } else
            {
                b(l);
                return;
            }
        } while (true);
    }

    final void a(String s)
    {
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            b(s.charAt(i));
        }

    }

    final void a(boolean flag)
    {
        if (flag)
        {
            a("true");
            return;
        } else
        {
            a("false");
            return;
        }
    }

    final void b()
    {
        b(',');
        b('\n');
    }

    final void b(char c)
    {
        if (a)
        {
            a();
        }
        a(c);
        if (c == '\n')
        {
            a = true;
        }
    }

    final void b(String s)
    {
        a(s);
        b('\n');
    }
}
