// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;

public final class ark extends arj
{

    public final ArrayList b = new ArrayList();
    public final int c;

    public ark(int i, int j)
    {
        super(i);
        c = j;
    }

    public final arl a(int i)
    {
        int k = b.size();
        for (int j = 0; j < k; j++)
        {
            arj arj1 = (arj)b.get(j);
            if (arj1.a == i)
            {
                return (arl)arj1;
            }
        }

        return null;
    }

    public final void a(arj arj1)
    {
        b.add(arj1);
    }

    public final ark b(int i)
    {
        int k = b.size();
        for (int j = 0; j < k; j++)
        {
            arj arj1 = (arj)b.get(j);
            if (arj1.a == i)
            {
                return (ark)arj1;
            }
        }

        return null;
    }
}
