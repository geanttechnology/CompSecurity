// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import android.support.v7.apv;
import android.support.v7.apx;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;

public class PrebufferedResponseBody extends ResponseBody
{

    private ResponseBody impl;
    private apx source;

    public PrebufferedResponseBody(ResponseBody responsebody, apx apx1)
    {
        impl = responsebody;
        source = apx1;
    }

    public void close()
        throws IOException
    {
        impl.close();
    }

    public long contentLength()
    {
        return source.b().a();
    }

    public MediaType contentType()
    {
        return impl.contentType();
    }

    public apx source()
    {
        return source;
    }
}
