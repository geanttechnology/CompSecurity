// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http;

import org.apache.http.Header;

// Referenced classes of package com.poshmark.http:
//            PMHttpError, PMHttpRequest

public class PMHttpResponse
{

    public Header headerArray[];
    public final int httpCode;
    public final PMHttpError httpError;
    public final PMHttpRequest httpRequest;
    public final String responseString;

    public PMHttpResponse(int i, Header aheader[], String s, PMHttpRequest pmhttprequest, PMHttpError pmhttperror)
    {
        httpCode = i;
        responseString = s;
        httpRequest = pmhttprequest;
        httpError = pmhttperror;
        headerArray = aheader;
    }

    public boolean hasError()
    {
        return httpError != null;
    }
}
