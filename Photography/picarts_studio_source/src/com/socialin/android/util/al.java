// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.socialin.android.util:
//            e

public final class al
{

    private static final char a[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
        'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static String a(String s)
    {
_L2:
        s = new String(ac1);
        return s;
        int i = 0;
        char ac[];
        char ac1[];
        int j;
        int k;
        try
        {
            s = MessageDigest.getInstance("MD5").digest(a(s, e.a));
            ac = a;
            ac1 = new char[s.length * 2];
            k = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        j = 0;
        while (i < k) 
        {
            byte byte0 = s[i];
            int l = j + 1;
            ac1[j] = ac[byte0 >> 4 & 0xf];
            j = l + 1;
            ac1[l] = ac[byte0 & 0xf];
            i++;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static byte[] a(String s, Charset charset)
    {
        try
        {
            s = s.getBytes(charset.name());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException(s);
        }
        return s;
    }

}
