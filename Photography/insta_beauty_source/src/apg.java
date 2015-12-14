// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class apg
{

    private static int a(byte abyte0[], char c1)
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            if (abyte0[i] == c1)
            {
                return i;
            }
        }

        return -1;
    }

    private static String a(int i)
    {
        return (new StringBuilder()).append(System.currentTimeMillis()).append("-").append(i).append(' ').toString();
    }

    static String a(int i, String s)
    {
        return b(i, s);
    }

    static boolean a(String s)
    {
        return c(s);
    }

    private static boolean a(byte abyte0[])
    {
        abyte0 = c(abyte0);
        if (abyte0 != null && abyte0.length == 2)
        {
            long l = Long.valueOf(abyte0[0]).longValue();
            long l1 = Long.valueOf(abyte0[1]).longValue();
            if (System.currentTimeMillis() > l1 * 1000L + l)
            {
                return true;
            }
        }
        return false;
    }

    private static byte[] a(byte abyte0[], int i, int j)
    {
        int k = j - i;
        if (k < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(i).append(" > ").append(j).toString());
        } else
        {
            byte abyte1[] = new byte[k];
            System.arraycopy(abyte0, i, abyte1, 0, Math.min(abyte0.length - i, k));
            return abyte1;
        }
    }

    private static String b(int i, String s)
    {
        return (new StringBuilder()).append(a(i)).append(s).toString();
    }

    static String b(String s)
    {
        return d(s);
    }

    private static boolean b(byte abyte0[])
    {
        return abyte0 != null && abyte0.length > 15 && abyte0[13] == 45 && a(abyte0, ' ') > 14;
    }

    private static boolean c(String s)
    {
        return a(s.getBytes());
    }

    private static String[] c(byte abyte0[])
    {
        if (b(abyte0))
        {
            return (new String[] {
                new String(a(abyte0, 0, 13)), new String(a(abyte0, 14, a(abyte0, ' ')))
            });
        } else
        {
            return null;
        }
    }

    private static String d(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (b(s.getBytes()))
            {
                s1 = s.substring(s.indexOf(' ') + 1, s.length());
            }
        }
        return s1;
    }
}
