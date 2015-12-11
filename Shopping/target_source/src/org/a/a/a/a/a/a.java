// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a.a;

import java.io.IOException;
import java.io.OutputStream;
import org.a.a.a.a.b.b;

// Referenced classes of package org.a.a.a.a.a:
//            d, c

public class a extends d
{

    private final byte a[];
    private final String b;

    public a(byte abyte0[], String s)
    {
        this(abyte0, "application/octet-stream", s);
    }

    public a(byte abyte0[], String s, String s1)
    {
        this(abyte0, org.a.a.a.a.a.c.a(s), s1);
    }

    public a(byte abyte0[], c c1, String s)
    {
        super(c1);
        org.a.a.a.a.b.b.a(abyte0, "byte[]");
        a = abyte0;
        b = s;
    }

    public String a()
    {
        return b;
    }

    public void a(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(a);
    }

    public String b()
    {
        return null;
    }

    public String c()
    {
        return "binary";
    }

    public long d()
    {
        return (long)a.length;
    }
}
