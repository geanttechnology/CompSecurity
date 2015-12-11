// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cks
{

    public final int a;
    final int b;

    public cks(int i, int j)
    {
        boolean flag;
        if (i >= j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        a = i;
        b = j;
    }

    public final int a(int i)
    {
        if (a >= i && i >= b)
        {
            return 0;
        }
        return i >= b ? 1 : -1;
    }
}
