// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.web;

import com.amazon.ansel.fetch.tools.collection.CollectionMap;
import java.io.IOException;
import java.io.InputStream;

public interface WebResponse
{

    public abstract InputStream getContent()
        throws IOException;

    public abstract long getContentLength()
        throws IOException;

    public abstract String getContentType()
        throws IOException;

    public abstract CollectionMap getHeaders()
        throws IOException;

    public abstract int getStatusCode()
        throws IOException;

    public abstract String getStatusLine()
        throws IOException;
}
