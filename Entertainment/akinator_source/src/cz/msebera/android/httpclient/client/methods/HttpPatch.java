// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import java.net.URI;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            HttpEntityEnclosingRequestBase

public class HttpPatch extends HttpEntityEnclosingRequestBase
{

    public static final String METHOD_NAME = "PATCH";

    public HttpPatch()
    {
    }

    public HttpPatch(String s)
    {
        setURI(URI.create(s));
    }

    public HttpPatch(URI uri)
    {
        setURI(uri);
    }

    public String getMethod()
    {
        return "PATCH";
    }
}
