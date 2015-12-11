// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


public class aiu
{

    private final int a;
    private final int b;

    public aiu(int i, int j)
    {
        a = i;
        b = j;
    }

    public aiu(int i, int j, int k)
    {
        if (k % 180 == 0)
        {
            a = i;
            b = j;
            return;
        } else
        {
            a = j;
            b = i;
            return;
        }
    }

    public int a()
    {
        return a;
    }

    public aiu a(float f)
    {
        return new aiu((int)((float)a * f), (int)((float)b * f));
    }

    public aiu a(int i)
    {
        return new aiu(a / i, b / i);
    }

    public int b()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder(9)).append(a).append("x").append(b).toString();
    }
}
