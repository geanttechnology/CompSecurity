// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package cz.msebera.android.httpclient:
//            Header

public interface HttpEntity
{

    public abstract void consumeContent()
        throws IOException;

    public abstract InputStream getContent()
        throws IOException, IllegalStateException;

    public abstract Header getContentEncoding();

    public abstract long getContentLength();

    public abstract Header getContentType();

    public abstract boolean isChunked();

    public abstract boolean isRepeatable();

    public abstract boolean isStreaming();

    public abstract void writeTo(OutputStream outputstream)
        throws IOException;
}
