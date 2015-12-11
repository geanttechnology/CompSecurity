// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class euc
{

    public static final euc b = new euc(new byte[0]);
    final byte a[];
    private volatile int c;

    private euc(byte abyte0[])
    {
        c = 0;
        a = abyte0;
    }

    public static euc a(byte abyte0[])
    {
        return a(abyte0, 0, abyte0.length);
    }

    public static euc a(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, i, abyte1, 0, j);
        return new euc(abyte1);
    }

    public final int a()
    {
        return a.length;
    }

    public final byte[] b()
    {
        int i = a.length;
        byte abyte0[] = new byte[i];
        System.arraycopy(a, 0, abyte0, 0, i);
        return abyte0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof euc))
            {
                return false;
            }
            euc euc1 = (euc)obj;
            int j = a.length;
            if (j != euc1.a.length)
            {
                return false;
            }
            obj = a;
            byte abyte0[] = euc1.a;
            int i = 0;
            while (i < j) 
            {
                if (obj[i] != abyte0[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int i = c;
        int k = i;
        if (i == 0)
        {
            byte abyte0[] = a;
            int l = a.length;
            k = 0;
            int j;
            byte byte0;
            for (j = l; k < l; j = byte0 + j * 31)
            {
                byte0 = abyte0[k];
                k++;
            }

            k = j;
            if (j == 0)
            {
                k = 1;
            }
            c = k;
        }
        return k;
    }

}
