// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpContext

public interface HttpExpectationVerifier
{

    public abstract void verify(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException;
}
