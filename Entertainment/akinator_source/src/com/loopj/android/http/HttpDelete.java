// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import java.net.URI;

public final class HttpDelete extends HttpEntityEnclosingRequestBase
{

    public static final String METHOD_NAME = "DELETE";

    public HttpDelete()
    {
    }

    public HttpDelete(String s)
    {
        setURI(URI.create(s));
    }

    public HttpDelete(URI uri)
    {
        setURI(uri);
    }

    public String getMethod()
    {
        return "DELETE";
    }
}
