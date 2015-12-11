// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import org.apache.http.entity.AbstractHttpEntity;

final class cvs extends AbstractHttpEntity
{

    private final File a;
    private final long b;
    private final long c;
    private final Key d;

    public cvs(File file, String s, long l, long l1, Key key)
    {
        a = (File)b.a(file);
        boolean flag;
        if (l <= l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag, "begin must be less than or equal to end");
        b = l;
        c = l1;
        d = key;
        setContentType(b.a(s, "contentType cannot be empty"));
    }

    public final InputStream getContent()
    {
        if (d != null)
        {
            return new cvp(a, b, c, d);
        } else
        {
            return new cvt(a, b, c);
        }
    }

    public final long getContentLength()
    {
        return (c - b) + 1L;
    }

    public final boolean isRepeatable()
    {
        return true;
    }

    public final boolean isStreaming()
    {
        return false;
    }

    public final void writeTo(OutputStream outputstream)
    {
        InputStream inputstream = getContent();
        bnh.a(inputstream, outputstream);
        inputstream.close();
        return;
        outputstream;
        inputstream.close();
        throw outputstream;
    }
}
