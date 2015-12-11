// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import com.mopub.d.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.mopub.d.a:
//            c

static final class g
{

    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public Map g;

    public static m a(InputStream inputstream)
    {
        m m = new <init>();
        if (com.mopub.d.a.c.a(inputstream) != 0x20140623)
        {
            throw new IOException();
        }
        m.b = com.mopub.d.a.c.c(inputstream);
        m.c = com.mopub.d.a.c.c(inputstream);
        if (m.c.equals(""))
        {
            m.c = null;
        }
        m.d = com.mopub.d.a.c.b(inputstream);
        m.e = com.mopub.d.a.c.b(inputstream);
        m.f = com.mopub.d.a.c.b(inputstream);
        m.g = com.mopub.d.a.c.d(inputstream);
        return m;
    }

    public final boolean a(OutputStream outputstream)
    {
        com.mopub.d.a.c.a(outputstream, 0x20140623);
        com.mopub.d.a.c.a(outputstream, b);
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        Object obj = "";
_L1:
        java.util.Entry entry;
        try
        {
            com.mopub.d.a.c.a(outputstream, ((String) (obj)));
            com.mopub.d.a.c.a(outputstream, d);
            com.mopub.d.a.c.a(outputstream, e);
            com.mopub.d.a.c.a(outputstream, f);
            obj = g;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            t.b("%s", new Object[] {
                outputstream.toString()
            });
            return false;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        com.mopub.d.a.c.a(outputstream, ((Map) (obj)).size());
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); com.mopub.d.a.c.a(outputstream, (String)entry.getValue()))
        {
            entry = (java.util.Entry)((Iterator) (obj)).next();
            com.mopub.d.a.c.a(outputstream, (String)entry.getKey());
        }

        break MISSING_BLOCK_LABEL_164;
        obj = c;
          goto _L1
        com.mopub.d.a.c.a(outputstream, 0);
        outputstream.flush();
        return true;
    }

    private n()
    {
    }

    public n(String s, com.mopub.d. )
    {
        b = s;
        a = .a.length;
        c = .b;
        d = .c;
        e = .d;
        f = .e;
        g = .f;
    }
}
