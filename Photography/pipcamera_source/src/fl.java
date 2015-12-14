// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class fl
{

    final fi a;
    private final String b;
    private final long c[];
    private boolean d;
    private fj e;
    private long f;

    private fl(fi fi1, String s)
    {
        a = fi1;
        super();
        b = s;
        c = new long[fi.e(fi1)];
    }

    fl(fi fi1, String s, fi._cls1 _pcls1)
    {
        this(fi1, s);
    }

    static long a(fl fl1, long l)
    {
        fl1.f = l;
        return l;
    }

    static fj a(fl fl1)
    {
        return fl1.e;
    }

    static fj a(fl fl1, fj fj)
    {
        fl1.e = fj;
        return fj;
    }

    static void a(fl fl1, String as[])
    {
        fl1.a(as);
    }

    private void a(String as[])
    {
        if (as.length != fi.e(a))
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

    static boolean a(fl fl1, boolean flag)
    {
        fl1.d = flag;
        return flag;
    }

    private IOException b(String as[])
    {
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
    }

    static long[] b(fl fl1)
    {
        return fl1.c;
    }

    static String c(fl fl1)
    {
        return fl1.b;
    }

    static boolean d(fl fl1)
    {
        return fl1.d;
    }

    static long e(fl fl1)
    {
        return fl1.f;
    }

    public File a(int i)
    {
        return new File(fi.f(a), (new StringBuilder()).append(b).append(".").append(i).toString());
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
        return new File(fi.f(a), (new StringBuilder()).append(b).append(".").append(i).append(".tmp").toString());
    }
}
