// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.o;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package myobfuscated.o:
//            a, b

public final class c
{

    final String a;
    final long b[];
    File c[];
    File d[];
    boolean e;
    b f;
    long g;
    private a h;

    private c(a a1, String s)
    {
        h = a1;
        super();
        a = s;
        b = new long[myobfuscated.o.a.f(a1)];
        c = new File[myobfuscated.o.a.f(a1)];
        d = new File[myobfuscated.o.a.f(a1)];
        s = (new StringBuilder(s)).append('.');
        int j = s.length();
        for (int i = 0; i < myobfuscated.o.a.f(a1); i++)
        {
            s.append(i);
            c[i] = new File(myobfuscated.o.a.g(a1), s.toString());
            s.append(".tmp");
            d[i] = new File(myobfuscated.o.a.g(a1), s.toString());
            s.setLength(j);
        }

    }

    c(a a1, String s, byte byte0)
    {
        this(a1, s);
    }

    private static IOException b(String as[])
    {
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(Arrays.toString(as)).toString());
    }

    public final String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        long al[] = b;
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            long l = al[i];
            stringbuilder.append(' ').append(l);
        }

        return stringbuilder.toString();
    }

    final void a(String as[])
    {
        if (as.length != myobfuscated.o.a.f(h))
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
                b[i] = Long.parseLong(as[i]);
            }
            catch (NumberFormatException numberformatexception)
            {
                throw b(as);
            }
            i++;
        } while (true);
    }
}
