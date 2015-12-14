// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class blu
{

    private static int a = 2;
    private blv b[];
    private int c;
    private int d;

    public blu()
    {
        b = new blv[a];
    }

    public static blv b(int i, int j)
    {
        if (i == 0 && j == 0)
        {
            return null;
        } else
        {
            return blv.a(i, j);
        }
    }

    public int a(int i)
    {
        int j = 0;
        int k = b[0].a();
        for (; j < a; j++)
        {
            if (i != b[j].b())
            {
                k = b[j].a();
            }
        }

        return k;
    }

    public void a()
    {
        for (int i = 0; i < a; i++)
        {
            if (b[i] != null)
            {
                b[i].c();
            }
        }

    }

    public void a(int i, int j)
    {
        if (i != c || j != d)
        {
            int k = 0;
            while (k < a) 
            {
                if (b[k] != null)
                {
                    b[k].c();
                    b[k] = null;
                }
                b[k] = blv.a(i, j);
                k++;
            }
        }
    }

    public int b(int i)
    {
        int j = 0;
        int k = 0;
        for (; j < a; j++)
        {
            if (i == b[j].b())
            {
                k = b[j].a();
            }
        }

        return k;
    }

    public int c(int i)
    {
        int j = 0;
        int k = 0;
        for (; j < a; j++)
        {
            if (i == b[j].a())
            {
                k = b[j].b();
            }
        }

        return k;
    }

}
