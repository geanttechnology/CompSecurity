// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cma extends cml
{

    private int e[];
    private int f;

    public cma()
    {
        super(new cmb(), 0x7fffffff, 0, 0x7fffffff, 0x7fffffff, 1.0F);
    }

    protected final app a(app aapp[], long l)
    {
        boolean flag = true;
        if (aapp.length == 1)
        {
            return aapp[0];
        }
        int j = aapp.length;
        if (e == null || e.length != j * (j - 1))
        {
            flag = false;
        }
        if (flag)
        {
            f = (f + 1) % e.length;
        } else
        {
            int j1 = aapp.length;
            e = new int[(j1 - 1) * j1];
            int i = 0;
            int k = 0;
            for (; i < j1; i++)
            {
                for (int i1 = i + 1; i1 < j1; i1++)
                {
                    int ai[] = e;
                    int k1 = k + 1;
                    ai[k] = i;
                    ai = e;
                    k = k1 + 1;
                    ai[k1] = i1;
                }

            }

            f = 0;
        }
        return aapp[e[f]];
    }
}
