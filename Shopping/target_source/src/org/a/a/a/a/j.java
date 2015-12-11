// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.a.a.a.a.a.f;
import org.a.a.a.a.b.b;
import org.apache.http.HttpEntity;

// Referenced classes of package org.a.a.a.a:
//            b, a, h, l, 
//            e, f, k, c

public class j
{

    private static final char a[] = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String b;
    private org.a.a.a.a.b c;
    private String d;
    private Charset e;
    private List f;

    j()
    {
        b = "form-data";
        c = b.a;
        d = null;
        e = null;
        f = null;
    }

    private String a(String s, String s1, Charset charset)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("multipart/").append(s1).append("; boundary=");
        stringbuilder.append(s);
        if (charset != null)
        {
            stringbuilder.append("; charset=");
            stringbuilder.append(charset.name());
        }
        return stringbuilder.toString();
    }

    public static j a()
    {
        return new j();
    }

    private String d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Random random = new Random();
        int i1 = random.nextInt(11);
        for (int i = 0; i < i1 + 30; i++)
        {
            stringbuilder.append(a[random.nextInt(a.length)]);
        }

        return stringbuilder.toString();
    }

    public j a(String s, f f1)
    {
        org.a.a.a.a.b.b.a(s, "Name");
        org.a.a.a.a.b.b.a(f1, "Content body");
        return a(new a(s, f1));
    }

    public j a(a a1)
    {
        if (a1 == null)
        {
            return this;
        }
        if (f == null)
        {
            f = new ArrayList();
        }
        f.add(a1);
        return this;
    }

    e b()
    {
        Object obj;
        String s;
        String s1;
        Charset charset;
        org.a.a.a.a.b b1;
        if (b != null)
        {
            s = b;
        } else
        {
            s = "form-data";
        }
        charset = e;
        if (d != null)
        {
            s1 = d;
        } else
        {
            s1 = d();
        }
        if (f != null)
        {
            obj = new ArrayList(f);
        } else
        {
            obj = Collections.emptyList();
        }
        if (c != null)
        {
            b1 = c;
        } else
        {
            b1 = b.a;
        }
        h.a[b1.ordinal()];
        JVM INSTR tableswitch 1 2: default 92
    //                   1 155
    //                   2 171;
           goto _L1 _L2 _L3
_L1:
        obj = new l(s, charset, s1, ((List) (obj)));
_L5:
        return new e(((org.a.a.a.a.f) (obj)), a(s1, s, charset), ((org.a.a.a.a.f) (obj)).c());
_L2:
        obj = new k(s, charset, s1, ((List) (obj)));
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new c(s, charset, s1, ((List) (obj)));
        if (true) goto _L5; else goto _L4
_L4:
    }

    public HttpEntity c()
    {
        return b();
    }

}
