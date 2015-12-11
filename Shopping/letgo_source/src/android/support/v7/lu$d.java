// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xv, lu, xu, xz

public static final class a extends xv
{

    public d a[];
    public d b[];
    public d c[];

    public a a()
    {
        a = a();
        b = a();
        c = a();
        r = null;
        s = -1;
        return this;
    }

    public void a(xu xu1)
        throws IOException
    {
        boolean flag = false;
        if (a != null && a.length > 0)
        {
            for (int i = 0; i < a.length; i++)
            {
                s s = a[i];
                if (s != null)
                {
                    xu1.a(1, s);
                }
            }

        }
        if (b != null && b.length > 0)
        {
            for (int j = 0; j < b.length; j++)
            {
                s s1 = b[j];
                if (s1 != null)
                {
                    xu1.a(2, s1);
                }
            }

        }
        if (c != null && c.length > 0)
        {
            for (int k = ((flag) ? 1 : 0); k < c.length; k++)
            {
                s s2 = c[k];
                if (s2 != null)
                {
                    xu1.a(3, s2);
                }
            }

        }
        super.a(xu1);
    }

    protected int b()
    {
        boolean flag = false;
        int i = super.b();
        int j = i;
        if (a != null)
        {
            j = i;
            if (a.length > 0)
            {
                for (j = 0; j < a.length;)
                {
                    c c1 = a[j];
                    int i1 = i;
                    if (c1 != null)
                    {
                        i1 = i + xu.c(1, c1);
                    }
                    j++;
                    i = i1;
                }

                j = i;
            }
        }
        i = j;
        if (b != null)
        {
            i = j;
            if (b.length > 0)
            {
                i = j;
                for (int k = 0; k < b.length;)
                {
                    c c2 = b[k];
                    int j1 = i;
                    if (c2 != null)
                    {
                        j1 = i + xu.c(2, c2);
                    }
                    k++;
                    i = j1;
                }

            }
        }
        int k1 = i;
        if (c != null)
        {
            k1 = i;
            if (c.length > 0)
            {
                int l = ((flag) ? 1 : 0);
                do
                {
                    k1 = i;
                    if (l >= c.length)
                    {
                        break;
                    }
                    c c3 = c[l];
                    k1 = i;
                    if (c3 != null)
                    {
                        k1 = i + xu.c(3, c3);
                    }
                    l++;
                    i = k1;
                } while (true);
            }
        }
        return k1;
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
                if (xz.a(a, ((a) (obj)).a))
                {
                    flag = flag1;
                    if (xz.a(b, ((b) (obj)).b))
                    {
                        flag = flag1;
                        if (xz.a(c, ((c) (obj)).c))
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
        return (((xz.a(a) + 527) * 31 + xz.a(b)) * 31 + xz.a(c)) * 31 + d();
    }

    public ()
    {
        a();
    }
}
