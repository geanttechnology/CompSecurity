// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            dl, di

final class de
{

    private final int a;
    private final byte b[];

    private de(int i, byte abyte0[])
    {
        a = i;
        b = abyte0;
    }

    static de[] a(byte abyte0[], dl dl1, di di)
    {
        if (abyte0.length != dl1.c())
        {
            throw new IllegalArgumentException();
        }
        dl1 = dl1.a(di);
        di = dl1.b();
        int i = 0;
        int k = 0;
        for (; i < di.length; i++)
        {
            k += di[i].a();
        }

        de ade[] = new de[k];
        i = 0;
        int l = 0;
        for (; i < di.length; i++)
        {
            dl.a a1 = di[i];
            for (k = 0; k < a1.a();)
            {
                int i1 = a1.b();
                ade[l] = new de(i1, new byte[dl1.a() + i1]);
                k++;
                l++;
            }

        }

        k = ade[0].b.length;
        for (i = ade.length - 1; i >= 0 && ade[i].b.length != k; i--) { }
        int k2 = i + 1;
        int i2 = k - dl1.a();
        k = 0;
        i = 0;
        for (; k < i2; k++)
        {
            for (int j1 = 0; j1 < l;)
            {
                ade[j1].b[k] = abyte0[i];
                j1++;
                i++;
            }

        }

        int k1 = k2;
        for (k = i; k1 < l; k++)
        {
            ade[k1].b[i2] = abyte0[k];
            k1++;
        }

        int l2 = ade[0].b.length;
        for (int j = i2; j < l2; j++)
        {
            int l1 = 0;
            while (l1 < l) 
            {
                int j2;
                if (l1 < k2)
                {
                    j2 = j;
                } else
                {
                    j2 = j + 1;
                }
                ade[l1].b[j2] = abyte0[k];
                k++;
                l1++;
            }
        }

        return ade;
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
