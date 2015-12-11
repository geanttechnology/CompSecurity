// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

public final class cvq extends AbstractHttpEntity
{

    private final art a;
    private arx b;

    public cvq(art art, arx arx1, String s)
    {
        a = art;
        b = arx1;
        setContentType(b.a(s, "contentType cannot be empty."));
    }

    public final InputStream getContent()
    {
        return new aru(a, b);
    }

    public final long getContentLength()
    {
        return b.e;
    }

    public final boolean isRepeatable()
    {
        return true;
    }

    public final boolean isStreaming()
    {
        return true;
    }

    public final void writeTo(OutputStream outputstream)
    {
        InputStream inputstream;
        b.a(outputstream);
        inputstream = getContent();
        a.a(inputstream, outputstream);
        inputstream.close();
        outputstream.close();
        return;
        Exception exception;
        exception;
        inputstream.close();
        outputstream.close();
        throw exception;
    }
}
