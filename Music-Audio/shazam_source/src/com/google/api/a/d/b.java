// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.m;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.google.api.a.d:
//            i

public abstract class b
    implements i
{

    public String a;
    public boolean b;

    public b(String s)
    {
        b = true;
        a(s);
    }

    public b a(String s)
    {
        a = s;
        return this;
    }

    public b a(boolean flag)
    {
        b = flag;
        return this;
    }

    public final void a(OutputStream outputstream)
    {
        m.a(b(), outputstream, b);
        outputstream.flush();
    }

    public abstract InputStream b();

    public final String c()
    {
        return a;
    }
}
