// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.c;

import com.gimbal.internal.d.b;
import com.gimbal.internal.d.h;
import com.gimbal.internal.proximity.core.b.a;
import com.gimbal.internal.proximity.d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{

    private static b a;

    public c()
    {
    }

    private static b a()
    {
        com/gimbal/internal/c/c;
        JVM INSTR monitorenter ;
        b b2;
        if (a == null)
        {
            b b1 = new b();
            a = b1;
            b1.a(new h(), new Class[0]);
        }
        b2 = a;
        com/gimbal/internal/c/c;
        JVM INSTR monitorexit ;
        return b2;
        Exception exception;
        exception;
        throw exception;
    }

    public static Integer a(String s, String s1)
    {
        String as[];
        String as1[];
        int k;
        int l;
        if (s == null)
        {
            return Integer.valueOf(-1);
        }
        as = s.split("\\.");
        as1 = s1.split("\\.");
        l = Math.max(as.length, as1.length);
        k = 0;
_L5:
        if (k >= l) goto _L2; else goto _L1
_L1:
        int i;
        if (k < as.length)
        {
            s = as[k];
        } else
        {
            s = "0";
        }
        if (k < as1.length)
        {
            s1 = as1[k];
        } else
        {
            s1 = "0";
        }
        if (s.equals(s1))
        {
            continue; /* Loop/switch isn't completed */
        }
        i = Integer.valueOf(s).compareTo(Integer.valueOf(s1));
_L4:
        if (i != 0)
        {
            return Integer.valueOf(Integer.signum(i));
        }
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        s = s.replaceAll("[^\\d.]", "");
        s1 = s1.replaceAll("[^\\d.]", "");
        if (s == null && s1 == null)
        {
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
        if (s1 == null)
        {
            i = -1;
            continue; /* Loop/switch isn't completed */
        }
        int i1 = s.length();
        int j1 = s1.length();
        i = 0;
        int j = 0;
        do
        {
            if (i >= i1 || j >= j1)
            {
                break;
            }
            char c1 = s.charAt(i);
            char c2 = s1.charAt(j);
            if (c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9')
            {
                long l1 = 0L;
                for (; i < i1 && s.charAt(i) >= '0' && s.charAt(i) <= '9'; i++)
                {
                    l1 = 10L * l1 + (long)(s.charAt(i) - 48);
                }

                long l2 = 0L;
                for (; j < j1 && s1.charAt(j) >= '0' && s1.charAt(j) <= '9'; j++)
                {
                    l2 = l2 * 10L + (long)(s1.charAt(j) - 48);
                }

                if (l1 < l2)
                {
                    i = -1;
                    continue; /* Loop/switch isn't completed */
                }
                if (l2 < l1)
                {
                    i = 1;
                    continue; /* Loop/switch isn't completed */
                }
            } else
            {
                char c3 = Character.toLowerCase(c1);
                char c4 = Character.toLowerCase(c2);
                if (c3 == c4)
                {
                    i++;
                    j++;
                } else
                {
                    i = c3 - c4;
                    continue; /* Loop/switch isn't completed */
                }
            }
        } while (true);
        i = i1 - i - (j1 - j);
        if (true) goto _L4; else goto _L3
_L3:
        k++;
          goto _L5
_L2:
        return Integer.valueOf(0);
    }

    public static Object a(String s, Class class1)
    {
        try
        {
            s = ((String) (a().a(class1, s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new com.gimbal.internal.proximity.core.b.b(a.b, s);
        }
        return s;
    }

    public static String a(Object obj)
    {
        try
        {
            obj = a().a(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new com.gimbal.internal.proximity.core.b.b(a.a, ((Throwable) (obj)));
        }
        return ((String) (obj));
    }

    public static String a(String s)
    {
        String s1 = null;
        if (s != null)
        {
            s1 = s.toUpperCase();
        }
        return s1;
    }

    public static String a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new com.gimbal.internal.proximity.a.a(d.a);
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(String.format("%02x", new Object[] {
                Integer.valueOf(abyte0[i] & 0xff)
            }));
        }

        return stringbuilder.toString().toUpperCase();
    }

    public static byte[] b(String s)
    {
        if (s == null)
        {
            throw new com.gimbal.internal.proximity.a.a(d.a);
        }
        int j = s.length();
        byte abyte0[] = new byte[j / 2];
        for (int i = 0; i < j;)
        {
            byte byte0 = (byte)Character.digit(s.charAt(i), 16);
            byte byte1 = (byte)Character.digit(s.charAt(i + 1), 16);
            if (byte0 >= 0 && byte1 >= 0)
            {
                abyte0[i / 2] = (byte)((byte0 << 4) + byte1);
                i += 2;
            } else
            {
                throw new com.gimbal.internal.proximity.a.a(d.a);
            }
        }

        return abyte0;
    }

    public static String c(String s)
    {
        String s1 = null;
        if (s != null)
        {
            s1 = s.replaceAll("<", "").replaceAll(">", "").replaceAll("-", "").replaceAll(" ", "");
        }
        return s1;
    }

    public static String d(String s)
    {
        Object obj;
        try
        {
            obj = MessageDigest.getInstance("SHA-256");
            ((MessageDigest) (obj)).update(s.getBytes());
            obj = a(((MessageDigest) (obj)).digest());
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            return s;
        }
        return ((String) (obj));
    }

    public static com.gimbal.a.a e(String s)
    {
        return new com.gimbal.a.a(s);
    }

    public static com.gimbal.a.b f(String s)
    {
        return new com.gimbal.a.b(s);
    }
}
