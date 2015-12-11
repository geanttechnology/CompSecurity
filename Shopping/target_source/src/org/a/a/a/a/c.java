// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.a.a.a.a:
//            f, a, i, d, 
//            g

class c extends f
{

    private final List b;

    public c(String s, Charset charset, String s1, List list)
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
        for (a1 = a1.c().iterator(); a1.hasNext(); a((d)a1.next(), g.b, outputstream)) { }
    }
}
