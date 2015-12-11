// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class agm extends agu
{

    public agn a[];

    public agm()
    {
        a();
    }

    public static agm a(byte abyte0[])
    {
        return (agm)aha.a(new agm(), abyte0);
    }

    public agm a()
    {
        a = agn.a();
        o = null;
        p = -1;
        return this;
    }

    public agm a(agr agr1)
    {
        do
        {
            int i = agr1.a();
            switch (i)
            {
            default:
                if (a(agr1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int k = ahd.a(agr1, 10);
                agn aagn[];
                int j;
                if (a == null)
                {
                    j = 0;
                } else
                {
                    j = a.length;
                }
                aagn = new agn[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(a, 0, aagn, 0, j);
                    k = j;
                }
                for (; k < aagn.length - 1; k++)
                {
                    aagn[k] = new agn();
                    agr1.a(aagn[k]);
                    agr1.a();
                }

                aagn[k] = new agn();
                agr1.a(aagn[k]);
                a = aagn;
                break;
            }
        } while (true);
    }

    public void a(ags ags1)
    {
        if (a != null && a.length > 0)
        {
            for (int i = 0; i < a.length; i++)
            {
                agn agn1 = a[i];
                if (agn1 != null)
                {
                    ags1.a(1, agn1);
                }
            }

        }
        super.a(ags1);
    }

    public aha b(agr agr1)
    {
        return a(agr1);
    }

    protected int c()
    {
        int i = super.c();
        int k = i;
        if (a != null)
        {
            k = i;
            if (a.length > 0)
            {
                int j = 0;
                do
                {
                    k = i;
                    if (j >= a.length)
                    {
                        break;
                    }
                    agn agn1 = a[j];
                    k = i;
                    if (agn1 != null)
                    {
                        k = i + ags.c(1, agn1);
                    }
                    j++;
                    i = k;
                } while (true);
            }
        }
        return k;
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
            if (obj instanceof agm)
            {
                obj = (agm)obj;
                flag = flag1;
                if (agy.a(a, ((agm) (obj)).a))
                {
                    return a(((agu) (obj)));
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (agy.a(a) + 527) * 31 + d();
    }
}
