// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.response;


// Referenced classes of package com.comcast.cim.cmasl.http.response:
//            DelegatingResponseHandler, IdentifyResponseHandler, ResponseId

public abstract class RevalidatingResponseHandler extends DelegatingResponseHandler
{

    private final IdentifyResponseHandler identifyResponseHandler;
    private Object resource;

    public Object getResourceIfNewer()
    {
        return resource;
    }

    public ResponseId getResponseId()
    {
        return identifyResponseHandler.getResponseId();
    }
}
