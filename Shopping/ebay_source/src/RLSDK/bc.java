// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            bf

final class bc
{

    private final int a;
    private final byte b[];

    private bc(int i, byte abyte0[])
    {
        a = i;
        b = abyte0;
    }

    static bc[] a(byte abyte0[], bf bf1)
    {
        bf.b b1 = bf1.g();
        bf.a aa[] = b1.b();
        int i = 0;
        int j = 0;
        for (; i < aa.length; i++)
        {
            j += aa[i].a();
        }

        bc abc[] = new bc[j];
        j = 0;
        i = 0;
        for (; j < aa.length; j++)
        {
            bf.a a1 = aa[j];
            for (int l = 0; l < a1.a();)
            {
                int j1 = a1.b();
                abc[i] = new bc(j1, new byte[b1.a() + j1]);
                l++;
                i++;
            }

        }

        int j2 = abc[0].b.length - b1.a();
        int i1 = 0;
        j = 0;
        for (; i1 < j2 - 1; i1++)
        {
            for (int k1 = 0; k1 < i;)
            {
                abc[k1].b[i1] = abyte0[j];
                k1++;
                j++;
            }

        }

        boolean flag;
        int l1;
        if (bf1.a() == 24)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i1 = 8;
        } else
        {
            i1 = i;
        }
        for (l1 = 0; l1 < i1;)
        {
            abc[l1].b[j2 - 1] = abyte0[j];
            l1++;
            j++;
        }

        int l2 = abc[0].b.length;
        i1 = j;
        for (int k = j2; k < l2; k++)
        {
            int i2 = 0;
            while (i2 < i) 
            {
                int k2;
                if (flag && i2 > 7)
                {
                    k2 = k - 1;
                } else
                {
                    k2 = k;
                }
                abc[i2].b[k2] = abyte0[i1];
                i1++;
                i2++;
            }
        }

        if (i1 != abyte0.length)
        {
            throw new IllegalArgumentException();
        } else
        {
            return abc;
        }
    }

    final int a()
    {
        return a;
    }

    final byte[] b()
    {
        return b;
    }
}
