// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import com.poshmark.http.BrainTreeHttpResponseHandler;
import com.poshmark.http.PMHttpRequest;
import java.util.Map;

public class BrainTreeApi
{

    public BrainTreeApi()
    {
    }

    public static void PostBrainTreeValidation(Map map, String s, BrainTreeHttpResponseHandler braintreehttpresponsehandler)
    {
        s = new PMHttpRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, s);
        ((PMHttpRequest) (s)).formData.putAll(map);
        s.execute(braintreehttpresponsehandler);
    }
}
