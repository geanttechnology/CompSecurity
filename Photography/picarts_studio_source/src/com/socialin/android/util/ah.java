// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import com.socialin.android.d;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import myobfuscated.dg.a;

public class ah
{

    private static String a = com/socialin/android/util/ah.getSimpleName();
    private static String b = "Socialin12345678";

    public ah()
    {
    }

    public static String a(String s)
    {
        String s1;
        do
        {
            s1 = s;
            if (s.length() >= 16)
            {
                break;
            }
            s = (new StringBuilder()).append(s).append("s").toString();
        } while (true);
        for (; s1.length() > 16; s1 = s1.substring(0, s1.length() - 1)) { }
        d.b(a, new Object[] {
            (new StringBuilder("Normalizacrac 256bit:")).append(s1).toString()
        });
        return s1;
    }

    public static String a(String s, String s1)
    {
        Object obj = null;
        s = myobfuscated.dg.a.b(s.getBytes());
        s1 = new SecretKeySpec(s1.getBytes(), "AES");
        int i;
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, s1);
            s = cipher.doFinal(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = obj;
        }
        s = new String(s);
        i = s.indexOf('|');
        return s.substring(i + 1, i + Integer.valueOf(s.substring(0, i)).intValue() + 1);
    }

    public static String b(String s)
    {
        Object obj = null;
        s = myobfuscated.dg.a.b(s.getBytes());
        SecretKeySpec secretkeyspec = new SecretKeySpec(b.getBytes(), "AES");
        int i;
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretkeyspec);
            s = cipher.doFinal(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = obj;
        }
        s = new String(s);
        i = s.indexOf('|');
        return s.substring(i + 1, i + Integer.valueOf(s.substring(0, i)).intValue() + 1);
    }

}
