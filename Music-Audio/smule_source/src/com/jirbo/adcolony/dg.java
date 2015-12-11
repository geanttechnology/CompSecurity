// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.jirbo.adcolony:
//            ax, ak, be, n, 
//            bl

class dg extends ax
{

    String c;
    OutputStream d;
    byte e[];
    int f;
    int g;
    int h;

    dg(String s)
    {
        e = new byte[1024];
        f = 0;
        c = s;
        if (ak.e != 0)
        {
            h = 23;
            g = h;
        }
        try
        {
            if (ak.c != null && ak.c.f != null)
            {
                ak.c.f.b();
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

    void a(char c1)
    {
        e[f] = (byte)(g ^ c1);
        g = g + h;
        c1 = f + 1;
        f = c1;
        if (c1 == '\u0400')
        {
            c();
        }
    }

    void a(IOException ioexception)
    {
        bl.d.a("Error writing \"").a(c).b("\":");
        bl.d.b(ioexception.toString());
        d();
    }

    void c()
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

    void d()
    {
        c();
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
