// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;

public class PrebufferedResponseBody extends ResponseBody
{

    private ResponseBody impl;
    private BufferedSource source;

    public PrebufferedResponseBody(ResponseBody responsebody, BufferedSource bufferedsource)
    {
        impl = responsebody;
        source = bufferedsource;
    }

    public void close()
        throws IOException
    {
        impl.close();
    }

    public long contentLength()
    {
        return source.buffer().size();
    }

    public MediaType contentType()
    {
        return impl.contentType();
    }

    public BufferedSource source()
    {
        return source;
    }
}
