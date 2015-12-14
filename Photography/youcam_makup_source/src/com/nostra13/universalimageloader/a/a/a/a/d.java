// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a.a;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.nostra13.universalimageloader.a.a.a.a:
//            a, b

final class d
{

    final a a;
    private final String b;
    private final long c[];
    private boolean d;
    private b e;
    private long f;

    private d(a a1, String s)
    {
        a = a1;
        super();
        b = s;
        c = new long[com.nostra13.universalimageloader.a.a.a.a.a.f(a1)];
    }

    d(a a1, String s, a._cls1 _pcls1)
    {
        this(a1, s);
    }

    static long a(d d1, long l)
    {
        d1.f = l;
        return l;
    }

    static b a(d d1)
    {
        return d1.e;
    }

    static b a(d d1, b b1)
    {
        d1.e = b1;
        return b1;
    }

    static void a(d d1, String as[])
    {
        d1.a(as);
    }

    private void a(String as[])
    {
        if (as.length != com.nostra13.universalimageloader.a.a.a.a.a.f(a))
        {
            throw b(as);
        }
        int i = 0;
        do
        {
            try
            {
                if (i >= as.length)
                {
                    break;
                }
                c[i] = Long.parseLong(as[i]);
            }
            catch (NumberFormatException numberformatexception)
            {
                throw b(as);
            }
            i++;
        } while (true);
    }

    static boolean a(d d1, boolean flag)
    {
        d1.d = flag;
        return flag;
    }

    private IOException b(String as[])
    {
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
    }

    static long[] b(d d1)
    {
        return d1.c;
    }

    static String c(d d1)
    {
        return d1.b;
    }

    static boolean d(d d1)
    {
        return d1.d;
    }

    static long e(d d1)
    {
        return d1.f;
    }

    public File a(int i)
    {
        return new File(com.nostra13.universalimageloader.a.a.a.a.a.g(a), (new StringBuilder()).append(i).append(".").append(b).toString());
    }

    public String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        long al[] = c;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            long l = al[i];
            stringbuilder.append(' ').append(l);
        }

        return stringbuilder.toString();
    }

    public File b(int i)
    {
        return new File(com.nostra13.universalimageloader.a.a.a.a.a.g(a), (new StringBuilder()).append(i).append(".").append(b).append(".tmp").toString());
    }
}
