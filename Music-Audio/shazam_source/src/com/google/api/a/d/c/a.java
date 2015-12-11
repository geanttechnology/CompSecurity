// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.c;

import com.google.api.a.e.d;
import com.google.api.a.f.a.a.a.a.c;
import java.io.OutputStream;

public final class a extends com.google.api.a.d.a
{

    public String b;
    private final Object c;
    private final com.google.api.a.e.c d;

    public a(com.google.api.a.e.c c1, Object obj)
    {
        super("application/json; charset=UTF-8");
        d = (com.google.api.a.e.c)com.google.api.a.f.a.a.a.a.c.a(c1);
        c = com.google.api.a.f.a.a.a.a.c.a(obj);
    }

    public final void a(OutputStream outputstream)
    {
        outputstream = d.a(outputstream, b());
        if (b != null)
        {
            outputstream.f();
            outputstream.a(b);
        }
        outputstream.a(false, c);
        if (b != null)
        {
            outputstream.c();
        }
        outputstream.a();
    }
}
