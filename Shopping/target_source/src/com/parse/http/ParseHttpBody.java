// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class ParseHttpBody
{

    private final long contentLength;
    private final String contentType;

    public ParseHttpBody(String s, long l)
    {
        contentType = s;
        contentLength = l;
    }

    public abstract InputStream getContent()
        throws IOException;

    public long getContentLength()
    {
        return contentLength;
    }

    public String getContentType()
    {
        return contentType;
    }

    public abstract void writeTo(OutputStream outputstream)
        throws IOException;
}
