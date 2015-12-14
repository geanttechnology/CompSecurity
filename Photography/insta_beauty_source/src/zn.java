// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class zn
{

    final zj a;
    private final String b;
    private final long c[];
    private boolean d;
    private zl e;
    private long f;

    private zn(zj zj1, String s)
    {
        a = zj1;
        super();
        b = s;
        c = new long[zj.e(zj1)];
    }

    zn(zj zj1, String s, zk zk)
    {
        this(zj1, s);
    }

    static long a(zn zn1, long l)
    {
        zn1.f = l;
        return l;
    }

    static zl a(zn zn1)
    {
        return zn1.e;
    }

    static zl a(zn zn1, zl zl)
    {
        zn1.e = zl;
        return zl;
    }

    static void a(zn zn1, String as[])
    {
        zn1.a(as);
    }

    private void a(String as[])
    {
        if (as.length != zj.e(a))
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

    static boolean a(zn zn1, boolean flag)
    {
        zn1.d = flag;
        return flag;
    }

    private IOException b(String as[])
    {
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
    }

    static long[] b(zn zn1)
    {
        return zn1.c;
    }

    static String c(zn zn1)
    {
        return zn1.b;
    }

    static boolean d(zn zn1)
    {
        return zn1.d;
    }

    static long e(zn zn1)
    {
        return zn1.f;
    }

    public File a(int i)
    {
        return new File(zj.f(a), (new StringBuilder()).append(b).append(".").append(i).toString());
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
        return new File(zj.f(a), (new StringBuilder()).append(b).append(".").append(i).append(".tmp").toString());
    }
}
