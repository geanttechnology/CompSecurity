// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import com.a.a.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.a.a.a:
//            c

static final class h
{

    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public Map h;

    public static tream a(InputStream inputstream)
    {
        tream tream = new <init>();
        if (com.a.a.a.c.a(inputstream) != 0x20150306)
        {
            throw new IOException();
        }
        tream.b = com.a.a.a.c.c(inputstream);
        tream.c = com.a.a.a.c.c(inputstream);
        if (tream.c.equals(""))
        {
            tream.c = null;
        }
        tream.d = com.a.a.a.c.b(inputstream);
        tream.e = com.a.a.a.c.b(inputstream);
        tream.f = com.a.a.a.c.b(inputstream);
        tream.g = com.a.a.a.c.b(inputstream);
        tream.h = com.a.a.a.c.d(inputstream);
        return tream;
    }

    public final boolean a(OutputStream outputstream)
    {
        com.a.a.a.c.a(outputstream, 0x20150306);
        com.a.a.a.c.a(outputstream, b);
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        Object obj = "";
_L1:
        java.util.Entry entry;
        try
        {
            com.a.a.a.c.a(outputstream, ((String) (obj)));
            com.a.a.a.c.a(outputstream, d);
            com.a.a.a.c.a(outputstream, e);
            com.a.a.a.c.a(outputstream, f);
            com.a.a.a.c.a(outputstream, g);
            obj = h;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            u.b("%s", new Object[] {
                outputstream.toString()
            });
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        com.a.a.a.c.a(outputstream, ((Map) (obj)).size());
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); com.a.a.a.c.a(outputstream, (String)entry.getValue()))
        {
            entry = (java.util.Entry)((Iterator) (obj)).next();
            com.a.a.a.c.a(outputstream, (String)entry.getKey());
        }

        break MISSING_BLOCK_LABEL_172;
        obj = c;
          goto _L1
        com.a.a.a.c.a(outputstream, 0);
        outputstream.flush();
        return true;
    }

    private ng()
    {
    }

    public ng(String s, com.a.a. )
    {
        b = s;
        a = .a.length;
        c = .b;
        d = .c;
        e = .d;
        f = .e;
        g = .f;
        h = .g;
    }
}
