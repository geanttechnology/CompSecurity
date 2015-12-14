// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            e, f

final class h
{

    final e a;
    private final String b;
    private final long c[];
    private boolean d;
    private f e;
    private long f;

    private h(e e1, String s)
    {
        a = e1;
        super();
        b = s;
        c = new long[com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.e.e(e1)];
    }

    h(e e1, String s, e._cls1 _pcls1)
    {
        this(e1, s);
    }

    static long a(h h1, long l)
    {
        h1.f = l;
        return l;
    }

    static f a(h h1)
    {
        return h1.e;
    }

    static f a(h h1, f f1)
    {
        h1.e = f1;
        return f1;
    }

    static void a(h h1, String as[])
    {
        h1.a(as);
    }

    private void a(String as[])
    {
        if (as.length != com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.e.e(a))
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

    static boolean a(h h1, boolean flag)
    {
        h1.d = flag;
        return flag;
    }

    private IOException b(String as[])
    {
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(Arrays.toString(as)).toString());
    }

    static long[] b(h h1)
    {
        return h1.c;
    }

    static String c(h h1)
    {
        return h1.b;
    }

    static boolean d(h h1)
    {
        return h1.d;
    }

    static long e(h h1)
    {
        return h1.f;
    }

    public File a(int i)
    {
        return new File(new File(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.e.f(a)), (new StringBuilder()).append(b).append(".").append(i).toString());
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
        return new File(new File(com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.e.f(a)), (new StringBuilder()).append(b).append(".").append(i).append(".tmp").toString());
    }
}
