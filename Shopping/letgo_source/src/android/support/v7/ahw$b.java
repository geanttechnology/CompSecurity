// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package android.support.v7:
//            ahw

private final class <init>
{

    final ahw a;
    private final String b;
    private final long c[];
    private boolean d;
    private oString e;
    private long f;

    static long a(<init> <init>1, long l)
    {
        <init>1.f = l;
        return l;
    }

    static f a(f f1)
    {
        return f1.e;
    }

    static e a(e e1, e e2)
    {
        e1.e = e2;
        return e2;
    }

    static void a(e e1, String as[])
        throws IOException
    {
        e1.a(as);
    }

    private void a(String as[])
        throws IOException
    {
        if (as.length != ahw.f(a))
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

    static boolean a(b b1, boolean flag)
    {
        b1.d = flag;
        return flag;
    }

    private IOException b(String as[])
        throws IOException
    {
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
    }

    static long[] b(oString ostring)
    {
        return ostring.c;
    }

    static String c(c c1)
    {
        return c1.b;
    }

    static boolean d(b b1)
    {
        return b1.d;
    }

    static long e(d d1)
    {
        return d1.f;
    }

    public File a(int i)
    {
        return new File(ahw.g(a), (new StringBuilder()).append(b).append(".").append(i).toString());
    }

    public String a()
        throws IOException
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
        return new File(ahw.g(a), (new StringBuilder()).append(b).append(".").append(i).append(".tmp").toString());
    }

    private eption(ahw ahw1, String s)
    {
        a = ahw1;
        super();
        b = s;
        c = new long[ahw.f(ahw1)];
    }

    c(ahw ahw1, String s, c c1)
    {
        this(ahw1, s);
    }
}
