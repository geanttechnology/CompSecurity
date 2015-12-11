// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class agw
{

    private static final agx a = new agx();
    private boolean b;
    private int c[];
    private agx d[];
    private int e;

    public agw()
    {
        this(10);
    }

    public agw(int i)
    {
        b = false;
        i = c(i);
        c = new int[i];
        d = new agx[i];
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

    private boolean a(agx aagx[], agx aagx1[], int i)
    {
        for (int j = 0; j < i; j++)
        {
            if (!aagx[j].equals(aagx1[j]))
            {
                return false;
            }
        }

        return true;
    }

    private int c(int i)
    {
        return d(i * 4) / 4;
    }

    private void c()
    {
        int l = e;
        int ai[] = c;
        agx aagx[] = d;
        int i = 0;
        int j;
        int k;
        for (j = 0; i < l; j = k)
        {
            agx agx1 = aagx[i];
            k = j;
            if (agx1 != a)
            {
                if (i != j)
                {
                    ai[j] = ai[i];
                    aagx[j] = agx1;
                    aagx[i] = null;
                }
                k = j + 1;
            }
            i++;
        }

        b = false;
        e = j;
    }

    private int d(int i)
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

    private int e(int i)
    {
        int j = 0;
        for (int k = e - 1; j <= k;)
        {
            int l = j + k >>> 1;
            int i1 = c[l];
            if (i1 < i)
            {
                j = l + 1;
            } else
            if (i1 > i)
            {
                k = l - 1;
            } else
            {
                return l;
            }
        }

        return ~j;
    }

    public int a()
    {
        if (b)
        {
            c();
        }
        return e;
    }

    public agx a(int i)
    {
        i = e(i);
        if (i < 0 || d[i] == a)
        {
            return null;
        } else
        {
            return d[i];
        }
    }

    public void a(int i, agx agx1)
    {
        int j = e(i);
        if (j >= 0)
        {
            d[j] = agx1;
            return;
        }
        int k = ~j;
        if (k < e && d[k] == a)
        {
            c[k] = i;
            d[k] = agx1;
            return;
        }
        j = k;
        if (b)
        {
            j = k;
            if (e >= c.length)
            {
                c();
                j = ~e(i);
            }
        }
        if (e >= c.length)
        {
            int l = c(e + 1);
            int ai[] = new int[l];
            agx aagx[] = new agx[l];
            System.arraycopy(c, 0, ai, 0, c.length);
            System.arraycopy(d, 0, aagx, 0, d.length);
            c = ai;
            d = aagx;
        }
        if (e - j != 0)
        {
            System.arraycopy(c, j, c, j + 1, e - j);
            System.arraycopy(d, j, d, j + 1, e - j);
        }
        c[j] = i;
        d[j] = agx1;
        e = e + 1;
    }

    public agx b(int i)
    {
        if (b)
        {
            c();
        }
        return d[i];
    }

    public boolean b()
    {
        return a() == 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof agw))
            {
                return false;
            }
            obj = (agw)obj;
            if (a() != ((agw) (obj)).a())
            {
                return false;
            }
            if (!a(c, ((agw) (obj)).c, e) || !a(d, ((agw) (obj)).d, e))
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
            c();
        }
        int j = 17;
        for (int i = 0; i < e; i++)
        {
            j = (j * 31 + c[i]) * 31 + d[i].hashCode();
        }

        return j;
    }

}
