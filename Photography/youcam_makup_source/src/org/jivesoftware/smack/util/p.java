// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Random;
import java.util.logging.Logger;

// Referenced classes of package org.jivesoftware.smack.util:
//            c

public class p
{

    private static final Logger a = Logger.getLogger(org/jivesoftware/smack/util/p.getName());
    private static MessageDigest b = null;
    private static Random c = new Random();
    private static char d[] = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public p()
    {
    }

    public static String a(int i)
    {
        if (i < 1)
        {
            return null;
        }
        char ac[] = new char[i];
        for (i = 0; i < ac.length; i++)
        {
            ac[i] = d[c.nextInt(71)];
        }

        return new String(ac);
    }

    public static String a(String s)
    {
        if (s == null)
        {
            return null;
        }
        int i = s.lastIndexOf("@");
        if (i <= 0)
        {
            return "";
        } else
        {
            return s.substring(0, i);
        }
    }

    public static String a(byte abyte0[])
    {
        return a(abyte0, false);
    }

    public static String a(byte abyte0[], int i, int j, boolean flag)
    {
        int k;
        if (flag)
        {
            k = 0;
        } else
        {
            k = 8;
        }
        return org.jivesoftware.smack.util.c.a(abyte0, i, j, k);
    }

    public static String a(byte abyte0[], boolean flag)
    {
        return a(abyte0, 0, abyte0.length, flag);
    }

    public static boolean a(CharSequence charsequence)
    {
        return !b(charsequence);
    }

    public static String b(String s)
    {
        if (s == null)
        {
            return null;
        }
        int i = s.lastIndexOf("@");
        if (i + 1 > s.length())
        {
            return "";
        }
        int j = s.indexOf("/");
        if (j > 0 && j > i)
        {
            return s.substring(i + 1, j);
        } else
        {
            return s.substring(i + 1);
        }
    }

    public static boolean b(CharSequence charsequence)
    {
        return charsequence == null || c(charsequence);
    }

    public static String c(String s)
    {
        if (s == null)
        {
            return null;
        }
        int i = s.indexOf("/");
        if (i + 1 > s.length() || i < 0)
        {
            return "";
        } else
        {
            return s.substring(i + 1);
        }
    }

    public static boolean c(CharSequence charsequence)
    {
        return charsequence.length() == 0;
    }

    public static String d(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            int i = s.indexOf("/");
            s1 = s;
            if (i >= 0)
            {
                if (i == 0)
                {
                    return "";
                } else
                {
                    return s.substring(0, i);
                }
            }
        }
        return s1;
    }

    public static CharSequence e(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L12:
        return s;
_L2:
        char ac[];
        StringBuilder stringbuilder;
        int i;
        int j;
        int k;
        ac = s.toCharArray();
        k = ac.length;
        stringbuilder = new StringBuilder((int)((double)k * 1.3D));
        i = 0;
        j = 0;
_L9:
        if (i >= k)
        {
            continue; /* Loop/switch isn't completed */
        }
        ac[i];
        JVM INSTR lookupswitch 5: default 100
    //                   34: 163
    //                   38: 157
    //                   39: 169
    //                   60: 145
    //                   62: 151;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        Object obj = null;
_L10:
        if (obj != null)
        {
            if (i > j)
            {
                stringbuilder.append(ac, j, i - j);
            }
            stringbuilder.append(((CharSequence) (obj)));
            j = i + 1;
            i = j;
        } else
        {
            i++;
        }
        if (true) goto _L9; else goto _L7
_L7:
        obj = "&lt;";
          goto _L10
_L8:
        obj = "&gt;";
          goto _L10
_L5:
        obj = "&amp;";
          goto _L10
_L4:
        obj = "&quot;";
          goto _L10
_L6:
        obj = "&apos;";
          goto _L10
        if (j == 0) goto _L12; else goto _L11
_L11:
        if (i > j)
        {
            stringbuilder.append(ac, j, i - j);
        }
        return stringbuilder;
    }

    public static String f(String s)
    {
        try
        {
            s = s.getBytes("ISO-8859-1");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException(s);
        }
        return a(s);
    }

    public static byte[] g(String s)
    {
        byte abyte0[] = s.getBytes("UTF-8");
        s = abyte0;
_L2:
        return org.jivesoftware.smack.util.c.b(s, 0, s.length, 0);
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        s = s.getBytes();
        if (true) goto _L2; else goto _L1
_L1:
    }

}
