// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import c.c;
import c.e;
import com.h.b.r;
import com.h.b.x;
import java.io.IOException;

public class PrebufferedResponseBody extends x
{

    private x impl;
    private e source;

    public PrebufferedResponseBody(x x1, e e1)
    {
        impl = x1;
        source = e1;
    }

    public void close()
        throws IOException
    {
        impl.close();
    }

    public long contentLength()
    {
        return source.c().b();
    }

    public r contentType()
    {
        return impl.contentType();
    }

    public e source()
    {
        return source;
    }
}
