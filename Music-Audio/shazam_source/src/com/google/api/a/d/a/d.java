// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.a;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.y;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

final class d extends AbstractHttpEntity
{

    private final long a;
    private final y b;

    d(long l, y y1)
    {
        a = l;
        b = (y)c.a(y1);
    }

    public final InputStream getContent()
    {
        throw new UnsupportedOperationException();
    }

    public final long getContentLength()
    {
        return a;
    }

    public final boolean isRepeatable()
    {
        return false;
    }

    public final boolean isStreaming()
    {
        return true;
    }

    public final void writeTo(OutputStream outputstream)
    {
        if (a != 0L)
        {
            b.a(outputstream);
        }
    }
}
