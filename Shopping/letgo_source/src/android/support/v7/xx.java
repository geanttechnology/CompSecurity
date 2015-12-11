// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            xy

class xx
    implements Cloneable
{

    private static final xy a = new xy();
    private boolean b;
    private int c[];
    private xy d[];
    private int e;

    public xx()
    {
        this(10);
    }

    public xx(int i)
    {
        b = false;
        i = b(i);
        c = new int[i];
        d = new xy[i];
        e = 0;
    }

    private boolean a(int ai[], int ai1[], int i)
    {
        for (int j = 0; j < i; j++)
        {
            if (ai[j] != ai1[j])
            {
                return false;
            }
        }

        return true;
    }

    private boolean a(xy axy[], xy axy1[], int i)
    {
        for (int j = 0; j < i; j++)
        {
            if (!axy[j].equals(axy1[j]))
            {
                return false;
            }
        }

        return true;
    }

    private int b(int i)
    {
        return c(i * 4) / 4;
    }

    private int c(int i)
    {
        int j = 4;
        do
        {
label0:
            {
                int k = i;
                if (j < 32)
                {
                    if (i > (1 << j) - 12)
                    {
                        break label0;
                    }
                    k = (1 << j) - 12;
                }
                return k;
            }
            j++;
        } while (true);
    }

    private void d()
    {
        int l = e;
        int ai[] = c;
        xy axy[] = d;
        int i = 0;
        int j;
        int k;
        for (j = 0; i < l; j = k)
        {
            xy xy1 = axy[i];
            k = j;
            if (xy1 != a)
            {
                if (i != j)
                {
                    ai[j] = ai[i];
                    axy[j] = xy1;
                    axy[i] = null;
                }
                k = j + 1;
            }
            i++;
        }

        b = false;
        e = j;
    }

    public int a()
    {
        if (b)
        {
            d();
        }
        return e;
    }

    public xy a(int i)
    {
        if (b)
        {
            d();
        }
        return d[i];
    }

    public boolean b()
    {
        return a() == 0;
    }

    public final xx c()
    {
        int i = 0;
        int j = a();
        xx xx1 = new xx(j);
        System.arraycopy(c, 0, xx1.c, 0, j);
        for (; i < j; i++)
        {
            if (d[i] != null)
            {
                xx1.d[i] = d[i].b();
            }
        }

        xx1.e = j;
        return xx1;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return c();
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof xx))
            {
                return false;
            }
            obj = (xx)obj;
            if (a() != ((xx) (obj)).a())
            {
                return false;
            }
            if (!a(c, ((xx) (obj)).c, e) || !a(d, ((xx) (obj)).d, e))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        if (b)
        {
            d();
        }
        int j = 17;
        for (int i = 0; i < e; i++)
        {
            j = (j * 31 + c[i]) * 31 + d[i].hashCode();
        }

        return j;
    }

}
