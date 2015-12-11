// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.jirbo.adcolony:
//            w, q, ac, d, 
//            aj

final class av extends w
{

    String c;
    OutputStream d;
    byte e[];
    int f;
    int g;
    int h;

    av(String s)
    {
        e = new byte[1024];
        f = 0;
        c = s;
        if (q.e != 0)
        {
            h = 23;
            g = h;
        }
        try
        {
            if (q.c != null && q.c.f != null)
            {
                q.c.f.a();
            }
            d = new FileOutputStream(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            a(s);
        }
    }

    private void a(IOException ioexception)
    {
        aj.d.a("Error writing \"").a(c).b("\":");
        aj.d.b(ioexception.toString());
        c();
    }

    private void d()
    {
        if (f <= 0 || d == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        d.write(e, 0, f);
        f = 0;
        d.flush();
        return;
        IOException ioexception;
        ioexception;
        f = 0;
        a(ioexception);
        return;
    }

    final void a(char c1)
    {
        e[f] = (byte)(g ^ c1);
        g = g + h;
        c1 = f + 1;
        f = c1;
        if (c1 == '\u0400')
        {
            d();
        }
    }

    final void c()
    {
        d();
        try
        {
            if (d != null)
            {
                d.close();
                d = null;
            }
            return;
        }
        catch (IOException ioexception)
        {
            d = null;
            a(ioexception);
            return;
        }
    }
}
