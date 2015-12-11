// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.e;
import com.google.api.a.g.m;
import com.google.api.a.g.q;
import com.google.api.a.g.u;
import com.google.api.a.g.z;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

// Referenced classes of package com.google.api.a.d:
//            p, z, v, m, 
//            o

public final class s
{

    public final String a;
    com.google.api.a.d.z b;
    public final int c;
    public final String d;
    public final p e;
    private InputStream f;
    private final String g;
    private final o h;
    private int i;
    private boolean j;
    private boolean k;

    s(p p1, com.google.api.a.d.z z1)
    {
        Object obj1 = null;
        super();
        e = p1;
        i = p1.d;
        j = p1.e;
        b = z1;
        g = z1.b();
        int i1 = z1.e();
        int l = i1;
        if (i1 < 0)
        {
            l = 0;
        }
        c = l;
        Object obj = z1.f();
        d = ((String) (obj));
        Logger logger = v.a;
        StringBuilder stringbuilder;
        boolean flag;
        if (j && logger.isLoggable(Level.CONFIG))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            stringbuilder = new StringBuilder();
            stringbuilder.append("-------------- RESPONSE --------------").append(z.a);
            Object obj2 = z1.d();
            if (obj2 != null)
            {
                stringbuilder.append(((String) (obj2)));
            } else
            {
                stringbuilder.append(c);
                if (obj != null)
                {
                    stringbuilder.append(' ').append(((String) (obj)));
                }
            }
            stringbuilder.append(z.a);
        } else
        {
            stringbuilder = null;
        }
        obj2 = p1.c;
        if (flag)
        {
            obj = stringbuilder;
        } else
        {
            obj = null;
        }
        ((com.google.api.a.d.m) (obj2)).a(z1, ((StringBuilder) (obj)));
        obj = z1.c();
        z1 = ((com.google.api.a.d.z) (obj));
        if (obj == null)
        {
            z1 = (String)m.a(p1.c.contentType);
        }
        a = z1;
        if (z1 == null)
        {
            p1 = obj1;
        } else
        {
            p1 = new o(z1);
        }
        h = p1;
        if (flag)
        {
            logger.config(stringbuilder.toString());
        }
    }

    public final Object a(Class class1)
    {
        boolean flag = true;
        int l = c;
        if (e.h.equals("HEAD") || l / 100 == 1 || l == 204 || l == 304)
        {
            c();
            flag = false;
        }
        if (!flag)
        {
            return null;
        } else
        {
            return e.m.a(b(), f(), class1);
        }
    }

    public final void a(OutputStream outputstream)
    {
        m.a(b(), outputstream, true);
    }

    public final boolean a()
    {
        int l = c;
        return l >= 200 && l < 300;
    }

    public final InputStream b()
    {
        Object obj1;
        Object obj2;
        if (k)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        obj1 = b.a();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj2 = obj1;
        Object obj3 = g;
        Object obj;
        obj = obj1;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = obj1;
        obj2 = obj1;
        if (!((String) (obj3)).contains("gzip"))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj2 = obj1;
        obj = new GZIPInputStream(((InputStream) (obj1)));
        obj2 = obj;
        obj3 = obj;
        Logger logger = v.a;
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        if (!j)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        if (!logger.isLoggable(Level.CONFIG))
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj2 = obj;
        obj3 = obj;
        obj1 = new q(((InputStream) (obj)), logger, Level.CONFIG, i);
        obj2 = obj1;
        obj3 = obj1;
        Exception exception;
        try
        {
            f = ((InputStream) (obj1));
        }
        catch (EOFException eofexception)
        {
            ((InputStream) (obj2)).close();
        }
        finally
        {
            obj1 = obj3;
        }
        k = true;
        return f;
        exception;
        ((InputStream) (obj1)).close();
        throw exception;
    }

    public final void c()
    {
        InputStream inputstream = b();
        if (inputstream != null)
        {
            inputstream.close();
        }
    }

    public final void d()
    {
        c();
        b.h();
    }

    public final String e()
    {
        InputStream inputstream = b();
        if (inputstream == null)
        {
            return "";
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            m.a(inputstream, bytearrayoutputstream, true);
            return bytearrayoutputstream.toString(f().name());
        }
    }

    public final Charset f()
    {
        if (h == null || h.b() == null)
        {
            return e.b;
        } else
        {
            return h.b();
        }
    }
}
