// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h.e.a;

import java.io.OutputStream;

// Referenced classes of package com.shazam.h.e.a:
//            b

public final class a
    implements b
{

    private final String b;
    private final String c;
    private OutputStream d;

    public a(String s, String s1)
    {
        b = s;
        c = s1;
    }

    public final void a()
    {
        d.write((new StringBuilder()).append(b).append(c).append("\r\n").toString().getBytes());
        d.write("Content-Disposition: form-data; ".getBytes());
    }

    public final void a(OutputStream outputstream)
    {
        d = outputstream;
    }

    public final void a(byte abyte0[])
    {
        d.write(abyte0);
    }

    public final void b()
    {
        d.write("\r\n".getBytes());
    }

    public final void c()
    {
        d.write((new StringBuilder()).append(b).append(c).append(b).toString().getBytes());
        d.close();
    }
}
