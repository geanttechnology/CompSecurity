// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.encrypt;


public class RC4Carder
{

    public RC4Carder()
    {
    }

    public static byte[] Dencrypt(byte abyte0[], String s)
    {
        return RC4(abyte0, s.getBytes());
    }

    public static byte[] Encrypt(byte abyte0[], String s)
    {
        return RC4(abyte0, s.getBytes());
    }

    public static byte[] RC4(byte abyte0[], byte abyte1[])
    {
        if (!isKeyValid(abyte1))
        {
            throw new IllegalArgumentException("key is fail!");
        }
        if (abyte0.length < 1)
        {
            throw new IllegalArgumentException("data is fail!");
        }
        int ai[] = new int[256];
        for (int i = 0; i < ai.length; i++)
        {
            ai[i] = i;
        }

        int l = 0;
        for (int j = 0; j < ai.length; j++)
        {
            l = (ai[j] + l + (abyte1[j % abyte1.length] & 0xff)) % 256;
            swap(ai, j, l);
        }

        int i1 = 0;
        l = 0;
        abyte1 = new byte[abyte0.length];
        for (int k = 0; k < abyte1.length; k++)
        {
            i1 = (i1 + 1) % 256;
            l = (ai[i1] + l) % 256;
            swap(ai, i1, l);
            int j1 = ai[(ai[i1] + ai[l]) % 256];
            abyte1[k] = (byte)(abyte0[k] ^ j1);
        }

        return abyte1;
    }

    public static boolean isKeyValid(byte abyte0[])
    {
        int k;
        int l;
        l = abyte0.length;
        k = 0;
        if (l <= 0 || l > 256) goto _L2; else goto _L1
_L1:
        int j = 0;
_L7:
        if (j >= l) goto _L4; else goto _L3
_L3:
        int i = k;
        if ((abyte0[j] & 0xff) != 14) goto _L6; else goto _L5
_L5:
        k++;
        i = k;
        if (k <= 3) goto _L6; else goto _L2
_L2:
        return false;
_L6:
        j++;
        k = i;
          goto _L7
_L4:
        return true;
    }

    public static void swap(int ai[], int i, int j)
    {
        int k = ai[i];
        ai[i] = ai[j];
        ai[j] = k;
    }
}
