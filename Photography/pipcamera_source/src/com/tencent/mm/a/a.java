// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.a;

import java.security.MessageDigest;

public final class a
{

    public static final String a(byte abyte0[])
    {
_L2:
        abyte0 = new String(ac1);
        return abyte0;
        int i = 0;
        char ac[] = new char[16];
        ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        char ac1[];
        int j;
        int k;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
            k = abyte0.length;
            ac1 = new char[k * 2];
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        j = 0;
        while (i < k) 
        {
            byte byte0 = abyte0[i];
            int l = j + 1;
            ac1[j] = ac[byte0 >>> 4 & 0xf];
            j = l + 1;
            ac1[l] = ac[byte0 & 0xf];
            i++;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
