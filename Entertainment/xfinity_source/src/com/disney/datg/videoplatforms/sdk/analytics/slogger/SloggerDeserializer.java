// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics.slogger;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import com.disney.datg.videoplatforms.sdk.service.serialization.ApiDeserializer;
import java.util.concurrent.Future;
import org.springframework.http.converter.HttpMessageConverter;

public class SloggerDeserializer extends ApiDeserializer
{

    public SloggerDeserializer()
    {
        super([B);
    }

    public SloggerDeserializer(HttpMessageConverter httpmessageconverter, Class class1)
    {
        super(httpmessageconverter, class1);
    }

    public Future executeAsync(Request request, int i, HttpRequestHandler httprequesthandler)
        throws AndroidSDKException
    {
        return super.executeAsync(request, i, httprequesthandler);
    }

    public Future getForObjectAsync(Request request, int i, HttpRequestHandler httprequesthandler)
        throws AndroidSDKException
    {
        return super.getForObjectAsync(request, i, httprequesthandler);
    }
}
