// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, xu

public static final class a extends xv
{

    public int a;
    public int b;
    public int c;

    public a a()
    {
        a = 1;
        b = 0;
        c = 0;
        r = null;
        s = -1;
        return this;
    }

    public void a(xu xu1)
        throws IOException
    {
        if (a != 1)
        {
            xu1.a(1, a);
        }
        if (b != 0)
        {
            xu1.a(2, b);
        }
        if (c != 0)
        {
            xu1.a(3, c);
        }
        super.a(xu1);
    }

    protected int b()
    {
        int j = super.b();
        int i = j;
        if (a != 1)
        {
            i = j + xu.b(1, a);
        }
        j = i;
        if (b != 0)
        {
            j = i + xu.b(2, b);
        }
        i = j;
        if (c != 0)
        {
            i = j + xu.b(3, c);
        }
        return i;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof c)
            {
                obj = (c)obj;
                flag = flag1;
                if (a == ((a) (obj)).a)
                {
                    flag = flag1;
                    if (b == ((b) (obj)).b)
                    {
                        flag = flag1;
                        if (c == ((c) (obj)).c)
                        {
                            return a(((xv) (obj)));
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (((a + 527) * 31 + b) * 31 + c) * 31 + d();
    }

    public ()
    {
        a();
    }
}
