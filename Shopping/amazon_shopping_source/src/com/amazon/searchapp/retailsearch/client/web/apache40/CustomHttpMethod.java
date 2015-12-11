// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class CustomHttpMethod extends HttpEntityEnclosingRequestBase
{

    private final String method;

    public CustomHttpMethod(String s, String s1)
    {
        method = s;
        setURI(URI.create(s1));
    }

    public String getMethod()
    {
        return method;
    }
}
