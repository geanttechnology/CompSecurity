// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.http;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

class apper extends HttpEntityWrapper
{

    public InputStream getContent()
    {
        return new GZIPInputStream(wrappedEntity.getContent());
    }

    public long getContentLength()
    {
        return -1L;
    }

    public apper(HttpEntity httpentity)
    {
        super(httpentity);
    }
}
