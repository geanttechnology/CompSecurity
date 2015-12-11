// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;


public final class dy
{

    private int a;
    private int b;
    private int c;

    public dy(int i, int j, int k)
    {
        a = i;
        b = j;
        c = k;
    }

    public final void a(int i, int j, int k)
    {
        a = i;
        b = j;
        c = k;
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof dy)
        {
            obj = (dy)obj;
            flag = flag1;
            if (a == ((dy) (obj)).a)
            {
                flag = flag1;
                if (b == ((dy) (obj)).b)
                {
                    flag = flag1;
                    if (c == ((dy) (obj)).c)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return a << b + 11 << c + 3;
    }
}
