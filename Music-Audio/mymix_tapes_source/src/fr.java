// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.UnsupportedEncodingException;

public class fr
{

    private static final bm a = d.a(fr);

    public fr()
    {
    }

    public static int a(byte abyte0[], int i)
    {
        return abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8;
    }

    public static String a(String s)
    {
        int i = 0;
        int k = s.length();
        char ac[] = s.toCharArray();
        int j;
        do
        {
            j = k;
            if (i >= k)
            {
                break;
            }
            j = k;
            if (ac[i] != ' ')
            {
                break;
            }
            i++;
        } while (true);
        for (; i < j && ac[j - 1] == ' '; j--) { }
        return s.substring(i, j);
    }

    public static String a(byte abyte0[], int i, int j, String s)
    {
        String s1;
        try
        {
            s1 = new String(abyte0, i, j, s);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            if (a.d())
            {
                a.d((new StringBuilder()).append(s).append(" character encoding is not available in your VM. Using the default one.").toString());
            }
            return new String(abyte0, i, j);
        }
        return s1;
    }

    public static int b(byte abyte0[], int i)
    {
        return a(abyte0, i) & 0xffff | (a(abyte0, i + 2) & 0xffff) << 16;
    }

    public static long c(byte abyte0[], int i)
    {
        return (long)((abyte0[i + 3] & 0xff) << 24 | (abyte0[i + 2] & 0xff) << 16 | (abyte0[i + 1] & 0xff) << 8 | abyte0[i] & 0xff) & 0xffffffffL;
    }

    public static int d(byte abyte0[], int i)
    {
        if (a.a())
        {
            a.a("Computing string length");
        }
        int j;
        for (j = i; abyte0[j] != 0; j++) { }
        i = j - i;
        if (a.a())
        {
            a.a((new StringBuilder("String length: [")).append(i).append("]").toString());
        }
        return i;
    }

}
