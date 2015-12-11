// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class ParseHttpBody
{

    protected final int contentLength;
    protected final String contentType;

    public ParseHttpBody(String s, int i)
    {
        contentType = s;
        contentLength = i;
    }

    public abstract InputStream getContent();

    public int getContentLength()
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
