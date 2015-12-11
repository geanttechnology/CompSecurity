// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.request;

import com.comcast.cim.cmasl.http.response.ResponseId;

// Referenced classes of package com.comcast.cim.cmasl.http.request:
//            RequestProvider

public class RevalidatingRequestProvider
    implements RequestProvider
{

    private final ResponseId lastResponseId;
    private RequestProvider requestProvider;

    public void addHeader(String s, String s1)
    {
        requestProvider.addHeader(s, s1);
    }

    public void addHttpEntityParameter(String s, String s1)
    {
        requestProvider.addHttpEntityParameter(s, s1);
    }

    public void addQueryParameter(String s, String s1)
    {
        requestProvider.addQueryParameter(s, s1);
    }

    public Object createRequest()
    {
        return requestProvider.createRequest();
    }

    public ResponseId getLastResponseId()
    {
        return lastResponseId;
    }

    public void setSocketTimeout(long l)
    {
        requestProvider.setSocketTimeout(l);
    }
}
