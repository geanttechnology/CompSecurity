// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.util;


public final class Arrays
{

    private Arrays()
    {
    }

    public static boolean areEqual(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != abyte1)
        {
            if (abyte0 == null || abyte1 == null)
            {
                return false;
            }
            if (abyte0.length != abyte1.length)
            {
                return false;
            }
            int i = 0;
            while (i != abyte0.length) 
            {
                if (abyte0[i] != abyte1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean areEqual(char ac[], char ac1[])
    {
        if (ac != ac1)
        {
            if (ac == null || ac1 == null)
            {
                return false;
            }
            if (ac.length != ac1.length)
            {
                return false;
            }
            int i = 0;
            while (i != ac.length) 
            {
                if (ac[i] != ac1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean areEqual(int ai[], int ai1[])
    {
        if (ai != ai1)
        {
            if (ai == null || ai1 == null)
            {
                return false;
            }
            if (ai.length != ai1.length)
            {
                return false;
            }
            int i = 0;
            while (i != ai.length) 
            {
                if (ai[i] != ai1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean areEqual(boolean aflag[], boolean aflag1[])
    {
        if (aflag != aflag1)
        {
            if (aflag == null || aflag1 == null)
            {
                return false;
            }
            if (aflag.length != aflag1.length)
            {
                return false;
            }
            int i = 0;
            while (i != aflag.length) 
            {
                if (aflag[i] != aflag1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static byte[] clone(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            byte abyte1[] = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            return abyte1;
        }
    }

    public static int[] clone(int ai[])
    {
        if (ai == null)
        {
            return null;
        } else
        {
            int ai1[] = new int[ai.length];
            System.arraycopy(ai, 0, ai1, 0, ai.length);
            return ai1;
        }
    }

    public static boolean constantTimeAreEqual(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != abyte1)
        {
            if (abyte0 == null || abyte1 == null)
            {
                return false;
            }
            if (abyte0.length != abyte1.length)
            {
                return false;
            }
            int j = 0;
            for (int i = 0; i != abyte0.length; i++)
            {
                j |= abyte0[i] ^ abyte1[i];
            }

            if (j != 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void fill(byte abyte0[], byte byte0)
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = byte0;
        }

    }

    public static void fill(long al[], long l)
    {
        for (int i = 0; i < al.length; i++)
        {
            al[i] = l;
        }

    }

    public static void fill(short aword0[], short word0)
    {
        for (int i = 0; i < aword0.length; i++)
        {
            aword0[i] = word0;
        }

    }

    public static int hashCode(byte abyte0[])
    {
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        return j;
_L2:
        j = abyte0.length;
        int i = j + 1;
        do
        {
            int k = j - 1;
            j = i;
            if (k < 0)
            {
                continue;
            }
            i = i * 257 ^ abyte0[k];
            j = k;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
