// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.utils;

import java.util.List;
import org.apache.http.HttpResponse;

public class HttpResponseWithDataPoints
{

    private final List mDataPoints;
    private final HttpResponse mResponse;

    public HttpResponseWithDataPoints(HttpResponse httpresponse, List list)
    {
        mResponse = httpresponse;
        mDataPoints = list;
    }

    public List getDataPoints()
    {
        return mDataPoints;
    }

    public HttpResponse getResponse()
    {
        return mResponse;
    }
}
