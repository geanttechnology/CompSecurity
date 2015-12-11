// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import org.a.a.a.a.a.f;

// Referenced classes of package org.a.a.a.a:
//            f, a, i

class k extends org.a.a.a.a.f
{

    private final List b;

    public k(String s, Charset charset, String s1, List list)
    {
        super(s, charset, s1);
        b = list;
    }

    public List a()
    {
        return b;
    }

    protected void a(a a1, OutputStream outputstream)
        throws IOException
    {
        i j = a1.c();
        a(j.a("Content-Disposition"), a, outputstream);
        if (a1.b().a() != null)
        {
            a(j.a("Content-Type"), a, outputstream);
        }
    }
}
