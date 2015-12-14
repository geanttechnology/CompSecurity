// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class aa
{

    private static final byte a[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte b[];

    public aa()
    {
    }

    public static void a(String as[])
    {
        as = a("cgping\uFFFD\271\uFFFD\u01BD".getBytes("gbk"));
        System.out.println("cgping\uFFFD\271\uFFFD\u01BD");
        System.out.println(new String(as));
        System.out.println(new String(a(new String(as))));
    }

    private static boolean a(byte byte0)
    {
        if (byte0 != 61)
        {
            if (byte0 < 0 || byte0 >= 128)
            {
                return false;
            }
            if (b[byte0] == -1)
            {
                return false;
            }
        }
        return true;
    }

    public static byte[] a(String s)
    {
        int i = 0;
        String s1 = b(s);
        int j;
        if (s1.charAt(s1.length() - 2) == '=')
        {
            s = new byte[(s1.length() / 4 - 1) * 3 + 1];
        } else
        if (s1.charAt(s1.length() - 1) == '=')
        {
            s = new byte[(s1.length() / 4 - 1) * 3 + 2];
        } else
        {
            s = new byte[(s1.length() / 4) * 3];
        }
        for (j = 0; j < s1.length() - 4;)
        {
            byte byte6 = b[s1.charAt(j)];
            byte byte9 = b[s1.charAt(j + 1)];
            byte byte11 = b[s1.charAt(j + 2)];
            byte byte12 = b[s1.charAt(j + 3)];
            s[i] = (byte)(byte6 << 2 | byte9 >> 4);
            s[i + 1] = (byte)(byte9 << 4 | byte11 >> 2);
            s[i + 2] = (byte)(byte11 << 6 | byte12);
            j += 4;
            i += 3;
        }

        if (s1.charAt(s1.length() - 2) == '=')
        {
            byte byte0 = b[s1.charAt(s1.length() - 4)];
            byte byte3 = b[s1.charAt(s1.length() - 3)];
            s[s.length - 1] = (byte)(byte0 << 2 | byte3 >> 4);
            return s;
        }
        if (s1.charAt(s1.length() - 1) == '=')
        {
            byte byte1 = b[s1.charAt(s1.length() - 4)];
            byte byte4 = b[s1.charAt(s1.length() - 3)];
            byte byte7 = b[s1.charAt(s1.length() - 2)];
            s[s.length - 2] = (byte)(byte1 << 2 | byte4 >> 4);
            s[s.length - 1] = (byte)(byte4 << 4 | byte7 >> 2);
            return s;
        } else
        {
            byte byte2 = b[s1.charAt(s1.length() - 4)];
            byte byte5 = b[s1.charAt(s1.length() - 3)];
            byte byte8 = b[s1.charAt(s1.length() - 2)];
            byte byte10 = b[s1.charAt(s1.length() - 1)];
            s[s.length - 3] = (byte)(byte2 << 2 | byte5 >> 4);
            s[s.length - 2] = (byte)(byte5 << 4 | byte8 >> 2);
            s[s.length - 1] = (byte)(byte8 << 6 | byte10);
            return s;
        }
    }

    public static byte[] a(byte abyte0[])
    {
        int i = 0;
        int l = abyte0.length % 3;
        byte abyte1[];
        int i1;
        if (l == 0)
        {
            abyte1 = new byte[(abyte0.length * 4) / 3];
        } else
        {
            abyte1 = new byte[(abyte0.length / 3 + 1) * 4];
        }
        i1 = abyte0.length;
        for (int j = 0; j < i1 - l;)
        {
            int j1 = abyte0[j] & 0xff;
            int k1 = abyte0[j + 1] & 0xff;
            int l1 = abyte0[j + 2] & 0xff;
            abyte1[i] = a[j1 >>> 2 & 0x3f];
            abyte1[i + 1] = a[(j1 << 4 | k1 >>> 4) & 0x3f];
            abyte1[i + 2] = a[(k1 << 2 | l1 >>> 6) & 0x3f];
            abyte1[i + 3] = a[l1 & 0x3f];
            j += 3;
            i += 4;
        }

        switch (l)
        {
        case 0: // '\0'
        default:
            return abyte1;

        case 1: // '\001'
            i = abyte0[abyte0.length - 1] & 0xff;
            abyte1[abyte1.length - 4] = a[i >>> 2 & 0x3f];
            abyte1[abyte1.length - 3] = a[i << 4 & 0x3f];
            abyte1[abyte1.length - 2] = 61;
            abyte1[abyte1.length - 1] = 61;
            return abyte1;

        case 2: // '\002'
            i = abyte0[abyte0.length - 2] & 0xff;
            break;
        }
        int k = abyte0[abyte0.length - 1] & 0xff;
        abyte1[abyte1.length - 4] = a[i >>> 2 & 0x3f];
        abyte1[abyte1.length - 3] = a[(i << 4 | k >>> 4) & 0x3f];
        abyte1[abyte1.length - 2] = a[k << 2 & 0x3f];
        abyte1[abyte1.length - 1] = 61;
        return abyte1;
    }

    private static String b(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            if (a((byte)s.charAt(i)))
            {
                stringbuffer.append(s.charAt(i));
            }
        }

        return stringbuffer.toString();
    }

    public static byte[] b(byte abyte0[])
    {
        int i = 0;
        byte abyte1[] = d(abyte0);
        int j;
        if (abyte1[abyte1.length - 2] == 61)
        {
            abyte0 = new byte[(abyte1.length / 4 - 1) * 3 + 1];
        } else
        if (abyte1[abyte1.length - 1] == 61)
        {
            abyte0 = new byte[(abyte1.length / 4 - 1) * 3 + 2];
        } else
        {
            abyte0 = new byte[(abyte1.length / 4) * 3];
        }
        for (j = 0; j < abyte1.length - 4;)
        {
            byte byte6 = b[abyte1[j]];
            byte byte9 = b[abyte1[j + 1]];
            byte byte11 = b[abyte1[j + 2]];
            byte byte12 = b[abyte1[j + 3]];
            abyte0[i] = (byte)(byte6 << 2 | byte9 >> 4);
            abyte0[i + 1] = (byte)(byte9 << 4 | byte11 >> 2);
            abyte0[i + 2] = (byte)(byte11 << 6 | byte12);
            j += 4;
            i += 3;
        }

        if (abyte1[abyte1.length - 2] == 61)
        {
            byte byte0 = b[abyte1[abyte1.length - 4]];
            byte byte3 = b[abyte1[abyte1.length - 3]];
            abyte0[abyte0.length - 1] = (byte)(byte0 << 2 | byte3 >> 4);
            return abyte0;
        }
        if (abyte1[abyte1.length - 1] == 61)
        {
            byte byte1 = b[abyte1[abyte1.length - 4]];
            byte byte4 = b[abyte1[abyte1.length - 3]];
            byte byte7 = b[abyte1[abyte1.length - 2]];
            abyte0[abyte0.length - 2] = (byte)(byte1 << 2 | byte4 >> 4);
            abyte0[abyte0.length - 1] = (byte)(byte4 << 4 | byte7 >> 2);
            return abyte0;
        } else
        {
            byte byte2 = b[abyte1[abyte1.length - 4]];
            byte byte5 = b[abyte1[abyte1.length - 3]];
            byte byte8 = b[abyte1[abyte1.length - 2]];
            byte byte10 = b[abyte1[abyte1.length - 1]];
            abyte0[abyte0.length - 3] = (byte)(byte2 << 2 | byte5 >> 4);
            abyte0[abyte0.length - 2] = (byte)(byte5 << 4 | byte8 >> 2);
            abyte0[abyte0.length - 1] = (byte)(byte8 << 6 | byte10);
            return abyte0;
        }
    }

    public static String c(byte abyte0[])
    {
        try
        {
            abyte0 = new String(a(abyte0), "US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
        return abyte0;
    }

    private static byte[] d(byte abyte0[])
    {
        byte abyte1[] = new byte[abyte0.length];
        int i = 0;
        int j;
        int k;
        for (j = 0; i < abyte0.length; j = k)
        {
            k = j;
            if (a(abyte0[i]))
            {
                abyte1[j] = abyte0[i];
                k = j + 1;
            }
            i++;
        }

        abyte0 = new byte[j];
        System.arraycopy(abyte1, 0, abyte0, 0, j);
        return abyte0;
    }

    static 
    {
        b = new byte[128];
        for (int i = 0; i < 128; i++)
        {
            b[i] = -1;
        }

        for (int j = 65; j <= 90; j++)
        {
            b[j] = (byte)(j - 65);
        }

        for (int k = 97; k <= 122; k++)
        {
            b[k] = (byte)((k - 97) + 26);
        }

        for (int l = 48; l <= 57; l++)
        {
            b[l] = (byte)((l - 48) + 52);
        }

        b[43] = 62;
        b[47] = 63;
    }
}
