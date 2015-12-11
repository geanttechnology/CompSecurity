// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.a;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.c.g;
import b.a.a.d;

public abstract class c
    implements aa, Comparable
{

    protected c()
    {
    }

    private int c(d d)
    {
        for (int i = 0; i < 3; i++)
        {
            if (b(i) == d)
            {
                return i;
            }
        }

        return -1;
    }

    public int a(aa aa1)
    {
        if (this != aa1)
        {
            for (int i = 0; i < 3; i++)
            {
                if (b(i) != aa1.b(i))
                {
                    throw new ClassCastException("ReadablePartial objects must have matching field types");
                }
            }

            int j = 0;
            while (j < 3) 
            {
                if (a(j) > aa1.a(j))
                {
                    return 1;
                }
                if (a(j) < aa1.a(j))
                {
                    return -1;
                }
                j++;
            }
        }
        return 0;
    }

    public int a(d d)
    {
        int i = c(d);
        if (i == -1)
        {
            throw new IllegalArgumentException((new StringBuilder("Field '")).append(d).append("' is not supported").toString());
        } else
        {
            return a(i);
        }
    }

    public abstract b.a.a.c a(int i, a a1);

    public final d b(int i)
    {
        return a(i, a()).a();
    }

    public boolean b(d d)
    {
        return c(d) != -1;
    }

    public final b.a.a.c c(int i)
    {
        return a(i, a());
    }

    public int compareTo(Object obj)
    {
        return a((aa)obj);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof aa)) goto _L4; else goto _L3
_L3:
        int i;
        obj = (aa)obj;
        i = 0;
_L7:
        if (i >= 3)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        flag = flag1;
        if (a(i) != ((aa) (obj)).a(i)) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (b(i) != ((aa) (obj)).b(i)) goto _L4; else goto _L6
_L6:
        i++;
          goto _L7
        return g.a(a(), ((aa) (obj)).a());
    }

    public int hashCode()
    {
        int j = 157;
        for (int i = 0; i < 3; i++)
        {
            j = (j * 23 + a(i)) * 23 + b(i).hashCode();
        }

        return a().hashCode() + j;
    }
}
