// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;


// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            HttpEntityEnclosingRequestBase, RequestBuilder

static class method extends HttpEntityEnclosingRequestBase
{

    private final String method;

    public String getMethod()
    {
        return method;
    }

    (String s)
    {
        method = s;
    }
}
