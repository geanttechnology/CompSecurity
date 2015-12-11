// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http;


// Referenced classes of package com.poshmark.http:
//            PMBaseHttpResponseHandler, PMHttpResponse

public interface PMHttpResponseHandler
    extends PMBaseHttpResponseHandler
{

    public abstract void handleResponse(PMHttpResponse pmhttpresponse);
}
