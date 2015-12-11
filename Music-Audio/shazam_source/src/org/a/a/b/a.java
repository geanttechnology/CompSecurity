// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.b;

import java.net.DatagramSocket;
import java.nio.charset.Charset;

// Referenced classes of package org.a.a.b:
//            c, b

public abstract class a
{

    private static final b e = new c();
    protected int a;
    public DatagramSocket b;
    protected boolean c;
    protected b d;
    private Charset f;

    public a()
    {
        f = Charset.defaultCharset();
        b = null;
        a = 0;
        c = false;
        d = e;
    }

    public final void a()
    {
        b = d.a();
        b.setSoTimeout(a);
        c = true;
    }

    public final void b()
    {
        if (b != null)
        {
            b.close();
        }
        b = null;
        c = false;
    }

    public final boolean c()
    {
        return c;
    }

}
